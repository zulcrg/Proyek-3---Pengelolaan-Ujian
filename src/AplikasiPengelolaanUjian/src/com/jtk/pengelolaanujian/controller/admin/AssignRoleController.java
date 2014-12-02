/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.admin;

import com.jtk.pengelolaanujian.entity.Role;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.entity.User;
import com.jtk.pengelolaanujian.facade.RoleFacade;
import com.jtk.pengelolaanujian.facade.UserFacade;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class AssignRoleController {

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
        userFacade.editUserRole(user);
    }

    public List<Staf> searchUser(String text, JTable tableStaf) {
        List<Staf> stafList;

        UserFacade userFacade = new UserFacade();
        stafList = userFacade.searchNameUsername(text);

        Object[] columnsName = {"Nama", "Username"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnsName);
        for (Staf staf : stafList) {
            Object[] o = new Object[2];
            o[0] = staf.getStafNama();
            o[1] = staf.getUser().getUserUsername();

            dtm.addRow(o);
        }
        tableStaf.setModel(dtm);
        
        return stafList;
    }
}
