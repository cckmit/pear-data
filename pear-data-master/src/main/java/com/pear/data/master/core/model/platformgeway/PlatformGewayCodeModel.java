package com.pear.data.master.core.model.platformgeway;

import com.pear.data.master.core.protocol.page.BasePage;

import java.io.Serializable;

/**
 * @ClassName:
 * @Description: 平台通道码的实体属性Bean
 * @Author: yoko
 * @Date: $
 * @Version: 1.0
 **/
public class PlatformGewayCodeModel extends BasePage implements Serializable {
    private static final long   serialVersionUID = 1233223301186L;

    /**
     * 自增主键ID
     */
    private Long id;

    /**
     * 平台通道码名称
     */
    private String codeName;

    /**
     * 平台通道编码
     */
    private String pfGewayCode;

    /**
     * 费率类型：1固定费率，2额外费率
     */
    private Integer serviceChargeType;

    /**
     * 费率
     */
    private String serviceCharge;

    /**
     * 费率之额外费率：每单还要收取额外的手续费
     */
    private String extraServiceCharge;

    /**
     * 平台通道码类型：1代收，2代付
     */
    private Integer pfGewayCodeType;

    /**
     * 支持金额
     */
    private String moneyRange;

    /**
     * 是否要进行跳转：1不跳转，2跳转
     */
    private Integer isJump;

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

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getPfGewayCode() {
        return pfGewayCode;
    }

    public void setPfGewayCode(String pfGewayCode) {
        this.pfGewayCode = pfGewayCode;
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

    public Integer getPfGewayCodeType() {
        return pfGewayCodeType;
    }

    public void setPfGewayCodeType(Integer pfGewayCodeType) {
        this.pfGewayCodeType = pfGewayCodeType;
    }

    public String getMoneyRange() {
        return moneyRange;
    }

    public void setMoneyRange(String moneyRange) {
        this.moneyRange = moneyRange;
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

    public Integer getIsJump() {
        return isJump;
    }

    public void setIsJump(Integer isJump) {
        this.isJump = isJump;
    }
}
