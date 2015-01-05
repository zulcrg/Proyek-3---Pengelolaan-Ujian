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
 * Reminder3Controller reminder3Controller = new Reminder3Controller();
         pemberitahuan untuk pembuat soal, bahwa soal berhasil diunggah dan 
         akan diproses ke tahap selanjutnya.
         notifikasi untuk tim vnv untuk memulai proses vnv
            
         pemberitahuan kepada pembuat soal bahwa soal yang diunggah tidak
         dapat di proses ke tahap selanjutnya karena keterlambatan proses
         pengunggahan        
 * 
 *                      
*/         
        
        
public class Reminder3Controller {
    private Date date;
        
    public Reminder3Controller() {
     
    }
    
    public void preparation(){
        EventFacade eventFacade = new EventFacade();
        Event event = new Event();
        GammuFacade gammuFacade = new GammuFacade();
        
        event = eventFacade.findLast();
        
        this.date = new Date();        
        if(date.after(event.getVnvSelesai())){
            String textSMS = "Soal anda berhasil diupload, Soal TIDAK diproses ke tahap VNV, Karena Keterlambatan";
            gammuFacade.sendKonfiramsiUploadSoal(textSMS);
        }else{                        
            String textSMS = "Soal anda berhasil diupload, Soal akan diproses ke tahap VNV";
            gammuFacade.sendKonfiramsiUploadSoal(textSMS);
        }
    }
    
}
