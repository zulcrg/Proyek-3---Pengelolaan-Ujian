/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.controller;

import com.jtk.pengelolaanujian.entity.Ujian;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pahlevi reminder pengingat_pengawas untuk ngawas di H-x
 *
 */
public class ReminderDayMonit7Controller extends Reminder {

    private final Date date;

    public ReminderDayMonit7Controller(Date date) {
        this.date = date;
    }

    public void checkRule() throws SQLException {
        List<Ujian> listUjianReminder = new ArrayList<>();
        event = eventFacade.findLast();

        listUjian = ujianFacade.findByKodeEvent(event.getKode());

        for (Ujian ujian : listUjian) {
            if (date.getDate() + event.getDelayPengawas() == ujian.getUjianMulai().getDate()) {
                listUjianReminder.add(ujian);
            }
        }

        if (listUjianReminder != null) {
            listRuanganUjian = ruanganUjianFacade.findAllWhereInsertedIn(listUjianReminder);
            gammuFacade.sendPengawasSMS(listRuanganUjian, event);
        }
    }
}
