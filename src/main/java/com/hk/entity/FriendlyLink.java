package com.hk.entity;

import java.io.Serializable;

/**
 * @Author: WillWang
 * @Description: 友情链接
 * @Date: Created in 2018/3/16
 */
public class FriendlyLink implements Serializable {
    private String id;
    private String linkName;
    private String linkUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
}
