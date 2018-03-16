package com.hk.dao;

import com.hk.entity.BrandType;

import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/16
 */
public interface BrandTypeDao {

    /**
     * 查询所有一级分类
     * @param map
     * @return
     */
    public List<BrandType> findFirstBrandTypes(Map<String, Object> map);

    /**
     * 一级分类数量
     * @param map
     * @return
     */
    public Long getTotalFirstBrandType(Map<String, Object> map);

    //根据PID查询二级分类
//    List<BrandType> findBrandTypesByPid(String pid);

    //查询所有二级分类
//    List<BrandType> findTwoBrandTypes();
}
