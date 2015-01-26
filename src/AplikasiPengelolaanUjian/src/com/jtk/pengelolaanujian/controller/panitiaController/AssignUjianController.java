/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.panitiaController;

import com.jtk.pengelolaanujian.controller.AbstractController;
import com.jtk.pengelolaanujian.entity.BeritaAcara;
import com.jtk.pengelolaanujian.entity.Kelas;
import com.jtk.pengelolaanujian.entity.Ruangan;
import com.jtk.pengelolaanujian.entity.RuanganUjian;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.facade.BeritaAcaraFacade;
import com.jtk.pengelolaanujian.facade.KelasFacade;
import com.jtk.pengelolaanujian.facade.RuanganFacade;
import com.jtk.pengelolaanujian.facade.RuanganUjianFacade;
import com.jtk.pengelolaanujian.facade.UjianFacade;
import com.jtk.pengelolaanujian.facade.UserFacade;
import com.jtk.pengelolaanujian.util.CommonHelper;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import com.jtk.pengelolaanujian.util.SendEmailModel;
import com.jtk.pengelolaanujian.util.SendingEmailControlProcess;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class AssignUjianController extends AbstractController {
    
    public boolean cekInRangeTanggal(Date sesudah, Date sebelum,Date rekamMedik){        
        if(sesudah.after(rekamMedik) && sebelum.before(rekamMedik)){
            return true;
        }else{
            return false;
        }        
    }        
    
    public List<Ujian> searchUjian(String text, JTable table) {
        UjianFacade ujianFacade = new UjianFacade();
        List<Ujian> ujianList = ujianFacade.findUjianLike(text);

        Object[] columnsName = {"Kode", "Nama", "Waktu"};
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");

        DefaultTableModel dtm = new DefaultTableModel(null, columnsName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Ujian ujian : ujianList) {
            Object[] o = new Object[3];
            o[0] = ujian.getUjianKode();
            o[1] = ujian.getUjianNama();
            o[2] = sdf.format(ujian.getUjianMulai());

            dtm.addRow(o);
        }
        table.setModel(dtm);
        return ujianList;
    }

    public List<Ruangan> searchRuangan(String text, JTable table) {
        RuanganFacade ruanganFacade = new RuanganFacade();
        List<Ruangan> ruangans = ruanganFacade.findKodeRuanganLike(text);

        Object[] columnsName = {"Kode", "Nama"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnsName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Ruangan r : ruangans) {
            Object[] o = new Object[3];
            o[0] = r.getRuanganKode();
            o[1] = r.getRuanganNama();

            dtm.addRow(o);
        }
        table.setModel(dtm);
        return ruangans;
    }

    public List<Kelas> searchKelas(String text, JTable table) {
        KelasFacade kelasFacade = new KelasFacade();
        List<Kelas> kelasList = kelasFacade.findKelasLike(text);

        Object[] columnsName = {"Kode", "Nama"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnsName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Kelas kelas : kelasList) {
            Object[] o = new Object[3];
            o[0] = kelas.getKelasKode();
            o[1] = kelas.getKelasNama();

            dtm.addRow(o);
        }
        table.setModel(dtm);
        return kelasList;
    }

    public List<Staf> searchPengawas(String text, JTable tableStaf) {
        List<Staf> stafList;

        UserFacade userFacade = new UserFacade();
        stafList = userFacade.searchNameNip(text);

        Object[] columnsName = {"NIP", "Nama"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnsName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Staf staf : stafList) {
            Object[] o = new Object[2];
            o[0] = staf.getStafNIP();
            o[1] = staf.getStafNama();

            dtm.addRow(o);
        }
        tableStaf.setModel(dtm);

        return stafList;
    }

    public boolean createRuanganUjian(String kodeUjian, String kodeRuangan, String stafNip, String kelasKode) {
        RuanganUjianFacade ruanganFacade = new RuanganUjianFacade();

        if (ruanganFacade.findByUjianKodeKelasKode(kodeUjian, kelasKode) != null) {
            addWarnMessage("Ujian sudah di assign", "Perhatian");
        } else {
            BeritaAcara beritaAcara = new BeritaAcara();
            beritaAcara.setBeritaKode(CommonHelper.createUUID());
            beritaAcara.setBeritaHadir(0);
            beritaAcara.setBeritaJawabSisa(0);
            beritaAcara.setBeritaSoalSisa(0);
            beritaAcara.setBeritaTidakHadir(0);
            beritaAcara.setBeritaStatus(false);

            BeritaAcaraFacade beritaAcaraFacade = new BeritaAcaraFacade();

            RuanganUjian ruanganUjian = new RuanganUjian();
            ruanganUjian.setBeritaKode(beritaAcara.getBeritaKode());
            ruanganUjian.setKelasKode(kelasKode);
            ruanganUjian.setRuanganKode(kodeRuangan);
            ruanganUjian.setRuanganUjianUploadNilaiStatus(false);
            ruanganUjian.setStafNip(stafNip);
            ruanganUjian.setUjianKode(kodeUjian);

            try {
                ConnectionHelper.getConnection().setAutoCommit(false);
                beritaAcaraFacade.createBeritaAcara(beritaAcara);
                ruanganFacade.createRuanganUjian(ruanganUjian);
                addInfoMessage("Berhasil menambahkat data", "Perhatian");
                ConnectionHelper.getConnection().commit();
                ConnectionHelper.getConnection().setAutoCommit(true);

                Staf staf = ruanganUjian.getStafQuery();
                Ruangan ruangan = ruanganUjian.getRuanganQuery();
                Ujian ujian = ruanganUjian.getUjianQuery();
                Kelas kelas = ruanganUjian.getKelasQuery();
                SendEmailModel sendEmailModel = new SendEmailModel();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");

                List<String> reciever = new ArrayList<>();
                reciever.add(staf.getStafEmail());

                sendEmailModel.setReciever(reciever);
                sendEmailModel.setSubject("Pemberitahuan Pengawas Ujian");

                String messageBody = "<table>\n"
                        + "	<tr>\n"
                        + "		<td style=\"width:150px;\">Ujian</td>\n"
                        + "             <td>:</td>"
                        + "		<td style=\"width:300px;\">" + ujian.getUjianNama() + "</td>\n"
                        + "	</tr>\n"
                        + "	<tr>\n"
                        + "		<td>NIP</td>\n"
                        + "             <td>:</td>"
                        + "		<td>" + staf.getStafNIP() + "</td>\n"
                        + "	</tr>\n"
                        + "	<tr>\n"
                        + "		<td>Nama</td>\n"
                        + "             <td>:</td>"
                        + "		<td>" + staf.getStafNama() + "</td>\n"
                        + "	</tr>\n"
                        + "	<tr>\n"
                        + "		<td>Kelas</td>\n"
                        + "             <td>:</td>"
                        + "		<td>" + kelas.getKelasNama() + "</td>\n"
                        + "	</tr>\n"
                        + "	<tr>\n"
                        + "		<td>Kode Ruangan</td>\n"
                        + "             <td>:</td>"
                        + "		<td>" + ruangan.getRuanganKode() + "</td>\n"
                        + "	</tr>\n"
                        + "	<tr>\n"
                        + "		<td>Nama Ruangan</td>\n"
                        + "             <td>:</td>"
                        + "		<td>" + ruangan.getRuanganNama() + "</td>\n"
                        + "	</tr>\n"
                        + "	<tr>\n"
                        + "		<td>Tanggal</td>\n"
                        + "             <td>:</td>"
                        + "		<td>" + sdf.format(ujian.getUjianMulai()) + "</td>\n"
                        + "	</tr>\n"
                        + "	<tr>\n"
                        + "		<td>Waktu</td>\n"
                        + "             <td>:</td>"
                        + "		<td>" + sdf2.format(ujian.getUjianMenit()) + "</td>\n"
                        + "	</tr>\n"
                        + "	<tr>\n"
                        + "		<td>Durasi</td>\n"
                        + "             <td>:</td>"
                        + "		<td>" + ujian.getUjianMenit() + " Menit</td>\n"
                        + "	</tr>\n"
                        + "</table>";
                sendEmailModel.setMessageBody(messageBody);
                SendingEmailControlProcess secp = new SendingEmailControlProcess();
                secp.SendEmail(sendEmailModel);
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(AssignUjianController.class.getName()).log(Level.SEVERE, null, ex);
                addErrorMessage(ex.getMessage(), "Error");
                try {
                    ConnectionHelper.getConnection().rollback();
                    ConnectionHelper.getConnection().setAutoCommit(true);
                } catch (SQLException ex1) {
                    Logger.getLogger(AssignUjianController.class.getName()).log(Level.SEVERE, null, ex1);
                    addErrorMessage(ex1.getMessage(), "Error");
                }
            } catch (MessagingException ex) {
                Logger.getLogger(AssignUjianController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }
}
