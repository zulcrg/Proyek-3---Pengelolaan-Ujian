/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.controller;

import com.jtk.pengelolaanujianserver.entity.Dosen;
import com.jtk.pengelolaanujianserver.entity.Event;
import com.jtk.pengelolaanujianserver.entity.RuanganUjian;
import com.jtk.pengelolaanujianserver.entity.Staf;
import com.jtk.pengelolaanujianserver.entity.Ujian;
import com.jtk.pengelolaanujianserver.facade.EventFacade;
import com.jtk.pengelolaanujianserver.facade.GammuFacade;
import com.jtk.pengelolaanujianserver.facade.RuanganUjianFacade;
import com.jtk.pengelolaanujianserver.facade.StafFacade;
import com.jtk.pengelolaanujianserver.facade.UjianFacade;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pahlevi
 */
public class Remainder7DayMonitController {

    private final Date date;

    private List<Ujian> listUjian;
    private List<RuanganUjian> listRuanganUjian;
    private List<Staf> listStaf;

    private Event event;

    private final EventFacade eventFacade = new EventFacade();
    private final GammuFacade gammuFacade = new GammuFacade();
    private final UjianFacade ujianFacade = new UjianFacade();
    private final RuanganUjianFacade ruanganUjianFacade = new RuanganUjianFacade();
    private final StafFacade stafFacade = new StafFacade();
    private List<RuanganUjian> listRuangUjian;

    public Remainder7DayMonitController(Date date) {
        this.date = date;
    }

    public void checkRule() throws SQLException {
        event = eventFacade.findLast();

        listUjian = ujianFacade.findByKodeEvent(event.getKode());        

        for (Ujian ujian : listUjian) {
            if (date.getDate()+event.getDelayPengawas()!=ujian.getUjianMulai().getDate()) {
                listRuanganUjian = ruanganUjianFacade.findAllWhereInsertedIn(ujian);
                listStaf = stafFacade.find1AllWhereListedIn(listRuangUjian);
                gammuFacade.sendPengawasSMS(listStaf,ujian,listRuangUjian,event);
            } else {            
                //nothing
            }
        }

    }
}
