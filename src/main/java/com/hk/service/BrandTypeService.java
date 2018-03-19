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
     *
     * @param map
     * @return
     */
    List<BrandType> findFirstBrandTypes(Map<String, Object> map);

    /**
     * 一级分类数量
     *
     * @param map
     * @return
     */
    public Long getTotalFirstBrandType(Map<String, Object> map);

    /**
     * 增加
     *
     * @param brandType
     * @return
     */
    public int addBrandType(BrandType brandType);

    /**
     * 修改
     * @author willwang
     * @date 2018/3/19 9:32
     * @param
     * @return
     */
    public int updateBrandType(BrandType brandType);

    /**
     * 根据Pid查询二级分类
     * @author willwang
     * @date 2018/3/19 13:24
     * @param
     * @return
     */
    List<BrandType> findSecondBrandTypeByPid(Map<String, Object> map);

    public Long getTotalSecondBrandType(Map<String, Object> map);

    /**
     * 根据id删除
     * @author willwang
     * @date 2018/3/19 15:39
     * @param
     * @return
     */
    public void deleteTypesById(String[] ids);

    /**
     * 根据Pid删除
     * @author willwang
     * @date 2018/3/19 15:39
     * @param
     * @return
     */
    public void deleteTypesByPid(String[] pids);
}
