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

    /**
     * 代收跳转的token
     */
    String IN_ORDER_JUMP_TOKEN = "-17";

    /**
     * 代收，支付成功后跳转地址的token
     */
    String IN_ORDER_RETURN_URL_TOKEN = "-18";

    /**
     * token锁住操作
     * <p>
     *     跳转时token锁住操作
     * </p>
     */
    String LOCK_IN_ORDER_JUMP_TOKEN = "-19";

    /**
     * 渠道号
     * <p>
     *     根据渠道号存储渠道信息
     * </p>
     */
    String CHANNEL_NUM = "-20";

    /**
     * 频繁请求的IP
     * <p>
     *     缓存中存的请求频繁的IP
     * </p>
     */
    String FREQUENTLY_IP = "-frequently-ip";


    /**
     * 频繁请求的渠道
     * <p>
     *     缓存中存的请求频繁的渠道
     * </p>
     */
    String FREQUENTLY_CHANNEL = "-frequently-channel";

}
