package com.hk.entity;

import java.io.Serializable;

/**
 * @Author: WillWang
 * @Description: 品牌类别映射
 * @Date: Created in 2018/3/16
 */
public class WebsiteTypeMap implements Serializable{
    private String id;
    private String createDate;
    private String modifyDate;
    private BrandType brandType;
    private Website website;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BrandType getBrandType() {
        return brandType;
    }

    public void setBrandType(BrandType brandType) {
        this.brandType = brandType;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }
}
