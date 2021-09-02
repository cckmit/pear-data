package com.pear.data.master.core.protocol.response.order;


import java.io.Serializable;

/**
 * @Description 协议：代收订单
 * @Author yoko
 * @Date 2020/5/22 11:04
 * @Version 1.0
 */
public class ResponseInOrder implements Serializable {
    private static final long   serialVersionUID = 1233023131150L;

    public String trade_no;// 订单号
    public String total_amount;// 订单金额
    public String pay_url;// 支付地址
    public String pay_picture_url;// 支付的二维码图片地址
    public String timestamp;// 时间戳


    public ResponseInOrder(){

    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getPay_url() {
        return pay_url;
    }

    public void setPay_url(String pay_url) {
        this.pay_url = pay_url;
    }

    public String getPay_picture_url() {
        return pay_picture_url;
    }

    public void setPay_picture_url(String pay_picture_url) {
        this.pay_picture_url = pay_picture_url;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
