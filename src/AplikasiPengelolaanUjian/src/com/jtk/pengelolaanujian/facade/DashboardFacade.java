/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Dosen;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pahlevi
 */
public class DashboardFacade {

    private Connection connection = ConnectionHelper.getConnection();

    public void findAlltableVnv(JTable tabelStatusVNV) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT staf.staf_nama , kbk.kbk_nama , staf_email, staf_kontak FROM staf, kbk, dosen, user, user_to_role WHERE kbk.kbk_kode IN('K000003','K000001','K000002') AND kbk.kbk_kode = dosen.kbk_kode AND user.staf_nip = dosen.staf_nip AND user_to_role.staf_nip = user.staf_nip AND user_to_role.role_kode = 2 AND user.staf_nip = staf.staf_nip";
            ResultSet rs = stmt.executeQuery(query);
            Object[] columnsName = {"Nama", "KBK","Email", "No. Telp"};
            DefaultTableModel dtm = new DefaultTableModel(null, columnsName) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            List<Dosen> dosenList = new ArrayList<>();
            while (rs.next()) {
                Object[] o = new Object[4];
                o[0] = rs.getString(1);
                o[1] = rs.getString(2);
                o[2] = rs.getString(3);
                o[3] = rs.getString(4);
                dtm.addRow(o);
            }            
            tabelStatusVNV.setModel(dtm);

        } catch (SQLException ex) {
            Logger.getLogger(DosenFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
