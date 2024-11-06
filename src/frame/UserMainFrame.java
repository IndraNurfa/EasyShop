/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import data.BarangDb;
import data.TransaksiDb;
import entity.BarangEntity;
import entity.DataUserEntity;
import entity.OrderEntity;
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
public class UserMainFrame extends javax.swing.JFrame {

    private final BarangDb barang = new BarangDb();
    private final TransaksiDb keranjang = new TransaksiDb();

    private final DefaultTableModel menu = new DefaultTableModel();
    private final DefaultTableModel order = new DefaultTableModel();
    private final DefaultTableModel history = new DefaultTableModel();

    private final String username = DataUserEntity.getUsername();
    private final String nama = DataUserEntity.getNama();

    public UserMainFrame() {
        initComponents();
        setLocationRelativeTo(this);

        lblNama.setText(nama);

        order.addColumn("Merek");
        order.addColumn("Tipe");
        order.addColumn("Berat");
        order.addColumn("Banyak");
        order.addColumn("Harga");
        tabelOrder.setModel(order);

        history.addColumn("ID");
        history.addColumn("Harga");
        history.addColumn("Waktu");
        tableHistory.setModel(history);

        menu.addColumn("Merek");
        menu.addColumn("Tipe");
        menu.addColumn("Berat");
        menu.addColumn("Harga");
        tabelMenu.setModel(menu);

        tfHarga.setEnabled(false);
        tfTotal.setEnabled(false);

        populateHistory();
    }

    public void populateTable() {
        menu.setRowCount(0);
        String jenis = comboJenis.getSelectedItem().toString();
        if (jenis.equals("Makanan")) {
            try {
                ArrayList<BarangEntity> entityMakanan = barang.getBarangMakanan();
                for (BarangEntity makEn : entityMakanan) {
                    Object[] isiMkn = {makEn.getMerek(), makEn.getTipe(), makEn.getBerat(), makEn.getHarga()};
                    menu.addRow(isiMkn);
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else if (jenis.equals("Minuman")) {
            try {
                ArrayList<BarangEntity> entityMinuman = barang.getBarangMinuman();
                for (BarangEntity minEn : entityMinuman) {
                    Object[] isiMin = {minEn.getMerek(), minEn.getTipe(), minEn.getBerat(), minEn.getHarga()};
                    menu.addRow(isiMin);
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            menu.setRowCount(0);
        }
    }

    public void populateTable(String keyword) {
        menu.setRowCount(0);
        String jenis = comboJenis.getSelectedItem().toString();
        if (jenis.equals("Makanan")) {
            try {
                ArrayList<BarangEntity> entityMakanan = barang.getBarangMakanan(keyword);
                for (BarangEntity makEn : entityMakanan) {
                    Object[] isiMkn = {makEn.getId(), makEn.getMerek(), makEn.getTipe(), makEn.getBerat(), makEn.getHarga()};
                    menu.addRow(isiMkn);
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else if (jenis.equals("Minuman")) {
            try {
                ArrayList<BarangEntity> entityMinuman = barang.getBarangMinuman(keyword);
                for (BarangEntity minEn : entityMinuman) {
                    Object[] isiMin = {minEn.getId(), minEn.getMerek(), minEn.getTipe(), minEn.getBerat(), minEn.getHarga()};
                    menu.addRow(isiMin);
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih Jenis Barang!!!");
        }
    }

    public void populateHistory() {
        history.setRowCount(0);
        try {
            ArrayList<OrderEntity> historyOrder = keranjang.getHistory(username);
            for (OrderEntity oE : historyOrder) {
                Object[] list = {oE.getId(), oE.getTotalHarga(), oE.getWaktu()};
                history.addRow(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getHarga() {
        int rowSelected = tabelMenu.getSelectedRow();
        int hargaSatuan = (int) menu.getValueAt(rowSelected, 3);
        int banyak = (int) spnBanyak.getValue();
        int totalBarang = hargaSatuan * banyak;
        String harga = String.valueOf(totalBarang);
        tfHarga.setText(harga);
    }

    private void getTotalHarga() {
        int harga = 0;
        for (int i = 0; i < tabelOrder.getRowCount(); i++) {
            int hargaSatuan = (int) order.getValueAt(i, 4);
            harga += hargaSatuan;
        }
        String totalHarga = String.valueOf(harga);
        tfTotal.setText(totalHarga);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelMenu = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnSearchBarang = new javax.swing.JButton();
        tfSearchBarang = new javax.swing.JTextField();
        comboJenis = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        tfHarga = new javax.swing.JTextField();
        spnBanyak = new javax.swing.JSpinner();
        btnDetailBarang = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableHistory = new javax.swing.JTable();
        btnDetailHistory = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelOrder = new javax.swing.JTable();
        btnOrder = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        tfTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jButton6.setText("jButton6");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        tabelMenu.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMenuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelMenu);

        jLabel8.setText("Banyak:");

        btnSearchBarang.setText("Search");
        btnSearchBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchBarangActionPerformed(evt);
            }
        });

        comboJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Jenis-", "Makanan", "Minuman" }));
        comboJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboJenisActionPerformed(evt);
            }
        });

        jLabel2.setText("Total: Rp.");

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

        spnBanyak.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnBanyak.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnBanyakStateChanged(evt);
            }
        });

        btnDetailBarang.setText("Detail");
        btnDetailBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailBarangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfSearchBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearchBarang))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(btnSubmit)
                                .addGap(18, 18, 18)
                                .addComponent(btnDetailBarang)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnReset)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchBarang)
                    .addComponent(tfSearchBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnReset)
                    .addComponent(btnDetailBarang))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 3, 1, 2, new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel1.setText("Wellcome,");

        lblNama.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNama, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(lblNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("History"));

        tableHistory.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableHistory);

        btnDetailHistory.setText("Detail");
        btnDetailHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(432, 432, 432)
                .addComponent(btnDetailHistory)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDetailHistory)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Order"));
        jPanel3.setToolTipText("");

        tabelOrder.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelOrder);

        btnOrder.setText("Order");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel3.setText("Total: Rp.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(btnOrder)
                .addGap(18, 18, 18)
                .addComponent(btnHapus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOrder)
                    .addComponent(btnHapus))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboJenisActionPerformed
        populateTable();
    }//GEN-LAST:event_comboJenisActionPerformed

    private void btnSearchBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchBarangActionPerformed
        String keyword = tfSearchBarang.getText();
        populateTable(keyword);
    }//GEN-LAST:event_btnSearchBarangActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        int rowSelected = tabelMenu.getSelectedRow();
        String merek = menu.getValueAt(rowSelected, 0).toString();
        String tipe = menu.getValueAt(rowSelected, 1).toString();
        int berat = (int) menu.getValueAt(rowSelected, 2);
        int hargaSatuan = (int) menu.getValueAt(rowSelected, 3);
        int banyak = (int) spnBanyak.getValue();
        int totalBarang = hargaSatuan * banyak;
        Object[] isiData = {merek, tipe, berat, banyak, totalBarang};
        order.addRow(isiData);
        getTotalHarga();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        menu.setRowCount(0);
        comboJenis.setSelectedIndex(0);
        spnBanyak.setValue(1);
    }//GEN-LAST:event_btnResetActionPerformed

    private void tabelMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMenuMouseClicked
        getHarga();
    }//GEN-LAST:event_tabelMenuMouseClicked

    private void spnBanyakStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnBanyakStateChanged
        int rowSelected = tabelMenu.getSelectedRow();
        if (spnBanyak != null && !spnBanyak.getValue().equals(spnBanyak) && rowSelected < 0) {
            JOptionPane.showMessageDialog(null, "Pilih terlebih dahulu");
        } else {
            getHarga();
        }
    }//GEN-LAST:event_spnBanyakStateChanged

    private void btnDetailBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailBarangActionPerformed
        int rowSelected = tabelMenu.getSelectedRow();
        if (rowSelected > 0) {
            String merek = menu.getValueAt(rowSelected, 0).toString();
            String tipe = menu.getValueAt(rowSelected, 1).toString();
            String berat = menu.getValueAt(rowSelected, 2).toString();
            String hargaSatuan = menu.getValueAt(rowSelected, 3).toString();
            String detail = "Merek: " + merek + "\nTipe: " + tipe + "\nBerat: " + berat + "\nHarga: RP. " + hargaSatuan;
            JOptionPane.showMessageDialog(null, detail);
        } else {
            JOptionPane.showMessageDialog(null, "Pilih terlebih dahulu");
        }
    }//GEN-LAST:event_btnDetailBarangActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int row = tabelOrder.convertRowIndexToModel(tabelOrder.getSelectedRow());
        String merek = menu.getValueAt(row, 0).toString();
        String tipe = menu.getValueAt(row, 1).toString();
        String berat = menu.getValueAt(row, 2).toString();
        String hargaSatuan = menu.getValueAt(row, 3).toString();
        String detail = "Merek: " + merek + "\nTipe: " + tipe + "\nBerat: " + berat + "\nHarga: RP. " + hargaSatuan;
        int jawaban = JOptionPane.showConfirmDialog(null, detail + "\nYakin Dihapus?");
        if (jawaban == JOptionPane.YES_OPTION) {
            order.removeRow(row);
        }
        getTotalHarga();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        String totalHarga = tfTotal.getText();
        OrderEntity oE = new OrderEntity(username, Integer.parseInt(totalHarga));
        try {
            boolean status = keranjang.getStruk(oE);
            if (status) {
                int id = keranjang.getIdStruk(username);
                ArrayList<OrderEntity> troli = new ArrayList<>();
                for (int i = 0; i < tabelOrder.getRowCount(); i++) {
                    int harga = 0;
                    String merek = menu.getValueAt(i, 0).toString();
                    String tipe = menu.getValueAt(i, 1).toString();
                    int berat = (int) order.getValueAt(i, 2);
                    int banyak = (int) order.getValueAt(i, 3);
                    int hargaSatuan = (int) order.getValueAt(i, 4);
                    harga = banyak * hargaSatuan;
                    OrderEntity o = new OrderEntity(id, merek, tipe, berat, banyak, harga);
                    troli.add(o);
                    boolean payment = keranjang.cekPayment(o);
                    if (!payment) {
                        JOptionPane.showMessageDialog(null, "Gagal Check Out Orderan");
                    }
                }
                JOptionPane.showMessageDialog(null, "Berhasil Check Out Orderan");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal Check Out Orderan");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        tfTotal.setText("");
        order.setRowCount(0);
        populateHistory();
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnDetailHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailHistoryActionPerformed
        int rowSelected = tableHistory.getSelectedRow();
        int id = (int) history.getValueAt(rowSelected, 0);
        String waktu = history.getValueAt(rowSelected, 2).toString();
        try {
            ArrayList<OrderEntity> detail = keranjang.getStruk(id);
            int totalBayar = 0;
            String detailStruk = "";
            for (OrderEntity o : detail) {
                String merek = o.getMerek();
                String tipe = o.getTipe();
                String berat = String.valueOf(o.getBerat());
                String banyak = String.valueOf(o.getBanyak());
                String harga = String.valueOf(o.getTotalHarga());
                String strukDetail = "\n" + merek + " " + tipe + " " + berat + " X" + banyak + " " + harga;
                detailStruk += strukDetail;
                int total = o.getTotalHarga();
                totalBayar += total;
            }
            JOptionPane.showMessageDialog(null, "ID: " + id + "\n" + waktu + detailStruk + "\nTotal: Rp." + totalBayar);
        } catch (SQLException ex) {
            Logger.getLogger(UserMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDetailHistoryActionPerformed

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
            java.util.logging.Logger.getLogger(UserMainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetailBarang;
    private javax.swing.JButton btnDetailHistory;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearchBarang;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> comboJenis;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static final javax.swing.JLabel lblNama = new javax.swing.JLabel();
    private javax.swing.JSpinner spnBanyak;
    private javax.swing.JTable tabelMenu;
    private javax.swing.JTable tabelOrder;
    private javax.swing.JTable tableHistory;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfSearchBarang;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
