package com.pear.data.master.core.model.agent;

import com.pear.data.master.core.protocol.page.BasePage;

import java.io.Serializable;

/**
 * @ClassName:
 * @Description: 代理利益分配的实体属性Bean
 * @Author: yoko
 * @Date: $
 * @Version: 1.0
 **/
public class AgentProfitDistributionModel extends BasePage implements Serializable {
    private static final long   serialVersionUID = 1233233302187L;

    public AgentProfitDistributionModel(){

    }

    /**
     * 自增主键ID
     */
    private Long id;

    /**
     * 别名
     */
    private String alias;

    /**
     * 归属代理ID
     */
    private Long agentId;

    /**
     * 通道码ID
     */
    private Long gewayCodeId;

    /**
     * 归属渠道ID
     */
    private Long channelId;

    /**
     * 绑定类型：1与通道码绑定，2与渠道绑定，3与渠道+通道码绑定
     */
    private Integer bindingType;


    /**
     * 利益类型/费率类型：1固定费率，2额外费率
     */
    private Integer serviceChargeType;

    /**
     * 利益分成/费率
     */
    private String serviceCharge;

    /**
     * 利益值额外利益/费率之额外费率
     */
    private String extraServiceCharge;

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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public Long getGewayCodeId() {
        return gewayCodeId;
    }

    public void setGewayCodeId(Long gewayCodeId) {
        this.gewayCodeId = gewayCodeId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Integer getBindingType() {
        return bindingType;
    }

    public void setBindingType(Integer bindingType) {
        this.bindingType = bindingType;
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

    public Integer getServiceChargeType() {
        return serviceChargeType;
    }

    public void setServiceChargeType(Integer serviceChargeType) {
        this.serviceChargeType = serviceChargeType;
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getExtraServiceCharge() {
        return extraServiceCharge;
    }

    public void setExtraServiceCharge(String extraServiceCharge) {
        this.extraServiceCharge = extraServiceCharge;
    }
}
