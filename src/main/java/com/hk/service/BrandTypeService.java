package com.hk.service;

import com.hk.entity.BrandType;

import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/16
 */
public interface BrandTypeService {

    /**
     * 查询所有一级分类
     * @param map
     * @return
     */
    List<BrandType> findFirstBrandTypes(Map<String, Object> map);

    /**
     * 一级分类数量
     * @param map
     * @return
     */
    public Long getTotalFirstBrandType(Map<String, Object> map);

    /**
     * 增加
     * @param brandType
     * @return
     */
    public int addBrandType(BrandType brandType);

}
