/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.RuanganUjian;
import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import com.jtk.pengelolaanujian.view.LoginPanel;
import java.sql.Connection;
import java.sql.Date;
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
public class UjianFacade {

    private final Connection connection = ConnectionHelper.getConnection();

    public List<Ujian> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM ujian";
            ResultSet rs = stmt.executeQuery(query);
            List<Ujian> ujianList = new ArrayList<>();
            while (rs.next()) {
                Ujian ujian = new Ujian();
                ujian.setEventKode(rs.getString("EVENT_KODE"));
                ujian.setSoalKode(rs.getString("SOAL_KODE"));
                ujian.setUjianKode(rs.getString("UJIAN_KODE"));
                ujian.setUjianMenit(rs.getInt("UJIAN_MENIT"));
                ujian.setUjianMulai(rs.getDate("UJIAN_MULAI"));
                ujian.setUjianNama(rs.getString("UJIAN_NAMA"));

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
                ujian.setEventKode(rs.getString("EVENT_KODE"));
                ujian.setSoalKode(rs.getString("SOAL_KODE"));
                ujian.setUjianKode(rs.getString("UJIAN_KODE"));
                ujian.setUjianMenit(rs.getInt("UJIAN_MENIT"));
                ujian.setUjianMulai(rs.getDate("UJIAN_MULAI"));
                ujian.setUjianNama(rs.getString("UJIAN_NAMA"));

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
                ujian.setEventKode(rs.getString("EVENT_KODE"));
                ujian.setSoalKode(rs.getString("SOAL_KODE"));
                ujian.setUjianKode(rs.getString("UJIAN_KODE"));
                ujian.setUjianMenit(rs.getInt("UJIAN_MENIT"));
                ujian.setUjianMulai(rs.getDate("UJIAN_MULAI"));
                ujian.setUjianNama(rs.getString("UJIAN_NAMA"));

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
                ujian.setEventKode(rs.getString("EVENT_KODE"));
                ujian.setSoalKode(rs.getString("SOAL_KODE"));
                ujian.setUjianKode(rs.getString("UJIAN_KODE"));
                ujian.setUjianMenit(rs.getInt("UJIAN_MENIT"));
                ujian.setUjianMulai(rs.getDate("UJIAN_MULAI"));
                ujian.setUjianNama(rs.getString("UJIAN_NAMA"));

                return ujian;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Ujian> findUjianLike(String text) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM ujian WHERE UJIAN_KODE LIKE '%" + text + "%' OR UJIAN_NAMA LIKE '%" + text + "%'";
            ResultSet rs = stmt.executeQuery(query);
            List<Ujian> ujians = new ArrayList<>();
            while (rs.next()) {
                Ujian ujian = new Ujian();
                ujian.setEventKode(rs.getString("EVENT_KODE"));
                ujian.setSoalKode(rs.getString("SOAL_KODE"));
                ujian.setUjianKode(rs.getString("UJIAN_KODE"));
                ujian.setUjianMenit(rs.getInt("UJIAN_MENIT"));
                ujian.setUjianMulai(rs.getDate("UJIAN_MULAI"));
                ujian.setUjianNama(rs.getString("UJIAN_NAMA"));

                ujians.add(ujian);
            }
            return ujians;
        } catch (SQLException ex) {
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Ujian> findByUsername() {
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
                ujian.setEventKode(rs.getString("EVENT_KODE"));
                ujian.setSoalKode(rs.getString("SOAL_KODE"));
                ujian.setUjianKode(rs.getString("UJIAN_KODE"));
                ujian.setUjianMenit(rs.getInt("UJIAN_MENIT"));
                ujian.setUjianMulai(rs.getDate("UJIAN_MULAI"));
                ujian.setUjianNama(rs.getString("UJIAN_NAMA"));

                ujianList.add(ujian);
            }
            return ujianList;
        } catch (SQLException ex) {
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Ujian> findAllWhereListedIN(List<RuanganUjian> listRuanganUjian) {
        List<Ujian> listUjian = new ArrayList<>();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("(");

            for (int i = 0; i < listRuanganUjian.size(); i++) {
                sb.append("'").append(listRuanganUjian.get(i).getUjianKode()).append("'");
                if (i < listRuanganUjian.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");

            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM ujian WHERE UJIAN_KODE IN " + sb.toString() + "";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Ujian ujian = new Ujian();
                ujian.setEventKode(rs.getString("EVENT_KODE"));
                ujian.setSoalKode(rs.getString("SOAL_KODE"));
                ujian.setUjianKode(rs.getString("UJIAN_KODE"));
                ujian.setUjianMenit(rs.getInt("UJIAN_MENIT"));
                ujian.setUjianMulai(rs.getDate("UJIAN_MULAI"));
                ujian.setUjianNama(rs.getString("UJIAN_NAMA"));

                listUjian.add(ujian);
            }
            return listUjian;
        } catch (SQLException ex) {
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void createUjian(Ujian ujian) {
        try {
            String query = "INSERT INTO ujian(UJIAN_KODE, EVENT_KODE, SOAL_KODE, UJIAN_MULAI, UJIAN_MENIT, UJIAN_NAMA) values(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ujian.getUjianKode());
            preparedStatement.setString(2, ujian.getEventKode());
            preparedStatement.setString(3, ujian.getSoalKode());
            preparedStatement.setDate(4, new Date(ujian.getUjianMulai().getTime()));
            preparedStatement.setInt(5, ujian.getUjianMenit());
            preparedStatement.setString(6, ujian.getUjianNama());

            preparedStatement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data", "Q1", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
