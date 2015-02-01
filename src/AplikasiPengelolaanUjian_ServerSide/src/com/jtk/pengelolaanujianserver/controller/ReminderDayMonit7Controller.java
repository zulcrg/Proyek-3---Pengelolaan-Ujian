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

    private Date date;

    public ReminderDayMonit7Controller() {
        this.date = new Date();
    }
    
    public void preparation(){
        this.checkRule();
    }

    public void checkRule(){
        boolean stat = false;
        List<Ujian> listUjianReminder = new ArrayList<>();
        event = eventFacade.findLast();
        listUjian = new ArrayList<>();
        
        listUjian = ujianFacade.findByKodeEvent(event.getKode());

        for (Ujian ujian : listUjian) {
            if (date.getDate() + event.getDelayPengawas()== ujian.getUjianMulai().getDate()) {
                listUjianReminder.add(ujian);
                stat = true;
            } else {
                
            }
        }
        if(stat==true){            
            listRuanganUjian = ruanganUjianFacade.findAllWhereInsertedIn(listUjianReminder);
            //System.out.println(listRuanganUjian.get(0).getUjianKode());
            //System.out.println(listRuanganUjian.get(1).getUjianKode());
            //System.out.println(listRuanganUjian.get(0).getUjian().getUjianNama());
            gammuFacade.sendPengawasSMS(listRuanganUjian, event);        
        }            
    }
}
