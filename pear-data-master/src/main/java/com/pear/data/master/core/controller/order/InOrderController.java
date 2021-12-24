package com.pear.data.master.core.controller.order;

import com.alibaba.fastjson.JSON;
import com.pear.data.master.core.common.utils.*;
import com.pear.data.master.core.common.utils.constant.ServerConstant;
import com.pear.data.master.core.model.geway.GewayCodeModel;
import com.pear.data.master.core.model.order.InOrderModel;
import com.pear.data.master.core.model.order.InOrderResultModel;
import com.pear.data.master.core.model.region.RegionModel;
import com.pear.data.master.core.model.strategy.StrategyModel;
import com.pear.data.master.core.model.template.NotifyFieldModel;
import com.pear.data.master.core.model.template.NotifyTemplateModel;
import com.pear.data.master.util.ComponentUtil;
import com.pear.data.master.util.HodgepodgeMethod;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * @Description 代收订单的数据同步的Controller层
 * @Author yoko
 * @Date 2020/5/22 10:21
 * @Version 1.0
 */
@RestController
@RequestMapping("/pearData/inOrder")
public class InOrderController {

    private static Logger log = LoggerFactory.getLogger(InOrderController.class);

    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    /**
     * 15分钟.
     */
    public long FIFTEEN_MIN = 900;

    /**
     * 30分钟.
     */
    public long THIRTY_MIN = 30;

    @Value("${secret.key.token}")
    private String secretKeyToken;

    @Value("${secret.key.sign}")
    private String secretKeySign;


    /**
     * @Description: 上游数据同步-get
     * <p>
     *
     * </p>
     * @param request
     * @param response
     * @return com.gd.chain.common.utils.JsonResult<java.lang.Object>
     * @author yoko
     * @date 2019/11/25 22:58
     * local:http://localhost:8098/pearData/inOrder/1/get
     * 请求的属性类:ProtocolInOrder
     * 必填字段:http://localhost:8098/pearData/inOrder/5/get?p1_merchantno=p1_merchantno1&p2_amount=50.00&p3_orderno=p3_orderno1&p4_status=2&p5_producttype=p5_producttype1&p6_requesttime=p6_requesttime1&p7_goodsname=p7_goodsname1&p8_tradetime=p8_tradetime1&p9_porderno=p9_porderno1&sign=sign1
     * #花呗通:http://localhost:8098/pearData/inOrder/5/get?p1_merchantno=p1_merchantno1&p2_amount=50.00&p3_orderno=DS202108311113501&p4_status=2&p5_producttype=p5_producttype1&p6_requesttime=p6_requesttime1&p7_goodsname=p7_goodsname1&p8_tradetime=p8_tradetime1&p9_porderno=p9_porderno1&sign=sign1
     */
    @RequestMapping(value = "/{identityKey}/get", method = {RequestMethod.GET})
    public String get(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "identityKey")String identityKey, @RequestParam Map<String, Object> dataMap) throws Exception{
        String ip = StringUtil.getIpAddress(request);
        String data = "";
        RegionModel regionModel = HodgepodgeMethod.assembleRegionModel(ip);
        int logSwitch = 0;// 打印log日志开关:1关闭，2打开
        String return_str_suc = "";// 成功返回的字符串
        String return_str_fail = "NO";// 默认返回的字符串

        // 策略数据：打印日志开关
        StrategyModel strategyLogSwitchQuery = HodgepodgeMethod.assembleStrategyQuery(ServerConstant.StrategyEnum.LOG_SWITCH.getStgType());
        StrategyModel strategyLogSwitchModel = ComponentUtil.strategyService.getStrategyModel(strategyLogSwitchQuery, ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO);
        logSwitch = strategyLogSwitchModel.getStgNumValue();

        // 打印请求的数据
        if (logSwitch == ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_TWO){
            log.info("---------InOrderController.get()-all-data-json:" + JSON.toJSONString(dataMap) + "ip:" + ip);
        }
        try{
            // 根据通道码ID校验是否有这个通道码信息
            GewayCodeModel gewayCodeQuery = HodgepodgeMethod.assembleGewayCodeQuery(0, null, 0,null,null,null,0, identityKey);
            GewayCodeModel gewayCodeModel = ComponentUtil.gewayCodeService.getGewayCodeModel(gewayCodeQuery, ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO);
            HodgepodgeMethod.checkGewayCodeIsNull(gewayCodeModel);

            // 校验是否是白名单IP
            if (!StringUtils.isBlank(gewayCodeModel.getWhiteListIp())){
                HodgepodgeMethod.checkWhiteListIp(gewayCodeModel.getWhiteListIp(), ip);
            }

            // 获取同步模板数据
            NotifyTemplateModel notifyTemplateQuery = HodgepodgeMethod.assembleNotifyTemplateByGewayCodeIdQuery(gewayCodeModel.getId(), 2);
            NotifyTemplateModel notifyTemplateModel = ComponentUtil.notifyTemplateService.getNotifyTemplateModel(notifyTemplateQuery, ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO);
            HodgepodgeMethod.checkNotifyTemplateIsNull(notifyTemplateModel);
            return_str_suc = notifyTemplateModel.getSucTag();
            return_str_fail = notifyTemplateModel.getFailTag();

            // 获取同步字段数据
            NotifyFieldModel notifyFieldQuery = HodgepodgeMethod.assembleNotifyFieldByNotifyTemplateIdQuery(notifyTemplateModel.getId());
            List<NotifyFieldModel> notifyFieldList = ComponentUtil.notifyFieldService.getNotifyFieldList(notifyFieldQuery, ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO);
            HodgepodgeMethod.checkNotifyFieldListIsNull(notifyFieldList);

            // 先check是否有状态码的字段
            boolean flag_status = HodgepodgeMethod.checkNotifyStatus(dataMap, notifyTemplateModel);
            if (flag_status){
                // 解析同步的数据
                InOrderResultModel inOrderResultModel = HodgepodgeMethod.assembleInOrderResultAndCheckData(dataMap, notifyTemplateModel, notifyFieldList);
                HodgepodgeMethod.checkInOrderResultData(inOrderResultModel);

                // 根据订单号查询订单信息
                InOrderModel inOrderQuery = HodgepodgeMethod.assembleInOrderByOrderNoQuery(inOrderResultModel.getMyTradeNo());
                InOrderModel inOrderModel = (InOrderModel)ComponentUtil.inOrderService.findByObject(inOrderQuery);
                HodgepodgeMethod.checkInOrderIsNull(inOrderModel);

                // check订单金额与同步数据的订单金额是否一致
                HodgepodgeMethod.checkTotalAmount(inOrderResultModel, inOrderModel.getTotalAmount());

                // 判断是否有重复数据录入
                InOrderResultModel inOrderResultQuery = HodgepodgeMethod.assembleInOrderResultQuery(0, inOrderResultModel.getMyTradeNo(), inOrderResultModel.getTradeNo(),0,null);
                InOrderResultModel inOrderResultData = (InOrderResultModel)ComponentUtil.inOrderResultService.findByObject(inOrderResultQuery);
                HodgepodgeMethod.checkInOrderResultIsNotNull(inOrderResultData);

                // 组装上游数据，并且添加上游结果
                InOrderResultModel inOrderResultAdd = HodgepodgeMethod.assembleInOrderResultAdd(inOrderResultModel);
                int num = ComponentUtil.inOrderResultService.add(inOrderResultAdd);
                if (num > 0){
                    return return_str_suc;
                }else {
                    return return_str_fail;
                }
            }else {
                return return_str_fail;
            }

        }catch (Exception e){
            log.error(String.format("this InOrderController.get() is error , the data=%s!", JSON.toJSONString(dataMap)));
            e.printStackTrace();
            return return_str_fail;
        }
    }



    /**
     * @Description: 上游数据同步-postJson
     * <p>
     *
     * </p>
     * @param request
     * @param response
     * @return com.gd.chain.common.utils.JsonResult<java.lang.Object>
     * @author yoko
     * @date 2019/11/25 22:58
     * local:http://localhost:8098/pearData/inOrder/1/postJson
     * 请求的属性类:ProtocolInOrder
     * 必填字段:http://localhost:8098/pearData/inOrder/6/postJson
     * 字段:{"state":"2","msg":"成功","data":{"mch_id":"40","trade_no":"trade_no1","out_trade_no":"DS202109021136511","psg_trade_no":"psg_trade_no1","money":"50.00","notify_time":"2021-09-02 11:24:39","subject":"钻石"},"sign":"sign1"}
     */
    @RequestMapping(value = "/{identityKey}/postJson", method = {RequestMethod.POST})
    public String postJson(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "identityKey")String identityKey, @RequestBody Map<String, Object> dataMap) throws Exception{
        String ip = StringUtil.getIpAddress(request);
        String data = "";
        RegionModel regionModel = HodgepodgeMethod.assembleRegionModel(ip);
        int logSwitch = 0;// 打印log日志开关:1关闭，2打开
        String return_str_suc = "";// 成功返回的字符串
        String return_str_fail = "NO";// 默认返回的字符串

        // 策略数据：打印日志开关
        StrategyModel strategyLogSwitchQuery = HodgepodgeMethod.assembleStrategyQuery(ServerConstant.StrategyEnum.LOG_SWITCH.getStgType());
        StrategyModel strategyLogSwitchModel = ComponentUtil.strategyService.getStrategyModel(strategyLogSwitchQuery, ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO);
        logSwitch = strategyLogSwitchModel.getStgNumValue();

        // 打印请求的数据
        if (logSwitch == ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_TWO){
            log.info("---------InOrderController.postJson()-all-data-json:" + JSON.toJSONString(dataMap) + "ip:" + ip);
        }
        try{
            // 根据通道码ID校验是否有这个通道码信息
            GewayCodeModel gewayCodeQuery = HodgepodgeMethod.assembleGewayCodeQuery(0, null, 0,null,null,null,0, identityKey);
            GewayCodeModel gewayCodeModel = ComponentUtil.gewayCodeService.getGewayCodeModel(gewayCodeQuery, ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO);
            HodgepodgeMethod.checkGewayCodeIsNull(gewayCodeModel);

            // 校验是否是白名单IP
            if (!StringUtils.isBlank(gewayCodeModel.getWhiteListIp())){
                HodgepodgeMethod.checkWhiteListIp(gewayCodeModel.getWhiteListIp(), ip);
            }

            // 获取同步模板数据
            NotifyTemplateModel notifyTemplateQuery = HodgepodgeMethod.assembleNotifyTemplateByGewayCodeIdQuery(gewayCodeModel.getId(), 2);
            NotifyTemplateModel notifyTemplateModel = ComponentUtil.notifyTemplateService.getNotifyTemplateModel(notifyTemplateQuery, ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO);
            HodgepodgeMethod.checkNotifyTemplateIsNull(notifyTemplateModel);
            return_str_suc = notifyTemplateModel.getSucTag();
            return_str_fail = notifyTemplateModel.getFailTag();
            log.info("");

            // 获取同步字段数据
            NotifyFieldModel notifyFieldQuery = HodgepodgeMethod.assembleNotifyFieldByNotifyTemplateIdQuery(notifyTemplateModel.getId());
            List<NotifyFieldModel> notifyFieldList = ComponentUtil.notifyFieldService.getNotifyFieldList(notifyFieldQuery, ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO);
            HodgepodgeMethod.checkNotifyFieldListIsNull(notifyFieldList);

            // 先check是否有状态码的字段
            boolean flag_status = HodgepodgeMethod.checkNotifyStatus(dataMap, notifyTemplateModel);
            if (flag_status){
                // 解析同步的数据
                InOrderResultModel inOrderResultModel = HodgepodgeMethod.assembleInOrderResultAndCheckData(dataMap, notifyTemplateModel, notifyFieldList);
                HodgepodgeMethod.checkInOrderResultData(inOrderResultModel);

                // 根据订单号查询订单信息
                InOrderModel inOrderQuery = HodgepodgeMethod.assembleInOrderByOrderNoQuery(inOrderResultModel.getMyTradeNo());
                InOrderModel inOrderModel = (InOrderModel)ComponentUtil.inOrderService.findByObject(inOrderQuery);
                HodgepodgeMethod.checkInOrderIsNull(inOrderModel);

                // check订单金额与同步数据的订单金额是否一致
                HodgepodgeMethod.checkTotalAmount(inOrderResultModel, inOrderModel.getTotalAmount());

                // 判断是否有重复数据录入
                InOrderResultModel inOrderResultQuery = HodgepodgeMethod.assembleInOrderResultQuery(0, inOrderResultModel.getMyTradeNo(), inOrderResultModel.getTradeNo(),0,null);
                InOrderResultModel inOrderResultData = (InOrderResultModel)ComponentUtil.inOrderResultService.findByObject(inOrderResultQuery);
                HodgepodgeMethod.checkInOrderResultIsNotNull(inOrderResultData);
                log.info("");

                // 组装上游数据，并且添加上游结果
                InOrderResultModel inOrderResultAdd = HodgepodgeMethod.assembleInOrderResultAdd(inOrderResultModel);
                int num = ComponentUtil.inOrderResultService.add(inOrderResultAdd);
                if (num > 0){
                    return return_str_suc;
                }else {
                    return return_str_fail;
                }
            }else {
                return return_str_fail;
            }

        }catch (Exception e){
            log.error(String.format("this InOrderController.postJson() is error , the data=%s!", JSON.toJSONString(dataMap)));
            e.printStackTrace();
            return return_str_fail;
        }
    }



    /**
     * @Description: 上游数据同步-postForm
     * <p>
     *
     * </p>
     * @param request
     * @param response
     * @return com.gd.chain.common.utils.JsonResult<java.lang.Object>
     * @author yoko
     * @date 2019/11/25 22:58
     * local:http://localhost:8098/pearData/inOrder/5/postForm
     * 请求的属性类:ProtocolInOrder
     * 必填字段:http://localhost:8098/pearData/inOrder/5/postForm
     * 字段:{"state":"2","msg":"成功","data":{"mch_id":"40","trade_no":"trade_no1","out_trade_no":"DS202109021136511","psg_trade_no":"psg_trade_no1","money":"50.00","notify_time":"2021-09-02 11:24:39","subject":"钻石"},"sign":"sign1"}
     */
    @RequestMapping(value = "/{identityKey}/postForm", method = {RequestMethod.POST})
    public String postForm(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "identityKey")String identityKey,@RequestParam Map<String, Object> dataMap) throws Exception{
        String ip = StringUtil.getIpAddress(request);
        String data = "";
        RegionModel regionModel = HodgepodgeMethod.assembleRegionModel(ip);
        int logSwitch = 0;// 打印log日志开关:1关闭，2打开
        String return_str_suc = "";// 成功返回的字符串
        String return_str_fail = "NO";// 默认返回的字符串

        // 策略数据：打印日志开关
        StrategyModel strategyLogSwitchQuery = HodgepodgeMethod.assembleStrategyQuery(ServerConstant.StrategyEnum.LOG_SWITCH.getStgType());
        StrategyModel strategyLogSwitchModel = ComponentUtil.strategyService.getStrategyModel(strategyLogSwitchQuery, ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO);
        logSwitch = strategyLogSwitchModel.getStgNumValue();

        // 打印请求的数据
        if (logSwitch == ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_TWO){
            log.info("---------InOrderController.postForm()-all-data-json:" + JSON.toJSONString(dataMap) + "ip:" + ip);
        }
        try{
            // 根据通道码ID校验是否有这个通道码信息
            GewayCodeModel gewayCodeQuery = HodgepodgeMethod.assembleGewayCodeQuery(0, null, 0,null,null,null,0, identityKey);
            GewayCodeModel gewayCodeModel = ComponentUtil.gewayCodeService.getGewayCodeModel(gewayCodeQuery, ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO);
            HodgepodgeMethod.checkGewayCodeIsNull(gewayCodeModel);

            // 校验是否是白名单IP
            if (!StringUtils.isBlank(gewayCodeModel.getWhiteListIp())){
                HodgepodgeMethod.checkWhiteListIp(gewayCodeModel.getWhiteListIp(), ip);
            }

            // 获取同步模板数据
            NotifyTemplateModel notifyTemplateQuery = HodgepodgeMethod.assembleNotifyTemplateByGewayCodeIdQuery(gewayCodeModel.getId(), 2);
            NotifyTemplateModel notifyTemplateModel = ComponentUtil.notifyTemplateService.getNotifyTemplateModel(notifyTemplateQuery, ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO);
            HodgepodgeMethod.checkNotifyTemplateIsNull(notifyTemplateModel);
            return_str_suc = notifyTemplateModel.getSucTag();
            return_str_fail = notifyTemplateModel.getFailTag();
            log.info("1");

            // 获取同步字段数据
            NotifyFieldModel notifyFieldQuery = HodgepodgeMethod.assembleNotifyFieldByNotifyTemplateIdQuery(notifyTemplateModel.getId());
            List<NotifyFieldModel> notifyFieldList = ComponentUtil.notifyFieldService.getNotifyFieldList(notifyFieldQuery, ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO);
            HodgepodgeMethod.checkNotifyFieldListIsNull(notifyFieldList);

            // 先check是否有状态码的字段
            boolean flag_status = HodgepodgeMethod.checkNotifyStatus(dataMap, notifyTemplateModel);
            if (flag_status){
                // 解析同步的数据
                InOrderResultModel inOrderResultModel = HodgepodgeMethod.assembleInOrderResultAndCheckData(dataMap, notifyTemplateModel, notifyFieldList);
                HodgepodgeMethod.checkInOrderResultData(inOrderResultModel);

                // 根据订单号查询订单信息
                InOrderModel inOrderQuery = HodgepodgeMethod.assembleInOrderByOrderNoQuery(inOrderResultModel.getMyTradeNo());
                InOrderModel inOrderModel = (InOrderModel)ComponentUtil.inOrderService.findByObject(inOrderQuery);
                HodgepodgeMethod.checkInOrderIsNull(inOrderModel);

                // check订单金额与同步数据的订单金额是否一致
                HodgepodgeMethod.checkTotalAmount(inOrderResultModel, inOrderModel.getTotalAmount());

                // 判断是否有重复数据录入
                InOrderResultModel inOrderResultQuery = HodgepodgeMethod.assembleInOrderResultQuery(0, inOrderResultModel.getMyTradeNo(), inOrderResultModel.getTradeNo(),0,null);
                InOrderResultModel inOrderResultData = (InOrderResultModel)ComponentUtil.inOrderResultService.findByObject(inOrderResultQuery);
                HodgepodgeMethod.checkInOrderResultIsNotNull(inOrderResultData);
                log.info("1");

                // 组装上游数据，并且添加上游结果
                InOrderResultModel inOrderResultAdd = HodgepodgeMethod.assembleInOrderResultAdd(inOrderResultModel);
                int num = ComponentUtil.inOrderResultService.add(inOrderResultAdd);
                if (num > 0){
                    return return_str_suc;
                }else {
                    return return_str_fail;
                }
            }else {
                return return_str_fail;
            }

        }catch (Exception e){
            log.error(String.format("this InOrderController.postForm() is error , the data=%s!", JSON.toJSONString(dataMap)));
            e.printStackTrace();
            return return_str_fail;
        }
    }











}
