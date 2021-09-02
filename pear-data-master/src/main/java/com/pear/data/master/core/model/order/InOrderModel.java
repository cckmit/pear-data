package com.pear.data.master.core.model.order;


import com.pear.data.master.core.protocol.page.BasePage;

import java.io.Serializable;

/**
 * @Description 任务订单的实体属性Bean
 * @Author yoko
 * @Date 2020/5/21 19:27
 * @Version 1.0
 */
public class InOrderModel extends BasePage implements Serializable {
    private static final long   serialVersionUID = 1203223201121L;

    public InOrderModel(){

    }

    /**
     * 主键ID
     */
    private Long id;


    /**
     * 我方订单号
     */
    private String myTradeNo;

    /**
     * 参数名称：商家订单号
     */
    private String outTradeNo;

    /**
     * 上游订单号
     */
    private String tradeNo;

    /**
     * 渠道的主键ID
     */
    private Long channelId;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 平台通道编码ID：对应tb_pr_platform_geway_code表的主键ID
     */
    private Long pfGewayCodeId;

    /**
     * 平台通道编码
     */
    private String pfGewayCode;

    /**
     * 平台通道码名称
     */
    private String codeName;

    /**
     * 通道ID
     */
    private Long gewayId;

    /**
     * 通道名称
     */
    private String gewayName;

    /**
     * 通道码ID：对应tb_pr_geway_code表的主键ID
     */
    private Long gewayCodeId;

    /**
     * 通道码
     */
    private String gewayCode;

    /**
     * 通道码名称
     */
    private String gewayCodeName;

    /**
     * 渠道号/商铺号
     */
    private String channel;

    /**
     * 参数名称：商家订单金额，订单总金额
     */
    private String totalAmount;

    /**
     * 手续费
     */
    private String serviceCharge;

    /**
     * 实际金额
     */
    private String actualMoney;

    /**
     * 订单状态：1初始化，2超时/失败，3有质疑，4成功
     */
    private Integer orderStatus;

    /**
     * 订单拉单状态：1拉单成功，2拉单失败
     */
    private Integer pullOrderStatus;

    /**
     * 拉单码类型：1根据平台通道码拉单，2根据通道码拉单
     */
    private Integer pullOrderCodeType;

    /**
     * 异步通知地址/渠道
     */
    private String notifyUrl;

    /**
     * 我方异步通知地址
     */
    private String myNotifyUrl;

    /**
     * 接口版本
     */
    private String interfaceVer;

    /**
     * 参数名称：页面跳转同步通知地址；支付成功后，通过页面跳转的方式跳转到商家网站
     */
    private String returnUrl;

    /**
     * 参数名称：回传参数商户如果支付请求是传递了该参数，则通知商户支付成功时会回传该参数
     */
    private String extraReturnParam;

    /**
     * 发起拉单服务端IP
     */
    private String serviceIp;

    /**
     * 客户端IP地址
     */
    private String clientIp;

    /**
     * 参数名称：平台返回签名数据该参数用于验签
     */
    private String sign;

    /**
     * 提交时间
     */
    private String subTime;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * productCode
     */
    private String productCode;

    /**
     * 订单的回执时间
     */
    private String tradeTime;

    /**
     * 是否是补单：1初始化不是补单，2是补单
     */
    private Integer replenishType;

    /**
     * 是否用于计算收益：1不计算收益，2计算收益
     */
    private Integer isProfit;

    /**
     * 数据说明：做解说用的
     */
    private String dataExplain;

    /**
     * 创建日期：存的日期格式20160530
     */
    private Integer curday;

    /**
     * 创建所属小时：24小时制
     */
    private Integer curhour;

    /**
     * 创建所属分钟：60分钟制
     */
    private Integer curminute;

    /**
     *运行计算次数
     */
    private Integer runNum;

    /**
     * 运行计算状态：0初始化，1锁定，2计算失败，3计算成功
     */
    private Integer runStatus;

    /**
     *发送次数
     */
    private Integer sendNum;

    /**
     * 发送状态：0初始化，1锁定，2计算失败，3计算成功
     */
    private Integer sendStatus;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 是否有效：0有效，1无效/删除
     */
    private Integer yn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMyTradeNo() {
        return myTradeNo;
    }

    public void setMyTradeNo(String myTradeNo) {
        this.myTradeNo = myTradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Long getPfGewayCodeId() {
        return pfGewayCodeId;
    }

    public void setPfGewayCodeId(Long pfGewayCodeId) {
        this.pfGewayCodeId = pfGewayCodeId;
    }

    public String getPfGewayCode() {
        return pfGewayCode;
    }

    public void setPfGewayCode(String pfGewayCode) {
        this.pfGewayCode = pfGewayCode;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Long getGewayId() {
        return gewayId;
    }

    public void setGewayId(Long gewayId) {
        this.gewayId = gewayId;
    }

    public String getGewayName() {
        return gewayName;
    }

    public void setGewayName(String gewayName) {
        this.gewayName = gewayName;
    }

    public Long getGewayCodeId() {
        return gewayCodeId;
    }

    public void setGewayCodeId(Long gewayCodeId) {
        this.gewayCodeId = gewayCodeId;
    }

    public String getGewayCode() {
        return gewayCode;
    }

    public void setGewayCode(String gewayCode) {
        this.gewayCode = gewayCode;
    }

    public String getGewayCodeName() {
        return gewayCodeName;
    }

    public void setGewayCodeName(String gewayCodeName) {
        this.gewayCodeName = gewayCodeName;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(String actualMoney) {
        this.actualMoney = actualMoney;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPullOrderStatus() {
        return pullOrderStatus;
    }

    public void setPullOrderStatus(Integer pullOrderStatus) {
        this.pullOrderStatus = pullOrderStatus;
    }

    public Integer getPullOrderCodeType() {
        return pullOrderCodeType;
    }

    public void setPullOrderCodeType(Integer pullOrderCodeType) {
        this.pullOrderCodeType = pullOrderCodeType;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getMyNotifyUrl() {
        return myNotifyUrl;
    }

    public void setMyNotifyUrl(String myNotifyUrl) {
        this.myNotifyUrl = myNotifyUrl;
    }

    public String getInterfaceVer() {
        return interfaceVer;
    }

    public void setInterfaceVer(String interfaceVer) {
        this.interfaceVer = interfaceVer;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getExtraReturnParam() {
        return extraReturnParam;
    }

    public void setExtraReturnParam(String extraReturnParam) {
        this.extraReturnParam = extraReturnParam;
    }

    public String getServiceIp() {
        return serviceIp;
    }

    public void setServiceIp(String serviceIp) {
        this.serviceIp = serviceIp;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSubTime() {
        return subTime;
    }

    public void setSubTime(String subTime) {
        this.subTime = subTime;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public Integer getReplenishType() {
        return replenishType;
    }

    public void setReplenishType(Integer replenishType) {
        this.replenishType = replenishType;
    }

    public Integer getIsProfit() {
        return isProfit;
    }

    public void setIsProfit(Integer isProfit) {
        this.isProfit = isProfit;
    }

    public Integer getCurday() {
        return curday;
    }

    public void setCurday(Integer curday) {
        this.curday = curday;
    }

    public Integer getCurhour() {
        return curhour;
    }

    public void setCurhour(Integer curhour) {
        this.curhour = curhour;
    }

    public Integer getCurminute() {
        return curminute;
    }

    public void setCurminute(Integer curminute) {
        this.curminute = curminute;
    }

    public Integer getRunNum() {
        return runNum;
    }

    public void setRunNum(Integer runNum) {
        this.runNum = runNum;
    }

    public Integer getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(Integer runStatus) {
        this.runStatus = runStatus;
    }

    public Integer getSendNum() {
        return sendNum;
    }

    public void setSendNum(Integer sendNum) {
        this.sendNum = sendNum;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public String getDataExplain() {
        return dataExplain;
    }

    public void setDataExplain(String dataExplain) {
        this.dataExplain = dataExplain;
    }
}
