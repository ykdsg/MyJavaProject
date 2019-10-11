package com.yt.icp.biz.domain.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * .
 *
 * @author wuzheng.yk
 * @since 16/6/21
 */
public class BrandBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    /**
     * 中文
     */
    private String cnName;
    /**
     * 西文
     */
    private String enName;

    /**
     * 编号
     */
    private String no;

    /**
     * 销量
     */
    private Integer sort;

    private String picture;

    /**
     * 这个字段原来是商品数量,我很无语
     */
    private Integer isHide;

    private String tags;

    private String properties;

    /**
     * 商品数量，回流的数据
     */
    private Integer itemCount;

    /**
     * 商品销量，回流的数据
     */
    private Integer itemSaleCount;

    /**
     * 供微小店的商品数量，回流的数据
     */
    private Integer itemWxdCount;

    /**
     * 品牌类型  0：普通；1：B类
     */
    private Integer brandType;

    /**
     * B类品牌子类型 0:大B 1:小B
     **/
    private Integer brandSubtypes;

    /**
     * 简介
     */
    private String remarks;

    /**
     * 门店分组id
     */
    private String shopGroupId;

    /**
     * 门店黑名单分组id
     */
    private String blackShopGroupId;

    /**
     * 品牌限制区域
     */
    private String  restrictArea;
    /**
     * 自主加盟
     */
    private Integer isSelfJoin;

    /**
     * 品牌卖点
     */
    private String brandSellingPoint;

    /**
     * 售后政策，是否支持清退，1:是，0:否
     */
    private Integer isSupportReturn;

    /**
     * 扩展字段
     */
    private String expand;

    /**
     * 主营类目
     */
    private Long primarySellCategoryId;

    /**
     * 主营类目修改时间
     */
    private Date primarySellCategoryEditTime;

    /**
     * 品牌分层信息审核状态 1:部分待审核 2:全部审核通过
     */
    private Integer layerInfoCheckStatus;

    /*
     *---------------------------- get and set -------------------------
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getIsHide() {
        return isHide;
    }

    public void setIsHide(Integer isHide) {
        this.isHide = isHide;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public Integer getItemSaleCount() {
        return itemSaleCount;
    }

    public void setItemSaleCount(Integer itemSaleCount) {
        this.itemSaleCount = itemSaleCount;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Integer getItemWxdCount() {
        return itemWxdCount;
    }

    public void setItemWxdCount(Integer itemWxdCount) {
        this.itemWxdCount = itemWxdCount;
    }

    public Integer getBrandType() {
        return brandType;
    }

    public void setBrandType(Integer brandType) {
        this.brandType = brandType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getShopGroupId() {
        return shopGroupId;
    }

    public void setShopGroupId(String shopGroupId) {
        this.shopGroupId = shopGroupId;
    }

    public String getBlackShopGroupId() {
        return blackShopGroupId;
    }

    public void setBlackShopGroupId(String blackShopGroupId) {
        this.blackShopGroupId = blackShopGroupId;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public Integer getIsSelfJoin() {
        return isSelfJoin;
    }

    public void setIsSelfJoin(Integer isSelfJoin) {
        this.isSelfJoin = isSelfJoin;
    }

    public String getRestrictArea() {
        return restrictArea;
    }

    public void setRestrictArea(String restrictArea) {
        this.restrictArea = restrictArea;
    }

    public String getBrandSellingPoint() {
        return brandSellingPoint;
    }

    public void setBrandSellingPoint(String brandSellingPoint) {
        this.brandSellingPoint = brandSellingPoint;
    }

    public Integer getBrandSubtypes() {
        return brandSubtypes;
    }

    public void setBrandSubtypes(Integer brandSubtypes) {
        this.brandSubtypes = brandSubtypes;
    }

    public Integer getIsSupportReturn() {
        return isSupportReturn;
    }

    public void setIsSupportReturn(Integer isSupportReturn) {
        this.isSupportReturn = isSupportReturn;
    }

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public Long getPrimarySellCategoryId() {
        return primarySellCategoryId;
    }

    public void setPrimarySellCategoryId(Long primarySellCategoryId) {
        this.primarySellCategoryId = primarySellCategoryId;
    }

    public Integer getLayerInfoCheckStatus() {
        return layerInfoCheckStatus;
    }

    public void setLayerInfoCheckStatus(Integer layerInfoCheckStatus) {
        this.layerInfoCheckStatus = layerInfoCheckStatus;
    }

    public Date getPrimarySellCategoryEditTime() {
        return primarySellCategoryEditTime;
    }

    public void setPrimarySellCategoryEditTime(Date primarySellCategoryEditTime) {
        this.primarySellCategoryEditTime = primarySellCategoryEditTime;
    }
}
