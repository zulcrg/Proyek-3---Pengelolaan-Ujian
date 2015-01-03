/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.controller.panitiaController;

import com.jtk.pengelolaanujian.entity.BeritaAcara;
import com.jtk.pengelolaanujian.entity.RuanganUjian;
import com.jtk.pengelolaanujian.facade.BeritaAcaraFacade;

/**
 *
 * @author pahlevi
 */
public class UpdateBeritaAcaraController {
    BeritaAcaraFacade beritaAcaraFacade = new BeritaAcaraFacade();    
        
    public void updateBeritaAcara(BeritaAcara beritaAcara) {
        beritaAcaraFacade.updateBeritaAcara(beritaAcara);
    }
}
