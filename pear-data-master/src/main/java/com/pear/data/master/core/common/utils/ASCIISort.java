package com.pear.data.master.core.common.utils;

import com.alibaba.fastjson.JSON;
import com.pear.data.master.core.model.geway.GewayCodeModel;
import com.pear.data.master.core.model.template.ReturnFieldModel;
import com.pear.data.master.core.model.template.ReturnTemplateModel;
import com.pear.data.master.core.model.template.SendFieldModel;
import com.pear.data.master.core.model.template.SendTemplateModel;
import com.pear.data.master.core.protocol.request.order.ProtocolInOrder;
import com.pear.data.master.util.HodgepodgeMethod;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @Description 字符串ASCII码排序的工具类
 * @Author yoko
 * @Date 2020/11/20 15:45
 * @Version 1.0
 */
public class ASCIISort {
    private static Logger log = LoggerFactory.getLogger(ASCIISort.class);




    /**
     * 生成签名
     * @param map
     * @param changeType - 大小写类型转换：1小写，2大写
     * @return
     */
    public static String getKeySign(Map<String, Object> map, String key, String secretKey, int changeType) {
        String result = "";
        try {
            List<Map.Entry<String, Object>> infoIds = new ArrayList<Map.Entry<String, Object>>(map.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, Object>>() {

                public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });

            // 构造签名键值对的格式
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> item : infoIds) {
                if (item.getKey() != null || item.getKey() != "") {
                    log.info("");
                    String str = item.getKey();
                    Object val = item.getValue();
                    if (!(val == "" || val == null)) {
                        sb.append(str + "=" + val + "&");
                    }
                }

            }
            result = sb.toString() + "&" + key + "=" + secretKey;
//            String str = sb.toString().substring(0, sb.toString().length() - 1);
            log.info("result:" + result);
            //进行MD5加密
            if (changeType == 1){
                result = DigestUtils.md5Hex(result).toLowerCase();
            }else if (changeType == 2){
                result = DigestUtils.md5Hex(result).toUpperCase();
            }
        } catch (Exception e) {
            return null;
        }
        return result;
    }





    /**
     * 生成签名
     * 根据ascii升序进行生成签名
     * @param map
     * @param key - 秘钥的参数名
     * @param secretKey - 秘钥
     * @param encryptionType - 加密类型：1md5加密，2base64加密，3md5加密之后在base64加密
     * @param encryptionWay - 大小写加密方式：1无需大小写，2小写加密，3大写加密
     * @param secretKeySeat - 秘钥放置位置：1存放字符串末尾，2根据ascii排序存放
     * @param secretKeyType - 秘钥key类型：1无需key存放在字符串最末尾，2需要key当做参数名赋值秘钥存放在最末尾
     * @param encryptionSort - 加密排序：1按照指定顺序，2按照ascii码升序，3按照ascii码降序
     * @return
     */
    public static String getSign(Map<String, Object> map, String key, String secretKey, int encryptionType, int encryptionWay,
                                    int secretKeySeat, int secretKeyType, int encryptionSort) {
        String result = "";
        try {
            List<Map.Entry<String, Object>> infoIds = new ArrayList<Map.Entry<String, Object>>(map.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, Object>>() {

                public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });

            // 构造签名键值对的格式
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> item : infoIds) {
                if (item.getKey() != null || item.getKey() != "") {
                    String str = item.getKey();
                    Object val = item.getValue();
                    if (!(val == "" || val == null)) {
                        sb.append(str + "=" + val + "&");
                    }
                }

            }
            String str = sb.toString().substring(0, sb.toString().length() - 1);
            result = str;
            if (secretKeySeat == 1){
                if (secretKeyType == 1){
                    result = result + secretKey;
                }else {
                    result = result + "&" + key + "=" + secretKey;
                }
            }

            if (encryptionType == 1){
                result = DigestUtils.md5Hex(result);
            }else if (encryptionType == 2){
                result = StringUtil.mergeCodeBase64(result);
            }else if (encryptionType == 3){
                result = DigestUtils.md5Hex(result);
                result = StringUtil.mergeCodeBase64(result);
            }
            if (encryptionWay == 2){
                result = result.toLowerCase();
            }else if (encryptionWay == 3){
                result = result.toUpperCase();
            }
        } catch (Exception e) {
            return null;
        }
        return result;
    }


    /**
     * @Description: 根据顺序加密
     * @param str - 要加密的字符串
     * @param encryptionType - 加密类型：1md5加密，2base64加密，3md5加密之后在base64加密
     * @param encryptionWay - 大小写加密方式：1无需大小写，2小写加密，3大写加密
     * @return java.lang.String
     * @Author: yoko
     * @Date 2021/8/24 15:27
     */
    public static String getSignBySort(String str, int encryptionType, int encryptionWay) throws Exception{
        String resStr = "";
        if (encryptionType == 1){
            resStr = DigestUtils.md5Hex(str);
        }else if (encryptionType == 2){
            resStr = StringUtil.mergeCodeBase64(str);
        }else if (encryptionType == 3){
            resStr = DigestUtils.md5Hex(str);
            resStr = StringUtil.mergeCodeBase64(resStr);
        }
        if (encryptionWay == 2){
            resStr = resStr.toLowerCase();
        }else if (encryptionWay == 3){
            resStr = resStr.toUpperCase();
        }
        return resStr;
    }










    public static void main(String [] args) throws Exception{
//        String url = "https://gopay.huafuwg.com/pay/Apply/newone";
//        String key ="Svz35Ge7MrneRpBvbPN5u2Nhx0zoisU7";
//        Map<String ,Object> sendDataMap = new HashMap<>();
//        sendDataMap.put("uid", "12138");
//        sendDataMap.put("addtime", String.valueOf(System.currentTimeMillis()));
//        sendDataMap.put("out_trade_id", String.valueOf(System.currentTimeMillis()));
//        sendDataMap.put("amount", "100.00");
//        sendDataMap.put("bankcode", "unionpay");
//        sendDataMap.put("bankuser", "测试_收款户名");
//        sendDataMap.put("bankname", "测试_银行名称");
//        sendDataMap.put("bankno", "测试_收款账号");
//        sendDataMap.put("notifyurl", "http://www.baidu.com/notifyurl");
////        String sb = ASCIISort.getSign(sendDataMap, key, 2);
////        System.out.println("sb:" + sb);
////        sendDataMap.put("sign", sb);
//        String sendData = JSON.toJSONString(sendDataMap);
//
//        String resultData = HttpSendUtils.sendPostAppJson(url, sendData);
//        resultData ="{\"code\":1,\"msg\":\"成功\",\"time\":1605865733,\"data\":{\"code\":1,\"msg\":\"成功\",\"uid\":\"12138\",\"balance\":\"900.00\",\"addtime\":\"1605865731211\",\"out_trade_id\":\"1605865731211\",\"orderid\":\"1858665732969251215\",\"amount\":\"100.00\",\"sign\":\"2838c31a3e2c1e9e4a15d26c52df530d\"}}";
//        Map<String, Object> resMap = new HashMap<>();
//        Map<String, Object> dataMap = new HashMap<>();
//        if (!StringUtils.isBlank(resultData)) {
//            resMap = JSON.parseObject(resultData, Map.class);
//            if (Integer.parseInt(resMap.get("code").toString()) == 1) {
//                System.out.println("code:" + resMap.get("code"));
//            }
//        }
//        System.out.println("resultData:" + resultData);





    }

}
