package com.hk.dao;

import com.hk.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/12 10:56
 */
@Repository
public interface SysUserDao {

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(SysUser user);

    /**
     * 登录
     * @param user
     * @return
     */
    public SysUser login(SysUser user);

    /**
     * 查找用户列表
     *
     * @param map
     * @return
     */
    public List<SysUser> findUsers(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalUser(Map<String, Object> map);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    public int updateUser(SysUser user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public int deleteUser(Integer id);

}
