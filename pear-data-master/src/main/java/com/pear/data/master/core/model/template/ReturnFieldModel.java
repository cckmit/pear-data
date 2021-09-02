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
public class ReturnFieldModel extends BasePage implements Serializable {
    private static final long   serialVersionUID = 1203223201523L;

    public ReturnFieldModel(){

    }

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 归属返回模板ID：对应tb_pr_return_template表的主键ID
     */
    private Long returnTemplateId;

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
     * 字段类型：1支付连接地址，2图片二维码地址，3json第二层的data
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

    public Long getReturnTemplateId() {
        return returnTemplateId;
    }

    public void setReturnTemplateId(Long returnTemplateId) {
        this.returnTemplateId = returnTemplateId;
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
