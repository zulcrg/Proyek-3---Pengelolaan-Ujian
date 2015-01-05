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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    public boolean submitVnv(List<Dosen> dosen, Soal soal, String relevansi, String kesulitan, String bobotNilai, String bobotWaktu, String lain) {
        // TODO: insert ke dosen_to_vnv, vnv udah itu doang
        return false;
    }
}
