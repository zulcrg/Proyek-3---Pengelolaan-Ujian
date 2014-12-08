/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.facade;

import com.jtk.pengelolaanujianserver.entity.MataKuliah;
import com.jtk.pengelolaanujianserver.entity.MataKuliahToDosen;
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
 * @author pahlevi
 */
public class MataKuliahToDosenFacade {

    private final Connection connection = ConnectionHelper.getConnection();

    public List<MataKuliahToDosen> findAllWhereListedIn(List<MataKuliah> listMataKuliah) {
        try {
            for (MataKuliah mataKuliah : listMataKuliah) {
                Statement stmt = connection.createStatement();
                String query = "SELECT * FROM mata_kuliah_to_dosen, staf WHERE MATKUL_KODE = " + mataKuliah.getMatkulKode() + "";
                ResultSet rs = stmt.executeQuery(query);
                List<MataKuliahToDosen> mataKuliahTodosenList = new ArrayList<>();
                while (rs.next()) {
                    MataKuliahToDosen mataKuliahToDosen = new MataKuliahToDosen();
                    mataKuliahToDosen.setDosenKode(rs.getString(1));
                    mataKuliahToDosen.setMatkulKode(rs.getString(2));                    
                    mataKuliahTodosenList.add(mataKuliahToDosen);
                }
                return mataKuliahTodosenList;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DosenFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
