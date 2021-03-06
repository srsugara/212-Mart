/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.KelolaBarang;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Barang;

/**
 *
 * @author Syauqi Rahmat Sugara
 */
public class UbahBarangForm extends javax.swing.JDialog {

    /**
     * Creates new form KelolaBarangForm
     */
    private final KelolaBarang dbKB = new KelolaBarang();
    public String idLama;

    public UbahBarangForm(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kodeText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        namaText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        hargaText = new javax.swing.JTextField();
        prosesUbah = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        stokText = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(52, 73, 94));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("212 MART");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel1)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Kode");

        kodeText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nama");

        namaText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Harga");

        hargaText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        prosesUbah.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        prosesUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/pin-sketch.png"))); // NOI18N
        prosesUbah.setText("Ubah");
        prosesUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosesUbahActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Stok");

        stokText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/home-sketch.png"))); // NOI18N
        menu.setText("Menu Utama");
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(prosesUbah, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kodeText, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(namaText)
                            .addComponent(hargaText)
                            .addComponent(stokText, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kodeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(namaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stokText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addComponent(prosesUbah)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(408, 402));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new MenuUtamaForm().setVisible(true);
    }//GEN-LAST:event_menuMouseClicked

    private void prosesUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosesUbahActionPerformed
        // TODO add your handling code here:
        Barang barang = new Barang();
        String kode = kodeText.getText();
        String nama = namaText.getText();
        String harga = hargaText.getText();
        String stok = stokText.getText();

        try {
            if (!kode.isEmpty() && !nama.isEmpty() && !harga.isEmpty() && !stok.isEmpty()) {
                if (harga.matches("[0-9]*") && stok.matches("[0-9]*")) {

                    if (dbKB.getCountBarang(kode) <= 1) {
                        barang.setId(kode);
                        barang.setNama(nama);
                        barang.setHarga(Integer.parseInt(harga));
                        barang.setStok(Integer.parseInt(stok));
                        if (idLama.equals(kode)) {
                            dbKB.ubahBarang(idLama, barang.getId(), barang.getNama(), barang.getHarga(), barang.getStok());
                            DaftarBarangForm daftarBarang = new DaftarBarangForm(this, true);
                            this.dispose();
                            daftarBarang.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Kode barang tidak boleh duplikat");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Kode barang tidak boleh duplikat");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Harga atau stok harus format angka");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak boleh kosong");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UbahBarangForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_prosesUbahActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField hargaText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField kodeText;
    private javax.swing.JMenu menu;
    public javax.swing.JTextField namaText;
    private javax.swing.JButton prosesUbah;
    public javax.swing.JTextField stokText;
    // End of variables declaration//GEN-END:variables
}
