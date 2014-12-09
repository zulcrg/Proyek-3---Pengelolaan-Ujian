/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Event;
import com.jtk.pengelolaanujian.entity.RuanganUjian;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.entity.Ujian;
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
public class GammuFacade {

    private final Connection connection = ConnectionHelper.getConnectionGammu();

    public boolean sendRemainderUploadSoalSMS(List<Staf> listStaf, String text) {
        Statement statmentDB = null;
        try {
            for (Staf staf : listStaf) {
                statmentDB = connection.createStatement();
                statmentDB.execute("INSERT INTO outbox(DestinationNumber, TextDecoded, creatorID) VALUES('" + staf.getStafKontak() + "','" + text + "','Gammu')");
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GammuFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean sendPengawasSMS(List<Staf> listStaf, String text) {
        Statement statmentDB = null;
        try {
            for (Staf staf : listStaf) {
                statmentDB = connection.createStatement();
                statmentDB.execute("INSERT INTO outbox(DestinationNumber, TextDecoded, creatorID) VALUES('" + staf.getStafKontak() + "','" + text + "','Gammu')");
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GammuFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void sendPengawasSMS(List<Staf> listStaf, Ujian ujian, List<RuanganUjian> listRuangUjian, Event event) throws SQLException {
        String smsString;
        
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        
        sb.append("(");
        sb1.append("(");
        
        for (int i = 0; i < listStaf.size(); i++) {
            sb.append("'").append(listStaf.get(i).getStafNIP()).append("'");
            sb1.append("'").append(listStaf.get(i).getStafKontak()).append("'");
            if (i < listStaf.size() - 1) {
                sb.append(",");
                sb1.append(",");
            }
        }
        
        sb.append(")");
        sb1.append(")");
        
        String kodeRuangan = null;
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM RUANGAN_UJIAN where RUANGAN_UJIAN.STAF_NIP  = " + sb.toString() + "";
            ResultSet rs = stmt.executeQuery(query);
            kodeRuangan = rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(GammuFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (event.getDelayPengawas() == 1) {
            smsString = "[REMINDER] Anda Harus mengawas besok, Ujian " + ujian.getUjianNama() + ""
                    + " di ruang "
                    + "" + kodeRuangan + ""
                    + " pukul: "
                    + "" + ujian.getUjianMulai() + "";
        } else {
            smsString = "[REMINDER] " + event.getDelayPengawas() + "-Hari lagi Anda Harus mengawas , Ujian " + ujian.getUjianNama() + ""
                    + " di ruang "
                    + "" + kodeRuangan + ""
                    + " pukul: "
                    + "" + ujian.getUjianMulai() + "";
        }

        Statement statmentDB = null;
        try {
            Statement statementDB;
            statmentDB = connection.createStatement();
            statmentDB.execute("INSERT INTO outbox(DestinationNumber, TextDecoded, creatorID) VALUES(" + sb1.toString() + ",'" + smsString + "','Gammu')");
        } catch (SQLException ex) {
            Logger.getLogger(GammuFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
