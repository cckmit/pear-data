package com.pear.data.master.core.model.template;

import com.pear.data.master.core.protocol.page.BasePage;

import java.io.Serializable;

/**
 * @ClassName:
 * @Description: 请求字段的实体属性Bean
 * @Author: yoko
 * @Date: $
 * @Version: 1.0
 **/
public class SendFieldModel extends BasePage implements Serializable {
    private static final long   serialVersionUID = 1203223201522L;

    public SendFieldModel(){

    }

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 归属请求模板ID：对应tb_pr_send_template表的主键ID
     */
    private Long sendTemplateId;

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     *参数名称
     */
    private String parameterName;

    /**
     * 参数值
     */
    private String parameterValue;

    /**
     * 参数值类型：1String类型，2Int类型,3Long类型
     */
    private Integer parameterValueType;

    /**
     * 是否要加密：1加密，2不加密
     */
    private Integer isEncryption;

    /**
     * 是否允许为空：1不允许为空，2允许为空
     */
    private Integer isVacant;

    /**
     * 顺序/位置
     */
    private Integer seat;

    /**
     * 字段类型：1其它，2订单号/商家订单号，3商铺号，4通道码，5订单金额（单位：元），6订单金额（单位：分），7异步同步地址，8支付成功后跳转地址，9签名，10客户端IP，11时间：yyyy-MM-dd HH:mm:ss，12时间：yyyyMMddHHmmss，13时间：13位时间戳，14时间：10位时间戳，15秘钥变量名
     */
    private Integer fieldType;

    /**
     * 备注
     */
    private String remark;

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

    public Long getSendTemplateId() {
        return sendTemplateId;
    }

    public void setSendTemplateId(Long sendTemplateId) {
        this.sendTemplateId = sendTemplateId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    public Integer getParameterValueType() {
        return parameterValueType;
    }

    public void setParameterValueType(Integer parameterValueType) {
        this.parameterValueType = parameterValueType;
    }

    public Integer getIsEncryption() {
        return isEncryption;
    }

    public void setIsEncryption(Integer isEncryption) {
        this.isEncryption = isEncryption;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getFieldType() {
        return fieldType;
    }

    public void setFieldType(Integer fieldType) {
        this.fieldType = fieldType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getIsVacant() {
        return isVacant;
    }

    public void setIsVacant(Integer isVacant) {
        this.isVacant = isVacant;
    }
}
