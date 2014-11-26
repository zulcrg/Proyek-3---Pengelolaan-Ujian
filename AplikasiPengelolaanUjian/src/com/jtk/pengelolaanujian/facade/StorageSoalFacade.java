/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.StorageSoal;
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
public class StorageSoalFacade {

    private Connection connection = ConnectionHelper.getConnection();

    public List<StorageSoal> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM storage_soal";
            ResultSet rs = stmt.executeQuery(query);
            List<StorageSoal> storageSoalList = new ArrayList<>();
            while (rs.next()) {
                StorageSoal storageSoal = new StorageSoal();
                storageSoal.setSoalKode(rs.getString(1));
                storageSoal.setStsoalNoUrut(rs.getInt(2));
                storageSoal.setStafNip(rs.getString(3));
                storageSoal.setStsoalTglUpload(rs.getDate(4));
                storageSoal.setStsoalFile(rs.getBlob(5));

                storageSoalList.add(storageSoal);
            }
            return storageSoalList;
        } catch (SQLException ex) {
            Logger.getLogger(StorageSoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<StorageSoal> findByKodeSoal(String kodeSoal) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM storage_soal WHERE SOAL_KODE = '" + kodeSoal + "'";
            ResultSet rs = stmt.executeQuery(query);
            List<StorageSoal> storageSoalList = new ArrayList<>();
            while (rs.next()) {
                StorageSoal storageSoal = new StorageSoal();
                storageSoal.setSoalKode(rs.getString(1));
                storageSoal.setStsoalNoUrut(rs.getInt(2));
                storageSoal.setStafNip(rs.getString(3));
                storageSoal.setStsoalTglUpload(rs.getDate(4));
                storageSoal.setStsoalFile(rs.getBlob(5));

                storageSoalList.add(storageSoal);
            }
            return storageSoalList;
        } catch (SQLException ex) {
            Logger.getLogger(StorageSoalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
