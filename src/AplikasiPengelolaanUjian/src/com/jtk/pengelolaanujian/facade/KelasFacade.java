/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Kelas;
import com.jtk.pengelolaanujian.entity.Ruangan;
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
public class KelasFacade {

    private final Connection connection = ConnectionHelper.getConnection();

    public List<Kelas> findKelasLike(String text) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM kelas where KELAS_KODE LIKE '%" + text + "%' OR KELAS_NAMA LIKE '%" + text + "%'";
            ResultSet rs = stmt.executeQuery(query);
            List<Kelas> kelass = new ArrayList<>();

            while (rs.next()) {
                Kelas kelas = new Kelas();
                kelas.setKelasKode(rs.getString(1));
                kelas.setKelasNama(rs.getString(2));

                kelass.add(kelas);
            }
            return kelass;
        } catch (SQLException ex) {
            Logger.getLogger(RuanganFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Kelas findByKelasKode(String kelasKode) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM kelas where KELAS_KODE = '" + kelasKode + "'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                Kelas kelas = new Kelas();
                kelas.setKelasKode(rs.getString(1));
                kelas.setKelasNama(rs.getString(2));

                return kelas;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RuanganFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
