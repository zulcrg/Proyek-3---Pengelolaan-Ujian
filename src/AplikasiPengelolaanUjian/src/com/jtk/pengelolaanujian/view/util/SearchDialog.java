/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.view.util;

import com.jtk.pengelolaanujian.controller.admin.AssignRoleController;
import com.jtk.pengelolaanujian.controller.admin.EditUserController;
import com.jtk.pengelolaanujian.controller.admin.RegistrasiUserController;
import com.jtk.pengelolaanujian.controller.panitiaController.AssignUjianController;
import com.jtk.pengelolaanujian.controller.panitiaController.CreateUjianController;
import com.jtk.pengelolaanujian.controller.vnv.BeritaAcaraVnvController;
import com.jtk.pengelolaanujian.entity.Dosen;
import com.jtk.pengelolaanujian.entity.Kelas;
import com.jtk.pengelolaanujian.entity.MataKuliah;
import com.jtk.pengelolaanujian.entity.Ruangan;
import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.util.EnumPanel;
import com.zlib.util.ZClass;
import java.awt.Color;
import java.awt.Frame;
import java.util.List;

/**
 *
 * @author pahlevi
 */
public class SearchDialog extends javax.swing.JDialog {

    boolean first = true;
    private Staf staf;
    private MataKuliah mataKuliah;
    private Soal soal;
    private Ujian ujian;
    private Ruangan ruangan;
    private List<Ruangan> ruanganList;
    private Kelas kelas;
    private List<Kelas> kelasList;
    private List<Soal> soalList;
    private List<Staf> stafList;
    private List<Dosen> dosenList;
    private List<Dosen> dosenListSelected;
    private List<MataKuliah> mataKuliahList;
    private List<Ujian> ujianList;
    private RegistrasiUserController registrasiUserController;
    private AssignRoleController assignRoleController;
    private EditUserController editUserController;
    private CreateUjianController createUjianController;
    private AssignUjianController assignUjianController;
    private BeritaAcaraVnvController beritaAcaraVnvController;
    private final EnumPanel enumPanel;

    /**
     * Creates new form SearchSoalDialog
     *
     * @param parent
     * @param modal
     * @param soal
     * @param enumPanel
     */
    public SearchDialog(Frame parent, boolean modal, Soal soal, EnumPanel enumPanel) {
        super(parent, modal);
        initComponents();
        setFocusable(true);
        setLocationRelativeTo(null);
        setResizable(false);
        this.soal = soal;
        this.enumPanel = enumPanel;
        switchPanel();
    }

    /**
     * Creates new form SearchStafDialog
     *
     * @param parent
     * @param modal
     * @param staf
     * @param enumPanel
     */
    public SearchDialog(Frame parent, boolean modal, Staf staf, EnumPanel enumPanel) {
        super(parent, modal);
        initComponents();
        setFocusable(true);
        setLocationRelativeTo(null);
        setResizable(false);
        this.staf = staf;
        this.enumPanel = enumPanel;
        switchPanel();
    }

    /**
     * Creates new form SearchStafDialog
     *
     * @param parent
     * @param modal
     * @param dosenList
     * @param enumPanel
     */
    public SearchDialog(Frame parent, boolean modal, List<Dosen> dosenList, EnumPanel enumPanel) {
        super(parent, modal);
        initComponents();
        setFocusable(true);
        setLocationRelativeTo(null);
        setResizable(false);
        this.dosenListSelected = dosenList;
        this.enumPanel = enumPanel;
        switchPanel();
    }

    /**
     * Creates new form SearchStafDialog
     *
     * @param parent
     * @param modal
     * @param mataKuliah
     * @param enumPanel
     */
    public SearchDialog(Frame parent, boolean modal, MataKuliah mataKuliah, EnumPanel enumPanel) {
        super(parent, modal);
        initComponents();
        setFocusable(true);
        setLocationRelativeTo(null);
        setResizable(false);
        this.mataKuliah = mataKuliah;
        this.enumPanel = enumPanel;
        switchPanel();
    }

    /**
     *
     * @param parent
     * @param modal
     * @param ujian
     * @param enumPanel
     */
    public SearchDialog(Frame parent, boolean modal, Ujian ujian, EnumPanel enumPanel) {
        super(parent, modal);
        initComponents();
        setFocusable(true);
        setLocationRelativeTo(null);
        setResizable(false);
        this.ujian = ujian;
        this.enumPanel = enumPanel;
        switchPanel();
    }

    /**
     *
     * @param parent
     * @param modal
     * @param ruangan
     * @param enumPanel
     */
    public SearchDialog(Frame parent, boolean modal, Ruangan ruangan, EnumPanel enumPanel) {
        super(parent, modal);
        initComponents();
        setFocusable(true);
        setLocationRelativeTo(null);
        setResizable(false);
        this.ruangan = ruangan;
        this.enumPanel = enumPanel;
        switchPanel();
    }

    /**
     *
     * @param parent
     * @param modal
     * @param kelas
     * @param enumPanel
     */
    public SearchDialog(Frame parent, boolean modal, Kelas kelas, EnumPanel enumPanel) {
        super(parent, modal);
        initComponents();
        setFocusable(true);
        setLocationRelativeTo(null);
        setResizable(false);
        this.kelas = kelas;
        this.enumPanel = enumPanel;
        switchPanel();
    }

    private void switchPanel() {
        switch (enumPanel) {
            case REGISTER_USER:
                registrasiUserController = new RegistrasiUserController();
                registrasiUserController.searchUser("", table);
                textSearch.setText("Cari berdasarkan NIP atau Nama");
                textSearch.setToolTipText("Cari berdasarkan NIP atau Nama");
                setTitle("Registrasi User");
                break;
            case ASSIGN_ROLE:
                assignRoleController = new AssignRoleController();
                stafList = assignRoleController.searchUser("", table);
                textSearch.setText("Cari berdasarkan Nama atau Username");
                textSearch.setToolTipText("Cari berdasarkan Nama atau Username");
                setTitle("Assign Role");
                break;
            case EDIT_USER:
                editUserController = new EditUserController();
                stafList = editUserController.searchUserNotMe("", table);
                textSearch.setText("Cari berdasarkan Nama atau Username");
                textSearch.setToolTipText("Cari berdasarkan Nama atau Username");
                setTitle("Edit User");
                break;
            case SEARCH_SOAL:
                createUjianController = new CreateUjianController();
                mataKuliahList = createUjianController.searchMataKuliah("", table);
                textSearch.setText("Cari berdasarkan Kode atau Nama Mata kuliah");
                textSearch.setToolTipText("Cari berdasarkan Kode atau Nama Mata kuliah");
                setTitle("Mata Kuliah");
                break;
            case SEARCH_UJIAN:
                assignUjianController = new AssignUjianController();
                ujianList = assignUjianController.searchUjian("", table);
                textSearch.setText("Cari berdasarkan Kode atau Nama Ujian");
                textSearch.setToolTipText("Cari berdasarkan Kode atau Nama Ujian");
                setTitle("Ujian");
                break;
            case SEARCH_RUANGAN:
                assignUjianController = new AssignUjianController();
                ruanganList = assignUjianController.searchRuangan("", table);
                textSearch.setText("Cari berdasarkan Kode atau Nama Ruangan");
                textSearch.setToolTipText("Cari berdasarkan Kode atau Nama Ruangan");
                setTitle("Ruangan");
                break;
            case SEARCH_KELAS:
                assignUjianController = new AssignUjianController();
                kelasList = assignUjianController.searchKelas("", table);
                textSearch.setText("Cari berdasarkan Kode atau Nama Kelas");
                textSearch.setToolTipText("Cari berdasarkan Kode atau Nama Kelas");
                setTitle("Kelas");
                break;
            case SEARCH_SOALMATKUL:
                beritaAcaraVnvController = new BeritaAcaraVnvController();
                soalList = beritaAcaraVnvController.searchSoal("", table);
                textSearch.setText("Cari berdasarkan Kode Soal atau Nama Mata Kuliah");
                textSearch.setToolTipText("Cari berdasarkan Kode Soal atau Nama Mata Kuliah");
                setTitle("Soal");
                break;
            case SEARCH_PENGAWAS:
                assignUjianController = new AssignUjianController();
                stafList = assignUjianController.searchPengawas("", table);
                textSearch.setText("Cari berdasarkan NIP atau Nama Pengawas");
                textSearch.setToolTipText("Cari berdasarkan NIP atau Nama Pengawas");
                setTitle("Pengawas");
                break;
            case SEARCH_STAF:
                beritaAcaraVnvController = new BeritaAcaraVnvController();
                dosenList = beritaAcaraVnvController.searchTimVnv("", table);
                textSearch.setText("Cari berdasarkan NIP atau Nama Staf");
                textSearch.setToolTipText("Cari berdasarkan NIP atau Nama Staf");
                setTitle("Tim Vnv");
                break;
        }
    }

    private void switchText() {
        switch (enumPanel) {
            case REGISTER_USER:
                textSearch.setText("Cari berdasarkan NIP atau Nama");
                textSearch.setToolTipText("Cari berdasarkan NIP atau Nama");
                break;
            case ASSIGN_ROLE:
                textSearch.setText("Cari berdasarkan Nama atau Username");
                textSearch.setToolTipText("Cari berdasarkan Nama atau Username");
                break;
            case EDIT_USER:
                textSearch.setText("Cari berdasarkan Nama atau Username");
                textSearch.setToolTipText("Cari berdasarkan Nama atau Username");
                break;
            case SEARCH_SOAL:
                textSearch.setText("Cari berdasarkan Kode atau Nama Mata kuliah");
                textSearch.setToolTipText("Cari berdasarkan Kode atau Nama Mata kuliah");
                break;
            case SEARCH_UJIAN:
                textSearch.setText("Cari berdasarkan Kode atau Nama Ujian");
                textSearch.setToolTipText("Cari berdasarkan Kode atau Nama Ujian");
                break;
            case SEARCH_RUANGAN:
                textSearch.setText("Cari berdasarkan Kode atau Nama Ruangan");
                textSearch.setToolTipText("Cari berdasarkan Kode atau Nama Ruangan");
                break;
            case SEARCH_KELAS:
                textSearch.setText("Cari berdasarkan Kode atau Nama Kelas");
                textSearch.setToolTipText("Cari berdasarkan Kode atau Nama Kelas");
                break;
            case SEARCH_SOALMATKUL:
                textSearch.setText("Cari berdasarkan Kode Soal atau Nama Mata Kuliah");
                textSearch.setToolTipText("Cari berdasarkan Kode Soal atau Nama Mata Kuliah");
                break;
            case SEARCH_PENGAWAS:
                textSearch.setText("Cari berdasarkan NIP atau Nama Pengawas");
                textSearch.setToolTipText("Cari berdasarkan NIP atau Nama Pengawas");
                break;
            case SEARCH_STAF:
                textSearch.setText("Cari berdasarkan NIP atau Nama Staf");
                textSearch.setToolTipText("Cari berdasarkan NIP atau Nama Staf");
                break;
        }
    }

    private void select() {
        switch (enumPanel) {
            case REGISTER_USER:
                staf.setStafNama(table.getValueAt(table.getSelectedRow(), 0).toString());
                staf.setStafNIP(table.getValueAt(table.getSelectedRow(), 1).toString());
                break;
            case ASSIGN_ROLE:
            case EDIT_USER:
                staf.setStafNama(stafList.get(table.getSelectedRow()).getStafNama());
                staf.setStafNIP(stafList.get(table.getSelectedRow()).getStafNIP());
                break;
            case SEARCH_SOAL:
                mataKuliah.setMatkulKode(mataKuliahList.get(table.getSelectedRow()).getMatkulKode());
                mataKuliah.setMatkulNama(mataKuliahList.get(table.getSelectedRow()).getMatkulNama());
                mataKuliah.setMatkulTipe(mataKuliahList.get(table.getSelectedRow()).getMatkulTipe());
                break;
            case SEARCH_UJIAN:
                ujian.setUjianKode(ujianList.get(table.getSelectedRow()).getUjianKode());
                ujian.setUjianNama(ujianList.get(table.getSelectedRow()).getUjianNama());
                ujian.setUjianMulai(ujianList.get(table.getSelectedRow()).getUjianMulai());
                break;
            case SEARCH_RUANGAN:
                ruangan.setRuanganKode(ruanganList.get(table.getSelectedRow()).getRuanganKode());
                ruangan.setRuanganNama(ruanganList.get(table.getSelectedRow()).getRuanganNama());
                break;
            case SEARCH_KELAS:
                kelas.setKelasKode(kelasList.get(table.getSelectedRow()).getKelasKode());
                kelas.setKelasNama(kelasList.get(table.getSelectedRow()).getKelasNama());
                break;
            case SEARCH_SOALMATKUL:
                ZClass.copyClass(soalList.get(table.getSelectedRow()), soal);
                break;
            case SEARCH_PENGAWAS:
                staf.setStafNama(stafList.get(table.getSelectedRow()).getStafNama());
                staf.setStafNIP(stafList.get(table.getSelectedRow()).getStafNIP());
                break;
            case SEARCH_STAF:
                for (int i = 0; i < dosenList.size(); i++) {
                    if ((boolean) table.getValueAt(i, 2)) {
                        dosenListSelected.add(dosenList.get(i));
                    }
                }
                break;
        }
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textSearch = new javax.swing.JTextField();
        btnSelect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Staff");

        textSearch.setForeground(new java.awt.Color(153, 153, 153));
        textSearch.setText("Cari berdasarkan Nama atau NIP");
        textSearch.setToolTipText("Cari berdasakan Nama atau NIK");
        textSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textSearchFocusLost(evt);
            }
        });
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });
        textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textSearchKeyReleased(evt);
            }
        });

        btnSelect.setText("Select");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "NIK"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSelect)
                        .addGap(0, 421, Short.MAX_VALUE))
                    .addComponent(textSearch))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSelect)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        select();
    }//GEN-LAST:event_btnSelectActionPerformed

    private void textSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyReleased
        switch (enumPanel) {
            case REGISTER_USER:
                registrasiUserController.searchUser(textSearch.getText(), table);
                break;
            case ASSIGN_ROLE:
                stafList = assignRoleController.searchUser(textSearch.getText(), table);
                break;
            case EDIT_USER:
                stafList = editUserController.searchUserNotMe(textSearch.getText(), table);
                break;
            case SEARCH_SOAL:
                mataKuliahList = createUjianController.searchMataKuliah(textSearch.getText(), table);
                break;
            case SEARCH_UJIAN:
                ujianList = assignUjianController.searchUjian(textSearch.getText(), table);
                break;
            case SEARCH_RUANGAN:
                ruanganList = assignUjianController.searchRuangan(textSearch.getText(), table);
                break;
            case SEARCH_KELAS:
                kelasList = assignUjianController.searchKelas(textSearch.getText(), table);
                break;
            case SEARCH_SOALMATKUL:
                soalList = beritaAcaraVnvController.searchSoal(textSearch.getText(), table);
                break;
            case SEARCH_PENGAWAS:
                stafList = assignUjianController.searchPengawas(textSearch.getText(), table);
                break;
            case SEARCH_STAF:
                dosenList = beritaAcaraVnvController.searchTimVnv(textSearch.getText(), table);
                break;
        }
    }//GEN-LAST:event_textSearchKeyReleased

    private void textSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textSearchFocusGained
        if (first) {
            textSearch.setForeground(Color.black);
            textSearch.setText("");
            first = false;
        }
    }//GEN-LAST:event_textSearchFocusGained

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (!enumPanel.equals(EnumPanel.SEARCH_STAF)) {
            if (evt.getClickCount() == 2) {
                select();
            }
        }
    }//GEN-LAST:event_tableMouseClicked

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchActionPerformed

    private void textSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textSearchFocusLost
        if (textSearch.getText().isEmpty()) {
            textSearch.setForeground(Color.getHSBColor(153, 153, 153));
            switchText();
            first = true;
        }
    }//GEN-LAST:event_textSearchFocusLost

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables
}
