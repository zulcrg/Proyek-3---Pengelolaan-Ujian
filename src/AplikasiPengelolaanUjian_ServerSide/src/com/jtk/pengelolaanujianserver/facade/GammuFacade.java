/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujianserver.facade;

import com.jtk.pengelolaanujianserver.entity.Staf;
import com.jtk.pengelolaanujianserver.util.ConnectionHelper;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pahlevi
 */
public class GammuFacade {
    private final Connection connection = ConnectionHelper.getConnectionGammu();
    
    public boolean sendSMS(List<Staf> listStaf, String text) {
        Statement statmentDB = null;
        try {                             
            for(Staf staf : listStaf){
                statmentDB = connection.createStatement();
                statmentDB.execute("INSERT INTO outbox(DestinationNumber, TextDecoded, creatorID) VALUES('"+staf.getStafKontak()+"','"+text+"','Gammu')");                
            }            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GammuFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    }
}
