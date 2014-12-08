/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.facade;

import com.jtk.pengelolaanujianserver.entity.User;
import com.jtk.pengelolaanujianserver.entity.Vnv;
import com.jtk.pengelolaanujianserver.util.ConnectionHelper;
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
 * @author Zulkhair Abdullah D
 */
public class VnvFacade {

    private final Connection connection = ConnectionHelper.getConnection();

    public List<Vnv> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM vnv";
            ResultSet rs = stmt.executeQuery(query);
            List<Vnv> vnvList = new ArrayList<>();
            while (rs.next()) {
                Vnv vnv = new Vnv();
                vnv.setVnvKode(rs.getString(1));
                vnv.setSoalKode(rs.getString(2));
                vnv.setStafNip(rs.getString(3));
                vnv.setVnvTgl(rs.getDate(4));
                vnv.setVnvStatus(rs.getBoolean(5));
                vnv.setVnvKet(rs.getString(6));

                vnvList.add(vnv);
            }
            return vnvList;
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Vnv findByKodeSoal(String kodeSoal) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM vnv WHERE SOAL_KODE'" + kodeSoal + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Vnv vnv = new Vnv();
                vnv.setVnvKode(rs.getString(1));
                vnv.setSoalKode(rs.getString(2));
                vnv.setStafNip(rs.getString(3));
                vnv.setVnvTgl(rs.getDate(4));
                vnv.setVnvStatus(rs.getBoolean(5));
                vnv.setVnvKet(rs.getString(6));

                return vnv;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
