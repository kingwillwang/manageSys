package com.hk.service.impl;

import com.hk.dao.BrandTypeDao;
import com.hk.entity.BrandType;
import com.hk.service.BrandTypeService;
import com.hk.util.AntiXssUtil;
import com.hk.util.DateUtil;
import com.hk.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    public int addBrandType(BrandType brandType) {
        String typeName = brandType.getTypeName().trim();
        if (StringUtil.isEmpty(typeName)) {
            return 0;//名称不能为空
        }
        String bTypeName = brandTypeDao.findBrandTypeByName(typeName);
        if (StringUtil.isNotEmpty(bTypeName)) {
            return 2;//已存在
        } else {
            brandType.setId(UUID.randomUUID().toString());
            brandType.setCreateDate(DateUtil.getCurrentDateStr());
            brandType.setModifyDate(DateUtil.getCurrentDateStr());
            brandType.setTypeName(AntiXssUtil.replaceHtmlCode(typeName));
            brandTypeDao.addBrandType(brandType);
            return 1;//创建成功
        }
    }
}
