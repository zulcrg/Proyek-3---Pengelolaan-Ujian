/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.entity;

import java.util.Date;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class Vnv {
    private String vnvKode;
    private String soalKode;
    private String stafNip;
    private Date vnvTgl;
    private boolean vnvStatus;
    private String vnvRelevansi;
    private String vnvKesulitan;
    private String vnvKelayakanBobot;
    private String vnvKelayakanWaktu;
    private String vnvLain;

    public String getVnvKode() {
        return vnvKode;
    }

    public void setVnvKode(String vnvKode) {
        this.vnvKode = vnvKode;
    }

    public String getSoalKode() {
        return soalKode;
    }

    public void setSoalKode(String soalKode) {
        this.soalKode = soalKode;
    }

    public String getStafNip() {
        return stafNip;
    }

    public void setStafNip(String stafNip) {
        this.stafNip = stafNip;
    }

    public Date getVnvTgl() {
        return vnvTgl;
    }

    public void setVnvTgl(Date vnvTgl) {
        this.vnvTgl = vnvTgl;
    }

    public boolean isVnvStatus() {
        return vnvStatus;
    }

    public void setVnvStatus(boolean vnvStatus) {
        this.vnvStatus = vnvStatus;
    }
    
    public String getVnvRelevansi() {
        return vnvRelevansi;
    }

    public void setVnvRelevansi(String vnvRelevansi) {
        this.vnvRelevansi = vnvRelevansi;
    }

    public String getVnvKesulitan() {
        return vnvKesulitan;
    }

    public void setVnvKesulitan(String vnvKesulitan) {
        this.vnvKesulitan = vnvKesulitan;
    }

    public String getVnvKelayakanBobot() {
        return vnvKelayakanBobot;
    }

    public void setVnvKelayakanBobot(String vnvKelayakanBobot) {
        this.vnvKelayakanBobot = vnvKelayakanBobot;
    }

    public String getVnvKelayakanWaktu() {
        return vnvKelayakanWaktu;
    }

    public void setVnvKelayakanWaktu(String vnvKelayakanWaktu) {
        this.vnvKelayakanWaktu = vnvKelayakanWaktu;
    }

    public String getVnvLain() {
        return vnvLain;
    }

    public void setVnvLain(String vnvLain) {
        this.vnvLain = vnvLain;
    }

}
