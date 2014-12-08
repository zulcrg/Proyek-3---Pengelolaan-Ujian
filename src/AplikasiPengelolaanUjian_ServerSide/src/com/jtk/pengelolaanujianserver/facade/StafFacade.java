/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Staf;
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
 * @author pahlevi
 */
public class StafFacade {

    private final Connection connection = ConnectionHelper.getConnection();

    public List<Staf> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM staf";
            ResultSet rs = stmt.executeQuery(query);
            List<Staf> stafList = new ArrayList<>();
            while (rs.next()) {
                Staf staf = new Staf();
                staf.setStafNIP(rs.getString(1));
                staf.setStafNama(rs.getString(2));
                staf.setStafEmail(rs.getString(3));
                staf.setStafKontak(rs.getString(4));

                stafList.add(staf);
            }
            return stafList;
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Staf findByStafNip(String StafNip) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM staf WHERE STAF_NIP = '" + StafNip + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                Staf staf = new Staf();
                staf.setStafNIP(rs.getString(1));
                staf.setStafNama(rs.getString(2));
                staf.setStafEmail(rs.getString(3));
                staf.setStafKontak(rs.getString(4));

                return staf;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean registrasiStaf() {
        try {
            Statement stmt;
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO staf(staf_nip,staf_nama,staf_email,staf_kontak) VALUES()");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<Staf> searchNameNIP(String keyword){
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM staf where staf_nip like '%"+keyword+"%' OR staf_nama like '%"+keyword+"%'";
            ResultSet rs = stmt.executeQuery(query);
            List<Staf> stafList = new ArrayList<>();
            while (rs.next()) {
                Staf staf = new Staf();
                staf.setStafNIP(rs.getString(1));
                staf.setStafNama(rs.getString(2));
                staf.setStafEmail(rs.getString(3));
                staf.setStafKontak(rs.getString(4));

                stafList.add(staf);
            }
            return stafList;
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Staf> searchNameNIPNotHaveUser(String keyword){
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM staf where (staf_nip like '%"+keyword+"%' OR staf_nama like '%"+keyword+"%') AND staf_nip NOT IN (Select staf_nip from user)";
            ResultSet rs = stmt.executeQuery(query);
            List<Staf> stafList = new ArrayList<>();
            while (rs.next()) {
                Staf staf = new Staf();
                staf.setStafNIP(rs.getString(1));
                staf.setStafNama(rs.getString(2));
                staf.setStafEmail(rs.getString(3));
                staf.setStafKontak(rs.getString(4));

                stafList.add(staf);
            }
            return stafList;
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
