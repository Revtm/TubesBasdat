/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_User;

import DAO.DAOuser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pengguna.user;

/**
 *
 * @author revan
 */
public class panelSR2 extends javax.swing.JPanel {
    Connection con;
    user pengguna;
    /**
     * Creates new form panelSR
     */
    public panelSR2() {
        
        initComponents();
    }
    
    public panelSR2(Connection con, user pengguna) {
        this.con = con;
        this.pengguna = pengguna;
        initComponents();
        this.buttonCari.setVisible(false);
        this.labelNama.setText(this.pengguna.getNama());
        this.labelNIM.setText(this.pengguna.getID());
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
        labelNIM = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        buttonCari = new javax.swing.JButton();
        fieldCari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCari = new javax.swing.JTable();
        labelCari = new javax.swing.JLabel();
        labelCariPenghuni = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(720, 560));
        setPreferredSize(new java.awt.Dimension(720, 560));

        jPanel1.setBackground(new java.awt.Color(194, 140, 83));
        jPanel1.setMaximumSize(new java.awt.Dimension(190, 32767));
        jPanel1.setMinimumSize(new java.awt.Dimension(190, 322));

        labelNIM.setForeground(new java.awt.Color(255, 255, 255));
        labelNIM.setText("NIM");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Teknik Informatika");

        labelNama.setForeground(new java.awt.Color(255, 255, 255));
        labelNama.setText("M Iqbal Revantama");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNIM)
                    .addComponent(jLabel6)
                    .addComponent(labelNama))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(labelNama)
                .addGap(18, 18, 18)
                .addComponent(labelNIM)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(548, 560));

        buttonCari.setText("Cari");
        buttonCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariActionPerformed(evt);
            }
        });

        fieldCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariKeyReleased(evt);
            }
        });

        tableCari.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIM", "Nama", "Kamar"
            }
        ));
        tableCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCariMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableCari);

        labelCari.setText("Hasil Pencarian");

        labelCariPenghuni.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelCariPenghuni.setForeground(new java.awt.Color(116, 62, 0));
        labelCariPenghuni.setText("Cari Penghuni");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCariPenghuni)
                    .addComponent(labelCari)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCari, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(labelCariPenghuni)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCari))
                .addGap(28, 28, 28)
                .addComponent(labelCari)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariActionPerformed
        // TODO add your handling code here:
        DAOuser dao = new DAOuser(this.con, this.pengguna);
        ResultSet rs = dao.cariPenghuniAdv(this.fieldCari.getText());
        
        DefaultTableModel model= (DefaultTableModel) this.tableCari.getModel();
        model.setRowCount(0);
        try {
            while(rs.next()){
                Object[]obj ={rs.getString("id_penghuni"), rs.getString("nama"), rs.getString("no_ruangan")};
                
                model.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(panelSR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonCariActionPerformed

    private void tableCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCariMouseClicked
        // TODO add your handling code here:
        JTable source = (JTable)evt.getSource();
        int baris = source.rowAtPoint( evt.getPoint() );
        String getKlik=source.getModel().getValueAt(baris, 0).toString();
    }//GEN-LAST:event_tableCariMouseClicked

    private void fieldCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariKeyReleased
        // TODO add your handling code here:
        DefaultTableModel model= (DefaultTableModel) this.tableCari.getModel();
        if(this.fieldCari.getText().isEmpty()){
            model.setRowCount(0);
        }else{
            DAOuser dao = new DAOuser(this.con, this.pengguna);
            ResultSet rs = dao.cariPenghuniAdv(this.fieldCari.getText());

           
            model.setRowCount(0);
            try {
                while(rs.next()){
                    Object[]obj ={rs.getString("id_penghuni"), rs.getString("nama"), rs.getString("no_ruangan")};

                    model.addRow(obj);
                }
            } catch (SQLException ex) {
                Logger.getLogger(panelSR.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_fieldCariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCari;
    private javax.swing.JTextField fieldCari;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCari;
    private javax.swing.JLabel labelCariPenghuni;
    private javax.swing.JLabel labelNIM;
    private javax.swing.JLabel labelNama;
    private javax.swing.JTable tableCari;
    // End of variables declaration//GEN-END:variables
}
