/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.panitiaController;

import com.jtk.pengelolaanujian.controller.AbstractController;
import com.jtk.pengelolaanujian.entity.BeritaAcara;
import com.jtk.pengelolaanujian.entity.RuanganUjian;
import com.jtk.pengelolaanujian.facade.BeritaAcaraFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pahlevi
 */
public class UpdateBeritaAcaraController extends AbstractController {

    BeritaAcaraFacade beritaAcaraFacade = new BeritaAcaraFacade();

    public void updateBeritaAcara(BeritaAcara beritaAcara) {
        try {
            beritaAcaraFacade.updateBeritaAcara(beritaAcara);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateBeritaAcaraController.class.getName()).log(Level.SEVERE, null, ex);
            addErrorMessage(ex.getMessage(), "Error");
        }
    }
}
