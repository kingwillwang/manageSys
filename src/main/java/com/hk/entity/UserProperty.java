package com.hk.entity;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/12 10:37
 */
public class UserProperty {
    private String id;
    private String userId;
    private String loginTime;
    private String loginIp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
}
