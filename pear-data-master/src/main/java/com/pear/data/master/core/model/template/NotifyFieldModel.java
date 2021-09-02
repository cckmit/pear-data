package com.pear.data.master.core.model.template;

import com.pear.data.master.core.protocol.page.BasePage;

import java.io.Serializable;

/**
 * @ClassName:
 * @Description: 接收字段的实体属性Bean
 * @Author: yoko
 * @Date: $
 * @Version: 1.0
 **/
public class NotifyFieldModel extends BasePage implements Serializable {
    private static final long   serialVersionUID = 1203223201523L;

    public NotifyFieldModel(){

    }

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 归属接收模板ID：对应tb_pr_notify_template表的主键ID
     */
    private Long notifyTemplateId;

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
     * 字段类型：1订单状态，2上游订单号，3商铺号，4订单金额（单位：元），5订单金额（单位：分），6交易时间，7透传参数，8签名，9json第二层的data，10我方订单号，11手续费
     */
    private Integer fieldType;

    /**
     * 存放位置：1在第一层JSON，2在第二层JSON
     */
    private Integer seat;

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

    public Long getNotifyTemplateId() {
        return notifyTemplateId;
    }

    public void setNotifyTemplateId(Long notifyTemplateId) {
        this.notifyTemplateId = notifyTemplateId;
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

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }
}
