package com.hk.service;

import com.hk.entity.Website;

import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/20 9:31
 */
public interface WebsiteService {

    /**
     * 查询十大品牌
     * @author willwang
     * @date 2018/3/20 9:31
     * @param
     * @return
     */
    public List<Website> getTopTenWebsite(Map<String, Object> map);

    public Long getTotalTopTen(Map<String, Object> map);

    /**
     * 查询不是十大品牌
     * @author willwang
     * @date 2018/3/20 11:16
     * @param
     * @return
     */
    public List<Website> getNotTopTenWebsite(Map<String, Object> map);

    public Long getTotalNotTopTen(Map<String, Object> map);

    /**
     * 添加十大品牌
     * @author willwang
     * @date 2018/3/20 13:47
     * @param
     * @return
     */
    public void addTopTen(String[] ids);

    /**
     * 移除十大品牌
     * @author willwang
     * @date 2018/3/20 14:12
     * @param
     * @return
     */
    public void removeTopTen(String[] ids);

    /**
     * 查询所有品牌
     * @author willwang
     * @date 2018/3/20 10:09
     * @param
     * @return
     */
    public List<Website> getAllWebsite(Map<String, Object> map);

    public Long getTotalWebsite(Map<String, Object> map);
}
