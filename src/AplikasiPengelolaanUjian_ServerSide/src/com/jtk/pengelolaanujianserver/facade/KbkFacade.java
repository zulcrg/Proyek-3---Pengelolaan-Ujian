/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Kbk;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author M Haska Ash Shiddiq
 */
public class KbkFacade {

    private final Connection connection = ConnectionHelper.getConnection();

    public List<Kbk> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM kbk";
            ResultSet rs = stmt.executeQuery(query);
            List<Kbk> kbkList = new ArrayList<>();
            while (rs.next()) {
                Kbk kbk = new Kbk();
                kbk.setKbkKode(rs.getString(1));
                kbk.setKbkNama(rs.getString(2));

                kbkList.add(kbk);
            }
            return kbkList;
        } catch (SQLException ex) {
            Logger.getLogger(KbkFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Kbk findByKbkKode(String kbkKode) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM kbk WHERE KBK_KODE = '" + kbkKode + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                Kbk kbk = new Kbk();
                kbk.setKbkKode(rs.getString(1));
                kbk.setKbkNama(rs.getString(2));

                return kbk;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KbkFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
