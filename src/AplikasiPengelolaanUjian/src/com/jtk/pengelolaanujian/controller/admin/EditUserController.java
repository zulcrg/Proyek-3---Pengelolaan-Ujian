/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.admin;

import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.entity.User;
import com.jtk.pengelolaanujian.facade.UserFacade;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rizki
 */
public class EditUserController {

    public boolean editUser(User user) {
        UserFacade userFacade = new UserFacade();
        return userFacade.editUser(user);
    }

    public List<Staf> searchUserNotMe(String text, JTable tableStaf) {
        List<Staf> stafList;

        UserFacade userFacade = new UserFacade();
        stafList = userFacade.searchNameUsernameNotMe(text);

        Object[] columnsName = {"Nama", "Username"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnsName){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
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
