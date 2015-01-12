/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.controller.reminder;

import com.jtk.pengelolaanujian.entity.Event;
import com.jtk.pengelolaanujian.facade.EventFacade;
import com.jtk.pengelolaanujian.facade.GammuFacade;
import java.util.Date;

/**
 *
 * @author pahlevi
 * 
 * Reminder 5
 *    real time monitoring -> Trigger DB
 *   
 *    pemberitahuan kepada :
 *    -pembuat soal bahwa soal lulus vnv
 *    -tim vnv bahwa laporan vnv dan soal sudah terunggah tepat waktu
 *    dan akan diproses ke tahap selanjutnya
 *    -tu, bahwa soal dan laporan vnv sudah tersedia dan menginstruksikan
 *    untuk segera melakukan proses pencetakan soal
 * 
 */

public class Reminder5Controller {
    private Date date;
    
    public Reminder5Controller(Date date) {
        this.date = date;
    }

    public Reminder5Controller() {

    }
    
    public void preparation(){
        EventFacade eventFacade = new EventFacade();
        Event event = new Event();
        GammuFacade gammuFacade = new GammuFacade();
        
        event = eventFacade.findLast();
        
        this.date = new Date();        
        if(date.after(event.getVnvSelesai())){
            String textSMS = "Laporan Vnv berhasil diupload, Soal akan segera di print";
            gammuFacade.sendKonfiramsiUploadVnvTrue(textSMS);
        }else{                        
            String textSMS = "Laporan Vnv berhasil diupload, karena keterlambatan silakan segera print sendiri soal anda";
            gammuFacade.sendKonfiramsiUploadVnv(textSMS);
        }
    }
}
