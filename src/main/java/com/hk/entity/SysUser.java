package com.hk.entity;

import java.util.List;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/12 10:36
 */
public class SysUser {
    private String id;
    private String name;
    private String password;

    private List<UserProperty> userPropertyList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserProperty> getUserPropertyList() {
        return userPropertyList;
    }

    public void setUserPropertyList(List<UserProperty> userPropertyList) {
        this.userPropertyList = userPropertyList;
    }
}
