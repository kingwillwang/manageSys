package com.hk.service.impl;

import com.hk.dao.WebsiteDao;
import com.hk.entity.Website;
import com.hk.service.WebsiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/20 9:32
 */
@Service("websiteService")
public class WebsiteServiceImpl implements WebsiteService {

    @Resource
    private WebsiteDao websiteDao;

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

    public List<Website> getAllWebsite(Map<String, Object> map) {
        return websiteDao.getAllWebsite(map);
    }

    public Long getTotalWebsite(Map<String, Object> map) {
        return websiteDao.getTotalWebsite(map);
    }
}
