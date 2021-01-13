package com.yt.easy.icp.biz.entity;

import java.io.Serializable;

/**
 * (TBrandAnalyse)实体类
 *
 * @author makejava
 * @since 2020-12-17 22:34:00
 */
public class TBrandAnalyse implements Serializable {

    private static final long serialVersionUID = 410712321095169130L;

    private Integer id;

    private Integer brandId;

    private String abType;

    private String brandChannel;

    private String brandName;

    private String brandUniteName;

    private String brandCnName;

    private String brandUniteCnName;

    private String skuCount;

    private String mainCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getAbType() {
        return abType;
    }

    public void setAbType(String abType) {
        this.abType = abType;
    }

    public String getBrandChannel() {
        return brandChannel;
    }

    public void setBrandChannel(String brandChannel) {
        this.brandChannel = brandChannel;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandUniteName() {
        return brandUniteName;
    }

    public void setBrandUniteName(String brandUniteName) {
        this.brandUniteName = brandUniteName;
    }

    public String getBrandCnName() {
        return brandCnName;
    }

    public void setBrandCnName(String brandCnName) {
        this.brandCnName = brandCnName;
    }

    public String getBrandUniteCnName() {
        return brandUniteCnName;
    }

    public void setBrandUniteCnName(String brandUniteCnName) {
        this.brandUniteCnName = brandUniteCnName;
    }

    public String getSkuCount() {
        return skuCount;
    }

    public void setSkuCount(String skuCount) {
        this.skuCount = skuCount;
    }

    public String getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

}
