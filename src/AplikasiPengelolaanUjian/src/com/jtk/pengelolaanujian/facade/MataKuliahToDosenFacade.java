/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.MataKuliah;
import com.jtk.pengelolaanujian.entity.MataKuliahToDosen;
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
public class MataKuliahToDosenFacade {

    private final Connection connection = ConnectionHelper.getConnection();

    public List<MataKuliahToDosen> findAllWhereListedIn(List<MataKuliah> listMataKuliah) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("(");

            for (int i = 0; i < listMataKuliah.size(); i++) {
                sb.append("'").append(listMataKuliah.get(i).getMatkulKode()).append("'");
                if (i < listMataKuliah.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
            
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM mata_kuliah_to_dosen, staf WHERE MATKUL_KODE IN " + sb.toString() + "";
            ResultSet rs = stmt.executeQuery(query);
            List<MataKuliahToDosen> mataKuliahTodosenList = new ArrayList<>();
            while (rs.next()) {
                MataKuliahToDosen mataKuliahToDosen = new MataKuliahToDosen();
                mataKuliahToDosen.setDosenKode(rs.getString(1));
                mataKuliahToDosen.setMatkulKode(rs.getString(2));
                
                mataKuliahTodosenList.add(mataKuliahToDosen);
            }
            return mataKuliahTodosenList;

        } catch (SQLException ex) {
            Logger.getLogger(DosenFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
