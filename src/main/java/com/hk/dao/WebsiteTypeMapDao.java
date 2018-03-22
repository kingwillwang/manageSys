package com.hk.dao;

import com.hk.entity.WebsiteTypeMap;

import java.util.List;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/22 9:34
 */
public interface WebsiteTypeMapDao {

    public void addWebsiteTypeMap(List<WebsiteTypeMap> websiteTypeMapList);

    public void deleteMapByWebsiteId(String[] websiteIds);

    public List<String> getTypeIdListByWebsiteId(String websiteId);

}
