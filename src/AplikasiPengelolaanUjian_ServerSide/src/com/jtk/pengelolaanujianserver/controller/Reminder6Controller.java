/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujianserver.controller;


import com.jtk.pengelolaanujian.entity.Dosen;
import com.jtk.pengelolaanujian.entity.MataKuliah;
import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.facade.GammuFacade;
import java.util.Date;

/**
 *
 * @author pahlevi
 */
public class Reminder6Controller {
    private Date date;
    private GammuFacade gammuFacade = new GammuFacade();
    private Soal soal = new Soal();
    private MataKuliah mataKuliah = new MataKuliah();
    private Dosen dosen = new Dosen();
    
            
    public Reminder6Controller(Date date) {
        this.date = date;
    }
    
    public void checkRule(){
       // gammuFacade.sendSMS(null, null);
    }
}
