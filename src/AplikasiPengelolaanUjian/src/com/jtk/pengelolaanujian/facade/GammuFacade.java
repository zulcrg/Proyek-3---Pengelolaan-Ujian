/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.util.ConnectionHelper;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pahlevi
 */
public class GammuFacade {
    private final Connection connection = ConnectionHelper.getConnectionGammu();
    
    public boolean SendSMS(String reciever, String text) {
        Statement statmentDB = null;
        try {                                     
            statmentDB = connection.createStatement();
            statmentDB.execute("INSERT INTO outbox(DestinationNumber, TextDecoded, creatorID) VALUES('"+reciever+"','"+text+"','Gammu')");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GammuFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
