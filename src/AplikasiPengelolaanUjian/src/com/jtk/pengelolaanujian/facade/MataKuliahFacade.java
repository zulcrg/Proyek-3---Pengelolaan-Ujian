/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.MataKuliah;
import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.entity.Staf;
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
 * @author Zulkhair Abdullah D
 */
public class MataKuliahFacade {

    private final Connection connection = ConnectionHelper.getConnection();

    public List<MataKuliah> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM mata_kuliah";
            ResultSet rs = stmt.executeQuery(query);
            List<MataKuliah> mataKuliahList = new ArrayList<>();
            while (rs.next()) {
                MataKuliah mataKuliah = new MataKuliah();
                mataKuliah.setMatkulKode(rs.getString(1));
                mataKuliah.setMatkulNama(rs.getString(2));
                mataKuliah.setMatkulTipe(rs.getString(3));

                mataKuliahList.add(mataKuliah);
            }
            return mataKuliahList;
        } catch (SQLException ex) {
            Logger.getLogger(EventFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public MataKuliah findByKodeMatkul(String kodeMatkul) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM mata_kuliah WHERE MATKUL_KODE = '" + kodeMatkul + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                MataKuliah mataKuliah = new MataKuliah();
                mataKuliah.setMatkulKode(rs.getString(1));
                mataKuliah.setMatkulNama(rs.getString(2));
                mataKuliah.setMatkulTipe(rs.getString(3));

                return mataKuliah;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<MataKuliah> findByLikeKodeMatkul(String text) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM mata_kuliah WHERE MATKUL_KODE LIKE '%" + text + "%' OR MATKUL_NAMA LIKE '%" + text + "%'";
            ResultSet rs = stmt.executeQuery(query);
            List<MataKuliah> mataKuliahs = new ArrayList<>();
            while (rs.next()) {
                MataKuliah mataKuliah = new MataKuliah();
                mataKuliah.setMatkulKode(rs.getString(1));
                mataKuliah.setMatkulNama(rs.getString(2));
                mataKuliah.setMatkulTipe(rs.getString(3));

                mataKuliahs.add(mataKuliah);
            }
            return mataKuliahs;
        } catch (SQLException ex) {
            Logger.getLogger(EventFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<MataKuliah> findByUsername(String username) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT mata_kuliah.* FROM mata_kuliah "
                    + "INNER JOIN mata_kuliah_to_dosen ON (mata_kuliah.MATKUL_KODE = mata_kuliah_to_dosen.MATKUL_KODE) "
                    + "INNER JOIN dosen ON (mata_kuliah_to_dosen.DOSEN_KODE = dosen.DOSEN_KODE) "
                    + "INNER JOIN staf ON (dosen.STAF_NIP = staf.STAF_NIP) "
                    + "INNER JOIN user ON (user.STAF_NIP = staf.STAF_NIP) "
                    + "WHERE user.USER_USERNAME = '" + username + "'";
            ResultSet rs = stmt.executeQuery(query);
            List<MataKuliah> mataKuliahList = new ArrayList<>();
            while (rs.next()) {
                MataKuliah mataKuliah = new MataKuliah();
                mataKuliah.setMatkulKode(rs.getString(1));
                mataKuliah.setMatkulNama(rs.getString(2));
                mataKuliah.setMatkulTipe(rs.getString(3));

                mataKuliahList.add(mataKuliah);
            }
            return mataKuliahList;
        } catch (SQLException ex) {
            Logger.getLogger(EventFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<MataKuliah> findAllWhereListedIn(List<Soal> listSoal) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("(");

            for (int i = 0; i < listSoal.size(); i++) {
                sb.append("'").append(listSoal.get(i).getMatkulKode()).append("'");
                if (i < listSoal.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
            
            System.out.println(sb);
            
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM mata_kuliah where mata_kuliah.MATKUL_KODE IN " + sb.toString() + "";
            ResultSet rs = stmt.executeQuery(query);
            List<MataKuliah> mataKuliahList = new ArrayList<>();
            while (rs.next()) {
                MataKuliah mataKuliah = new MataKuliah();
                mataKuliah.setMatkulKode(rs.getString(1));
                mataKuliah.setMatkulNama(rs.getString(2));
                mataKuliah.setMatkulTipe(rs.getString(3));

                mataKuliahList.add(mataKuliah);
            }
            return mataKuliahList;
        } catch (SQLException ex) {
            Logger.getLogger(EventFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<MataKuliah> findAllWhereSesionIdis(String username) {
        try {
            Statement stmt = connection.createStatement();            
            String query = "SELECT * FROM mata_kuliah, soal, dosen, mata_kuliah_to_dosen, staf, user WHERE mata_kuliah.matkul_kode = soal.matkul_kode AND mata_kuliah.matkul_tipe = soal.matkul_tipe AND mata_kuliah.matkul_kode = mata_kuliah_to_dosen.matkul_kode AND mata_kuliah.matkul_tipe = mata_kuliah_to_dosen.matkul_tipe AND mata_kuliah_to_dosen.dosen_kode = dosen.dosen_kode AND dosen.staf_nip = staf.staf_nip AND staf.staf_nip = user.staf_nip AND user.user_username ='"+username+"'";
            ResultSet rs = stmt.executeQuery(query);
            List<MataKuliah> mataKuliahList = new ArrayList<>();
            while (rs.next()) {
                MataKuliah mataKuliah = new MataKuliah();                
                
                mataKuliah.setMatkulKode(rs.getString(1));
                mataKuliah.setMatkulNama(rs.getString(2)+" - "+rs.getString(3));
                mataKuliah.setMatkulTipe(rs.getString(3));
                                
                mataKuliahList.add(mataKuliah);
            }
            return mataKuliahList;
        } catch (SQLException ex) {
            Logger.getLogger(MataKuliahFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
