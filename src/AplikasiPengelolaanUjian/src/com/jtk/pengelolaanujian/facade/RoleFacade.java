/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Role;
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
public class RoleFacade {

    private Connection connection = ConnectionHelper.getConnection();

    public List<Role> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM role";
            ResultSet rs = stmt.executeQuery(query);
            List<Role> roleList = new ArrayList<>();
            while (rs.next()) {
                Role role = new Role();
                role.setRoleKode(rs.getString(1));
                role.setRoleNama(rs.getString(2));

                roleList.add(role);
            }
            return roleList;
        } catch (SQLException ex) {
            Logger.getLogger(RoleFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Role> findByKodeStafNIP(String NIP) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT role.ROLE_KODE, role.ROLE_NAME FROM role, user_to_role "
                    + "where role.ROLE_KODE = user_to_role.ROLE_KODE AND user_to_role.STAF_NIP = '" + NIP + "'";
            ResultSet rs = stmt.executeQuery(query);
            List<Role> roleList = new ArrayList<>();
            while (rs.next()) {
                Role role = new Role();
                role.setRoleKode(rs.getString(1));
                role.setRoleNama(rs.getString(2));

                roleList.add(role);
            }
            return roleList;
        } catch (SQLException ex) {
            Logger.getLogger(RoleFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Role findByKodeRole(char kodeRole) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM role WHERE role.ROLE_KODE = '" + kodeRole + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                Role role = new Role();
                role.setRoleKode(rs.getString(1));
                role.setRoleNama(rs.getString(2));

                return role;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
