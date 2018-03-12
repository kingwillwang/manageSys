package com.hk.service.impl;

import com.hk.dao.SysUserDao;
import com.hk.entity.SysUser;
import com.hk.service.SysUserService;
import com.hk.util.AntiXssUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/12 11:02
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao userDao;

    /**
     * 用户登录
     * @author willwang
     * @date 2018/3/12 13:23
     * @param
     * @return
     */
    public SysUser login(SysUser user) {
        return userDao.login(user);
    }

    /**
     *查询用户
     * @author willwang
     * @date 2018/3/12 17:13
     * @param
     * @return
     */
    public List<SysUser> findUser(Map<String, Object> map) {
        return userDao.findUsers(map);
    }

    /**
     * @author willwang
     * @date 2018/3/12 17:14
     * @param
     * @return
     */
    public Long getTotalUser(Map<String, Object> map) {
        return userDao.getTotalUser(map);
    }

    /**
     * 增加用户
     * @author willwang
     * @date 2018/3/12 11:08
     * @param
     * @return
     */
    public int addUser(SysUser user) {
        if (user.getUserName() == null || user.getPassword() == null) {
            return 0;
        }
        user.setId(UUID.randomUUID().toString());
        user.setUserName(AntiXssUtil.replaceHtmlCode(user.getUserName()));
        return userDao.addUser(user);
    }

}
