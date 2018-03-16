package com.hk.dao;

import com.hk.entity.SysUser;
import com.hk.entity.UserProperty;
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
    public void addUser(SysUser user);

    /**
     * 添加登录信息
     * @param userProperty
     * @return
     */
    public void addUserIp(UserProperty userProperty);

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
//    public int updateUser(SysUser user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
//    public int deleteUser(Integer id);

    /**
     * 根据用户名查询
     * @author willwang
     * @date 2018/3/16 15:29
     * @param
     * @return
     */
    public SysUser findUserByUserName (String userName);

    /**
     * 查询用户详情
     * @author willwang
     * @date 2018/3/16 17:30
     * @param
     * @return
     */
    public List<UserProperty> findUserDetails(Map<String, Object> map);
}
