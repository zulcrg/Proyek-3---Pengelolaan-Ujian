/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.entity;

import com.jtk.pengelolaanujian.facade.MataKuliahFacade;
import com.jtk.pengelolaanujian.facade.StorageSoalFacade;
import com.jtk.pengelolaanujian.facade.UjianFacade;
import com.jtk.pengelolaanujian.facade.VnvFacade;
import java.util.List;

/**
 *
 * @author Rizki
 */
public class Soal {

    private String soalKode;
    private String matkulKode;
    private Boolean soalUploaded;
    private Boolean soalVnved;
    private Boolean soalPrinted;
    private String soalSifat;
    private MataKuliah mataKuliah;
    private List<StorageSoal> storageSoalList;
    private Ujian ujian;
    private Vnv vnv;

    public Soal() {
    
    }

    public Soal(String soalKode, String matkulKode, Boolean soalUploaded, Boolean soalVnved, Boolean soalPrinted, String soalSifat) {
        this.soalKode = soalKode;
        this.matkulKode = matkulKode;
        this.soalUploaded = soalUploaded;
        this.soalVnved = soalVnved;
        this.soalPrinted = soalPrinted;
        this.soalSifat = soalSifat;        
    }
       
    public String getSoalKode() {
        return soalKode;
    }

    public void setSoalKode(String soalKode) {
        this.soalKode = soalKode;
    }

    public String getMatkulKode() {
        return matkulKode;
    }

    public void setMatkulKode(String matkulKode) {
        this.matkulKode = matkulKode;
    }

    public Boolean isSoalUploaded() {
        return soalUploaded;
    }

    public void setSoalUploaded(Boolean soalUploaded) {
        this.soalUploaded = soalUploaded;
    }

    public Boolean isSoalVnved() {
        return soalVnved;
    }

    public void setSoalVnved(Boolean soalVnved) {
        this.soalVnved = soalVnved;
    }

    public Boolean isSoalPrinted() {
        return soalPrinted;
    }

    public void setSoalPrinted(Boolean soalPrinted) {
        this.soalPrinted = soalPrinted;
    }

    public String getSoalSifat() {
        return soalSifat;
    }

    public void setSoalSifat(String soalSifat) {
        this.soalSifat = soalSifat;
    }

    public MataKuliah getMataKuliah() {
        MataKuliahFacade mataKuliahFacade = new MataKuliahFacade();
        mataKuliah = mataKuliahFacade.findByKodeMatkul(matkulKode);
        return mataKuliah;
    }

    public void setMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public List<StorageSoal> getStorageSoalList() {
        StorageSoalFacade storageSoalFacade = new StorageSoalFacade();
        storageSoalFacade.findByKodeSoal(soalKode);
        return storageSoalList;
    }

    public void setStorageSoalList(List<StorageSoal> storageSoalList) {
        this.storageSoalList = storageSoalList;
    }

    public Ujian getUjian() {
        UjianFacade ujianFacade = new UjianFacade();
        ujian = ujianFacade.findByKodeSoal(soalKode);
        return ujian;
    }

    public void setUjian(Ujian ujian) {
        this.ujian = ujian;
    }

    public Vnv getVnv() {
        VnvFacade vnvFacade = new VnvFacade();
        vnv = vnvFacade.findByKodeSoal(soalKode);
        return vnv;
    }

    public void setVnv(Vnv vnv) {
        this.vnv = vnv;
    }

}
