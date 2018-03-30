package com.hk.service.impl;

import com.hk.dao.WebsiteDao;
import com.hk.dao.WebsiteTypeMapDao;
import com.hk.entity.BrandType;
import com.hk.entity.Website;
import com.hk.entity.WebsiteTypeMap;
import com.hk.service.WebsiteService;
import com.hk.util.AntiXssUtil;
import com.hk.util.DateUtil;
import com.hk.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/20 9:32
 */
@Service("websiteService")
public class WebsiteServiceImpl implements WebsiteService {

    @Resource
    private WebsiteDao websiteDao;
    @Resource
    private WebsiteTypeMapDao websiteTypeMapDao;

    public List<Website> getTopTenWebsite(Map<String, Object> map) {
        return websiteDao.getTopTenWebsite(map);
    }

    public Long getTotalTopTen(Map<String, Object> map) {
        return websiteDao.getTotalTopTen(map);
    }

    public List<Website> getNotTopTenWebsite(Map<String, Object> map) {
        return websiteDao.getNotTopTenWebsite(map);
    }

    public Long getTotalNotTopTen(Map<String, Object> map) {
        return websiteDao.getTotalNotTopTen(map);
    }

    public void addTopTen(String[] ids) {
        websiteDao.addTopTen(ids);
    }

    public void removeTopTen(String[] ids) {
        websiteDao.removeTopTen(ids);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<Website> getAllWebsite(Map<String, Object> map) {
        List<Website> websiteList = websiteDao.getAllWebsite(map);
        for (Website website : websiteList) {
            List<String> brandTypeList = websiteTypeMapDao.getTypeIdListByWebsiteId(website.getId());
            website.setBrandTypeIdList(brandTypeList);
        }
        return websiteList;
    }

    public Long getTotalWebsite(Map<String, Object> map) {
        return websiteDao.getTotalWebsite(map);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int addWebsite(Website website) {
        if (StringUtil.isEmpty(website.getWebsiteName())) {
            return 0;//名称不能为空
        }
        List<String> brandTypeIdList = website.getBrandTypeIdList();
        if (brandTypeIdList.size() == 0) {
            return 0;
        }
        Long isExist = websiteDao.findWebsiteNameIsExist(website.getWebsiteName());
        if (isExist > 0) {
            return 2;//已存在
        }
        website.setId(UUID.randomUUID().toString());
        website.setCreateDate(DateUtil.getCurrentDateStr());
        website.setModifyDate(DateUtil.getCurrentDateStr());
        website.setWebsiteName(AntiXssUtil.replaceHtmlCode(website.getWebsiteName()));
        website.setWebsiteDesc(AntiXssUtil.replaceHtmlCode(website.getWebsiteDesc()));
        website.setIsTopTen("");
        websiteDao.addWebsite(website);

        List<WebsiteTypeMap> websiteTypeMapList = new ArrayList<WebsiteTypeMap>();
        for (String brandTypeId : brandTypeIdList) {
            WebsiteTypeMap websiteTypeMap = new WebsiteTypeMap();
            websiteTypeMap.setId(UUID.randomUUID().toString());
            websiteTypeMap.setWebsiteId(website.getId());
            websiteTypeMap.setBrandTypeId(brandTypeId);
            websiteTypeMap.setCreateDate(DateUtil.getCurrentDateStr());
            websiteTypeMapList.add(websiteTypeMap);
        }
        websiteTypeMapDao.addWebsiteTypeMap(websiteTypeMapList);
        return 1;//创建成功
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deleteWebsiteByIds(String[] ids) {
        websiteTypeMapDao.deleteMapByWebsiteId(ids);
        websiteDao.deleteWebsiteByIds(ids);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int updateWebsite(Website website) {
        if (StringUtil.isEmpty(website.getWebsiteName())) {
            return 0;//名称不能为空
        }
        List<String> brandTypeIdList = website.getBrandTypeIdList();
        if (brandTypeIdList.size() == 0) {
            return 0;
        }
        
        String ids[] = {website.getId()};
        websiteTypeMapDao.deleteMapByWebsiteId(ids);
        
        List<WebsiteTypeMap> websiteTypeMapList = new ArrayList<WebsiteTypeMap>();
        for (String brandTypeId : brandTypeIdList) {
            WebsiteTypeMap websiteTypeMap = new WebsiteTypeMap();
            websiteTypeMap.setId(UUID.randomUUID().toString());
            websiteTypeMap.setWebsiteId(website.getId());
            websiteTypeMap.setBrandTypeId(brandTypeId);
            websiteTypeMap.setCreateDate(DateUtil.getCurrentDateStr());
            websiteTypeMapList.add(websiteTypeMap);
        }
        websiteTypeMapDao.addWebsiteTypeMap(websiteTypeMapList);

        Website newWebsite = websiteDao.findWebsiteById(website.getId());
        newWebsite.setModifyDate(DateUtil.getCurrentDateStr());
        newWebsite.setWebsiteName(AntiXssUtil.replaceHtmlCode(website.getWebsiteName()));
        newWebsite.setWebsiteLogo(website.getWebsiteLogo());
        newWebsite.setWebsiteUrl(website.getWebsiteUrl());
        newWebsite.setWebsiteSort(website.getWebsiteSort());
        newWebsite.setIsTopTen(website.getIsTopTen());
        newWebsite.setCountNum(website.getCountNum());
        newWebsite.setIsRecommend(website.getIsRecommend());
        newWebsite.setWebsiteDesc(AntiXssUtil.replaceHtmlCode(website.getWebsiteDesc()));
        websiteDao.updateWebsite(newWebsite);
        return 1;//操作成功
    }

    public Long findWebsiteNameIsExist(String websiteName) {
        return websiteDao.findWebsiteNameIsExist(websiteName);
    }
}
