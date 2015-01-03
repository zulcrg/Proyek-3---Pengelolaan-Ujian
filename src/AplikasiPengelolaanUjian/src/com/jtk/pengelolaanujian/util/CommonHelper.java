/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class CommonHelper {

    public static boolean isStrongPassword(String password) {
        String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+{8,}$"; // harus mengandung huruf kecil , besar, angka, dan min 8 digit
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        boolean kuat = matcher.matches() == true;
        return kuat;
    }

    public static boolean isStringNumber(String text) {
        return text.matches("\\d+");
    }

    public static boolean isStringNumberMaxMin(String text, int max, int min) {
        if (text.matches("\\d+")) {
            if (Integer.parseInt(text) <= max && Integer.parseInt(text) >= min) {
                return true;
            }
        }
        return false;
    }

    public static SpinnerModel createDurasiSpinnerModel() {
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 10);
        return spinnerModel;
    }
}
