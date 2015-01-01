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

    public int checkUploadedSoalFacade() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT COUNT(*) FROM soal WHERE SOAL_UPLOADED = 1";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0; //rs.getString(1);           
        } catch (SQLException ex) {
            Logger.getLogger(SoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int checkUnUploadedSoalFacade() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT COUNT(*) FROM soal WHERE SOAL_UPLOADED = 0";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0; //rs.getString(1);           
        } catch (SQLException ex) {
            Logger.getLogger(SoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int checkUploadVNV() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT COUNT(*) FROM soal WHERE SOAL_VNVED = 1";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(SoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    public int checkUnUploadVNV() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT COUNT(*) FROM soal WHERE SOAL_VNVED = 0";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(SoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    public int checkUploadNilai() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT COUNT(*) FROM ruangan_ujian WHERE ruangan_ujian_nilai_uploaded = 1";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(SoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int checkUnUploadNilai() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT COUNT(*) FROM ruangan_ujian WHERE ruangan_ujian_nilai_uploaded = 0";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(SoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
