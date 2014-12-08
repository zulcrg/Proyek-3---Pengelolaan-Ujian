/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.proces;

import com.jtk.pengelolaanujianserver.controller.*;
import java.util.Date;
import java.util.TimerTask;

/**
 *
 * @author pahlevi
 */
public class ValidityActionControlProcess extends TimerTask {

    public void run() {
        Date date = new Date();
        System.out.println("Cek aturan main - action control setiap 10 detik 1x");

        Remainder1Controller remainder1Controller = new Remainder1Controller(date);
        Remainder2DayMonitController remainder2Controller = new Remainder2DayMonitController(date);
        Remainder3Controller remainder3Controller = new Remainder3Controller(date);
        Remainder4Controller remainder4Controller = new Remainder4Controller(date);
        Remainder5Controller remainder5Controller = new Remainder5Controller(date);
        Remainder6Controller remainder6Controller = new Remainder6Controller(date);
        Remainder7DayMonitController remainder7Controller = new Remainder7DayMonitController(date);
        Remainder8DayMonitController remainder8Controller = new Remainder8DayMonitController(date);

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
