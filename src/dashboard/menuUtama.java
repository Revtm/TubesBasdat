/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;
import UI_JR.Tampilan_JR1;
import UI_User.testPanelSR;
import java.sql.Connection;
import java.sql.DriverManager;
import tubesbasdat.conect;
import admin.HalamanAdmin;

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
    Connection con;
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
    
    public void tampilan(){
        //model.getDataVector().removeAllElements();
        //model.fireTableDataChanged();
        
        try{
            
            Connection con =  DriverManager.getConnection("jdbc:mysql://localhost/asrama_v4","root","");
            Statement stat =con.createStatement();
            if(status.getSelectedItem()=="Senior"){
                String sql = "SELECT * FROM penghuni_asrama where id_penghuni like 'SR%' and nama like '"+tulis.getText()+"%'";
                ResultSet res = stat.executeQuery(sql);
            
                while(res.next()){
                    Object[] obj = new Object[4];
                    obj[0] = res.getString("nama");
                    obj[1] = res.getString("tgl_lahir");
                    obj[2] = res.getString("jenis_kelamin");
                    obj[3] = res.getString("prov");
                   
                    model.addRow(obj);
                }
            }else if(status.getSelectedItem()=="Junior"){
                String sql = "SELECT * FROM penghuni_asrama where id_penghuni like 'JR%' and nama like '"+tulis.getText()+"%'";
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
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        u = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        p = new javax.swing.JPasswordField();
        tulis = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cari = new javax.swing.JButton();
        status = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelASM = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Utama");
        setPreferredSize(new java.awt.Dimension(810, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));
        getContentPane().add(u, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 150, -1));

        login.setText("login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, -1, -1));
        getContentPane().add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 160, -1));
        getContentPane().add(tulis, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 344, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cari Nama Penghuni");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 130, 20));

        cari.setText("Cari");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        getContentPane().add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, -1, 20));

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 100, -1));
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 440, 150));

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
        conect kon = new conect();
        this.con=kon.getConect();
        
        try{
            Statement stat=this.con.createStatement();
            String sql_1 = "select * from akun where id_akun ='"+u.getText()
                    +"' and password ='"+p.getText()+"'";
            ResultSet rset= stat.executeQuery(sql_1);
                   
            if (rset.next()){
                if(u.getText().contains("SR")){
                    dispose();
                testPanelSR test = new testPanelSR();
                test.setVisible(true);
                }else if(u.getText().contains("JR")){
                    dispose();
                Tampilan_JR1 test = new Tampilan_JR1(con, u.getText()); 
                test.setVisible(true);
                }else if(u.getText().contains("AD")){
                    dispose();
                HalamanAdmin test = new HalamanAdmin(u.getText());
                test.setVisible(true);
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Maaf Password Atau Username Salah");
            }
        }catch(SQLException er){
            JOptionPane.showMessageDialog(null, er.getMessage());
        }
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField p;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextField tulis;
    private javax.swing.JTextField u;
    // End of variables declaration//GEN-END:variables
}
