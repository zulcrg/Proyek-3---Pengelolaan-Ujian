/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Dosen;
import com.jtk.pengelolaanujian.entity.RuanganUjian;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.entity.User;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import com.jtk.pengelolaanujian.view.LoginPanel;
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

    public Staf findByUsername(String username) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT staf.* FROM staf INNER JOIN user ON (user.STAF_NIP = staf.STAF_NIP) "
                    + "WHERE user.USER_USERNAME = '" + username + "'";
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

    public List<Staf> searchNameNIP(String keyword) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM staf where staf_nip like '%" + keyword + "%' OR staf_nama like '%" + keyword + "%'";
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

    public List<Staf> searchNameNIPNotHaveUser(String keyword) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM staf where (staf_nip like '%" + keyword + "%' OR staf_nama like '%" + keyword + "%') AND staf_nip NOT IN (Select staf_nip from user)";
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

    public List<Staf> findAllWhereListedIn(List<Dosen> listDosen) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("(");

            for (int i = 0; i < listDosen.size(); i++) {
                sb.append("'").append(listDosen.get(i).getStafNIP()).append("'");
                if (i < listDosen.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");

            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM staf where STAF_NIP IN " + sb.toString() + "";
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

    public List<Staf> find1AllWhereListedIn(List<RuanganUjian> listRuangUjian) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("(");

            for (int i = 0; i < listRuangUjian.size(); i++) {
                sb.append("'").append(listRuangUjian.get(i).getStafNip()).append("'");
                if (i < listRuangUjian.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");

            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM STAF where RUANGAN_UJIAN.STAF_NIP IN " + sb.toString() + "";
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

    public List<Staf> findAllWhereListedIn1(List<User> users) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("(");

            for (int i = 0; i < users.size(); i++) {
                sb.append("'").append(users.get(i).getStafNIP()).append("'");
                if (i < users.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");

            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM staf where STAF_NIP IN " + sb.toString() + "";
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
