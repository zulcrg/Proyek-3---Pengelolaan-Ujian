/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.dosenPengampu;

import com.jtk.pengelolaanujian.entity.Ruangan;
import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.facade.RuanganFacade;
import com.jtk.pengelolaanujian.facade.UjianFacade;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author pahlevi
 */
public class UploadNilaiController {

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
        List<Ruangan> ruangans = ruanganFacade.findByKodeUjian(ujianKode);
        String ruangan[] = new String[ruangans.size()];
        for (int i = 0; i < ruangans.size(); i++) {
            Ruangan u = ruangans.get(i);
            ruangan[i] = u.getRuanganKode();
        }
        cbo.setModel(new DefaultComboBoxModel(ruangan));
        return ruangans;
    }

}
