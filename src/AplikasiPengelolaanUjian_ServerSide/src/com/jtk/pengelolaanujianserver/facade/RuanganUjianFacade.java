/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.facade;

import com.jtk.pengelolaanujianserver.entity.RuanganUjian;
import com.jtk.pengelolaanujianserver.entity.Ujian;
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
public class RuanganUjianFacade {

    private Connection connection = ConnectionHelper.getConnection();

    public List<RuanganUjian> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM ruangan_ujian";
            ResultSet rs = stmt.executeQuery(query);
            List<RuanganUjian> ruanganUjianList = new ArrayList<>();
            while (rs.next()) {
                RuanganUjian ruanganUjian = new RuanganUjian();
                ruanganUjian.setRuanganKode(rs.getString(1));
                ruanganUjian.setUjianKode(rs.getString(2));
                ruanganUjian.setStafNip(rs.getString(3));
                ruanganUjian.setBeritaKode(rs.getString(4));

                ruanganUjianList.add(ruanganUjian);
            }
            return ruanganUjianList;
        } catch (SQLException ex) {
            Logger.getLogger(RuanganUjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<RuanganUjian> findByRuanganKodeUjianKodeStafNip(String ruanganKode, String ujianKode, String stafNip) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM ruangan_ujian ";
            StringBuilder sb = new StringBuilder();
            if (ruanganKode != null && !ruanganKode.isEmpty()) {
                sb.append("WHERE RUANGAN_KODE = '").append(ruanganKode).append("' ");
            }
            if (ujianKode != null && !ujianKode.isEmpty()) {
                if (sb.length() > 0) {
                    sb.append("AND ");
                } else {
                    sb.append("WHERE ");
                }
                sb.append("UJIAN_KODE = '").append(ujianKode).append("'");
            }
            if (stafNip != null && !stafNip.isEmpty()) {
                if (sb.length() > 0) {
                    sb.append("AND ");
                } else {
                    sb.append("WHERE ");
                }
                sb.append("STAF_NIP = '").append(stafNip).append("'");
            }

            ResultSet rs = stmt.executeQuery(query + sb.toString());
            List<RuanganUjian> ruanganUjianList = new ArrayList<>();
            while (rs.next()) {
                RuanganUjian ruanganUjian = new RuanganUjian();
                ruanganUjian.setRuanganKode(rs.getString(1));
                ruanganUjian.setUjianKode(rs.getString(2));
                ruanganUjian.setStafNip(rs.getString(3));
                ruanganUjian.setBeritaKode(rs.getString(4));

                ruanganUjianList.add(ruanganUjian);
            }
            return ruanganUjianList;
        } catch (SQLException ex) {
            Logger.getLogger(RuanganUjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<RuanganUjian> findAllWhereListedIn(List<Ujian> listUjian) {
        try {
            for (Ujian ujian : listUjian) {
                Statement stmt = connection.createStatement();
                String query = "SELECT * FROM ruangan_ujian where UJIAN_KODE = '"+ujian.getUjianKode()+"'";
                ResultSet rs = stmt.executeQuery(query);
                List<RuanganUjian> ruanganUjianList = new ArrayList<>();
                while (rs.next()) {
                    RuanganUjian ruanganUjian = new RuanganUjian();
                    ruanganUjian.setRuanganKode(rs.getString(1));
                    ruanganUjian.setUjianKode(rs.getString(2));
                    ruanganUjian.setStafNip(rs.getString(3));
                    ruanganUjian.setBeritaKode(rs.getString(4));

                    ruanganUjianList.add(ruanganUjian);
                }
                return ruanganUjianList;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RuanganUjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<RuanganUjian> findAllWhereInsertedIn(Ujian ujian) {
        try {            
                Statement stmt = connection.createStatement();
                String query = "SELECT * FROM ruangan_ujian where UJIAN_KODE = '"+ujian.getUjianKode()+"'";
                ResultSet rs = stmt.executeQuery(query);
                List<RuanganUjian> ruanganUjianList = new ArrayList<>();
                while (rs.next()) {
                    RuanganUjian ruanganUjian = new RuanganUjian();
                    ruanganUjian.setRuanganKode(rs.getString(1));
                    ruanganUjian.setUjianKode(rs.getString(2));
                    ruanganUjian.setStafNip(rs.getString(3));
                    ruanganUjian.setBeritaKode(rs.getString(4));

                    ruanganUjianList.add(ruanganUjian);
                }
                return ruanganUjianList;            
        } catch (SQLException ex) {
            Logger.getLogger(RuanganUjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }   
}
