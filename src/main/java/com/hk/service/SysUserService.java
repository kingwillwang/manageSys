package com.hk.service;

import com.hk.entity.SysUser;

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
     * @param user
     * @return
     */
    public int addUser(SysUser user);
}
