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

    /**
     * 增加类型
     * @param brandType
     */
    public void addBrandType(BrandType brandType);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public BrandType findBrandTypeById(String id);

    /**
     * 判断名称是否存在
     * @author willwang
     * @date 2018/3/19 10:54
     * @param
     * @return
     */
    public Long findTypeNameIsExist(String typeName);

    /**
     * 修改
     * @author willwang
     * @date 2018/3/19 9:36
     * @param
     * @return
     */
    public void updateBrandType(BrandType brandType);

    /**
     * 根据PID查询二级分类
     * @author willwang
     * @date 2018/3/19 13:18
     * @param
     * @return
     */
    List<BrandType> findSecondBrandTypesByPid(Map<String, Object> map);

    /**
     * @author willwang
     * @date 2018/3/19 13:30
     * @param
     * @return
     */
    public Long getTotalSecondBrandType(Map<String, Object> map);

    /**
     * 根据ID删除
     * @author willwang
     * @date 2018/3/19 15:37
     * @param
     * @return
     */
    public void deleteBrandTypesById(String[] ids);

    /**
     * 根据Pid删除
     * @author willwang
     * @date 2018/3/19 15:37
     * @param
     * @return
     */
    public void deleteBrandTypesByPid(String[] pids);
}
