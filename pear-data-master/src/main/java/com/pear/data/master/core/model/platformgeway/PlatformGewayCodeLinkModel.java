package com.pear.data.master.core.model.platformgeway;

import com.pear.data.master.core.protocol.page.BasePage;

import java.io.Serializable;

/**
 * @ClassName:
 * @Description: 平台通道码与通道码关联的实体属性Bean
 * @Author: yoko
 * @Date: $
 * @Version: 1.0
 **/
public class PlatformGewayCodeLinkModel extends BasePage implements Serializable {
    private static final long   serialVersionUID = 1233233322148L;

    public PlatformGewayCodeLinkModel(){

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
     * 平台通道编码ID：对应tb_pr_platform_geway_code表的主键ID
     */
    private Long pfGewayCodeId;

    /**
     * 通道码ID：对应tb_pr_geway_code表的主键ID
     */
    private Long gewayCodeId;

    /**
     * 权重
     */
    private Integer ratio;

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

    /**
     * 比例大于-SQL
     */
    private String ratioGreaterThan;

    /**
     * 筛选比例：开始
     */
    private int startRatio;

    /**
     * 筛选比例结束
     */
    private int endRatio;

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

    public Long getPfGewayCodeId() {
        return pfGewayCodeId;
    }

    public void setPfGewayCodeId(Long pfGewayCodeId) {
        this.pfGewayCodeId = pfGewayCodeId;
    }

    public Long getGewayCodeId() {
        return gewayCodeId;
    }

    public void setGewayCodeId(Long gewayCodeId) {
        this.gewayCodeId = gewayCodeId;
    }

    public Integer getRatio() {
        return ratio;
    }

    public void setRatio(Integer ratio) {
        this.ratio = ratio;
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

    public String getRatioGreaterThan() {
        return ratioGreaterThan;
    }

    public void setRatioGreaterThan(String ratioGreaterThan) {
        this.ratioGreaterThan = ratioGreaterThan;
    }

    public int getStartRatio() {
        return startRatio;
    }

    public void setStartRatio(int startRatio) {
        this.startRatio = startRatio;
    }

    public int getEndRatio() {
        return endRatio;
    }

    public void setEndRatio(int endRatio) {
        this.endRatio = endRatio;
    }
}
