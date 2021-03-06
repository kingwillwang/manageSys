package com.hk.service;

import com.hk.entity.SysUser;
import com.hk.entity.UserProperty;

import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/12 11:01
 */
public interface SysUserService {

    /**
     * @param user
     * @return
     */
    public SysUser login(SysUser user);

    /**
     * @param map
     * @return
     */
    public List<SysUser> findUser(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalUser(Map<String, Object> map);

    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    public int addUser(SysUser user);

    /**
     * 增加登录信息
     *
     * @param userId
     * @return
     */
    public void addUserProperty(String userId, String ip);

    /**
     * 查询用户详情
     * @author willwang
     * @date 2018/3/16 17:29
     * @param
     * @return
     */
    public List<UserProperty> findUserDetails(Map<String, Object> map);

    /**
     * 用户详情数量
     * @param map
     * @return
     */
    public Long getTotalUserDetail(Map<String, Object> map);
}
