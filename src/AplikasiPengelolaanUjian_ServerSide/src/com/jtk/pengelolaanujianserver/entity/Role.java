/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.entity;

import com.jtk.pengelolaanujian.facade.UserFacade;
import java.util.List;

/**
 *
 * @author pahlevi
 */
public class Role {

    private String roleKode;
    private String roleNama;
    private List<User> userList;

    public Role() {

    }

    public String getRoleKode() {
        return roleKode;
    }

    public void setRoleKode(String roleKode) {
        this.roleKode = roleKode;
    }

    public String getRoleNama() {
        return roleNama;
    }

    public void setRoleNama(String roleNama) {
        this.roleNama = roleNama;
    }

    public List<User> getUserList() {
        UserFacade userFacade = new UserFacade();
        userList = userFacade.findByRoleKode(roleKode);
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}
