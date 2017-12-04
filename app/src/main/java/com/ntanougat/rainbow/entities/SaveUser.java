package com.ntanougat.rainbow.entities;

/**
 * Created by Peelson on 2017/12/4.
 */

public class SaveUser {

    private String username;
    private String password;
    private int staus;//用户登录状态，1为在线，0为离线


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStaus() {
        return staus;
    }

    public void setStaus(int staus) {
        this.staus = staus;
    }
}
