package com.pear.data.master.core.common.utils.constant;

/**
 * @author df
 * @Description:redis的key
 * @create 2019-05-22 15:43
 **/
public interface CacheKey {

    /**
     * 策略数据
     */
    String STRATEGY = "-1";

    /**
     * 查询订单号状态时，纪录的商家订单号
     */
    String OUT_TRADE_NO_BY_IN_ORDER = "-2";

    /**
     * 锁：渠道在累积金额时需要进行redis锁
     */
    String LOCK_CHANNEL_MONEY = "-3";


    /**
     * 锁：代理在累积金额时需要进行redis锁
     */
    String LOCK_AGENT_MONEY = "-4";

    /**
     * 通道码数据
     */
    String GEWAY_CODE = "-5";

    /**
     * 锁：通道码在累积跑量金额时需要进行redis锁
     */
    String LOCK_GEWAY_CODE_MONEY = "-6";

    /**
     * 渠道信息
     */
    String CHANNEL = "-7";

    /**
     * 请求模板
     */
    String SEND_TEMPLATE = "-8";

    /**
     * 请求字段
     */
    String SEND_FIELD = "-9";

    /**
     * 请求字段-集合
     */
    String SEND_FIELD_LIST = "-10";

    /**
     * 返回模板
     */
    String RETURN_TEMPLATE = "-11";

    /**
     * 返回字段
     */
    String RETURN_FIELD = "-12";

    /**
     * 返回字段-集合
     */
    String RETURN_FIELD_LIST = "-13";


    /**
     * 接收模板
     */
    String NOTIFY_TEMPLATE = "-14";

    /**
     * 接收字段
     */
    String NOTIFY_FIELD = "-15";

    /**
     * 接收字段-集合
     */
    String NOTIFY_FIELD_LIST = "-16";

}
