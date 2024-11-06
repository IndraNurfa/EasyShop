/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import data.BarangDb;
import entity.BarangEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nurfa
 */
public class AdminMainFrame extends javax.swing.JFrame {

    private final BarangDb barang = new BarangDb();

    private final DefaultTableModel makanan = new DefaultTableModel();
    private final DefaultTableModel minuman = new DefaultTableModel();

    public AdminMainFrame() {
        initComponents();
        setLocationRelativeTo(this);

        makanan.addColumn("ID");
        makanan.addColumn("Merek");
        makanan.addColumn("Tipe");
        makanan.addColumn("Berat");
        makanan.addColumn("Harga");
        tabelMakanan.setModel(makanan);

        minuman.addColumn("ID");
        minuman.addColumn("Merek");
        minuman.addColumn("Tipe");
        minuman.addColumn("Berat");
        minuman.addColumn("Harga");
        tabelMinuman.setModel(minuman);

        populateTable();
    }

    private void populateTable() {
        makanan.setRowCount(0);
        minuman.setRowCount(0);
        try {
            ArrayList<BarangEntity> entityMakanan = barang.getBarangMakanan();
            for (BarangEntity makEn : entityMakanan) {
                Object[] isiMkn = {makEn.getId(), makEn.getMerek(), makEn.getTipe(), makEn.getBerat(), makEn.getHarga()};
                makanan.addRow(isiMkn);
            }
            ArrayList<BarangEntity> entityMinuman = barang.getBarangMinuman();
            for (BarangEntity minEn : entityMinuman) {
                Object[] isiMin = {minEn.getId(), minEn.getMerek(), minEn.getTipe(), minEn.getBerat(), minEn.getHarga()};
                minuman.addRow(isiMin);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        tfID.setEnabled(true);
        reset();
    }

    private void populateTable(String jenis, String keyword) {
        try {
            if (jenis.equals("makanan")) {
                makanan.setRowCount(0);
                ArrayList<BarangEntity> entityMakanan = barang.getBarangMakanan(keyword);
                for (BarangEntity makEn : entityMakanan) {
                    Object[] isiMkn = {makEn.getId(), makEn.getMerek(), makEn.getTipe(), makEn.getBerat(), makEn.getHarga()};
                    makanan.addRow(isiMkn);
                }
            } else {
                minuman.setRowCount(0);
                ArrayList<BarangEntity> entityMinuman = barang.getBarangMinuman(keyword);
                for (BarangEntity minEn : entityMinuman) {
                    Object[] isiMin = {minEn.getId(), minEn.getMerek(), minEn.getTipe(), minEn.getBerat(), minEn.getHarga()};
                    minuman.addRow(isiMin);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        tfID.setEnabled(true);
        reset();
    }

    private void insertMakanan(BarangEntity b) {
        if (btnSubmit.getText().equals("Submit")) {
            try {
                boolean statusMakan = barang.insertMakanan(b);
                if (statusMakan) {
                    JOptionPane.showMessageDialog(null, "Berhasil Submit");
                    populateTable();
                    reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Submit");
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            try {
                boolean statusMakan = barang.updateMakanan(b);
                if (statusMakan) {
                    JOptionPane.showMessageDialog(null, "Berhasil Update");
                    populateTable();
                    reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Update");
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    private void insertMinuman(BarangEntity b) {
        if (btnSubmit.getText().equals("Submit")) {
            try {
                boolean statusMinum = barang.insertMinuman(b);
                if (statusMinum) {
                    JOptionPane.showMessageDialog(null, "Berhasil Submit");
                    populateTable();
                    reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Submit");
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            try {
                boolean statusMinum = barang.updateMinuman(b);
                if (statusMinum) {
                    JOptionPane.showMessageDialog(null, "Berhasil Submit");
                    populateTable();
                    reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Update");
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    private void reset() {
        tfID.setText("");
        tfID.setEnabled(true);
        tfMerek.setText("");
        tfTipe.setText("");
        spinnerBerat.setValue(0);
        spinnerHarga.setValue(0);
        btnSubmit.setText("Submit");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        tfMerek = new javax.swing.JTextField();
        tfTipe = new javax.swing.JTextField();
        spinnerHarga = new javax.swing.JSpinner();
        btnSubmit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboJenis = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        spinnerBerat = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMakanan = new javax.swing.JTable();
        makananDelete = new javax.swing.JButton();
        tfMakananSearch = new javax.swing.JTextField();
        makananSearch = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelMinuman = new javax.swing.JTable();
        minumanDelete = new javax.swing.JButton();
        tfMinumanSearch = new javax.swing.JTextField();
        minumanSearrch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Barang"));

        jLabel2.setText("Merek:");

        jLabel3.setText("Tipe:");

        jLabel4.setText("Harga:");

        jLabel5.setText("ID:");

        spinnerHarga.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 500));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel1.setText("Jenis:");

        comboJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Makanan", "Minuman" }));

        jLabel6.setText("Berat:");

        spinnerBerat.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(comboJenis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTipe)
                            .addComponent(tfMerek)
                            .addComponent(spinnerHarga)
                            .addComponent(spinnerBerat)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSubmit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(btnReset)))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tfMerek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfTipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(spinnerBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(spinnerHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnReset))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Makanan"));

        tabelMakanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelMakanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMakananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelMakanan);

        makananDelete.setText("Delete");
        makananDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makananDeleteActionPerformed(evt);
            }
        });

        makananSearch.setText("Search");
        makananSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makananSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tfMakananSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(makananSearch)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(makananDelete)
                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMakananSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(makananSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makananDelete)
                .addGap(4, 4, 4))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Minuman"));

        tabelMinuman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelMinuman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMinumanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelMinuman);

        minumanDelete.setText("Delete");
        minumanDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minumanDeleteActionPerformed(evt);
            }
        });

        minumanSearrch.setText("Search");
        minumanSearrch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minumanSearrchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tfMinumanSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minumanSearrch)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minumanDelete)
                .addGap(160, 160, 160))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMinumanSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minumanSearrch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minumanDelete)
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        String jenis = comboJenis.getSelectedItem().toString();
        String id = tfID.getText();
        String merek = tfMerek.getText();
        String tipe = tfTipe.getText();
        String berat = spinnerBerat.getValue().toString();
        String harga = spinnerHarga.getValue().toString();
        if (id.equals("") || merek.equals("") || tipe.equals("") || berat.equals("0") || harga.equals("0")) {
            JOptionPane.showMessageDialog(null, "Isi semua form");
        } else {
            BarangEntity barang = new BarangEntity(id, merek, tipe, Integer.parseInt(berat), Integer.parseInt(harga));
            if (jenis.equals("Makanan")) {
                insertMakanan(barang);
            } else {
                insertMinuman(barang);
            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void makananSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makananSearchActionPerformed
        String cari = tfMakananSearch.getText();
        populateTable("makanan", cari);
    }//GEN-LAST:event_makananSearchActionPerformed

    private void minumanSearrchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minumanSearrchActionPerformed
        String cari = tfMinumanSearch.getText();
        populateTable("minuman", cari);
    }//GEN-LAST:event_minumanSearrchActionPerformed

    private void makananDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makananDeleteActionPerformed
        int rowSelected = tabelMakanan.getSelectedRow();
        String id = makanan.getValueAt(rowSelected, 0).toString();
        int jawaban = JOptionPane.showConfirmDialog(null, "Yakin hapus data: " + id);
        if (jawaban == JOptionPane.YES_OPTION) {
            try {
                boolean status = barang.deleteMakanan(id);
                if (status) {
                    JOptionPane.showMessageDialog(null, "Berhasil dihapus");
                    populateTable();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminMainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_makananDeleteActionPerformed

    private void minumanDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minumanDeleteActionPerformed
        int rowSelected = tabelMinuman.getSelectedRow();
        String id = minuman.getValueAt(rowSelected, 0).toString();
        int jawaban = JOptionPane.showConfirmDialog(null, "Yakin hapus data: " + id);
        if (jawaban == JOptionPane.YES_OPTION) {
            try {
                boolean status = barang.deleteMinuman(id);
                if (status) {
                    JOptionPane.showMessageDialog(null, "Berhasil dihapus");
                    populateTable();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminMainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_minumanDeleteActionPerformed

    private void tabelMakananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMakananMouseClicked
        int rowSelected = tabelMakanan.getSelectedRow();
        String id = makanan.getValueAt(rowSelected, 0).toString();
        String merek = makanan.getValueAt(rowSelected, 1).toString();
        String tipe = makanan.getValueAt(rowSelected, 2).toString();
        int berat = (int) makanan.getValueAt(rowSelected, 3);
        int harga = (int) makanan.getValueAt(rowSelected, 4);
        comboJenis.setSelectedItem("Makanan");
        tfID.setText(id);
        tfID.setEnabled(false);
        tfMerek.setText(merek);
        tfTipe.setText(tipe);
        spinnerBerat.setValue(berat);
        spinnerHarga.setValue(harga);
        btnSubmit.setText("Update");
    }//GEN-LAST:event_tabelMakananMouseClicked

    private void tabelMinumanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMinumanMouseClicked
        int rowSelected = tabelMinuman.getSelectedRow();
        String id = minuman.getValueAt(rowSelected, 0).toString();
        String merek = minuman.getValueAt(rowSelected, 1).toString();
        String tipe = minuman.getValueAt(rowSelected, 2).toString();
        int berat = (int) minuman.getValueAt(rowSelected, 3);
        int harga = (int) minuman.getValueAt(rowSelected, 4);
        comboJenis.setSelectedItem("Minuman");
        tfID.setText(id);
        tfID.setEnabled(false);
        tfMerek.setText(merek);
        tfTipe.setText(tipe);
        spinnerBerat.setValue(berat);
        spinnerHarga.setValue(harga);
        btnSubmit.setText("Update");
    }//GEN-LAST:event_tabelMinumanMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> comboJenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton makananDelete;
    private javax.swing.JButton makananSearch;
    private javax.swing.JButton minumanDelete;
    private javax.swing.JButton minumanSearrch;
    private javax.swing.JSpinner spinnerBerat;
    private javax.swing.JSpinner spinnerHarga;
    private javax.swing.JTable tabelMakanan;
    private javax.swing.JTable tabelMinuman;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfMakananSearch;
    private javax.swing.JTextField tfMerek;
    private javax.swing.JTextField tfMinumanSearch;
    private javax.swing.JTextField tfTipe;
    // End of variables declaration//GEN-END:variables
}
