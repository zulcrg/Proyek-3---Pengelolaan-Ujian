/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.controller;

import com.jtk.pengelolaanujian.entity.Event;
import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.facade.EventFacade;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author pahlevi
 */
public class ReminderDayMonit8Controller extends Reminder {

    private final Date date;
                    
    public ReminderDayMonit8Controller(Date date) {
        this.date = date;
    }

    public void checkRule() throws SQLException {
        event = eventFacade.findLast();

        listUjian = ujianFacade.findByKodeEvent(event.getKode());

        for (Ujian ujian : listUjian) {
            if (date.getDate() + event.getDelayUploadNilai()== event.getUploadNilaiSelesai().getDate()) {
//                listRuanganUjian = ruanganUjianFacade.findAllWhereInsertedIn(ujian);
//                listStaf = stafFacade.find1AllWhereListedIn(listRuanganUjian);
//                
//                gammuFacade.sendPengawasSMS(listStaf, ujian, listRuanganUjian, event);
            } else {
                //nothing
            }
        }

    }
}