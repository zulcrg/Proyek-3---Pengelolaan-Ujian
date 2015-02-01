/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.util;

import com.jtk.pengelolaanujian.entity.Event;
import java.awt.Component;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

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

    public static String createTahun(Event event) {
        if (event != null) {
            String string = "Ujian ";
            char[] a = event.getKode().toCharArray();

            if (a[3] == 'T') {
                string = string + "Tengah semester ";
            } else {
                string = string + "Akhir semester ";
            }

            if (a[2] == '1') {
                string = string + "Genap ";
            } else {
                string = string + "Ganjil ";
            }
            string = string + "Tahun 20" + a[0] + a[1];

            return string;
        }
        return "";
    }

    public static String convertTipeMatkul(String text) {
        switch (text) {
            case "TE":
                return "TEORI";
            case "PR":
                return "PRAKTEK";
            default:
                return "";
        }
    }

    public static String createUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static Integer booleanToInt(Boolean b) {
        if (b) {
            return 1;
        } else if (!b) {
            return 0;
        } else {
            Logger.getLogger(CommonHelper.class.getName()).log(Level.SEVERE, null, "Error Convert " + b + " to integer");
            return null;
        }
    }

    public static Boolean intToBoolean(Integer i) {
        if (i == 1) {
            return true;
        } else if (i == 0) {
            return false;
        } else {
            Logger.getLogger(CommonHelper.class.getName()).log(Level.SEVERE, null, "Error Convert " + i + " to boolean");
            return null;
        }
    }

    public static void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 50; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width, width);
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
}
