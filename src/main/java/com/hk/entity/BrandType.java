package com.hk.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: WillWang
 * @Description: 品牌类别
 * @Date: Created in 2018/3/16
 */
public class BrandType implements Serializable{
    //类型Id
    private String id;
    //创建日期
    private String createDate;
    //修改日期
    private String modifyDate;
    //父级Id
    private String pid;
    //类型名称
    private String typeName;
    //级别
    private String sortNum;
    //一个类别对应的品牌ID
    private List<String> websiteIdList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSortNum() {
        return sortNum;
    }

    public void setSortNum(String sortNum) {
        this.sortNum = sortNum;
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

    public List<String> getWebsiteIdList() {
        return websiteIdList;
    }

    public void setWebsiteIdList(List<String> websiteIdList) {
        this.websiteIdList = websiteIdList;
    }
}
