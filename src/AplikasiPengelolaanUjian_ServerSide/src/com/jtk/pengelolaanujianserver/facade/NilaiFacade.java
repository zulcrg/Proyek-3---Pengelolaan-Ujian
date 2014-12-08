/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujianserver.facade;

import com.jtk.pengelolaanujianserver.entity.Nilai;
import com.jtk.pengelolaanujianserver.util.ConnectionHelper;
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
 * @author Rizki
 */
public class NilaiFacade {
     private Connection connection = ConnectionHelper.getConnection();
     
     public List<Nilai> findAll(){
         try {
             Statement stmt = connection.createStatement();
             String query = "SELECT * FROM nilai";
             ResultSet rs = stmt.executeQuery(query);
             List<Nilai> nilaiList = new ArrayList<>();
             while(rs.next()){
                 Nilai nilai = new Nilai();
                 nilai.setRuanganKode(rs.getString(1));
                 nilai.setUjianKode(rs.getString(2));
                 nilai.setNilaiFile(rs.getBlob(3));
                 
                 nilaiList.add(nilai);
             }
             return nilaiList;
         } catch (SQLException ex) {
             Logger.getLogger(NilaiFacade.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
     }
}
