/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujianserver.entity;

import com.jtk.pengelolaanujianserver.facade.SoalFacade;
import com.jtk.pengelolaanujianserver.facade.UserFacade;
import java.sql.Blob;
import java.sql.Date;

/**
 *
 * @author Rizki
 */
public class StorageSoal {
    private String soalKode;
    private int stsoalNoUrut;
    private String stafNip;
    private Date stsoalTglUpload;
    private Blob stsoalFile;
    private Soal soal;
    private User user;
    
    public StorageSoal() {
    }

    public StorageSoal(String soalKode, int stsoalNoUrut, String stafNip, Date stsoalTglUpload, Blob stsoalFile) {
        this.soalKode = soalKode;
        this.stsoalNoUrut = stsoalNoUrut;
        this.stafNip = stafNip;
        this.stsoalTglUpload = stsoalTglUpload;
        this.stsoalFile = stsoalFile;
    }


    public String getSoalKode() {
        
        return soalKode;
    }

    public void setSoalKode(String soalKode) {
        this.soalKode = soalKode;
    }

    public int getStsoalNoUrut() {
        return stsoalNoUrut;
    }

    public void setStsoalNoUrut(int stsoalNoUrut) {
        this.stsoalNoUrut = stsoalNoUrut;
    }

    public String getStafNip() {
        return stafNip;
    }

    public void setStafNip(String stafNip) {
        this.stafNip = stafNip;
    }

    public Date getStsoalTglUpload() {
        return stsoalTglUpload;
    }

    public void setStsoalTglUpload(Date stsoalTglUpload) {
        this.stsoalTglUpload = stsoalTglUpload;
    }

    public Blob getStsoalFile() {
        return stsoalFile;
    }

    public void setStsoalFile(Blob stsoalFile) {
        this.stsoalFile = stsoalFile;
    }

    public Soal getSoal() {
        SoalFacade soalControler = new SoalFacade();
        soal = soalControler.findByKodeSoal(soalKode);
        return soal;
    }

    public void setSoal(Soal soal) {
        this.soal = soal;
    }

    public User getUser() {
        UserFacade userFacade = new UserFacade();
        user = userFacade.findByKodeStafNip(stafNip);
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   
    
    
}
