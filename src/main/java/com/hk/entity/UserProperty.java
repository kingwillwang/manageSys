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
    private String loginIP;

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

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }
}
