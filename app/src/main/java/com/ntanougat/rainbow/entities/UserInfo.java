package com.ntanougat.rainbow.entities;


/**
 * Created by Peelson on 2017/12/4.
 */

public class UserInfo {

    /**
     * uid : userId
     * uname : userName
     * headUrl : 头像
     * uphone : 账号
     */

    private String uid;
    private String uname;
    private String headUrl;
    private String uphone;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }
}
