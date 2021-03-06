/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.BeritaAcara;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

    public void createBeritaAcara(BeritaAcara beritaAcara) throws SQLException {
        String query = "INSERT INTO berita_acara(BERITA_KODE, BERITA_KET, BERITA_HADIR, BERITA_TIDAK_HADIR, BERITA_SOAL_SISA, BERITA_JAWAB_SISA, BERITA_STATUS) values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, beritaAcara.getBeritaKode());
        preparedStatement.setString(2, beritaAcara.getBeritaKet());
        preparedStatement.setInt(3, beritaAcara.getBeritaHadir());
        preparedStatement.setInt(4, beritaAcara.getBeritaTidakHadir());
        preparedStatement.setInt(5, beritaAcara.getBeritaSoalSisa());
        preparedStatement.setInt(6, beritaAcara.getBeritaJawabSisa());
        preparedStatement.setBoolean(7, beritaAcara.isBeritaStatus());

        preparedStatement.execute();
    }

    public void updateBeritaAcara(BeritaAcara beritaAcara) throws SQLException {
        String beritaKet = beritaAcara.getBeritaKet();
        int beritaHadir = beritaAcara.getBeritaHadir();
        int beritaTidakHadir = beritaAcara.getBeritaTidakHadir();
        int beritaSoalSisa = beritaAcara.getBeritaSoalSisa();
        int beritaJawabSisa = beritaAcara.getBeritaJawabSisa();
        String beritaKode = beritaAcara.getBeritaKode();

        Statement stmt = connection.createStatement();
        String query = "UPDATE berita_acara SET BERITA_KET = '" + beritaKet + "',BERITA_HADIR = '" + beritaHadir + "',BERITA_TIDAK_HADIR = '" + beritaTidakHadir + "',BERITA_SOAL_SISA = '" + beritaSoalSisa + "',BERITA_JAWAB_SISA = '" + beritaJawabSisa + "',BERITA_STATUS = 1 WHERE berita_acara.BERITA_KODE = '" + beritaKode + "'";
        stmt.executeUpdate(query);

    }
}
