/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.controller.panitiaController;

import com.jtk.pengelolaanujian.entity.RuanganUjian;
import com.jtk.pengelolaanujian.facade.RuanganUjianFacade;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author pahlevi
 */
public class AssignBeritaAcaraController {
      public List<RuanganUjian> searchUjianWhere(JComboBox cbo) {
        RuanganUjianFacade ruanganUjianFacade = new RuanganUjianFacade();
        List<RuanganUjian> ruanganUjians = ruanganUjianFacade.findRuanganUjianAll();
        String ruanganUjian[] = new String[ruanganUjians.size()];
        for (int i = 0; i < ruanganUjians.size(); i++) {
            RuanganUjian u = ruanganUjians.get(i);
            ruanganUjian[i] = "Ujian "+u.getUjian().getUjianNama()+", Kelas "+u.getKelas().getKelasNama()+", Ruangan "+u.getRuanganKode();
        }
        cbo.setModel(new DefaultComboBoxModel(ruanganUjian));
        return ruanganUjians;        
    }
}
