/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.entity;

import com.jtk.pengelolaanujian.facade.SoalFacade;
import com.jtk.pengelolaanujian.facade.UserFacade;
import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author Rizki
 */
public class StorageSoal {
    private String soalKode;
    private int stsoalNoUrut;
    private String stafNip;
    private Date stsoalTglUpload;
    private InputStream stsoalFile;
    private Soal soal;
    private User user;
    private String namaFile;
    private String tipeFile;
    
    public StorageSoal() {
    }

    public StorageSoal(String soalKode, int stsoalNoUrut, String stafNip, Date stsoalTglUpload, InputStream stsoalFile) {
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

    public InputStream getStsoalFile() {
        return stsoalFile;
    }

    public void setStsoalFile(InputStream stsoalFile) {
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

    public String getNamaFile() {
        return namaFile;
    }

    public void setNamaFile(String namaFile) {
        this.namaFile = namaFile;
    }

    public String getTipeFile() {
        return tipeFile;
    }

    public void setTipeFile(String tipeFile) {
        this.tipeFile = tipeFile;
    }    
}
