package com.pear.data.master.util;

import com.alibaba.fastjson.JSON;
import com.pear.data.master.core.common.exception.ServiceException;
import com.pear.data.master.core.common.utils.DateUtil;
import com.pear.data.master.core.common.utils.StringUtil;
import com.pear.data.master.core.common.utils.constant.ErrorCode;
import com.pear.data.master.core.model.geway.GewayCodeModel;
import com.pear.data.master.core.model.order.InOrderModel;
import com.pear.data.master.core.model.order.InOrderResultModel;
import com.pear.data.master.core.model.strategy.StrategyData;
import com.pear.data.master.core.model.strategy.StrategyModel;
import com.pear.data.master.core.model.template.NotifyFieldModel;
import com.pear.data.master.core.model.template.NotifyTemplateModel;
import com.pear.data.master.core.protocol.response.ResponseData;
import com.pear.data.master.core.model.region.RegionModel;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


/**
 * @Description 公共方法类
 * @Author yoko
 * @Date 2020/1/7 20:25
 * @Version 1.0
 */
public class HodgepodgeMethod {
    private static Logger log = LoggerFactory.getLogger(HodgepodgeMethod.class);

    /**
     * @Description: 组装查询地域的查询条件
     * @param ip
     * @return RegionModel
     * @author yoko
     * @date 2019/12/18 18:41
     */
    public static RegionModel assembleRegionModel(String ip){
        RegionModel resBean = new RegionModel();
        resBean.setIp(ip);
        return resBean;
    }

    /**
     * @Description: 组装获取用户归属的省份跟城市
     * @param regionModel
     * @return
     * @author yoko
     * @date 2020/7/15 19:06
    */
    public static RegionModel getRegion(RegionModel regionModel){
        RegionModel resBean = new RegionModel();
        if (regionModel != null){
            // 获取地域信息
            if (!StringUtils.isBlank(regionModel.getIp())){
                regionModel = ComponentUtil.regionService.getCacheRegion(regionModel);
                resBean.setIp(regionModel.getIp());
                if (!StringUtils.isBlank(regionModel.getProvince())){
                    resBean.setProvince(regionModel.getProvince());
                }
                if (!StringUtils.isBlank(regionModel.getCity())){
                    resBean.setCity(regionModel.getCity());
                }
            }
        }
        return resBean;
    }

    /**
     * @Description: 公共的返回客户端的方法
     * @param stime - 服务器的时间
     * @param token - 登录token
     * @param sign - 签名
     * @return java.lang.String
     * @author yoko
     * @date 2019/11/13 21:45
     */
    public static String assembleResult(long stime, String token, String sign){
        ResponseData dataModel = new ResponseData();
        dataModel.stime = stime;
        if (!StringUtils.isBlank(token)){
            dataModel.token = token;
        }
        dataModel.sign = sign;
        return JSON.toJSONString(dataModel);
    }




    /**
     * @Description: 组装查询策略数据条件的方法
     * @return com.pf.play.rule.core.model.strategy.StrategyModel
     * @author yoko
     * @date 2020/5/19 17:12
     */
    public static StrategyModel assembleStrategyQuery(int stgType){
        StrategyModel resBean = new StrategyModel();
        resBean.setStgType(stgType);
        return resBean;
    }


    /**
     * @Description: 组装查询通道码的方法
     * @param id - 主键ID
     * @param idList - 主键ID的集合
     * @param gewayId - 通道ID
     * @param gewayCodeName - 通道码名称
     * @param myGewayCode - 我方通道码
     * @param gewayCode - 通道码
     * @param isEnable - 是否启用：0初始化属于暂停状态，1表示暂停使用，2正常状态
     * @param identityKey - 接收同步数据的身份key
     * @return com.hz.pear.master.core.model.geway.GewayCodeModel
     * @Author: yoko
     * @Date 2021/8/7 14:50
     */
    public static GewayCodeModel assembleGewayCodeQuery(long id, List<Long> idList, long gewayId, String gewayCodeName,
                                                        String myGewayCode, String gewayCode, int isEnable, String identityKey){
        GewayCodeModel resBean = new GewayCodeModel();
        if (id > 0){
            resBean.setId(id);
        }
        if (idList != null && idList.size() > 0){
            resBean.setIdList(idList);
        }
        if (gewayId > 0){
            resBean.setGewayId(gewayId);
        }
        if (!StringUtils.isBlank(gewayCodeName)){
            resBean.setGewayCodeName(gewayCodeName);
        }
        if (!StringUtils.isBlank(myGewayCode)){
            resBean.setMyGewayCode(myGewayCode);
        }
        if (!StringUtils.isBlank(gewayCode)){
            resBean.setGewayCode(gewayCode);
        }
        if (isEnable > 0){
            resBean.setIsEnable(isEnable);
        }
        if (!StringUtils.isBlank(identityKey)){
            resBean.setIdentityKey(identityKey);
        }
        return resBean;
    }

    /**
     * @Description: check通道码数据是否为空
     * @param gewayCodeModel
     * @return
     * @author yoko
     * @date 2020/05/14 15:57
     */
    public static void checkGewayCodeIsNull(GewayCodeModel gewayCodeModel) throws Exception{
        if (gewayCodeModel == null || gewayCodeModel.getId() == null || gewayCodeModel.getId() <= 0){
            throw new ServiceException(ErrorCode.ENUM_ERROR.IOR00001.geteCode(), ErrorCode.ENUM_ERROR.IOR00001.geteDesc());
        }
    }


    /**
     * @Description: 组装查询同步模板数据
     * @param gewayCodeId - 通道码ID
     * @param isEnable - 是否启用：0初始化属于暂停状态，1表示暂停使用，2正常状态
     * @return com.hz.pear.master.core.model.template.SendTemplateModel
     * @Author: yoko
     * @Date 2021/8/19 10:03
     */
    public static NotifyTemplateModel assembleNotifyTemplateByGewayCodeIdQuery(long gewayCodeId, int isEnable){
        NotifyTemplateModel resBean = new NotifyTemplateModel();
        resBean.setGewayCodeId(gewayCodeId);
        resBean.setIsEnable(isEnable);
        return resBean;
    }


    /**
     * @Description: check同步模板是否为空
     * @param notifyTemplateModel
     * @return
     * @author yoko
     * @date 2020/05/14 15:57
     */
    public static void checkNotifyTemplateIsNull(NotifyTemplateModel notifyTemplateModel) throws Exception{
        if (notifyTemplateModel == null || notifyTemplateModel.getId() == null || notifyTemplateModel.getId() <= 0){
            throw new ServiceException(ErrorCode.ENUM_ERROR.IOR00002.geteCode(), ErrorCode.ENUM_ERROR.IOR00002.geteDesc());
        }
    }


    /**
     * @Description: 组装查询同步字段数据
     * @param notifyTemplateId - 同步模板ID
     * @return com.hz.pear.master.core.model.template.ReturnFieldModel
     * @Author: yoko
     * @Date 2021/8/19 10:03
     */
    public static NotifyFieldModel assembleNotifyFieldByNotifyTemplateIdQuery(long notifyTemplateId){
        NotifyFieldModel resBean = new NotifyFieldModel();
        resBean.setNotifyTemplateId(notifyTemplateId);
        return resBean;
    }


    /**
     * @Description: check同步字段是否为空
     * @param notifyFieldList
     * @return
     * @author yoko
     * @date 2020/05/14 15:57
     */
    public static void checkNotifyFieldListIsNull(List<NotifyFieldModel> notifyFieldList) throws Exception{
        if (notifyFieldList == null || notifyFieldList.size() <= 0){
            throw new ServiceException(ErrorCode.ENUM_ERROR.IOR00003.geteCode(), ErrorCode.ENUM_ERROR.IOR00003.geteDesc());
        }
    }


    /**
     * @Description: check代收同步数据后同步的状态码是否是正确的
     * @param map - 同步数据的数据
     * @param notifyTemplateModel - 同步的模板信息
     * @return
     * @Author: yoko
     * @Date 2021/8/30 14:01
     */
    public static boolean checkNotifyStatus(Map<String, Object> map, NotifyTemplateModel notifyTemplateModel) throws Exception{
        boolean containsKey = map.containsKey(notifyTemplateModel.getParameterName());
        if (containsKey) {
            if (!StringUtils.isBlank(notifyTemplateModel.getParameterValue())){
                String [] strArr = notifyTemplateModel.getParameterValue().split(",");
                for (String str : strArr){
                    if (notifyTemplateModel.getParameterValueType() == 1){
                        // String类型
                        if (map.get(notifyTemplateModel.getParameterName()).equals(str)) {
                            return true;
                        }
                    }else if (notifyTemplateModel.getParameterValueType() == 2){
                        // Int类型
                        if (Integer.parseInt(map.get(notifyTemplateModel.getParameterName()).toString()) == Integer.parseInt(str)) {
                            return true;
                        }
                    }else if (notifyTemplateModel.getParameterValueType() == 3){
                        // Long类型
                        if (Long.parseLong(map.get(notifyTemplateModel.getParameterName()).toString()) == Long.parseLong(str)) {
                            return true;
                        }
                    }

                }
            }else {
                throw new ServiceException(ErrorCode.ENUM_ERROR.IOR00004.geteCode(), ErrorCode.ENUM_ERROR.IOR00004.geteDesc());
            }
        }else {
            return false;
        }
        return false;
    }


    /**
     * @Description: 组装上游同步的数据
     * @param dataMap - 上游同步的数据
     * @param notifyTemplateModel - 同步模板
     * @param notifyFieldList - 同步字段
     * @return com.pear.data.master.core.model.order.InOrderResultModel
     * @Author: yoko
     * @Date 2021/9/1 14:04
     */
    public static InOrderResultModel assembleInOrderResultAndCheckData(Map<String, Object> dataMap,
                                                                       NotifyTemplateModel notifyTemplateModel, List<NotifyFieldModel> notifyFieldList){
        InOrderResultModel resBean = new InOrderResultModel();
        if (notifyTemplateModel.getDataType() <= 2){
            // 只有一层json
            for (NotifyFieldModel data : notifyFieldList){
                if (data.getFieldType() == 1){
                    // 订单状态
                    // 无需做任何操作：因为优先check了状态了
                    resBean.setTradeStatus(1);
                }
                if (data.getFieldType() == 2){
                    // 上游订单号
                    if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                        resBean.setTradeNo(dataMap.get(data.getParameterName()).toString());
                    }

                }
                if (data.getFieldType() == 3){
                    // 商铺号
                    if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                        resBean.setPayId(dataMap.get(data.getParameterName()).toString());
                    }
                }
                if (data.getFieldType() == 4){
                    // 订单金额（单位：元）
                    if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                        resBean.setTotalAmount(dataMap.get(data.getParameterName()).toString());
                    }
                }
                if (data.getFieldType() == 5){
                    // 订单金额（单位：分）
                    if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                        String amount = StringUtil.getBigDecimalDivide(dataMap.get(data.getParameterName()).toString(), "100.00");
                        resBean.setTotalAmount(amount);
                    }
                }
                if (data.getFieldType() == 6){
                    // 交易时间
                    if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                        resBean.setTradeTime(dataMap.get(data.getParameterName()).toString());
                    }
                }
                if (data.getFieldType() == 7){
                    // 透传参数
                    if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                        resBean.setExtraReturnParam(dataMap.get(data.getParameterName()).toString());
                    }
                }
                if (data.getFieldType() == 8){
                    // 签名
                    if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                        resBean.setSign(dataMap.get(data.getParameterName()).toString());
                    }
                }
                if (data.getFieldType() == 10){
                    // 我方订单号
                    if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                        resBean.setMyTradeNo(dataMap.get(data.getParameterName()).toString());
                    }
                }
                if (data.getFieldType() == 11){
                    // 手续费
                    if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                        resBean.setServiceCharge(dataMap.get(data.getParameterName()).toString());
                    }
                }

            }
        }else if (notifyTemplateModel.getDataType() == 3){
            // 有二层json
            Map<String, Object> twoDataMap = new HashMap<>();
            for (NotifyFieldModel data : notifyFieldList){
                if (data.getFieldType() == 9){
//                    twoDataMap = JSON.parseObject(dataMap.get(data.getParameterName()).toString(), Map.class);
                    twoDataMap = (Map<String, Object>) dataMap.get(data.getParameterName());
                    break;
                }
            }



            for (NotifyFieldModel data : notifyFieldList){
                if (data.getFieldType() == 1){
                    // 订单状态
                    // 无需做任何操作：因为优先check了状态了
                    resBean.setTradeStatus(1);
                }
                if (data.getFieldType() == 2){
                    // 上游订单号
                    if (data.getSeat() == 1){
                        if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                            resBean.setTradeNo(dataMap.get(data.getParameterName()).toString());
                        }
                    }else if(data.getSeat() == 2){
                        // 第二层JSON
                        // 上游订单号
                        if (!StringUtils.isBlank(twoDataMap.get(data.getParameterName()).toString())){
                            resBean.setTradeNo(twoDataMap.get(data.getParameterName()).toString());
                        }
                    }
                }

                if (data.getFieldType() == 3){
                    // 商铺号
                    if (data.getSeat() == 1){
                        if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                            resBean.setPayId(dataMap.get(data.getParameterName()).toString());
                        }
                    }else if (data.getSeat() == 2){
                        if (!StringUtils.isBlank(twoDataMap.get(data.getParameterName()).toString())){
                            resBean.setPayId(twoDataMap.get(data.getParameterName()).toString());
                        }
                    }
                }

                if (data.getFieldType() == 4){
                    // 订单金额（单位：元）
                    if (data.getSeat() == 1){
                        if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                            resBean.setTotalAmount(dataMap.get(data.getParameterName()).toString());
                        }
                    }else if (data.getSeat() == 2){
                        if (!StringUtils.isBlank(twoDataMap.get(data.getParameterName()).toString())){
                            resBean.setTotalAmount(twoDataMap.get(data.getParameterName()).toString());
                        }
                    }
                }

                if (data.getFieldType() == 5){
                    // 订单金额（单位：分）
                    if (data.getSeat() == 1){
                        if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                            String amount = StringUtil.getBigDecimalDivide(dataMap.get(data.getParameterName()).toString(), "100.00");
                            resBean.setTotalAmount(amount);
                        }
                    }else if (data.getSeat() == 2){
                        if (!StringUtils.isBlank(twoDataMap.get(data.getParameterName()).toString())){
                            String amount = StringUtil.getBigDecimalDivide(twoDataMap.get(data.getParameterName()).toString(), "100.00");
                            resBean.setTotalAmount(amount);
                        }
                    }
                }

                if (data.getFieldType() == 6){
                    // 交易时间
                    if (data.getSeat() == 1){
                        if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                            resBean.setTradeTime(dataMap.get(data.getParameterName()).toString());
                        }
                    }else if (data.getSeat() == 2){
                        if (!StringUtils.isBlank(twoDataMap.get(data.getParameterName()).toString())){
                            resBean.setTradeTime(twoDataMap.get(data.getParameterName()).toString());
                        }
                    }
                }

                if (data.getFieldType() == 7){
                    // 透传参数
                    if (data.getSeat() == 1){
                        if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                            resBean.setExtraReturnParam(dataMap.get(data.getParameterName()).toString());
                        }
                    }else if (data.getSeat() == 2){
                        if (!StringUtils.isBlank(twoDataMap.get(data.getParameterName()).toString())){
                            resBean.setExtraReturnParam(twoDataMap.get(data.getParameterName()).toString());
                        }
                    }
                }

                if (data.getFieldType() == 8){
                    // 签名
                    if (data.getSeat() == 1){
                        if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                            resBean.setSign(dataMap.get(data.getParameterName()).toString());
                        }
                    }else if (data.getSeat() == 2){
                        if (!StringUtils.isBlank(twoDataMap.get(data.getParameterName()).toString())){
                            resBean.setSign(twoDataMap.get(data.getParameterName()).toString());
                        }
                    }
                }

                if (data.getFieldType() == 10){
                    // 我方订单号
                    if (data.getSeat() == 1){
                        if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                            resBean.setMyTradeNo(dataMap.get(data.getParameterName()).toString());
                        }
                    }else if (data.getSeat() == 2){
                        if (!StringUtils.isBlank(twoDataMap.get(data.getParameterName()).toString())){
                            resBean.setMyTradeNo(twoDataMap.get(data.getParameterName()).toString());
                        }
                    }
                }

                if (data.getFieldType() == 11){
                    // 手续费
                    if (data.getSeat() == 1){
                        if (!StringUtils.isBlank(dataMap.get(data.getParameterName()).toString())){
                            resBean.setServiceCharge(dataMap.get(data.getParameterName()).toString());
                        }
                    }else if (data.getSeat() == 2){
                        if (!StringUtils.isBlank(twoDataMap.get(data.getParameterName()).toString())){
                            resBean.setServiceCharge(twoDataMap.get(data.getParameterName()).toString());
                        }
                    }
                }

            }
        }
        return resBean;
    }


    /**
     * @Description: check上游同步的数据
     * @param inOrderResultModel
     * @return
     * @Author: yoko
     * @Date 2021/9/1 15:03
    */
    public static void checkInOrderResultData(InOrderResultModel inOrderResultModel) throws Exception{
        if (inOrderResultModel == null){
            throw new ServiceException(ErrorCode.ENUM_ERROR.IOR00005.geteCode(), ErrorCode.ENUM_ERROR.IOR00005.geteDesc());
        }

        if (StringUtils.isBlank(inOrderResultModel.getMyTradeNo())){
            throw new ServiceException(ErrorCode.ENUM_ERROR.IOR00006.geteCode(), ErrorCode.ENUM_ERROR.IOR00006.geteDesc());
        }

        if (StringUtils.isBlank(inOrderResultModel.getTradeNo())){
            throw new ServiceException(ErrorCode.ENUM_ERROR.IOR00007.geteCode(), ErrorCode.ENUM_ERROR.IOR00007.geteDesc());
        }

    }


    /**
     * @Description: 组装查询代收订单的查询方法
     * @param orderNo
     * @return 
     * @Author: yoko
     * @Date 2021/9/1 15:25 
    */
    public static InOrderModel assembleInOrderByOrderNoQuery(String orderNo){
        InOrderModel resBean = new InOrderModel();
        resBean.setMyTradeNo(orderNo);
        return resBean;
    }

    /**
     * @Description: check代收订单数据是否为空
     * @param inOrderModel
     * @return
     * @Author: yoko
     * @Date 2021/9/1 16:05
    */
    public static void checkInOrderIsNull(InOrderModel inOrderModel) throws Exception{
        if (inOrderModel == null || inOrderModel.getId() == null || inOrderModel.getId() <= 0){
            throw new ServiceException(ErrorCode.ENUM_ERROR.IOR00008.geteCode(), ErrorCode.ENUM_ERROR.IOR00008.geteDesc());
        }
    }


    /**
     * @Description: check拉单金额与同步金额是否一致
     * @param inOrderResultModel - 上游同步的数据
     * @param totalAmount - 拉单的订单金额
     * @return void
     * @Author: yoko
     * @Date 2021/9/1 16:15
     */
    public static void checkTotalAmount(InOrderResultModel inOrderResultModel, String totalAmount) throws Exception{
        if (!StringUtils.isBlank(inOrderResultModel.getTotalAmount())){
            // 金额相减
            String result = StringUtil.getBigDecimalSubtractByStr(inOrderResultModel.getTotalAmount(), totalAmount);
            if (!result.equals("0")){
                throw new ServiceException(ErrorCode.ENUM_ERROR.IOR00009.geteCode(), ErrorCode.ENUM_ERROR.IOR00009.geteDesc());
            }
        }
    }


    /**
     * @Description: 组装查询代收订单结果的查询方法
     * @param id - 主键ID
     * @param myTradeNo - 我方订单号
     * @param tradeNo - 上游订单号
     * @param tradeStatus - 交易状态/订单状态：1成功，2失败
     * @param payId - 商铺号
     * @return com.pear.data.master.core.model.order.InOrderResultModel
     * @Author: yoko
     * @Date 2021/9/1 17:00
     */
    public static InOrderResultModel assembleInOrderResultQuery(long id, String myTradeNo, String tradeNo, int tradeStatus, String payId){
        InOrderResultModel resBean = new InOrderResultModel();
        if (id > 0){
            resBean.setId(id);
        }
        if (!StringUtils.isBlank(myTradeNo)){
            resBean.setMyTradeNo(myTradeNo);
        }
        if (!StringUtils.isBlank(tradeNo)){
            resBean.setTradeNo(tradeNo);
        }
        if (tradeStatus > 0){
            resBean.setTradeStatus(tradeStatus);
        }
        if (!StringUtils.isBlank(payId)){
            resBean.setPayId(payId);
        }
        return resBean;
    }


    /**
     * @Description: check上游同步的数据是否已经存在数据库
     * @param inOrderResultModel
     * @return
     * @Author: yoko
     * @Date 2021/9/1 15:03
     */
    public static void checkInOrderResultIsNotNull(InOrderResultModel inOrderResultModel) throws Exception{
        if (inOrderResultModel != null && inOrderResultModel.getId() != null && inOrderResultModel.getId() > 0){
            throw new ServiceException(ErrorCode.ENUM_ERROR.IOR00010.geteCode(), ErrorCode.ENUM_ERROR.IOR00010.geteDesc());
        }
    }


    /**
     * @Description: 组装添加上游结果数据
     * @param inOrderResultModel
     * @return
     * @Author: yoko
     * @Date 2021/9/1 17:12
    */
    public static InOrderResultModel assembleInOrderResultAdd(InOrderResultModel inOrderResultModel){
        inOrderResultModel.setCurday(DateUtil.getDayNumber(new Date()));
        inOrderResultModel.setCurhour(DateUtil.getHour(new Date()));
        inOrderResultModel.setCurminute(DateUtil.getCurminute(new Date()));
        return inOrderResultModel;
    }


    /**
     * @Description: 校验同步数据是否是在白名单内的IP进行数据同步的
     * @param whiteListIp - 白名单IP：多个以英文逗号分割
     * @param ip - 同步数据的IP
     * @return void
     * @author yoko
     * @date 2020/10/31 19:29
     */
    public static void checkWhiteListIp(String whiteListIp, String ip) throws Exception{
        if (!StringUtils.isBlank(whiteListIp)){
            if (whiteListIp.indexOf(ip) <= -1){
                throw new ServiceException(ErrorCode.ENUM_ERROR.IOR00011.geteCode(), ErrorCode.ENUM_ERROR.IOR00011.geteDesc());
            }

        }

    }


    /**
     * @Description: check代收订单的状态是否不是初始化状态
     * <p>
     *     接收同步数据时：订单如果不是初始化状态，则数据不做接收
     * </p>
     * @param inOrderModel
     * @return
     * @Author: yoko
     * @Date 2021/9/1 16:05
     */
    public static void checkInOrderOrderStatus(InOrderModel inOrderModel) throws Exception{
        if (inOrderModel.getOrderStatus() != 1){
            throw new ServiceException(ErrorCode.ENUM_ERROR.IOR00012.geteCode(), ErrorCode.ENUM_ERROR.IOR00012.geteDesc());
        }
    }















    public static void main(String [] args) throws Exception{
        Map<String, Object> dataMap = new HashMap<>();

        NotifyTemplateModel notifyTemplateModel = new NotifyTemplateModel();

        List<NotifyFieldModel> notifyFieldList = new ArrayList<>();

        HodgepodgeMethod.assembleInOrderResultAndCheckData(dataMap, notifyTemplateModel, notifyFieldList);


    }




    

}
