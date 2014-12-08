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
public class ValidityActionControlProcess  extends TimerTask  {
     
    public void run() {
        Date date = new Date();
        System.out.println("Cek aturan main - action control setiap 10 detik 1x");
        
        Remainder1Controller remainder1Controller = new Remainder1Controller(date);        
        Remainder2Controller remainder2Controller = new Remainder2Controller(date);        
        Remainder3Controller remainder3Controller = new Remainder3Controller(date);        
        Remainder4Controller remainder4Controller = new Remainder4Controller(date);        
        Remainder5Controller remainder5Controller = new Remainder5Controller(date);        
        Remainder6Controller remainder6Controller = new Remainder6Controller(date);
        
    }
    /* TODO:  
    Reminder 1
	mesin kirim email dengan informasi :
	-jadwal setiap proses upload soal, vnv, ujian.
	-role setiap orang /akun
	-tanggal2 penting lainnya

    Reminder 2 
	peringatan H-xx untuk mengunggah soal bagi pembuat soal

    Reminder 3 
	- pemberitahuan untuk pembuat soal, bahwa soal berhasil diunggah dan 
	  akan diproses ke tahap selanjutnya.
	- notifikasi untuk tim vnv untuk memulai proses vnv

    Reminder 4 		
	pemberitahuan kepada pembuat soal bahwa soal yang diunggah tidak
	dapat di proses ke tahap selanjutnya karena keterlambatan proses
	pengunggahan

    Reminder 5
	pemberitahuan kepada :
	-pembuat soal bahwa soal lulus vnv
	-tim vnv bahwa laporan vnv dan soal sudah terunggah tepat waktu
	 dan akan diproses ke tahap selanjutnya
	-tu, bahwa soal dan laporan vnv sudah tersedia dan menginstruksikan
	 untuk segera melakukan proses pencetakan soal

    Reminder 6 
	soal sudah tercetak.        
    */
    
}
