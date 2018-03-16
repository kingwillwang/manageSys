package com.hk.entity;

import java.util.List;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/12 10:36
 */
public class SysUser {
    private String id;
    private String userName;
    private String password;
    private String createDate;

    private List<UserProperty> userPropertyList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<UserProperty> getUserPropertyList() {
        return userPropertyList;
    }

    public void setUserPropertyList(List<UserProperty> userPropertyList) {
        this.userPropertyList = userPropertyList;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
