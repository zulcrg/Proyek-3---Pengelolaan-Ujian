/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import com.jtk.pengelolaanujian.view.LoginPanel;
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
public class UjianFacade {

    private Connection connection = ConnectionHelper.getConnection();

    public List<Ujian> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM ujian";
            ResultSet rs = stmt.executeQuery(query);
            List<Ujian> ujianList = new ArrayList<>();
            while (rs.next()) {
                Ujian ujian = new Ujian();
                ujian.setEventKode(rs.getString(1));
                ujian.setSoalKode(rs.getString(2));
                ujian.setUjianKode(rs.getString(3));
                ujian.setUjianMenit(rs.getInt(4));
                ujian.setUjianMulai(rs.getDate(5));

                ujianList.add(ujian);
            }
            return ujianList;
        } catch (SQLException ex) {
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Ujian> findByKodeEvent(String kodeEvent) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM ujian WHERE ujian.EVENT_KODE = '" + kodeEvent + "'";
            ResultSet rs = stmt.executeQuery(query);
            List<Ujian> ujianList = new ArrayList<>();
            while (rs.next()) {
                Ujian ujian = new Ujian();
                ujian.setEventKode(rs.getString(1));
                ujian.setSoalKode(rs.getString(2));
                ujian.setUjianKode(rs.getString(3));
                ujian.setUjianMenit(rs.getInt(4));
                ujian.setUjianMulai(rs.getDate(5));

                ujianList.add(ujian);
            }
            return ujianList;
        } catch (SQLException ex) {
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Ujian findByKodeSoal(String kodeSoal) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM ujian WHERE ujian.SOAL_KODE = '" + kodeSoal + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                Ujian ujian = new Ujian();
                ujian.setEventKode(rs.getString(1));
                ujian.setSoalKode(rs.getString(2));
                ujian.setUjianKode(rs.getString(3));
                ujian.setUjianMenit(rs.getInt(4));
                ujian.setUjianMulai(rs.getDate(5));

                return ujian;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Ujian findByKodeUjian(String kodeUjian) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM ujian WHERE UJIAN_KODE = '" + kodeUjian + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                Ujian ujian = new Ujian();
                ujian.setEventKode(rs.getString(1));
                ujian.setSoalKode(rs.getString(2));
                ujian.setUjianKode(rs.getString(3));
                ujian.setUjianMenit(rs.getInt(4));
                ujian.setUjianMulai(rs.getDate(5));

                return ujian;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Ujian> findByUsername(){
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT ujian.* FROM ujian "
                    + "INNER JOIN soal ON (soal.SOAL_KODE = ujian.SOAL_KODE) "
                    + "INNER JOIN mata_kuliah ON (mata_kuliah.MATKUL_KODE = soal.MATKUL_KODE) "
                    + "INNER JOIN mata_kuliah_to_dosen ON (mata_kuliah_to_dosen.MATKUL_KODE = mata_kuliah.MATKUL_KODE) "
                    + "INNER JOIN dosen ON (mata_kuliah_to_dosen.DOSEN_KODE = dosen.DOSEN_KODE) "
                    + "INNER JOIN staf ON (staf.STAF_NIP = dosen.STAF_NIP) "
                    + "INNER JOIN user ON (user.STAF_NIP = staf.STAF_NIP) "
                    + "WHERE user.USER_USERNAME = '" + LoginPanel.getUsername() + "'";
            ResultSet rs = stmt.executeQuery(query);
            List<Ujian> ujianList = new ArrayList<>();
            while (rs.next()) {
                Ujian ujian = new Ujian();
                ujian.setEventKode(rs.getString(1));
                ujian.setSoalKode(rs.getString(2));
                ujian.setUjianKode(rs.getString(3));
                ujian.setUjianMenit(rs.getInt(4));
                ujian.setUjianMulai(rs.getDate(5));

                ujianList.add(ujian);
            }
            return ujianList;
        } catch (SQLException ex) {
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
