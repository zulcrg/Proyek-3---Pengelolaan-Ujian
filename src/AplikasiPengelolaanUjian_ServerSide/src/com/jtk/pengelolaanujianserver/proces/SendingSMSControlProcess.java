/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujianserver.proces;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 *
 * @author pahlevi
 */
public class SendingSMSControlProcess extends TimerTask{

    public void run() {
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Cek aturan main - action control setiap 10 detik 1x "+formatDate.format(date));

        //Reminder1Controller remainder1Controller = new Reminder1Controller(date);
        //ReminderDayMonit2Controller remainder2Controller = new ReminderDayMonit2Controller(date);
        //Reminder3Controller remainder3Controller = new Reminder3Controller(date);
        //Reminder4Controller remainder4Controller = new Reminder4Controller(date);
        //Reminder5Controller remainder5Controller = new Reminder5Controller(date);
        //Reminder6Controller remainder6Controller = new Reminder6Controller(date);
        //ReminderDayMonit7Controller remainder7Controller = new ReminderDayMonit7Controller(date);
        //ReminderDayMonit8Controller remainder8Controller = new ReminderDayMonit8Controller(date);

    }
    /* TODO:  
     Reminder 1
     real time monitoring -> Trigger DB
    
     mesin kirim email dengan informasi :
     -jadwal setiap proses upload soal, vnv, ujian.
     -role setiap orang /akun
     -tanggal2 penting lainnya

     Reminder 2 
     Day Monitoring
    
     peringatan H-xx untuk mengunggah soal bagi pembuat soal dalam hal ini dosen pengampu

     Reminder 3 
     real time monitoring -> Trigger DB
    
    
     - pemberitahuan untuk pembuat soal, bahwa soal berhasil diunggah dan 
     akan diproses ke tahap selanjutnya.
     - notifikasi untuk tim vnv untuk memulai proses vnv

     Reminder 4 		
     real time monitoring -> Trigger DB
    
     pemberitahuan kepada pembuat soal bahwa soal yang diunggah tidak
     dapat di proses ke tahap selanjutnya karena keterlambatan proses
     pengunggahan

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
    
     Remainder 7
     Day Monitoring
    
     H-xx pengawas ujian diingatkan mengenai jadwal mengawsnya
    
     Remainder 8
     Day Monitoring
    
     H-xx dosen pengampu diingatkan mengenai jadwal mengupload nilai
    
     Reminder 9
     real time monitoring -> Trigger DB
    
     pemberitahuan dosen pengampu Nilai telah diupload tepat waktu.        
    
     Reminder 9
     real time monitoring -> Trigger DB
    
     pemberitahuan dosen pengampu Nilai terlambat diupload.        
    
     */
    
}
