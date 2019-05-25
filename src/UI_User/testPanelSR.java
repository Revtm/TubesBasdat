/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_User;

import DAO.DAOuser;
import dashboard.menuUtama;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import pengguna.penghuniSR;
import pengguna.user;
import tubesbasdat.conect;

/**
 *
 * @author revan
 */
public class testPanelSR extends javax.swing.JFrame {
 Connection con;
 user pengguna;
    /**
     * Creates new form testPanelSR
     */
    public testPanelSR() {
        conect kon = new conect();
        this.con = kon.getConect();
        
        user penggunaa = new penghuniSR();
        String sql = "select * from penghuni_asrama where id_penghuni = 'SR211170801';";
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                penggunaa.setID(rs.getString("id_penghuni"));
                penggunaa.setNama(rs.getString("nama"));
            }
            
            this.pengguna = penggunaa;
            

        } catch (SQLException ex) {
            Logger.getLogger(testPanelSR.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
        this.panelSR2.setVisible(false);
        
        setLocationRelativeTo(null);
        
    }
    
    public testPanelSR(Connection con, String id) {
       
        this.con = con;
        
        user penggunaa = new penghuniSR();
        String sql = "select * from penghuni_asrama where id_penghuni = '"+id+"';";
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                penggunaa.setID(rs.getString("id_penghuni"));
                penggunaa.setNama(rs.getString("nama"));
            }
            
            DAOuser dao = new DAOuser(this.con, penggunaa);
            
            this.pengguna = dao.getIdentitas(penggunaa.getID());
            //this.pengguna = penggunaa;
            

        } catch (SQLException ex) {
            Logger.getLogger(testPanelSR.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
        this.panelSR2.setVisible(false);
        
        setLocationRelativeTo(null);
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        buttonCari = new javax.swing.JButton();
        buttonMain = new javax.swing.JButton();
        buttonProfil = new javax.swing.JButton();
        buttonLogout = new javax.swing.JButton();
        buttonpaket = new javax.swing.JButton();
        panelSR = new UI_User.panelSR(this.con,this.pengguna);
        panelSR2 = new UI_User.panelCariPenghuni(this.con,this.pengguna);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setOpaque(false);

        buttonCari.setBackground(new java.awt.Color(116, 62, 0));
        buttonCari.setForeground(new java.awt.Color(255, 255, 255));
        buttonCari.setText("cari");
        buttonCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariActionPerformed(evt);
            }
        });

        buttonMain.setBackground(new java.awt.Color(116, 62, 0));
        buttonMain.setForeground(new java.awt.Color(255, 255, 255));
        buttonMain.setText("main menu");
        buttonMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMainActionPerformed(evt);
            }
        });

        buttonProfil.setBackground(new java.awt.Color(116, 62, 0));
        buttonProfil.setForeground(new java.awt.Color(255, 255, 255));
        buttonProfil.setText("profil");
        buttonProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProfilActionPerformed(evt);
            }
        });

        buttonLogout.setBackground(new java.awt.Color(116, 62, 0));
        buttonLogout.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogout.setText("Logout");
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogoutActionPerformed(evt);
            }
        });

        buttonpaket.setBackground(new java.awt.Color(116, 62, 0));
        buttonpaket.setForeground(new java.awt.Color(255, 255, 255));
        buttonpaket.setText("katering");
        buttonpaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonpaketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonProfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonpaket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(buttonMain)
                .addGap(18, 18, 18)
                .addComponent(buttonProfil)
                .addGap(18, 18, 18)
                .addComponent(buttonpaket)
                .addGap(18, 18, 18)
                .addComponent(buttonCari)
                .addGap(18, 18, 18)
                .addComponent(buttonLogout)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelSR, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelSR2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(549, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(panelSR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(panelSR2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(panelSR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(panelSR2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMainActionPerformed
        // TODO add your handling code here:
        this.panelSR.setVisible(true);
        this.panelSR2.setVisible(false);
        this.buttonMain.setBackground(new java.awt.Color(173, 92, 0));
        this.buttonCari.setBackground(new java.awt.Color(116, 62, 0));
    }//GEN-LAST:event_buttonMainActionPerformed

    private void buttonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariActionPerformed
        // TODO add your handling code here:
        this.panelSR.setVisible(false);
        this.panelSR2.setVisible(true);
        this.buttonCari.setBackground(new java.awt.Color(173, 92, 0));
        this.buttonMain.setBackground(new java.awt.Color(116, 62, 0));
    }//GEN-LAST:event_buttonCariActionPerformed

    private void buttonProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProfilActionPerformed
        // TODO add your handling code here:
        
        
         
        
        panelIdentitas idenJR = new panelIdentitas(this.pengguna);
        idenJR.setVisible(true);
    }//GEN-LAST:event_buttonProfilActionPerformed

    private void buttonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogoutActionPerformed
     try {
         // TODO add your handling code here:
         this.con.close();
         dispose();
         
         menuUtama menu= new menuUtama();
         menu.setVisible(true);
         
     } catch (SQLException ex) {
         Logger.getLogger(testPanelSR.class.getName()).log(Level.SEVERE, null, ex);
     }
        
        
    }//GEN-LAST:event_buttonLogoutActionPerformed

    private void buttonpaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonpaketActionPerformed
        // TODO add your handling code here:
        testList_paket paket = new testList_paket(this.con,this.pengguna);
        paket.setVisible(rootPaneCheckingEnabled);
        
        
    }//GEN-LAST:event_buttonpaketActionPerformed

    
    /**
     * @param args the command line arguments173, 92, 0
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
            java.util.logging.Logger.getLogger(testPanelSR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testPanelSR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testPanelSR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testPanelSR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testPanelSR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCari;
    private javax.swing.JButton buttonLogout;
    private javax.swing.JButton buttonMain;
    private javax.swing.JButton buttonProfil;
    private javax.swing.JButton buttonpaket;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private UI_User.panelSR panelSR;
    private UI_User.panelCariPenghuni panelSR2;
    // End of variables declaration//GEN-END:variables
}
