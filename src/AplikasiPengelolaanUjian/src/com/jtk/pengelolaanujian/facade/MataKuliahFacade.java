/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.MataKuliah;
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
public class MataKuliahFacade {

    private final Connection connection = ConnectionHelper.getConnection();

    public List<MataKuliah> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM mata_kuliah";
            ResultSet rs = stmt.executeQuery(query);
            List<MataKuliah> mataKuliahList = new ArrayList<>();
            while (rs.next()) {
                MataKuliah mataKuliah = new MataKuliah();
                mataKuliah.setMatkulKode(rs.getString(1));
                mataKuliah.setMatkulNama(rs.getString(2));
                mataKuliah.setMatkulTipe(rs.getString(3));

                mataKuliahList.add(mataKuliah);
            }
            return mataKuliahList;
        } catch (SQLException ex) {
            Logger.getLogger(EventFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public MataKuliah findByKodeMatkul(String kodeMatkul) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM mata_kuliah WHERE MATKUL_KODE = '" + kodeMatkul + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                MataKuliah mataKuliah = new MataKuliah();
                mataKuliah.setMatkulKode(rs.getString(1));
                mataKuliah.setMatkulNama(rs.getString(2));
                mataKuliah.setMatkulTipe(rs.getString(3));

                return mataKuliah;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<MataKuliah> findByUsername(String username) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT mata_kuliah.* FROM mata_kuliah "
                    + "INNER JOIN mata_kuliah_to_dosen ON (mata_kuliah.MATKUL_KODE = mata_kuliah_to_dosen.MATKUL_KODE) "
                    + "INNER JOIN dosen ON (mata_kuliah_to_dosen.DOSEN_KODE = dosen.DOSEN_KODE) "
                    + "INNER JOIN staf ON (dosen.STAF_NIP = staf.STAF_NIP) "
                    + "INNER JOIN user ON (user.STAF_NIP = staf.STAF_NIP) "
                    + "WHERE user.USER_USERNAME = '" + username + "'";
            ResultSet rs = stmt.executeQuery(query);
            List<MataKuliah> mataKuliahList = new ArrayList<>();
            while (rs.next()) {
                MataKuliah mataKuliah = new MataKuliah();
                mataKuliah.setMatkulKode(rs.getString(1));
                mataKuliah.setMatkulNama(rs.getString(2));
                mataKuliah.setMatkulTipe(rs.getString(3));

                mataKuliahList.add(mataKuliah);
            }
            return mataKuliahList;
        } catch (SQLException ex) {
            Logger.getLogger(EventFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
