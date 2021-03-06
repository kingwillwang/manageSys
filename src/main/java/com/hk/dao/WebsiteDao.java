package com.hk.dao;

import com.hk.entity.Website;

import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/20 9:16
 */
public interface WebsiteDao {

    /**
     * 十大品牌查询
     * @author willwang
     * @date 2018/3/20 9:17
     * @param
     * @return
     */
    public List<Website> getTopTenWebsite(Map<String, Object> map);

    public Long getTotalTopTen(Map<String, Object> map);

    /**
     * 查询不是十大品牌
     * @author willwang
     * @date 2018/3/20 11:10
     * @param
     * @return
     */
    public List<Website> getNotTopTenWebsite(Map<String, Object> map);

    public Long getTotalNotTopTen(Map<String, Object> map);

    /**
     * 批量增加十大品牌
     * @author willwang
     * @date 2018/3/20 13:34
     * @param
     * @return
     */
    public void addTopTen(String[] ids);

    /**
     * 批量移除十大品牌
     * @author willwang
     * @date 2018/3/20 14:10
     * @param
     * @return
     */
    public void removeTopTen(String[] ids);

    /**
     * 查询所有品牌
     * @author willwang
     * @date 2018/3/20 9:52
     * @param
     * @return
     */
    public List<Website> getAllWebsite(Map<String, Object> map);

    public Long getTotalWebsite(Map<String, Object> map);

    /**
     * 新增
     * @author willwang
     * @date 2018/3/22 9:23
     * @param
     * @return
     */
    public void addWebsite(Website website);

    public Long findWebsiteNameIsExist(String websiteName);

    public Website findWebsiteById(String id);
    /**
     * 删除
     * @author willwang
     * @date 2018/3/22 14:06
     * @param
     * @return
     */
    public void deleteWebsiteByIds(String[] ids);

    /**
     * 修改
     * @author willwang
     * @date 2018/3/22 13:36
     * @param
     * @return
     */
    public void updateWebsite(Website website);
}
