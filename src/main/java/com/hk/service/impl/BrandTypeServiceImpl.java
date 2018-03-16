package com.hk.service.impl;

import com.hk.dao.BrandTypeDao;
import com.hk.entity.BrandType;
import com.hk.service.BrandTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description: 品牌分类
 * @Date: Created in 2018/3/16
 */
@Service("brandTypeService")
public class BrandTypeServiceImpl implements BrandTypeService {

    @Resource
    private BrandTypeDao brandTypeDao;

    /**
     * 查询所有一级分类
     * @param map
     * @return
     */
    public List<BrandType> findFirstBrandTypes(Map<String, Object> map) {
        return brandTypeDao.findFirstBrandTypes(map);
    }

    /**
     * 一级分类数量
     * @param map
     * @return
     */
    public Long getTotalFirstBrandType(Map<String, Object> map) {
        return brandTypeDao.getTotalFirstBrandType(map);
    }
}
