/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Soal;
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
public class SoalFacade {

    private final Connection connection = ConnectionHelper.getConnection();

    public List<Soal> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM soal";
            ResultSet rs = stmt.executeQuery(query);
            List<Soal> soalList = new ArrayList<>();
            while (rs.next()) {
                Soal soal = new Soal();
                soal.setMatkulKode(rs.getString(1));
                soal.setSoalKode(rs.getString(2));
                soal.setSoalPrinted(rs.getBoolean(3));
                soal.setSoalVnved(rs.getBoolean(4));
                soal.setSoalUploaded(rs.getBoolean(5));
                soal.setSoalSifat(rs.getString(6));

                soalList.add(soal);
            }
            return soalList;
        } catch (SQLException ex) {
            Logger.getLogger(SoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Soal findByKodeSoal(String kodeSoal) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM soal where SOAL_KODE = '" + kodeSoal + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                Soal soal = new Soal();
                soal.setMatkulKode(rs.getString(1));
                soal.setSoalKode(rs.getString(2));
                soal.setSoalPrinted(rs.getBoolean(3));
                soal.setSoalVnved(rs.getBoolean(4));
                soal.setSoalUploaded(rs.getBoolean(5));
                soal.setSoalSifat(rs.getString(6));
                return soal;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Soal> findByKodeMatkul(String kodeMatkul) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM soal where MATKUL_KODE = '" + kodeMatkul + "'";
            ResultSet rs = stmt.executeQuery(query);
            List<Soal> soalList = new ArrayList<>();
            while (rs.next()) {
                Soal soal = new Soal();
                soal.setMatkulKode(rs.getString(1));
                soal.setSoalKode(rs.getString(2));
                soal.setSoalPrinted(rs.getBoolean(3));
                soal.setSoalVnved(rs.getBoolean(4));
                soal.setSoalUploaded(rs.getBoolean(5));
                soal.setSoalSifat(rs.getString(6));

                soalList.add(soal);
            }
            return soalList;

        } catch (SQLException ex) {
            Logger.getLogger(SoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
