package com.pear.data.master.core.model.geway;


import com.pear.data.master.core.protocol.page.BasePage;

import java.io.Serializable;

/**
 * @Description 通道的实体属性Bean
 * @Author yoko
 * @Date 2020/3/24 15:37
 * @Version 1.0
 */
public class GewayModel extends BasePage implements Serializable {
    private static final long   serialVersionUID = 123322343301146L;

    /**
     * 自增主键ID
     */
    private Long id;

    /**
     * 通道名称
     */
    private String gewayName;

    /**
     *通道名称
     */
    private String secretKey;

    /**
     * 商铺号（商家号）
     */
    private String payId;

    /**
     * 通道属性：1代收，2代付
     */
    private Integer attributeType;

    /**
     * 总账
     */
    private String totalMoney;


    /**
     * 保底金额：预付款通道，如果余额少于保底金额，就不出码
     */
    private String leastMoney;

    /**
     * 余额
     */
    private String balance;

    /**
     * 锁定金额
     */
    private String lockMoney;

    /**
     * 通道类型：1普通通道，2预付款通道
     */
    private Integer gewayType;

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

    public String getGewayName() {
        return gewayName;
    }

    public void setGewayName(String gewayName) {
        this.gewayName = gewayName;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public Integer getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(Integer attributeType) {
        this.attributeType = attributeType;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getLeastMoney() {
        return leastMoney;
    }

    public void setLeastMoney(String leastMoney) {
        this.leastMoney = leastMoney;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getLockMoney() {
        return lockMoney;
    }

    public void setLockMoney(String lockMoney) {
        this.lockMoney = lockMoney;
    }

    public Integer getGewayType() {
        return gewayType;
    }

    public void setGewayType(Integer gewayType) {
        this.gewayType = gewayType;
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
