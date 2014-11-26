/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.admin;

import com.jtk.pengelolaanujian.entity.Role;
import com.jtk.pengelolaanujian.entity.User;
import com.jtk.pengelolaanujian.facade.RoleFacade;
import com.jtk.pengelolaanujian.facade.UserFacade;
import java.util.ArrayList;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author pahlevi
 */
public class AdminController {
    public void assignRole(String username, boolean[] roleList) {
        UserFacade userFacade = new UserFacade();
        RoleFacade roleFacade = new RoleFacade();
        User user = userFacade.findByUsername(username);
        user.setRoleList(new ArrayList<Role>());
        if (roleList[0]) {
            Role role = roleFacade.findByKodeRole('0');
            user.getRoleList().add(role);
        }
        if (roleList[1]) {
            Role role = roleFacade.findByKodeRole('1');
            user.getRoleList().add(role);
        }
        if (roleList[2]) {
            Role role = roleFacade.findByKodeRole('2');
            user.getRoleList().add(role);
        }
        if (roleList[3]) {
            Role role = roleFacade.findByKodeRole('3');
            user.getRoleList().add(role);
        }
                
    }        
    
}
