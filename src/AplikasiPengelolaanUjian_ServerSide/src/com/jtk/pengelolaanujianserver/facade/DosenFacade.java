/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.facade;

import com.jtk.pengelolaanujianserver.entity.Dosen;
import com.jtk.pengelolaanujianserver.entity.MataKuliah;
import com.jtk.pengelolaanujianserver.entity.MataKuliahToDosen;
import com.jtk.pengelolaanujianserver.util.ConnectionHelper;
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
 * @author M Haska Ash Shiddiq
 */
public class DosenFacade {

    private final Connection connection = ConnectionHelper.getConnection();

    public List<Dosen> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT dosen.*, staf.* FROM dosen, staf WHERE dosen.STAF_NIP = staf.STAF_NIP";
            ResultSet rs = stmt.executeQuery(query);
            List<Dosen> dosenList = new ArrayList<>();
            while (rs.next()) {
                Dosen dosen = new Dosen();
                dosen.setDosenKode(rs.getString(1));
                dosen.setKbkKode(rs.getString(2));
                dosen.setStafNIP(rs.getString(3));
                dosen.setStafNama(rs.getString(4));
                dosen.setStafEmail(rs.getString(5));
                dosen.setStafKontak(rs.getString(6));

                dosenList.add(dosen);
            }
            return dosenList;
        } catch (SQLException ex) {
            Logger.getLogger(DosenFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Dosen findByDosenKode(String dosenKode) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT dosen.*, staf.* FROM dosen, staf WHERE dosen.STAF_NIP = staf.STAF_NIP AND DOSEN_KODE = '" + dosenKode + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                Dosen dosen = new Dosen();
                dosen.setDosenKode(rs.getString(1));
                dosen.setKbkKode(rs.getString(2));
                dosen.setStafNIP(rs.getString(3));
                dosen.setStafNama(rs.getString(4));
                dosen.setStafEmail(rs.getString(5));
                dosen.setStafKontak(rs.getString(6));

                return dosen;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DosenFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Dosen> findByKbkKode(String kbkKode) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT dosen.*, staf.* FROM dosen, staf WHERE dosen.STAF_NIP = staf.STAF_NIP AND KBK_KODE = '" + kbkKode + "'";
            ResultSet rs = stmt.executeQuery(query);
            List<Dosen> dosenList = new ArrayList<>();
            while (rs.next()) {
                Dosen dosen = new Dosen();
                dosen.setDosenKode(rs.getString(1));
                dosen.setKbkKode(rs.getString(2));
                dosen.setStafNIP(rs.getString(3));
                dosen.setStafNama(rs.getString(4));
                dosen.setStafEmail(rs.getString(5));
                dosen.setStafKontak(rs.getString(6));

                dosenList.add(dosen);
            }
            return dosenList;
        } catch (SQLException ex) {
            Logger.getLogger(DosenFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Dosen> findAllWhereListedIn(List<MataKuliahToDosen> listMataKuliahToDosen) {
        try {
            for (MataKuliahToDosen mataKuliahToDosen : listMataKuliahToDosen) {
                Statement stmt = connection.createStatement();
                String query = "SELECT * FROM dosen WHERE DOSEN_KODE = " + mataKuliahToDosen.getDosenKode() + "";
                ResultSet rs = stmt.executeQuery(query);
                List<Dosen> dosenList = new ArrayList<>();
                while (rs.next()) {
                    Dosen dosen = new Dosen();
                    dosen.setDosenKode(rs.getString(1));
                    dosen.setKbkKode(rs.getString(2));
                    dosen.setStafNIP(rs.getString(3));
                    dosen.setStafNama(rs.getString(4));
                    dosen.setStafEmail(rs.getString(5));
                    dosen.setStafKontak(rs.getString(6));

                    dosenList.add(dosen);
                }
                return dosenList;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DosenFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
