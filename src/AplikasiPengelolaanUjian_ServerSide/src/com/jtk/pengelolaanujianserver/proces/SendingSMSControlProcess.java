/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.proces;

import com.jtk.pengelolaanujian.controller.reminder.Reminder3Controller;
import com.jtk.pengelolaanujianserver.controller.ReminderDayMonit2Controller;
import com.jtk.pengelolaanujianserver.controller.ReminderDayMonit7Controller;
import com.jtk.pengelolaanujianserver.controller.ReminderDayMonit8Controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 *
 * @author pahlevi
 */
public class SendingSMSControlProcess extends TimerTask {

    ReminderDayMonit2Controller reminderDayMonit2Controller = new ReminderDayMonit2Controller();
    ReminderDayMonit7Controller reminderDayMonit7Controller = new ReminderDayMonit7Controller();
    ReminderDayMonit8Controller reminderDayMonit8Controller = new ReminderDayMonit8Controller();    
    
    public void run() {
        //SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Cek aturan main - action control setiap 10 detik 1x ");

        //Reminder1Controller remainder1Controller = new Reminder1Controller(date);                
        //Reminder4Controller remainder4Controller = new Reminder4Controller(date);
        //Reminder5Controller remainder5Controller = new Reminder5Controller(date);
        //Reminder6Controller remainder6Controller = new Reminder6Controller(date);
        /* 
         Reminder 2 
         Day Monitoring    
         peringatan H-xx untuk mengunggah soal bagi pembuat soal dalam hal ini dosen pengampu
         */
        reminderDayMonit2Controller.preparation();

        /*
         Remainder 7
         Day Monitoring    
         H-xx pengawas ujian diingatkan mengenai jadwal mengawsnya
         */
        reminderDayMonit7Controller.preparation();

        /*
         Remainder 8
         Day Monitoring    
         H - xx dosen pengampu diingatkan mengenai jadwal mengupload nilai reminderDayMonit8Controller
         */
        reminderDayMonit8Controller.preparation();                
          
    }
    /* TODO:  
     Reminder 1
     real time monitoring -> Trigger DB
    
     mesin kirim email dengan informasi :
     -jadwal setiap proses upload soal, vnv, ujian.
     -role setiap orang /akun
     -tanggal2 penting lainnya
           
     Reminder 5
     real time monitoring -> Trigger DB
    
     pemberitahuan kepada :
     -pembuat soal bahwa soal lulus vnv
     -tim vnv bahwa laporan vnv dan soal sudah terunggah tepat waktu
     dan akan diproses ke tahap selanjutnya
     -tu, bahwa soal dan laporan vnv sudah tersedia dan menginstruksikan
     untuk segera melakukan proses pencetakan soal

     Reminder 6 
     real time monitoring -> Trigger DB    
     soal sudah tercetak.        
    
     Reminder 9
     real time monitoring -> Trigger DB   
     pemberitahuan dosen pengampu Nilai telah diupload tepat waktu.        
         
     real time monitoring -> Trigger DB    
     pemberitahuan dosen pengampu Nilai terlambat diupload.        
    
     */

}
