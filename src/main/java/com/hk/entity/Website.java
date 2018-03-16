package com.hk.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: WillWang
 * @Description: 品牌明细
 * @Date: Created in 2018/3/16
 */
public class Website implements Serializable{
    //品牌Id
    private String id;
    //创建日期
    private String createDate;
    //修改日期
    private String modifyDate;
    //品牌名称
    private String websiteName;
    //品牌logo地址
    private String websiteLogo;
    //品牌外链
    private String websiteUrl;
    //排序
    private String websiteSort;
    //是否是十大品牌
    private String isTopTen;
    //访问次数
    private int countNum;
    //是否是推荐品牌
    private String isRecommend;
    //介绍
    private String websiteDesc;
    //分类类别
    private List<BrandType> brandTypes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getWebsiteLogo() {
        return websiteLogo;
    }

    public void setWebsiteLogo(String websiteLogo) {
        this.websiteLogo = websiteLogo;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getWebsiteSort() {
        return websiteSort;
    }

    public void setWebsiteSort(String websiteSort) {
        this.websiteSort = websiteSort;
    }

    public String getIsTopTen() {
        return isTopTen;
    }

    public void setIsTopTen(String isTopTen) {
        this.isTopTen = isTopTen;
    }

    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }

    public String getWebsiteDesc() {
        return websiteDesc;
    }

    public void setWebsiteDesc(String websiteDesc) {
        this.websiteDesc = websiteDesc;
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

    public List<BrandType> getBrandTypes() {
        return brandTypes;
    }

    public void setBrandTypes(List<BrandType> brandTypes) {
        this.brandTypes = brandTypes;
    }

    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend;
    }
}
