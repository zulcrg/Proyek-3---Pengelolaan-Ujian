/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.facade;

import com.jtk.pengelolaanujianserver.entity.BeritaAcara;
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
 * @author Rizki
 */
public class BeritaAcaraFacade {

    private Connection connection = ConnectionHelper.getConnection();

    public List<BeritaAcara> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM berita_acara";
            ResultSet rs = stmt.executeQuery(query);
            List<BeritaAcara> beritaAcaraList = new ArrayList<>();
            while (rs.next()) {
                BeritaAcara beritaAcara = new BeritaAcara();
                beritaAcara.setBeritaKode(rs.getString(1));
                beritaAcara.setBeritaKet(rs.getString(2));
                beritaAcara.setBeritaHadir(rs.getInt(3));
                beritaAcara.setBeritaTidakHadir(rs.getInt(4));
                beritaAcara.setBeritaSoalSisa(rs.getInt(5));
                beritaAcara.setBeritaJawabSisa(rs.getInt(6));

                beritaAcaraList.add(beritaAcara);
            }
            return beritaAcaraList;
        } catch (SQLException ex) {
            Logger.getLogger(BeritaAcaraFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public BeritaAcara findByBeritaKode(String beritaKode) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM berita_acara WHERE BERITA_KODE = '" + beritaKode + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                BeritaAcara beritaAcara = new BeritaAcara();
                beritaAcara.setBeritaKode(rs.getString(1));
                beritaAcara.setBeritaKet(rs.getString(2));
                beritaAcara.setBeritaHadir(rs.getInt(3));
                beritaAcara.setBeritaTidakHadir(rs.getInt(4));
                beritaAcara.setBeritaSoalSisa(rs.getInt(5));
                beritaAcara.setBeritaJawabSisa(rs.getInt(6));

                return beritaAcara;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BeritaAcaraFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
