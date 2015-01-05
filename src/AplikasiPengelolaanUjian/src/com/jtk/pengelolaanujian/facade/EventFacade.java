/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.facade;

import com.jtk.pengelolaanujian.entity.Event;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

    public Event findByKodeEvent(String kodeEvent) {
        try {
            String query = "SELECT event.* FROM event WHERE event.EVENT_KODE = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, kodeEvent);
            ResultSet rs = stmt.executeQuery();
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

    public void createEvent(Event event) throws SQLException {
        String query = "INSERT INTO event(EVENT_KODE, EVENT_TGL_MULAI, EVENT_TGL_SELESAI, "
                + "EVENT_TGL_UPLOAD_MULAI, EVENT_TGL_UPLOAD_SELESAI, EVENT_TGL_VNV_MULAI, "
                + "EVENT_TGL_VNV_SELESAI, EVENT_DELAY_UPLOAD_SOAL, EVENT_DELAY_PENGAWAS, "
                + "EVENT_DELAY_UPLOAD_NILAI, EVENT_TGL_UPLOAD_NILAI_SELESAI, "
                + "EVENT_ACTIVE, EVENT_REMINDER_TIME) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, event.getKode());
        preparedStatement.setDate(2, new Date(event.getTanggalMulai().getTime()));
        preparedStatement.setDate(3, new Date(event.getTanggalSelesai().getTime()));
        preparedStatement.setDate(4, new Date(event.getUploadMulai().getTime()));
        preparedStatement.setDate(5, new Date(event.getUploadSelesai().getTime()));
        preparedStatement.setDate(6, new Date(event.getVnvMulai().getTime()));
        preparedStatement.setDate(7, new Date(event.getVnvSelesai().getTime()));
        preparedStatement.setInt(8, event.getDelayUploadSoal());
        preparedStatement.setInt(9, event.getDelayPengawas());
        preparedStatement.setInt(10, event.getDelayUploadNilai());
        preparedStatement.setDate(11, new Date(event.getUploadNilaiSelesai().getTime()));
        preparedStatement.setBoolean(12, true);
        preparedStatement.setInt(13, event.getTimeReminder());
        preparedStatement.executeUpdate();
    }
    
    public void updateActiveEvent() throws SQLException{
        String query = "UPDATE event SET EVENT_ACTIVE = 0 WHERE EVENT_ACTIVE = 1";
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         preparedStatement.executeUpdate();
    }

    public Event findLast() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM event ORDER BY EVENT_KODE DESC LIMIT 1";
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
                event.setUploadNilaiSelesai(rs.getDate(8));
                event.setDelayUploadSoal(rs.getInt(10));
                event.setDelayPengawas(rs.getInt(11));
                event.setDelayUploadNilai(rs.getInt(12));                
                event.setTimeReminder(rs.getInt(13));
                return event;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Event findTrue() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM event WHERE EVENT_ACTIVE = 1";
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
                event.setUploadNilaiSelesai(rs.getDate(8));
                event.setDelayUploadSoal(rs.getInt(10));
                event.setDelayPengawas(rs.getInt(11));
                event.setDelayUploadNilai(rs.getInt(12));
                event.setTimeReminder(rs.getInt(13));
                return event;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
