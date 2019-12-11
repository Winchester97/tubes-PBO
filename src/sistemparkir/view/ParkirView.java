package sistemparkir.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.EventListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Ammar Amri
 */
public class ParkirView extends javax.swing.JDialog {

    public ParkirView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jenisKendaraan = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        topPaneParkir = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sidePane = new javax.swing.JPanel();
        jButtonKeluar = new javax.swing.JButton();
        jButtonMasuk = new javax.swing.JButton();
        card = new javax.swing.JPanel();
        masukPane = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        noPolMasuk = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        motor = new javax.swing.JRadioButton();
        mobil = new javax.swing.JRadioButton();
        simpanMasuk = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMasuk = new javax.swing.JTable();
        keluarPane = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cariKeluar = new javax.swing.JTextField();
        jBtnCariKeluar = new javax.swing.JButton();
        jTextNopol = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextJenis = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextDurasi = new javax.swing.JTextField();
        jTextBiaya = new javax.swing.JTextField();
        jTextTglJamMasuk = new javax.swing.JTextField();
        jBtnParkirKeluar = new javax.swing.JButton();
        jBtnBersihkan = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableKeluar = new javax.swing.JTable();
        jTextNoTiket = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);

        topPaneParkir.setBackground(new java.awt.Color(0, 0, 203));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PARKIR");

        javax.swing.GroupLayout topPaneParkirLayout = new javax.swing.GroupLayout(topPaneParkir);
        topPaneParkir.setLayout(topPaneParkirLayout);
        topPaneParkirLayout.setHorizontalGroup(
            topPaneParkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPaneParkirLayout.createSequentialGroup()
                .addGap(361, 361, 361)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topPaneParkirLayout.setVerticalGroup(
            topPaneParkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPaneParkirLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidePane.setBackground(new java.awt.Color(204, 204, 255));

        jButtonKeluar.setBackground(new java.awt.Color(204, 204, 255));
        jButtonKeluar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonKeluar.setText("KELUAR");
        jButtonKeluar.setBorderPainted(false);
        jButtonKeluar.setIconTextGap(15);
        jButtonKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKeluarActionPerformed(evt);
            }
        });

        jButtonMasuk.setBackground(new java.awt.Color(204, 204, 255));
        jButtonMasuk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonMasuk.setText("MASUK");
        jButtonMasuk.setBorderPainted(false);
        jButtonMasuk.setIconTextGap(15);

        javax.swing.GroupLayout sidePaneLayout = new javax.swing.GroupLayout(sidePane);
        sidePane.setLayout(sidePaneLayout);
        sidePaneLayout.setHorizontalGroup(
            sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
            .addComponent(jButtonMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidePaneLayout.setVerticalGroup(
            sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePaneLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jButtonMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        card.setBackground(new java.awt.Color(255, 255, 255));
        card.setLayout(new java.awt.CardLayout());

        masukPane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("No. Polisi              :");

        noPolMasuk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        noPolMasuk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noPolMasukKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Jenis Kendaraan  :");

        motor.setBackground(new java.awt.Color(255, 255, 255));
        jenisKendaraan.add(motor);
        motor.setText("Motor");

        mobil.setBackground(new java.awt.Color(255, 255, 255));
        jenisKendaraan.add(mobil);
        mobil.setText("Mobil");

        simpanMasuk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        simpanMasuk.setText("Simpan");

        tableMasuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Tiket", "No Polisi", "Jenis Kendaraan", "Tgl Masuk", "Jam Masuk"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableMasuk);

        javax.swing.GroupLayout masukPaneLayout = new javax.swing.GroupLayout(masukPane);
        masukPane.setLayout(masukPaneLayout);
        masukPaneLayout.setHorizontalGroup(
            masukPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masukPaneLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(masukPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32)
                .addGroup(masukPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, masukPaneLayout.createSequentialGroup()
                        .addComponent(motor)
                        .addGap(18, 18, 18)
                        .addComponent(mobil))
                    .addComponent(noPolMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpanMasuk, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
        );
        masukPaneLayout.setVerticalGroup(
            masukPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masukPaneLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(masukPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(noPolMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(masukPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(motor)
                    .addComponent(mobil))
                .addGap(18, 18, 18)
                .addComponent(simpanMasuk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        card.add(masukPane, "card2");

        keluarPane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("No. Polisi / No. Tiket      :");

        cariKeluar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jBtnCariKeluar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnCariKeluar.setText("CARI");

        jTextNopol.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Jenis Kendaraan : ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("No. Polisi             :");

        jTextJenis.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tgl / jam Masuk : ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Durasi                  : ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Biaya                    :");

        jTextDurasi.setEditable(false);

        jTextBiaya.setEditable(false);

        jTextTglJamMasuk.setEditable(false);

        jBtnParkirKeluar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnParkirKeluar.setText("Parkir Keluar");
        jBtnParkirKeluar.setEnabled(false);

        jBtnBersihkan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnBersihkan.setText("Bersihkan");
        jBtnBersihkan.setEnabled(false);

        tableKeluar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Tiket", "No Polisi", "Jenis Kendaraan", "Tgl Keluar", "Jam Keluar", "Biaya"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableKeluar);

        jTextNoTiket.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("No. Tiket             :");

        javax.swing.GroupLayout keluarPaneLayout = new javax.swing.GroupLayout(keluarPane);
        keluarPane.setLayout(keluarPaneLayout);
        keluarPaneLayout.setHorizontalGroup(
            keluarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keluarPaneLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(keluarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnCariKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(keluarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(keluarPaneLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(26, 26, 26)
                            .addComponent(cariKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(keluarPaneLayout.createSequentialGroup()
                            .addGroup(keluarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(keluarPaneLayout.createSequentialGroup()
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(25, 25, 25)))
                            .addGap(18, 18, 18)
                            .addGroup(keluarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextNopol)
                                .addComponent(jTextJenis, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                .addComponent(jTextDurasi, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                .addComponent(jTextBiaya, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                .addComponent(jTextTglJamMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                .addComponent(jTextNoTiket)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jBtnParkirKeluar)
                .addGap(18, 18, 18)
                .addComponent(jBtnBersihkan)
                .addGap(27, 27, 27))
            .addComponent(jScrollPane3)
        );
        keluarPaneLayout.setVerticalGroup(
            keluarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keluarPaneLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(keluarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cariKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnCariKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(keluarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNoTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(keluarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNopol, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(keluarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, keluarPaneLayout.createSequentialGroup()
                        .addGroup(keluarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(keluarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextTglJamMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(keluarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextDurasi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, keluarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jBtnParkirKeluar)
                        .addComponent(jBtnBersihkan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        card.add(keluarPane, "card3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPaneParkir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(sidePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(card, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(topPaneParkir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void noPolMasukKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noPolMasukKeyTyped
        evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
    }//GEN-LAST:event_noPolMasukKeyTyped

    private void jButtonKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKeluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(ParkirView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParkirView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParkirView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParkirView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParkirView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card;
    private javax.swing.JTextField cariKeluar;
    private javax.swing.JButton jBtnBersihkan;
    private javax.swing.JButton jBtnCariKeluar;
    private javax.swing.JButton jBtnParkirKeluar;
    private javax.swing.JButton jButtonKeluar;
    private javax.swing.JButton jButtonMasuk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextBiaya;
    private javax.swing.JTextField jTextDurasi;
    private javax.swing.JTextField jTextJenis;
    private javax.swing.JTextField jTextNoTiket;
    private javax.swing.JTextField jTextNopol;
    private javax.swing.JTextField jTextTglJamMasuk;
    private javax.swing.ButtonGroup jenisKendaraan;
    private javax.swing.JPanel keluarPane;
    private javax.swing.JPanel masukPane;
    private javax.swing.JRadioButton mobil;
    private javax.swing.JRadioButton motor;
    private javax.swing.JTextField noPolMasuk;
    private javax.swing.JPanel sidePane;
    private javax.swing.JButton simpanMasuk;
    private javax.swing.JTable tableKeluar;
    private javax.swing.JTable tableMasuk;
    private javax.swing.JPanel topPaneParkir;
    // End of variables declaration//GEN-END:variables

    public JButton getjButtonKeluar() {
        return jButtonKeluar;
    }

    public JButton getjButtonMasuk() {
        return jButtonMasuk;
    }

    public JPanel getTopPaneParkir() {
        return topPaneParkir;
    }

    public JPanel getKeluarPane() {
        return keluarPane;
    }

    public JPanel getMasukPane() {
        return masukPane;
    }

    public JTextField getCariKeluar() {
        return cariKeluar;
    }

    public JButton getjBtnBersihkan() {
        return jBtnBersihkan;
    }

    public JButton getjBtnKeluar() {
        return jBtnCariKeluar;
    }

    public JButton getjBtnParkirKeluar() {
        return jBtnParkirKeluar;
    }

    public JTextField getjTextBiaya() {
        return jTextBiaya;
    }

    public JTextField getjTextDurasi() {
        return jTextDurasi;
    }

    public JTextField getjTextJenis() {
        return jTextJenis;
    }

    public JTextField getjTextNopol() {
        return jTextNopol;
    }

    public JTextField getjTextTglJamMasuk() {
        return jTextTglJamMasuk;
    }

    public ButtonGroup getJenisKendaraan() {
        return jenisKendaraan;
    }

    public JTextField getNoPolMasuk() {
        return noPolMasuk;
    }

    public JButton getSimpanMasuk() {
        return simpanMasuk;
    }

    public JTable getTableKeluar() {
        return tableKeluar;
    }

    public JTable getTableMasuk() {
        return tableMasuk;
    }

    public JRadioButton getMobil() {
        return mobil;
    }

    public JRadioButton getMotor() {
        return motor;
    }

    public JTextField getjTextNoTiket() {
        return jTextNoTiket;
    }
    
    public void setListener(EventListener event){
        jButtonMasuk.addActionListener((ActionListener) event);
        jButtonMasuk.addMouseListener((MouseListener) event);
        jButtonKeluar.addActionListener((ActionListener) event);
        jButtonKeluar.addMouseListener((MouseListener) event);
        simpanMasuk.addActionListener((ActionListener) event);
        jBtnCariKeluar.addActionListener((ActionListener) event);
        jBtnParkirKeluar.addActionListener((ActionListener) event);
        jBtnBersihkan.addActionListener((ActionListener) event);
    }
    
     public void setColor(JButton btn)
     {
         btn.setBackground(new java.awt.Color(153,153,255));
     }

     public void resetColor(JButton btn)
     {
         btn.setBackground(new java.awt.Color(204,204,255));
     }
}

