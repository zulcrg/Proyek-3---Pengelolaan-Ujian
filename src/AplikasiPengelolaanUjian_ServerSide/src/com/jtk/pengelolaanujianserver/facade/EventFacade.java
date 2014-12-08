/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.facade;

import com.jtk.pengelolaanujianserver.entity.Event;
import com.jtk.pengelolaanujianserver.util.ConnectionHelper;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rizki
 */
public class EventFacade {

    private final Connection connection = ConnectionHelper.getConnection();

    public List<Event> findAll() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM EVENT";
            ResultSet rs = stmt.executeQuery(query);
            List<Event> eventList = new ArrayList<>();
            while (rs.next()) {
                Event event = new Event();
                event.setKode(rs.getString(1));
                event.setTanggalMulai(rs.getDate(2));
                event.setTanggalSelesai(rs.getDate(3));
                event.setUploadMulai(rs.getDate(4));
                event.setUploadSelesai(rs.getDate(5));
                event.setVnvMulai(rs.getDate(6));
                event.setVnvSelesai(rs.getDate(7));

                eventList.add(event);
            }
            return eventList;
        } catch (SQLException ex) {
            Logger.getLogger(EventFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Event findByKodeUjian(String kodeUjian) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT event.* FROM event, ujian "
                    + "WHERE event.EVENT_KODE = ujian.EVENT_KODE AND ujian.UJIAN_KODE = '" + kodeUjian + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                Event event = new Event();
                event.setKode(rs.getString(1));
                event.setTanggalMulai(rs.getDate(2));
                event.setTanggalSelesai(rs.getDate(3));
                event.setUploadMulai(rs.getDate(4));
                event.setUploadSelesai(rs.getDate(5));
                event.setVnvMulai(rs.getDate(6));
                event.setVnvSelesai(rs.getDate(7));

                return event;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Event findLast() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM event ORDER BY id DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                Event event = new Event();
                event.setKode(rs.getString(1));
                event.setTanggalMulai(rs.getDate(2));
                event.setTanggalSelesai(rs.getDate(3));
                event.setUploadMulai(rs.getDate(4));
                event.setUploadSelesai(rs.getDate(5));
                event.setVnvMulai(rs.getDate(6));
                event.setVnvSelesai(rs.getDate(7));
                event.setDelayUploadSoal(rs.getInt(8));
                event.setDelayPengawas(rs.getInt(9));
                return event;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

