/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.util;

/**
 *
 * @author Zulkhair Abdullah D
 */
public enum EnumRole {

    ADMIN("0"), DOSEN_PENGAMPU("1"), PANITIA("3"), VNV("2"), DASHBOARD("4");
    String key;

    private EnumRole(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
