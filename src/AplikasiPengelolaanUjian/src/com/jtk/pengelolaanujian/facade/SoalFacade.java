/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
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

    public List<Soal> findAllWhereUploaded(boolean flag) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM soal where SOAL_UPLOADED = '" + flag + "'";
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

    public List<Soal> findAllWhereListedIN(List<Ujian> listUjian) {
        List<Soal> listSoal = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("(");

            for (int i = 0; i < listUjian.size(); i++) {
                sb.append("'").append(listUjian.get(i).getSoalKode()).append("'");
                if (i < listUjian.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");

            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM soal WHERE soal_kode IN " + sb.toString() + "";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Soal soal = new Soal();
                soal.setSoalKode(rs.getString(1));
                soal.setMatkulKode(rs.getString(2));
                soal.setSoalUploaded(rs.getBoolean(3));
                soal.setSoalVnved(rs.getBoolean(4));
                soal.setSoalPrinted(rs.getBoolean(5));
                soal.setSoalSifat(rs.getString(6));

                listSoal.add(soal);
            }
            return listSoal;
        } catch (SQLException ex) {
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void createSoal(Soal soal) {
        try {
            String query = "INSERT INTO soal(SOAL_KODE, MATKUL_KODE, SOAL_UPLOADED, SOAL_VNVED, SOAL_PRINTED, SOAL_SIFAT, MATKUL_TIPE) values(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, soal.getSoalKode());
            preparedStatement.setString(2, soal.getMatkulKode());
            preparedStatement.setBoolean(3, soal.isSoalUploaded());
            preparedStatement.setBoolean(4, soal.isSoalVnved());
            preparedStatement.setBoolean(5, soal.isSoalPrinted());
            preparedStatement.setString(6, soal.getSoalSifat());
            preparedStatement.setString(7, soal.getMatkulTipe());
            
            preparedStatement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data", "Q1", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
