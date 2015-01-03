/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.admin;

import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.facade.StafFacade;
import com.jtk.pengelolaanujian.facade.UserFacade;
import com.zlib.util.ZHash;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pahlevi
 */
public class RegistrasiUserController {

    public void registrasiUser(Staf staf, String textNama, String textPassword) {
        UserFacade userFacade = new UserFacade();
        userFacade.registrasiUser(staf, textNama, ZHash.hashMD5(textPassword));
    }

    public void searchUser(String text, JTable tableStaf) {
        List<Staf> stafList;

        StafFacade stafFacade = new StafFacade();
        stafList = stafFacade.searchNameNIPNotHaveUser(text);

        Object[] columnsName = {"Nama", "NIP"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnsName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Staf staf : stafList) {
            Object[] o = new Object[2];
            o[0] = staf.getStafNama();
            o[1] = staf.getStafNIP();

            dtm.addRow(o);
        }
        tableStaf.setModel(dtm);
    }

    
}
