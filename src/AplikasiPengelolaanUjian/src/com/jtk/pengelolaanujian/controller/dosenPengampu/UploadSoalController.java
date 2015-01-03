/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.dosenPengampu;

import com.jtk.pengelolaanujian.entity.MataKuliah;
import com.jtk.pengelolaanujian.facade.MataKuliahFacade;
import com.jtk.pengelolaanujian.view.LoginPanel;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author pahlevi
 */
public class UploadSoalController {

    public List<MataKuliah> searchMatkul(JComboBox cbo) {
        MataKuliahFacade mataKuliahFacade = new MataKuliahFacade();
        List<MataKuliah> mataKuliahs = mataKuliahFacade.findAllWhereSesionIdis(LoginPanel.getUsername());//findByUsername(LoginPanel.getUsername());
        String matkul[] = new String[mataKuliahs.size()];
        for (int i = 0; i < mataKuliahs.size(); i++) {
            MataKuliah mk = mataKuliahs.get(i);
            matkul[i] = mk.getMatkulNama();
        }
        cbo.setModel(new DefaultComboBoxModel(matkul));
        return mataKuliahs;
    }
    
    
}
