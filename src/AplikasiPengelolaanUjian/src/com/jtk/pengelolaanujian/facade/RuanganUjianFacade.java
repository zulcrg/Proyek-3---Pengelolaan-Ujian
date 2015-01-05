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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public RuanganUjian findByUjianKodeKelasKode(String ujianKode, String kelasKode) {
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
            if (rs.next()) {
                RuanganUjian ruanganUjian = new RuanganUjian();
                ruanganUjian.setRuanganKode(rs.getString("RUANGAN_KODE"));
                ruanganUjian.setUjianKode(rs.getString("UJIAN_KODE"));
                ruanganUjian.setStafNip(rs.getString("STAF_NIP"));
                ruanganUjian.setBeritaKode(rs.getString("BERITA_KODE"));
                ruanganUjian.setKelasKode(rs.getString("KELAS_KODE"));
                ruanganUjian.setRuanganUjianUploadNilaiStatus(rs.getBoolean("RUANGAN_UJIAN_NILAI_UPLOADED"));

                return ruanganUjian;
            }
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
            String query = "SELECT ruangan_ujian.*, staf.*, ujian.* FROM ruangan_ujian,staf,ujian where ujian.UJIAN_KODE IN " + sb.toString() + " "
                    + "AND ruangan_ujian.staf_nip = staf.staf_nip "
                    + "AND ruangan_ujian.ujian_kode = ujian.ujian_kode";
            ResultSet rs = stmt.executeQuery(query);
            List<RuanganUjian> ruanganUjianList = new ArrayList<>();
            while (rs.next()) {
                RuanganUjian ruanganUjian = new RuanganUjian();
                ruanganUjian.setRuanganKode(rs.getString(1));
                ruanganUjian.setUjianKode(rs.getString(2));
                ruanganUjian.setStafNip(rs.getString(3));
                ruanganUjian.setBeritaKode(rs.getString(4));

                Staf staf = new Staf();
                staf.setStafNIP(rs.getString(7));
                staf.setStafNama(rs.getString(8));
                staf.setStafEmail(rs.getString(9));
                staf.setStafKontak(rs.getString(10));

                Ujian ujian = new Ujian();
                ujian.setUjianKode(rs.getString(11));
                ujian.setEventKode(rs.getString(12));
                ujian.setSoalKode(rs.getString(13));
                ujian.setUjianMulai(rs.getDate(14));
                ujian.setUjianMenit(rs.getInt(15));
                ujian.setUjianNama(rs.getString(16));

                ruanganUjian.setUjian(ujian);
                ruanganUjian.setStaf(staf);
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
            String query = "SELECT * FROM RUANGAN_UJIAN WHERE RUANGAN_UJIAN_NILAI_UPLOADED = '" + b + "'";
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

                listRuanganUjian.add(ruanganUjian);
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
                ruanganUjian.setRuanganKode(rs.getString("RUANGAN_KODE"));
                ruanganUjian.setUjianKode(rs.getString("UJIAN_KODE"));
                ruanganUjian.setStafNip(rs.getString("STAF_NIP"));
                ruanganUjian.setBeritaKode(rs.getString("BERITA_KODE"));
                ruanganUjian.setRuanganUjianUploadNilaiStatus(getBoolean("RUANGAN_UJIAN_NILAI_UPLOADED"));
                ruanganUjian.setKelasKode(rs.getString("KELAS_KODE"));

                Ujian ujian = new Ujian();
                ujian.setUjianNama(rs.getString("UJIAN_NAMA"));
                Kelas kelas = new Kelas();
                kelas.setKelasNama(rs.getString("KELAS_NAMA"));

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

    public List<RuanganUjian> findRuanganUjianAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * "
                    + " FROM"
                    + " ruangan_ujian,ujian,soal,mata_kuliah"
                    + " WHERE"
                    + " ruangan_ujian.ujian_kode = ujian.ujian_kode AND"
                    + " ujian.soal_kode= soal.soal_kode AND"
                    + " soal.matkul_kode = mata_kuliah.matkul_kode AND"
                    + " soal.matkul_tipe = mata_kuliah.matkul_tipe";

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

    public void createRuanganUjian(RuanganUjian ruanganUjian) throws SQLException {
        String query = "INSERT INTO ruangan_ujian(RUANGAN_KODE, UJIAN_KODE, STAF_NIP, BERITA_KODE, RUANGAN_UJIAN_NILAI_UPLOADED, KELAS_KODE) values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, ruanganUjian.getRuanganKode());
        preparedStatement.setString(2, ruanganUjian.getUjianKode());
        preparedStatement.setString(3, ruanganUjian.getStafNip());
        preparedStatement.setString(4, ruanganUjian.getBeritaKode());
        preparedStatement.setBoolean(5, ruanganUjian.isRuanganUjianUploadNilaiStatus());
        preparedStatement.setString(6, ruanganUjian.getKelasKode());

        preparedStatement.execute();
    }

    public int checkTerlalui(boolean b) {
        int counter = 0;
        String tanggal;
        boolean stat;
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM ruangan_ujian,ujian WHERE ruangan_ujian.ujian_kode = ujian.ujian_kode";
            ResultSet rs = stmt.executeQuery(query);
            Ujian ujian = new Ujian();
            while (rs.next()) {
                tanggal = rs.getString(10);

                tanggal = tanggal.substring(0, 10);
                System.out.println(tanggal);
                stat = check(tanggal, b);
                if (stat == true) {
                    counter++;
                }
            }
            return counter;
        } catch (SQLException ex) {
            Logger.getLogger(RuanganUjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return counter;
    }

    private boolean check(String tanggal, boolean b) {
        try {
            Date date = new Date();
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

            Date tanggal2 = formatDate.parse(tanggal);
            if (b == true) {
                if (date.after(tanggal2)) {
                    return true;
                } else {
                    return false;
                }
            }
            if (b == false) {
                if (tanggal2.after(date)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(RuanganUjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void updateUploadedNilai(RuanganUjian ruanganUjian) throws SQLException {
        String query = "UPDATE ruangan_ujian SET RUANGAN_UJIAN_NILAI_UPLOADED = ? WHERE KELAS_KODE = ? AND UJIAN_KODE = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setBoolean(1, ruanganUjian.isRuanganUjianUploadNilaiStatus());
        preparedStatement.setString(2, ruanganUjian.getKelasKode());
        preparedStatement.setString(3, ruanganUjian.getUjianKode());

        preparedStatement.executeUpdate();
    }
}
