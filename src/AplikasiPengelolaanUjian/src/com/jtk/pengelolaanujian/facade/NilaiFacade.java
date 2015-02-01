/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Event;
import com.jtk.pengelolaanujian.entity.Nilai;
import com.jtk.pengelolaanujian.entity.RuanganUjian;
import com.jtk.pengelolaanujian.entity.Vnv;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class NilaiFacade {

    private Connection connection = ConnectionHelper.getConnection();

    public List<Nilai> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM nilai";
            ResultSet rs = stmt.executeQuery(query);
            List<Nilai> nilaiList = new ArrayList<>();
            while (rs.next()) {
                Nilai nilai = new Nilai();
                nilai.setKelasKode(rs.getString("KELAS_KODE"));
                nilai.setUjianKode(rs.getString("UJIAN_KODE"));
                nilai.setNilaiFile(rs.getBinaryStream("NILAI_FILE"));
                nilai.setNamaFile(rs.getString("NILAI_NAMA_FILE"));
                nilai.setTipeFile(rs.getString("NILAI_TIPE_FILE"));

                nilaiList.add(nilai);
            }
            return nilaiList;
        } catch (SQLException ex) {
            Logger.getLogger(NilaiFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void uploadNilai(Nilai nilai) throws SQLException {
        String query = "INSERT INTO nilai(UJIAN_KODE, KELAS_KODE, NILAI_FILE, NILAI_NAMA_FILE, NILAI_TIPE_FILE) values(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nilai.getUjianKode());
        preparedStatement.setString(2, nilai.getKelasKode());
        preparedStatement.setBinaryStream(3, nilai.getNilaiFile());
        preparedStatement.setString(4, nilai.getNamaFile());
        preparedStatement.setString(5, nilai.getTipeFile());

        preparedStatement.executeUpdate();
    }

    public int findTepatWaktuCount(Event event) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM nilai";
            ResultSet rs = stmt.executeQuery(query);
            List<Nilai> nilais = new ArrayList<>();
            while (rs.next()) {
                Nilai nilai = new Nilai();
                nilai.setNilaiTanggal(rs.getDate(6));
                nilais.add(nilai);
            }
            int counter = 0;
            for (Nilai nilai : nilais) {
                if (nilai.getNilaiTanggal().after(event.getUploadNilaiSelesai())) {
                    counter++;
                }
            }
            return counter;
        } catch (SQLException ex) {
            Logger.getLogger(StorageSoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int findTerlambatCount(Event event) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM nilai";
            ResultSet rs = stmt.executeQuery(query);
            List<Nilai> nilais = new ArrayList<>();
            while (rs.next()) {
                Nilai nilai = new Nilai();
                nilai.setNilaiTanggal(rs.getDate(6));
                nilais.add(nilai);
            }
            int counter = 0;
            for (Nilai nilai : nilais) {
                if (nilai.getNilaiTanggal().before(event.getUploadNilaiSelesai())) {
                    counter++;
                }
            }
            return counter;
        } catch (SQLException ex) {
            Logger.getLogger(StorageSoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
