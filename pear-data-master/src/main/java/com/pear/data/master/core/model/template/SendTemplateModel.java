package com.pear.data.master.core.model.template;

import com.pear.data.master.core.protocol.page.BasePage;

import java.io.Serializable;

/**
 * @ClassName:
 * @Description: 请求模板的实体属性Bean
 * @Author: yoko
 * @Date: $
 * @Version: 1.0
 **/
public class SendTemplateModel extends BasePage implements Serializable {
    private static final long   serialVersionUID = 1203223201521L;

    public SendTemplateModel(){

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
     *是否要加密：1加密，2不加密
     */
    private Integer isEncryption;

    /**
     * 大小写加密方式：1无需大小写，2小写加密，3大写加密
     */
    private Integer encryptionWay;

    /**
     * 加密类型：1md5加密，2base64加密，3md5加密之后在base64加密
     */
    private Integer encryptionType;

    /**
     * 秘钥放置位置：1存放字符串末尾，2根据ascii排序存放
     */
    private Integer secretKeySeat;


    /**
     * 秘钥key类型：1无需key存放在字符串最末尾，2需要key当做参数名赋值秘钥存放在最末尾
     */
    private Integer secretKeyType;

    /**
     * 加密排序：1按照指定顺序，2按照ascii码升序，3按照ascii码降序
     */
    private Integer encryptionSort;

    /**
     * 请求提交数据方式：1get，2post数据格式application/json，3post数据格式application/x-www-form-urlencoded
     */
    private Integer sendType;

    /**
     * 请求传输数据案例
     */
    private String sendCase;

    /**
     * 返回数据案例
     */
    private String returnCase;

    /**
     * 同步数据案例
     */
    private String notifyCase;

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

    public Integer getIsEncryption() {
        return isEncryption;
    }

    public void setIsEncryption(Integer isEncryption) {
        this.isEncryption = isEncryption;
    }

    public Integer getEncryptionWay() {
        return encryptionWay;
    }

    public void setEncryptionWay(Integer encryptionWay) {
        this.encryptionWay = encryptionWay;
    }

    public Integer getEncryptionType() {
        return encryptionType;
    }

    public void setEncryptionType(Integer encryptionType) {
        this.encryptionType = encryptionType;
    }

    public Integer getSecretKeySeat() {
        return secretKeySeat;
    }

    public void setSecretKeySeat(Integer secretKeySeat) {
        this.secretKeySeat = secretKeySeat;
    }

    public Integer getSecretKeyType() {
        return secretKeyType;
    }

    public void setSecretKeyType(Integer secretKeyType) {
        this.secretKeyType = secretKeyType;
    }

    public Integer getEncryptionSort() {
        return encryptionSort;
    }

    public void setEncryptionSort(Integer encryptionSort) {
        this.encryptionSort = encryptionSort;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public String getSendCase() {
        return sendCase;
    }

    public void setSendCase(String sendCase) {
        this.sendCase = sendCase;
    }

    public String getReturnCase() {
        return returnCase;
    }

    public void setReturnCase(String returnCase) {
        this.returnCase = returnCase;
    }

    public String getNotifyCase() {
        return notifyCase;
    }

    public void setNotifyCase(String notifyCase) {
        this.notifyCase = notifyCase;
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
