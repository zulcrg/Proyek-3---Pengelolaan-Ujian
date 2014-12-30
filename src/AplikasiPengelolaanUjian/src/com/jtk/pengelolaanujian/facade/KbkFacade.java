/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Dosen;
import com.jtk.pengelolaanujian.entity.Kbk;
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
 * @author M Haska Ash Shiddiq
 */
public class KbkFacade {

    private final Connection connection = ConnectionHelper.getConnection();

    public List<Kbk> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM kbk";
            ResultSet rs = stmt.executeQuery(query);
            List<Kbk> kbkList = new ArrayList<>();
            while (rs.next()) {
                Kbk kbk = new Kbk();
                kbk.setKbkKode(rs.getString(1));
                kbk.setKbkNama(rs.getString(2));

                kbkList.add(kbk);
            }
            return kbkList;
        } catch (SQLException ex) {
            Logger.getLogger(KbkFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Kbk findByKbkKode(String kbkKode) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM kbk WHERE KBK_KODE = '" + kbkKode + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                Kbk kbk = new Kbk();
                kbk.setKbkKode(rs.getString(1));
                kbk.setKbkNama(rs.getString(2));

                return kbk;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KbkFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Kbk> findAllWhereListedIn(List<Dosen> dosens) {
        try {
            //for (MataKuliahToDosen mataKuliahToDosen : listMataKuliahToDosen) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");

            for (int i = 0; i < dosens.size(); i++) {
                sb.append("'").append(dosens.get(i).getKbkKode()).append("'");
                if (i < dosens.size() - 1) {
                    sb.append(",");
                }
            }
            
            sb.append(")");
            System.out.println(sb);
            
            Statement stmt = connection.createStatement();
            String query = "SELECT kbk * FROM kbk WHERE kbk_kode IN " + sb.toString() + "";
            ResultSet rs = stmt.executeQuery(query);
            List<Kbk> kbks = new ArrayList<>();
            while (rs.next()) {
                Kbk kbk = new Kbk();
                kbk.setKbkKode(rs.getString(1));
                kbk.setKbkNama(rs.getString(2));                

                kbks.add(kbk);
            }
            return kbks;
            //}

        } catch (SQLException ex) {
            Logger.getLogger(DosenFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
