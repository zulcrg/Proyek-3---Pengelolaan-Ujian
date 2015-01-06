/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Dosen;
import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.entity.Vnv;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class VnvFacade {

    private final Connection connection = ConnectionHelper.getConnection();

    public List<Vnv> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM vnv";
            ResultSet rs = stmt.executeQuery(query);
            List<Vnv> vnvList = new ArrayList<>();
            while (rs.next()) {
                Vnv vnv = new Vnv();
                vnv.setVnvKode(rs.getString(1));
                vnv.setSoalKode(rs.getString(2));
                vnv.setStafNip(rs.getString(3));
                vnv.setVnvTgl(rs.getDate(4));
                vnv.setVnvStatus(rs.getBoolean(5));
                vnv.setVnvRelevansi(rs.getString(6));
                vnv.setVnvKesulitan(rs.getString(7));
                vnv.setVnvKelayakanBobot(rs.getString(8));
                vnv.setVnvKelayakanWaktu(rs.getString(9));
                vnv.setVnvLain(rs.getString(10));

                vnvList.add(vnv);
            }
            return vnvList;
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Vnv findByKodeSoal(String kodeSoal) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM vnv WHERE SOAL_KODE'" + kodeSoal + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Vnv vnv = new Vnv();
                vnv.setVnvKode(rs.getString(1));
                vnv.setSoalKode(rs.getString(2));
                vnv.setStafNip(rs.getString(3));
                vnv.setVnvTgl(rs.getDate(4));
                vnv.setVnvStatus(rs.getBoolean(5));
                vnv.setVnvRelevansi(rs.getString(6));
                vnv.setVnvKesulitan(rs.getString(7));
                vnv.setVnvKelayakanBobot(rs.getString(8));
                vnv.setVnvKelayakanWaktu(rs.getString(9));
                vnv.setVnvLain(rs.getString(10));

                return vnv;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean submitVnv(List<Dosen> dosen, Vnv vnv) {
        try {
            // TODO: insert ke dosen_to_vnv, vnv udah itu doang: hese euy itu doang oge :D
            connection.setAutoCommit(false);

            String query1 = "INSERT INTO vnv(VNV_KODE, SOAL_KODE, STAF_NIP, \n"
                    + "VNV_TGL, VNV_STATUS, VNV_RELEVANSI, VNV_KESULITAN, \n"
                    + "VNV_KELAYAKAN_BOBOT, VNV_KELAYAKAN_WAKTU, VNV_LAIN)\n"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setString(1, vnv.getVnvKode());
            preparedStatement.setString(2, vnv.getSoalKode());
            preparedStatement.setString(3, vnv.getStafNip());
            preparedStatement.setTimestamp(4, new Timestamp(vnv.getVnvTgl().getTime()));
            preparedStatement.setBoolean(5, vnv.isVnvStatus());
            preparedStatement.setString(6, vnv.getVnvRelevansi());
            preparedStatement.setString(7, vnv.getVnvKesulitan());
            preparedStatement.setString(8, vnv.getVnvKelayakanBobot());
            preparedStatement.setString(9, vnv.getVnvKelayakanWaktu());
            preparedStatement.setString(10, vnv.getVnvLain());

            preparedStatement.executeUpdate();

            query1 = "INSERT INTO dosen_to_vnv(DOSEN_KODE, VNV_KODE) VALUES ";
            for (int i = 0; i < dosen.size(); i++) {
                query1 = query1 + "(?,?)";
                if (i < dosen.size() - 1) {
                    query1 = query1 + ", ";
                }
            }

            preparedStatement = connection.prepareStatement(query1);
            for (int i = 0; i < dosen.size(); i++) {
                preparedStatement.setString(i + i + 1, dosen.get(i).getDosenKode());
                preparedStatement.setString(i + i + 2, vnv.getVnvKode());
            }

            preparedStatement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            try {
                Logger.getLogger(VnvFacade.class.getName()).log(Level.SEVERE, null, ex);
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException ex1) {
                Logger.getLogger(VnvFacade.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }
}
