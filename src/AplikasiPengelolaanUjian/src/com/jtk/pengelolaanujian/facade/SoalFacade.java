/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Dosen;
import com.jtk.pengelolaanujian.entity.Event;
import com.jtk.pengelolaanujian.entity.Kbk;
import com.jtk.pengelolaanujian.entity.Kelas;
import com.jtk.pengelolaanujian.entity.MataKuliah;
import com.jtk.pengelolaanujian.entity.RuanganUjian;
import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.entity.Staf;
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
                soal.setMatkulKode(rs.getString("MATKUL_KODE"));
                soal.setSoalKode(rs.getString("SOAL_KODE"));
                soal.setSoalPrinted(rs.getBoolean("SOAL_PRINTED"));
                soal.setSoalVnved(rs.getBoolean("SOAL_VNVED"));
                soal.setSoalUploaded(rs.getBoolean("SOAL_UPLOADED"));
                soal.setSoalSifat(rs.getString("SOAL_SIFAT"));
                soal.setMatkulTipe(rs.getString("MATKUL_TIPE"));

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
                soal.setMatkulKode(rs.getString("MATKUL_KODE"));
                soal.setSoalKode(rs.getString("SOAL_KODE"));
                soal.setSoalPrinted(rs.getBoolean("SOAL_PRINTED"));
                soal.setSoalVnved(rs.getBoolean("SOAL_VNVED"));
                soal.setSoalUploaded(rs.getBoolean("SOAL_UPLOADED"));
                soal.setSoalSifat(rs.getString("SOAL_SIFAT"));
                soal.setMatkulTipe(rs.getString("MATKUL_TIPE"));
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
                soal.setMatkulKode(rs.getString("MATKUL_KODE"));
                soal.setSoalKode(rs.getString("SOAL_KODE"));
                soal.setSoalPrinted(rs.getBoolean("SOAL_PRINTED"));
                soal.setSoalVnved(rs.getBoolean("SOAL_VNVED"));
                soal.setSoalUploaded(rs.getBoolean("SOAL_UPLOADED"));
                soal.setSoalSifat(rs.getString("SOAL_SIFAT"));
                soal.setMatkulTipe(rs.getString("MATKUL_TIPE"));

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
                soal.setMatkulKode(rs.getString("MATKUL_KODE"));
                soal.setSoalKode(rs.getString("SOAL_KODE"));
                soal.setSoalPrinted(rs.getBoolean("SOAL_PRINTED"));
                soal.setSoalVnved(rs.getBoolean("SOAL_VNVED"));
                soal.setSoalUploaded(rs.getBoolean("SOAL_UPLOADED"));
                soal.setSoalSifat(rs.getString("SOAL_SIFAT"));
                soal.setMatkulTipe(rs.getString("MATKUL_TIPE"));

                soalList.add(soal);
            }
            return soalList;

        } catch (SQLException ex) {
            Logger.getLogger(SoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Soal> findAllWhereListedIN(List<Ujian> listUjian) {
        List<Soal> listSoal = new ArrayList<>();
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
                soal.setMatkulKode(rs.getString("MATKUL_KODE"));
                soal.setSoalKode(rs.getString("SOAL_KODE"));
                soal.setSoalPrinted(rs.getBoolean("SOAL_PRINTED"));
                soal.setSoalVnved(rs.getBoolean("SOAL_VNVED"));
                soal.setSoalUploaded(rs.getBoolean("SOAL_UPLOADED"));
                soal.setSoalSifat(rs.getString("SOAL_SIFAT"));
                soal.setMatkulTipe(rs.getString("MATKUL_TIPE"));

                listSoal.add(soal);
            }
            return listSoal;
        } catch (SQLException ex) {
            Logger.getLogger(UjianFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void createSoal(Soal soal) throws SQLException {
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

    public List<Soal> findAllWhereVNVtrue() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT soal.soal_kode, mata_kuliah.matkul_kode, mata_kuliah.matkul_nama , staf.staf_nama FROM soal,mata_kuliah,mata_kuliah_to_dosen,dosen,staf WHERE staf.staf_nip = dosen.staf_nip AND dosen.dosen_kode = mata_kuliah_to_dosen.dosen_kode AND mata_kuliah_to_dosen.matkul_kode = mata_kuliah.matkul_kode AND mata_kuliah_to_dosen.matkul_tipe = mata_kuliah.matkul_tipe AND mata_kuliah.matkul_kode = soal.matkul_kode AND mata_kuliah.matkul_tipe = soal.matkul_tipe AND soal.soal_vnved = 1";

            ResultSet rs = stmt.executeQuery(query);
            List<Soal> soalList = new ArrayList<>();
            while (rs.next()) {
                Soal soal = new Soal();
                soal.setSoalKode(rs.getString(1));

                MataKuliah mataKuliah = new MataKuliah();
                mataKuliah.setMatkulKode(rs.getString(2));
                mataKuliah.setMatkulNama(rs.getString(3));

                Staf staf = new Staf();
                staf.setStafNama(rs.getString(4));

                Dosen dosen = new Dosen();
                dosen.setStafNama(staf.getStafNama());

                mataKuliah.setDosen(dosen);

                soal.setMataKuliah(mataKuliah);

                soalList.add(soal);
            }
            return soalList;

        } catch (SQLException ex) {
            Logger.getLogger(SoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Soal> searchSoalInKbk(String text) {
        Statement stmt;
        try {
            // create statement for connection
            String kbkKode = findUserKbk();
            if (kbkKode != null && !kbkKode.isEmpty()) {
                stmt = connection.createStatement();
                // query yang diberikan
                String query = "SELECT soal.SOAL_KODE, soal.SOAL_SIFAT, mata_kuliah.MATKUL_KODE, mata_kuliah.MATKUL_NAMA, mata_kuliah.MATKUL_TIPE, ujian.UJIAN_MULAI,  ujian.UJIAN_MENIT, event.EVENT_KODE, dosen.DOSEN_KODE, staf.STAF_NAMA, kelas.KELAS_NAMA "
                        + "FROM soal, mata_kuliah, ujian, event, staf, dosen, kelas, mata_kuliah_to_dosen, ruangan_ujian "
                        + "WHERE (soal.SOAL_KODE like '%" + text + "%' OR mata_kuliah.MATKUL_NAMA like '%" + text + "%' ) "
                        + "AND mata_kuliah.MATKUL_KODE = soal.MATKUL_KODE AND "
                        + "mata_kuliah.MATKUL_TIPE = soal.MATKUL_TIPE AND "
                        + "ujian.SOAL_KODE = soal.SOAL_KODE AND "
                        + "event.EVENT_KODE = ujian.EVENT_KODE AND "
                        + "mata_kuliah_to_dosen.MATKUL_KODE = mata_kuliah.MATKUL_KODE AND "
                        + "mata_kuliah_to_dosen.MATKUL_TIPE = mata_kuliah.MATKUL_TIPE AND "
                        + "dosen.DOSEN_KODE = mata_kuliah_to_dosen.DOSEN_KODE AND "
                        + "staf.STAF_NIP = dosen.STAF_NIP AND "
                        + "ruangan_ujian.UJIAN_KODE = ujian.UJIAN_KODE AND "
                        + "kelas.KELAS_KODE = ruangan_ujian.KELAS_KODE AND "
                        + "dosen.KBK_KODE = '" + kbkKode + "' AND "
                        + "soal.SOAL_VNVED = 0";                
                // alokasi resultset sebagai penampung hasil dari query yang di eksekusi

                System.out.println("wasfa = "+query);
                ResultSet rs = stmt.executeQuery(query);
                List<Soal> soalList = new ArrayList<>();
                while (rs.next()) {
                    Soal soal = new Soal();
                    soal.setSoalKode(rs.getString(1));
                    soal.setSoalSifat(rs.getString(2));
                    
                    System.out.println(soal.getSoalSifat());

                    MataKuliah mataKuliah = new MataKuliah();
                    mataKuliah.setMatkulKode(rs.getString(3));
                    mataKuliah.setMatkulNama(rs.getString(4));
                    mataKuliah.setMatkulTipe(rs.getString(5));

                    soal.setMataKuliah(mataKuliah);

                    Ujian ujian = new Ujian();
                    ujian.setUjianMulai(rs.getDate(6));
                    ujian.setUjianMenit(rs.getInt(7));

                    soal.setUjian(ujian);

                    Event event = new Event();
                    event.setKode(rs.getString(8));

                    ujian.setEvent(event);

                    Dosen dosen = new Dosen();
                    dosen.setDosenKode(rs.getString(9));

                    mataKuliah.setDosen(dosen);

                    dosen.setStafNama(rs.getString(10));

                    Kelas kelas = new Kelas();
                    kelas.setKelasNama(rs.getString(11));

                    RuanganUjian ruanganUjian = new RuanganUjian();
                    ruanganUjian.setKelas(kelas);

                    ruanganUjian.setUjian(ujian);
                    ujian.setSoal(soal);
                    ujian.setRuanganUjian(ruanganUjian);                    
                    soal.setUjian(ujian);
                    soalList.add(soal);
                    //gelo asli

                }
                return soalList;
            } else {
                return new ArrayList<>();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String findUserKbk() {
        try {
            String kbkKode = "";
            Statement statement = connection.createStatement();
            String query = "SELECT kbk.KBK_KODE from kbk, user, dosen, staf "
                    + "WHERE user.user_username = '" + LoginPanel.getUsername() + "' AND "
                    + "user.staf_nip = staf.staf_nip AND "
                    + "dosen.staf_nip = staf.staf_nip AND "
                    + "kbk.KBK_KODE = dosen.KBK_KODE";
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                kbkKode = rs.getString(1);
            }
            return kbkKode;
        } catch (SQLException ex) {
            Logger.getLogger(SoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateSoalSifatUploaded(Soal soal) throws SQLException {
        String query = "UPDATE soal SET SOAL_SIFAT = ?, SOAL_UPLOADED = ? WHERE SOAL_KODE = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, soal.getSoalSifat());
        preparedStatement.setBoolean(2, soal.isSoalUploaded());
        preparedStatement.setString(3, soal.getSoalKode());

        preparedStatement.executeUpdate();
    }
}
