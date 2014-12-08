/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.entity;

import com.jtk.pengelolaanujianserver.facade.RoleFacade;
import java.util.List;

/**
 *
 * @author pahlevi
 */
public class User {

    private String stafNIP;
    private String userUsername;
    private String userPassword;
    private boolean userActive;
    private List<Role> roleList;

    public User() {

    }

    public String getStafNIP() {

        return stafNIP;
    }

    public void setStafNIP(String stafNIP) {
        this.stafNIP = stafNIP;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<Role> getRoleListQuery() {
        RoleFacade roleControler = new RoleFacade();
        roleList = roleControler.findByKodeStafNIP(this.getStafNIP());
        return roleList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public boolean isUserActive() {
        return userActive;
    }

    public int getUserActive() {
        if (userActive) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setUserActive(boolean userActive) {
        this.userActive = userActive;
    }

}
