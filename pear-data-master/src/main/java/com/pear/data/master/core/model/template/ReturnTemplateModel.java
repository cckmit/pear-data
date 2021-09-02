package com.pear.data.master.core.model.template;

import com.pear.data.master.core.protocol.page.BasePage;

import java.io.Serializable;

/**
 * @ClassName:
 * @Description: 返回模板的实体属性Bean
 * @Author: yoko
 * @Date: $
 * @Version: 1.0
 **/
public class ReturnTemplateModel extends BasePage implements Serializable {
    private static final long   serialVersionUID = 1203223201523L;

    public ReturnTemplateModel(){

    }

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 通道码ID：对应tb_pr_geway_code表的主键ID
     */
    private Long gewayCodeId;

    /**
     * 模板名称
     */
    private String template;

    /**
     *返回数据类型：1直接返回，2返回一层json，3返回二层json
     */
    private Integer dataType;

    /**
     * check拉单状态的参数名
     */
    private String parameterName;

    /**
     * check拉单成功的参数值：如果有多个值代表成功，则以英文逗号分割
     */
    private String parameterValue;

    /**
     * check拉单成功参数值的数据类型：1String类型，2Int类型，3Long类型
     */
    private Integer parameterValueType;

    /**
     * 返回数据案例
     */
    private String returnCase;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否启用：0初始化属于暂停状态，1表示暂停使用，2正常状态
     */
    private Integer isEnable;

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

    public Long getGewayCodeId() {
        return gewayCodeId;
    }

    public void setGewayCodeId(Long gewayCodeId) {
        this.gewayCodeId = gewayCodeId;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
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

    public String getReturnCase() {
        return returnCase;
    }

    public void setReturnCase(String returnCase) {
        this.returnCase = returnCase;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
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
}
