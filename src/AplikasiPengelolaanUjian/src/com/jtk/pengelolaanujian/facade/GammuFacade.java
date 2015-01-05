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
import sun.security.krb5.internal.LoginOptions;

/**
 *
 * @author pahlevi
 */
public class GammuFacade {

    private final Connection connection = ConnectionHelper.getConnectionGammu();

    public boolean sendRemainderUploadSoalSMS(List<Staf> listStaf, String text) {
        Statement statmentDB = null;
        StringBuilder sb = new StringBuilder();;        
        
        try {
            Staf stafData;
            for (int i = 0; i < listStaf.size(); i++) {
                stafData = new Staf();
                stafData.setStafNIP(listStaf.get(i).getStafNIP());
                stafData.setStafKontak(listStaf.get(i).getStafKontak());                
                sb.append("(");
                sb.append("'");
                sb.append(stafData.getStafKontak());
                sb.append("'");
                sb.append(",'");
                sb.append(text);
                sb.append("',");
                sb.append("'Gammu'");
                sb.append(")");
                if (i < listStaf.size() - 1) {
                    sb.append(",");
                }
            }

            for (Staf staf : listStaf) {
                statmentDB = connection.createStatement();
                statmentDB.execute("INSERT INTO outbox(DestinationNumber, TextDecoded, creatorID) VALUES" + sb.toString());
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

    public void sendPengawasSMS(List<RuanganUjian> listRuanganUjian, Event event) {
        String smsString;
        StringBuilder sb = new StringBuilder();
        RuanganUjian ruanganUjian; 
        Ujian ujian;
        
        for (int i = 0; i < listRuanganUjian.size(); i++) {
            ruanganUjian = new RuanganUjian();
            ujian = new Ujian();
            
            ujian = listRuanganUjian.get(i).getUjian();            
            ruanganUjian.setUjian(ujian);
            
            //System.out.println(ruanganUjian.getUjian().getUjianNama());
            ruanganUjian.setStaf(listRuanganUjian.get(i).getStaf());
            ruanganUjian.setRuanganKode(listRuanganUjian.get(i).getRuanganKode());
                                    
            sb.append("(");
            sb.append("'").append(ruanganUjian.getStaf().getStafKontak()).append("'");
            sb.append(",");
            if (event.getDelayPengawas() == 1) {
                smsString = "[REMINDER] Anda Harus mengawas besok, Ujian " + ruanganUjian.getUjian().getUjianNama() + ""
                        + " di ruang "
                        + "" + ruanganUjian.getRuanganKode() + ""
                        + " pukul: "
                        + "" + ruanganUjian.getUjian().getUjianMulai() + "";
            } else {
                smsString = "[REMINDER] " + event.getDelayPengawas() + "-Hari lagi Anda Harus mengawas , Ujian " + ruanganUjian.getUjian().getUjianNama() + ""
                        + " di ruang "
                        + "" + ruanganUjian.getRuanganKode() + ""
                        + " pukul: "
                        + "" + ruanganUjian.getUjian().getUjianMulai() + "";
            }
            sb.append("'").append(smsString).append("'");
            sb.append(",");
            sb.append("'Gammu'");
            sb.append(")");
            if (i < listRuanganUjian.size() - 1) {
                sb.append(",");
            }
        }

        Statement statmentDB = null;
        try {
            Statement statementDB;
            statmentDB = connection.createStatement();
            statmentDB.execute("INSERT INTO outbox(DestinationNumber, TextDecoded, creatorID) VALUES" + sb.toString());
        } catch (SQLException ex) {
            Logger.getLogger(GammuFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean sendRemainderUploadNilaiSMS(List<Staf> listStaf, String text) {
        Statement statmentDB = null;
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = 0; i < listStaf.size(); i++) {
                Staf staf = listStaf.get(i);
                sb.append("(");
                sb.append("'");
                sb.append(staf.getStafKontak());
                sb.append("'");
                sb.append(",'");
                sb.append(text);
                sb.append("',");
                sb.append("'Gammu'");
                sb.append(")");
                if (i < listStaf.size() - 1) {
                    sb.append(",");
                }
            }

            for (Staf staf : listStaf) {
                statmentDB = connection.createStatement();
                statmentDB.execute("INSERT INTO outbox(DestinationNumber, TextDecoded, creatorID) VALUES" + sb.toString());
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GammuFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void sendKonfiramsiUploadSoal(String textSMS) {        
        Statement statementDB;
        try {
            UserFacade userFacade = new UserFacade();
            StafFacade stafFacade = new StafFacade();
            User user = userFacade.findByUsername(LoginPanel.getUsername());
            Staf staf = new Staf();            
            staf = stafFacade.findByStafNip(user.getStafNIP());            
            
            statementDB = connection.createStatement();
            statementDB.execute("INSERT INTO outbox(DestinationNumber, TextDecoded, creatorID) VALUES('" + staf.getStafKontak() + "','" + textSMS + "','Gammu')");
        } catch (SQLException ex) {
            Logger.getLogger(GammuFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
