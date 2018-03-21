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
     *
     * @param map
     * @return
     */
    public List<BrandType> findFirstBrandTypes(Map<String, Object> map) {
        return brandTypeDao.findFirstBrandTypes(map);
    }

    /**
     * 一级分类数量
     *
     * @param map
     * @return
     */
    public Long getTotalFirstBrandType(Map<String, Object> map) {
        return brandTypeDao.getTotalFirstBrandType(map);
    }

    public int addBrandType(BrandType brandType) {
        if (StringUtil.isEmpty(brandType.getTypeName())) {
            return 0;//名称不能为空
        }
        Long isExist = brandTypeDao.findTypeNameIsExist(brandType.getTypeName());
        if (isExist > 0) {
            return 2;//已存在
        } else {
            brandType.setId(UUID.randomUUID().toString());
            brandType.setCreateDate(DateUtil.getCurrentDateStr());
            brandType.setModifyDate(DateUtil.getCurrentDateStr());
            brandType.setTypeName(AntiXssUtil.replaceHtmlCode(brandType.getTypeName()));
            if (StringUtil.isEmpty(brandType.getPid())) {
                //一级分类
                brandType.setSortNum("0");
                brandType.setPid("");
            } else {
                //二级分类
                brandType.setSortNum("1");
            }
            brandTypeDao.addBrandType(brandType);
            return 1;//创建成功
        }
    }

    public int updateBrandType(BrandType brandType) {
        if (StringUtil.isEmpty(brandType.getTypeName())) {
            return 0;//名称不能为空
        }
        Long isExist = brandTypeDao.findTypeNameIsExist(brandType.getTypeName());
        if (isExist > 0) {
            return 2;//名称已存在
        } else {
            BrandType fBrandType = brandTypeDao.findBrandTypeById(brandType.getId());
            fBrandType.setModifyDate(DateUtil.getCurrentDateStr());
            if (StringUtil.isNotEmpty(brandType.getPid())) {
                fBrandType.setPid(brandType.getPid());
            }
            fBrandType.setTypeName(AntiXssUtil.replaceHtmlCode(brandType.getTypeName()));
            brandTypeDao.updateBrandType(fBrandType);
            return 1;//操作成功
        }
    }

    public List<BrandType> findSecondBrandTypeByPid(Map<String, Object> map) {
        return brandTypeDao.findSecondBrandTypesByPid(map);
    }

    public Long getTotalSecondBrandType(Map<String, Object> map) {
        return brandTypeDao.getTotalSecondBrandType(map);
    }

    public void deleteTypesById(String[] ids) {
        brandTypeDao.deleteBrandTypesById(ids);
    }

    public void deleteTypesByPid(String[] pids) {
        brandTypeDao.deleteBrandTypesByPid(pids);
    }

    public List<BrandType> findAllBrandTypes() {
        return brandTypeDao.findAllBrandTypes();
    }
}
