/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.dosenPengampu;

import com.jtk.pengelolaanujian.controller.AbstractController;
import com.jtk.pengelolaanujian.entity.Nilai;
import com.jtk.pengelolaanujian.entity.Ruangan;
import com.jtk.pengelolaanujian.entity.RuanganUjian;
import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.facade.NilaiFacade;
import com.jtk.pengelolaanujian.facade.RuanganFacade;
import com.jtk.pengelolaanujian.facade.RuanganUjianFacade;
import com.jtk.pengelolaanujian.facade.UjianFacade;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author pahlevi
 */
public class UploadNilaiController extends AbstractController {

    public List<Ujian> searchUjian(JComboBox cbo) {
        UjianFacade ujianFacade = new UjianFacade();
        List<Ujian> ujians = ujianFacade.findByUsername();
        String ujian[] = new String[ujians.size()];
        for (int i = 0; i < ujians.size(); i++) {
            Ujian u = ujians.get(i);
            ujian[i] = u.getUjianKode();
        }
        cbo.setModel(new DefaultComboBoxModel(ujian));
        return ujians;
    }

    public List<Ruangan> searchRuangan(JComboBox cbo, String ujianKode) {
        RuanganFacade ruanganFacade = new RuanganFacade();
        List<Ruangan> ruangans = ruanganFacade.findAll();//findByKodeUjian(ujianKode);
        String ruangan[] = new String[ruangans.size()];
        for (int i = 0; i < ruangans.size(); i++) {
            Ruangan u = ruangans.get(i);
            ruangan[i] = u.getRuanganKode();
        }
        cbo.setModel(new DefaultComboBoxModel(ruangan));
        return ruangans;
    }

    public List<RuanganUjian> searchUjianByUsername(JComboBox cbo) {
        RuanganUjianFacade ruanganUjianFacade = new RuanganUjianFacade();
        List<RuanganUjian> ruanganUjians = ruanganUjianFacade.findRuanganUjianByUsername();
        String ruanganUjian[] = new String[ruanganUjians.size()];
        for (int i = 0; i < ruanganUjians.size(); i++) {
            RuanganUjian u = ruanganUjians.get(i);
            ruanganUjian[i] = "Ujian " + u.getUjian().getUjianNama() + ", Kelas " + u.getKelas().getKelasNama() + ", Ruangan " + u.getRuanganKode();
        }
        cbo.setModel(new DefaultComboBoxModel(ruanganUjian));
        return ruanganUjians;
    }

    public boolean uploadNilai(Nilai nilai) {
        try {
            RuanganUjianFacade ruanganUjianFacade = new RuanganUjianFacade();
            NilaiFacade nilaiFacade = new NilaiFacade();
            RuanganUjian ruanganUjian = ruanganUjianFacade.findByUjianKodeKelasKode(nilai.getUjianKode(), nilai.getKelasKode());
            ruanganUjian.setRuanganUjianUploadNilaiStatus(true);

            ConnectionHelper.getConnection().setAutoCommit(false);
            ruanganUjianFacade.updateUploadedNilai(ruanganUjian);
            nilaiFacade.uploadNilai(nilai);
            
            ConnectionHelper.getConnection().commit();
            ConnectionHelper.getConnection().setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UploadNilaiController.class.getName()).log(Level.SEVERE, null, ex);
            addErrorMessage(ex.getMessage(), "Error");
            try {
                ConnectionHelper.getConnection().rollback();
                ConnectionHelper.getConnection().setAutoCommit(true);
            } catch (SQLException ex1) {
                Logger.getLogger(UploadNilaiController.class.getName()).log(Level.SEVERE, null, ex1);
                addErrorMessage(ex1.getMessage(), "Error");
            }
        }
        return false;
    }

}
