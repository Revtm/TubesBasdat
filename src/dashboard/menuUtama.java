/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;
import java.sql.Connection;
import java.sql.DriverManager;
import tubesbasdat.conect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.*;
/**
 *
 * @author Windows 10
 */
public class menuUtama extends javax.swing.JFrame {
    DefaultTableModel model;
    String Stat;
    /**
     * Creates new form menuUtama
     */
    public menuUtama() {
        initComponents();
        setLocationRelativeTo(null);
        
        model = new DefaultTableModel();
        TabelASM.setModel(model);
        model.addColumn("Nama");
        model.addColumn("TTL");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Asal");
        status.removeAllItems();
        status.addItem("--Pangkat--");
        status.addItem("Junior");
        status.addItem("Senior");
        
       // status.requestFocus();
    }
    
    public   void tampilan(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            
            Connection con =  DriverManager.getConnection("jdbc:mysql://localhost/asrama","root","");
            Statement stat =con.createStatement();
            if(status.getSelectedItem()=="Senior"||status.getSelectedItem()=="Junior"){
                String sql = "SELECT * FROM "+getStat()+" where nama like '"+tulis.getText()+"%'";
                ResultSet res = stat.executeQuery(sql);
            
                while(res.next()){
                    Object[] obj = new Object[4];
                    obj[0] = res.getString("nama");
                    obj[1] = res.getString("tgl_lahir");
                    obj[2] = res.getString("jenis_kelamin");
                    obj[3] = res.getString("prov");
                   
                    model.addRow(obj);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Anda Belum Menentukan Jenis Pangkat");
            }   
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public String getStat(){
       
         if(status.getSelectedItem()=="Junior"){
            Stat="jr_asrama";
        }else if(status.getSelectedItem()=="Senior"){
            Stat="sr_asrama";
        }   
         return Stat;
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tulis = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cari = new javax.swing.JButton();
        status = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelASM = new javax.swing.JTable();
        login = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(tulis, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 344, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cari Nama Penghuni");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 130, 20));

        cari.setText("Cari");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        getContentPane().add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, -1, 20));

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 240, 100, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 310, -1, -1));

        TabelASM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TabelASM);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 440, 150));

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/asrama.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 870, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
        tampilan();
        tulis.setText("");
        TabelASM.show();
    }//GEN-LAST:event_cariActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_statusActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        //dispose();
        new login().show();
    }//GEN-LAST:event_loginActionPerformed

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
            java.util.logging.Logger.getLogger(menuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelASM;
    private javax.swing.JButton cari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton login;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextField tulis;
    // End of variables declaration//GEN-END:variables
}
