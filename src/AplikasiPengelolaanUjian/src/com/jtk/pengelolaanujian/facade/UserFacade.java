/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Role;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.entity.User;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import java.sql.Connection;
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
 * @author pahlevi
 */
public class UserFacade {

    private final Connection connection = ConnectionHelper.getConnection();

    public UserFacade() {

    }

    public List<User> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM user";
            ResultSet rs = stmt.executeQuery(query);
            List<User> userList = new ArrayList<>();
            while (rs.next()) {
                User user = new User();

                user.setStafNIP(rs.getString(1));
                user.setUserUsername(rs.getString(2));
                user.setUserPassword(rs.getString(3));

                userList.add(user);
            }
            return userList;
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<User> findByRoleKode(String roleKode) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT user.* FROM user, user_to_role WHERE user_to_role.ROLE_KODE = '" + roleKode + "'";
            ResultSet rs = stmt.executeQuery(query);
            List<User> userList = new ArrayList<>();
            while (rs.next()) {
                User user = new User();

                user.setStafNIP(rs.getString(1));
                user.setUserUsername(rs.getString(2));
                user.setUserPassword(rs.getString(3));

                userList.add(user);
            }
            return userList;
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User findByKodeStafNip(String stafNip) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT user.* FROM user WHERE user.STAF_NIP = '" + stafNip + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                User user = new User();

                user.setStafNIP(rs.getString(1));
                user.setUserUsername(rs.getString(2));
                user.setUserPassword(rs.getString(3));

                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User findByUsername(String username) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT user.* FROM user WHERE user.USER_USERNAME = '" + username + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                User user = new User();

                user.setStafNIP(rs.getString(1));
                user.setUserUsername(rs.getString(2));
                user.setUserPassword(rs.getString(3));

                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean editUser(User user) {

        try {
            Statement stmt;
            stmt = connection.createStatement();
            boolean flag = stmt.execute("UPDATE USER SET USER_ACTIVE ='" + user.isUserActive() + "' where STAF_NIP ='" + user.getStafNIP() + "'");
            return flag;
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return false;
    }

    public boolean editUser() {

        return false;
    }

    public boolean editUserRole(User user) {
        try {
            Statement stmt;
            stmt = connection.createStatement();
            stmt.execute("DELETE FROM user_to_role WHERE STAF_NIP = '" + user.getStafNIP() + "'");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < user.getRoleList().size(); i++) {
                Role role = user.getRoleList().get(i);
                sb.append("('").append(user.getStafNIP()).append("', '").append(role.getRoleKode()).append("')");
                if (i < user.getRoleList().size() - 1) {
                    sb.append(",");
                } else {
                    sb.append(";");
                }
            }

            return stmt.execute("INSERT INTO user_to_role VALUES" + sb.toString());
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean registrasiUser(Staf staf, String textNama, String textPassword) {
        try {
            Statement stmt;
            stmt = connection.createStatement();
            boolean flag = stmt.execute("INSERT INTO user(STAF_NIP,USER_USERNAME,USER_PASSWORD) VALUES('" + staf.getStafNIP() + "','" + textNama + "','" + textPassword + "')");
            return flag;
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Staf> searchNameUsername(String keyword) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT staf.*, user.USER_USERNAME, user.USER_PASSWORD FROM staf, user "
                    + "WHERE user.USER_USERNAME like '%" + keyword + "%' OR staf.STAF_NAMA like '%" + keyword + "%' "
                    + "AND staf.STAF_NIP = user.STAF_NIP ";
            ResultSet rs = stmt.executeQuery(query);
            List<Staf> stafList = new ArrayList<>();
            while (rs.next()) {
                Staf staf = new Staf();
                staf.setStafNIP(rs.getString(1));
                staf.setStafNama(rs.getString(2));
                staf.setStafEmail(rs.getString(3));
                staf.setStafKontak(rs.getString(4));

                User user = new User();
                user.setStafNIP(rs.getString(1));
                user.setUserUsername(rs.getString(5));
                user.setUserPassword(rs.getString(6));
                staf.setUser(user);

                stafList.add(staf);
            }
            return stafList;
        } catch (SQLException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
