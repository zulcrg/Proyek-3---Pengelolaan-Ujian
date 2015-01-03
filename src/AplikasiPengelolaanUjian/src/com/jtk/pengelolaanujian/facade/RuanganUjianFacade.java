/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.BeritaAcara;
import com.jtk.pengelolaanujian.entity.Kelas;
import com.jtk.pengelolaanujian.entity.RuanganUjian;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import com.jtk.pengelolaanujian.view.LoginPanel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getBoolean;

/**
 *
 * @author Rizki
 */
public class RuanganUjianFacade {

    private final Connection connection = ConnectionHelper.getConnection();

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

    public List<RuanganUjian> findByUjianKodeStafNipKelasKode(String ujianKode, String kelasKode) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM ruangan_ujian ";
            StringBuilder sb = new StringBuilder();
            if (ujianKode != null && !ujianKode.isEmpty()) {
                sb.append("WHERE UJIAN_KODE = '").append(ujianKode).append("' ");
            }
            if (kelasKode != null && !kelasKode.isEmpty()) {
                if (sb.length() > 0) {
                    sb.append("AND ");
                } else {
                    sb.append("WHERE ");
                }
                sb.append("KELAS_KODE = '").append(kelasKode).append("'");
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
                ruanganUjian.setRuanganUjianUploadNilaiStatus(rs.getBoolean(5));
                ruanganUjian.setKelasKode(rs.getString(6));

            }
            return listRuanganUjian;
        } catch (SQLException ex) {
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<RuanganUjian> findRuanganUjianByUsername() {
        try {
            Statement stmt = connection.createStatement();
            String query = "select ruangan_ujian.*,ujian.*,kelas.*\n"
                    + "from user,staf,dosen,mata_kuliah_to_dosen,mata_kuliah,soal,ujian,ruangan_ujian,kelas \n"
                    + "where ruangan_ujian.ujian_kode = ujian.ujian_kode AND \n"
                    + "kelas.kelas_kode = ruangan_ujian.kelas_kode AND\n\n"
                    + "ujian.soal_kode = soal.soal_kode AND \n"
                    + "soal.matkul_kode = mata_kuliah.matkul_kode AND\n"
                    + "soal.matkul_tipe = mata_kuliah.matkul_tipe AND \n"
                    + "mata_kuliah_to_dosen.matkul_kode = mata_kuliah.matkul_kode AND \n"
                    + "mata_kuliah_to_dosen.matkul_tipe = mata_kuliah.matkul_tipe AND \n"
                    + "dosen.dosen_kode = mata_kuliah_to_dosen.dosen_kode AND \n"
                    + "dosen.staf_nip = staf.staf_nip AND \n"
                    + "user.staf_nip = staf.staf_nip AND \n"
                    + "user.user_username = '" + LoginPanel.getUsername() + "'";
            ResultSet rs = stmt.executeQuery(query);
            List<RuanganUjian> listRuanganUjian = new ArrayList<>();
            while (rs.next()) {
                RuanganUjian ruanganUjian = new RuanganUjian();
                ruanganUjian.setRuanganKode(rs.getString(1));
                ruanganUjian.setUjianKode(rs.getString(2));
                ruanganUjian.setStafNip(rs.getString(3));
                ruanganUjian.setBeritaKode(rs.getString(4));
                ruanganUjian.setRuanganUjianUploadNilaiStatus(getBoolean(5));
                ruanganUjian.setKelasKode(rs.getString(6));

                Ujian ujian = new Ujian();
                ujian.setUjianNama(rs.getString(12));
                Kelas kelas = new Kelas();
                kelas.setKelasNama(rs.getString(14));

                ruanganUjian.setUjian(ujian);
                ruanganUjian.setKelas(kelas);

                listRuanganUjian.add(ruanganUjian);
            }
            return listRuanganUjian;
        } catch (SQLException ex) {
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void createRuanganUjian(RuanganUjian ruanganUjian) {
        try {
            String query = "INSERT INTO ruangan_ujian(RUANGAN_KODE, UJIAN_KODE, STAF_NIP, BERITA_KODE, RUANGAN_UJIAN_NILAI_UPLOADED, KELAS_KODE) values(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ruanganUjian.getRuanganKode());
            preparedStatement.setString(2, ruanganUjian.getUjianKode());
            preparedStatement.setString(3, ruanganUjian.getStafNip());
            preparedStatement.setString(4, ruanganUjian.getBeritaKode());
            preparedStatement.setBoolean(5, ruanganUjian.isRuanganUjianUploadNilaiStatus());
            preparedStatement.setString(6, ruanganUjian.getKelasKode());

            preparedStatement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data", "Q1", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
