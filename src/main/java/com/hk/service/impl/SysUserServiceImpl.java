package com.hk.service.impl;

import com.hk.dao.SysUserDao;
import com.hk.entity.SysUser;
import com.hk.entity.UserProperty;
import com.hk.service.SysUserService;
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
 * @Description:
 * @Date: Created in 2018/3/12 11:02
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao userDao;

    /**
     * 用户登录
     *
     * @param
     * @return
     * @author willwang
     * @date 2018/3/12 13:23
     */
    public SysUser login(SysUser user) {
        return userDao.login(user);
    }

    /**
     * 查询用户
     *
     * @param
     * @return
     * @author willwang
     * @date 2018/3/12 17:13
     */
    public List<SysUser> findUser(Map<String, Object> map) {
        return userDao.findUsers(map);
    }

    /**
     * @param
     * @return
     * @author willwang
     * @date 2018/3/12 17:14
     */
    public Long getTotalUser(Map<String, Object> map) {
        return userDao.getTotalUser(map);
    }

    /**
     * 增加用户
     *
     * @param
     * @return
     * @author willwang
     * @date 2018/3/12 11:08
     */
    public int addUser(SysUser user) {
        if (StringUtil.isEmpty(user.getUserName()) || StringUtil.isEmpty(user.getPassword())) {
            return 0;//用户名或者密码为空
        }
        SysUser sysUser = userDao.findUserByUserName(user.getUserName());
        if (sysUser != null) {
            return 2;//用户已存在
        } else {
            user.setId(UUID.randomUUID().toString());
            user.setUserName(AntiXssUtil.replaceHtmlCode(user.getUserName()));
            user.setCreateDate(DateUtil.getCurrentDateStr());
            userDao.addUser(user);
            return 1;//创建成功
        }
    }

    /**
     * 增加用户登录信息
     *
     * @param
     * @return
     * @author willwang
     * @date 2018/3/12 11:08
     */
    public void addUserProperty(String userId, String ip) {
        UserProperty userProperty = new UserProperty();
        userProperty.setId(UUID.randomUUID().toString());
        userProperty.setUserId(userId);
        userProperty.setLoginTime(DateUtil.getCurrentDateStr());
        userProperty.setLoginIp(ip);
        userDao.addUserIp(userProperty);
    }

}
