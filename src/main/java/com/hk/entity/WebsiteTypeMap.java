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
    private String brandTypeId;
    private String websiteId;

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

    public String getBrandTypeId() {
        return brandTypeId;
    }

    public void setBrandTypeId(String brandTypeId) {
        this.brandTypeId = brandTypeId;
    }

    public String getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(String websiteId) {
        this.websiteId = websiteId;
    }
}
