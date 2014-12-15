/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.RuanganUjian;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.UIManager.getBoolean;

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
            StringBuilder sb = new StringBuilder();
            sb.append("(");

            for (int i = 0; i < listUjian.size(); i++) {
                sb.append("'").append(listUjian.get(i).getUjianKode()).append("'");
                if (i < listUjian.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");

            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM ruangan_ujian where UJIAN_KODE = " + sb.toString() + "";
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

    public List<RuanganUjian> findAllWhereInsertedIn(Ujian ujian) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM ruangan_ujian where UJIAN_KODE = '" + ujian.getUjianKode() + "'";
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

    public List<RuanganUjian> findAllWhereInsertedIn(List<Ujian> listUjian) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("(");

            for (int i = 0; i < listUjian.size(); i++) {
                sb.append("'").append(listUjian.get(i).getUjianKode()).append("'");
                if (i < listUjian.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");

            Statement stmt = connection.createStatement();
            String query = "SELECT ruangan_ujian.*, staf.*, ujian.* FROM ruangan_ujian,staf,ujian where UJIAN_KODE IN " + sb.toString() + " "
                    + "AND ruangan_ujian.staf_nip = staf.staf_nip";
            ResultSet rs = stmt.executeQuery(query);
            List<RuanganUjian> ruanganUjianList = new ArrayList<>();
            while (rs.next()) {
                RuanganUjian ruanganUjian = new RuanganUjian();
                ruanganUjian.setRuanganKode(rs.getString(1));
                ruanganUjian.setUjianKode(rs.getString(2));
                ruanganUjian.setStafNip(rs.getString(3));
                ruanganUjian.setBeritaKode(rs.getString(4));

                Staf staf = new Staf();
                staf.setStafNIP(rs.getString(5));
                staf.setStafNama(rs.getString(6));
                staf.setStafEmail(rs.getString(7));
                staf.setStafKontak(rs.getString(8));

                Ujian ujian = new Ujian();
                ujian.setUjianKode(rs.getString(9));
                ujian.setEventKode(rs.getString(10));
                ujian.setSoalKode(rs.getString(11));
                ujian.setUjianMulai(rs.getDate(12));
                ujian.setUjianMenit(rs.getInt(13));

                ruanganUjianList.add(ruanganUjian);
            }
            return ruanganUjianList;
        } catch (SQLException ex) {
            Logger.getLogger(RuanganUjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<RuanganUjian> findAllWhereNilaiUploaded(boolean b) {        
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM RUANG_UJIAN WHERE RUANGUJIAN_NILAI_UPLOADED = '" + b + "'";
            ResultSet rs = stmt.executeQuery(query);
            List<RuanganUjian> listRuanganUjian = new ArrayList<>();
            while (rs.next()) {
                RuanganUjian ruanganUjian = new RuanganUjian();
                ruanganUjian.setRuanganKode(rs.getString(1));
                ruanganUjian.setUjianKode(rs.getString(2));
                ruanganUjian.setStafNip(rs.getString(3));
                ruanganUjian.setBeritaKode(rs.getString(4));
                ruanganUjian.setRuanganUjianTanggalUjian(getDate(5));
                ruanganUjian.setRuanganUjianUploadNilaiStatus(getBoolean(6));

                listRuanganUjian.add(ruanganUjian);
            }
            return listRuanganUjian;
        } catch (SQLException ex) {
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;        
    }

    private Date getDate(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
