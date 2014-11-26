/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Ruangan;
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
 * @author Rizki
 */
public class RuanganFacade {

    private Connection connection = ConnectionHelper.getConnection();

    public List<Ruangan> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM ruangan";
            ResultSet rs = stmt.executeQuery(query);
            List<Ruangan> ruanganList = new ArrayList<>();
            while (rs.next()) {
                Ruangan ruangan = new Ruangan();
                ruangan.setRuanganKode(rs.getString(1));
                ruangan.setRuanganNama(rs.getString(2));

                ruanganList.add(ruangan);
            }
            return ruanganList;
        } catch (SQLException ex) {
            Logger.getLogger(RuanganFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Ruangan findByKodeRuangan(String kodeRuangan) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM ruangan where RUANGAN_KODE = '"+kodeRuangan+"'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                Ruangan ruangan = new Ruangan();
                ruangan.setRuanganKode(rs.getString(1));
                ruangan.setRuanganNama(rs.getString(2));

                return ruangan;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RuanganFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
