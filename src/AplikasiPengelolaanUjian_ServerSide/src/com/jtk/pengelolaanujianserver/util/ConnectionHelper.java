/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class ConnectionHelper {

    private static Connection connection;
    private static Connection connectionGammu;

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pengelolaan_ujian", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void createConnectionGammu(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gammu", "root", "root");            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionHelper.class.getName()).log(Level.SEVERE, null, ex);                       
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }
    
    public static Connection getConnectionGammu(){
        if (connectionGammu == null) {
            createConnection();
        }
        return connectionGammu;
        
    }

}
