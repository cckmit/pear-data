package com.pear.data.master.core.protocol.request.order;

import java.io.Serializable;

/**
 * @Description 出码的协议-第三方接口
 * @Author yoko
 * @Date 2020/9/9 10:54
 * @Version 1.0
 */
public class ProtocolInOrder implements Serializable {
    private static final long   serialVersionUID = 1233283332519L;

    public ProtocolInOrder(){

    }

    public String channel;// 商铺号
    public String trade_type;// 交易类型
    public String total_amount;// 参数名称：商家订单金额，订单总金额，单位为分
    public String out_trade_no;// 参数名称：商家订单号
    public String notify_url;// 异步通知地址
    public String interface_ver;// 接口版本
    public String return_url;// 参数名称：页面跳转同步通知地址支付成功后，通过页面跳转的方式跳转到商家网站
    public String extra_return_param;// 参数名称：回传参数商户如果支付请求是传递了该参数，则通知商户支付成功时会回传该参数
    public String client_ip;// 客户端IP地址
    public String sign;// 签名
    public String sub_time;// 提交时间
    public String product_name;// 商品名称
    public String product_code;// 商品码
    public String noredirect;// 1返回json数据，2返回base64加密的支付地址，3走302跳转


    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getInterface_ver() {
        return interface_ver;
    }

    public void setInterface_ver(String interface_ver) {
        this.interface_ver = interface_ver;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getExtra_return_param() {
        return extra_return_param;
    }

    public void setExtra_return_param(String extra_return_param) {
        this.extra_return_param = extra_return_param;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSub_time() {
        return sub_time;
    }

    public void setSub_time(String sub_time) {
        this.sub_time = sub_time;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getNoredirect() {
        return noredirect;
    }

    public void setNoredirect(String noredirect) {
        this.noredirect = noredirect;
    }
}
