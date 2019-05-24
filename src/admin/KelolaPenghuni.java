/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tubesbasdat.conect;

/**
 *
 * @author #RIGBY MULTIMEDIA
 */
public class KelolaPenghuni extends javax.swing.JFrame {

    /**
     * Creates new form KelolaPenghuni
     */
    
    private DefaultTableModel model;
    Connection con;
    String id_penghuni, nama, tgl_lahir, jenis_kelamin, no_telp, no_ruangan,
           email, prov, kota, jalan, id_sr_pembina;
    
    public KelolaPenghuni() {
        initComponents();
        setLocationRelativeTo(null);
        model = new DefaultTableModel();
        penghuni_asrama.setModel(model);
        model.addColumn("ID Penghuni");
        model.addColumn("Nama");
        model.addColumn("Tanggal Lahir");
        model.addColumn("JK");
        model.addColumn("Telepon");
        model.addColumn("No. Ruangan");
        model.addColumn("Email");
        model.addColumn("Provinsi");
        model.addColumn("Kota");
        model.addColumn("Alamat");
        model.addColumn("ID SR");
        getData();
        
    }
    
    public void getData(){
        conect kon = new conect();
        con = kon.getConect();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            Statement stmt = (Statement) con.createStatement();
            String sql ="SELECT id_penghuni, nama, tgl_lahir, jenis_kelamin, no_telp, no_ruangan, "
                  + "email, prov, kota, jalan, id_sr_pembina FROM penghuni_asrama";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){ 
                Object[] obj = new Object[11];
                obj[0] = rs.getString("id_penghuni");
                obj[1] = rs.getString("nama");
                obj[2] = rs.getString("tgl_lahir");
                obj[3] = rs.getString("jenis_kelamin");
                obj[4] = rs.getString("no_telp");
                obj[5] = rs.getString("no_ruangan");
                obj[6] = rs.getString("email");
                obj[7] = rs.getString("prov");
                obj[8] = rs.getString("kota");
                obj[9] = rs.getString("jalan");
                obj[10] = rs.getString("id_sr_pembina");
                
                model.addRow(obj);
            }
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    
    }
    
    public void loadData(){
        id_penghuni = a.getText(); 
        nama  = b.getText();
        tgl_lahir = c.getText();
        jenis_kelamin = d.getText();
        no_telp = e.getText();
        no_ruangan = f.getText();
        email = g.getText();
        prov = h.getText();
        kota = i.getText();
        jalan = j.getText();
        id_sr_pembina = k.getText();
    }
    
    public void saveData(){
        conect kon = new conect();
        con = kon.getConect();
        loadData();
        
        try{
            Statement stmt = (Statement) con.createStatement();
            String sql = "INSERT INTO penghuni_asrama (id_penghuni, nama, tgl_lahir, jenis_kelamin, no_telp, no_ruangan, email, prov, kota, jalan, id_sr_pembina)"
                         + "VALUES ('" + id_penghuni +"','" + nama + "','" + tgl_lahir + "','" 
                         + jenis_kelamin + "','" + no_telp + "','" + no_ruangan + "','" + email + "','" 
                         + prov + "','" + kota + "','" + jalan + "','" + id_sr_pembina + "')";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.executeUpdate();
            getData();
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void reset(){
        id_penghuni = ""; 
        nama  = "";
        tgl_lahir = "";
        jenis_kelamin = "";
        no_telp = "";
        no_ruangan = "";
        email = "";
        prov = "";
        kota = "";
        jalan = "";
        id_sr_pembina = "";
        
        a.setText(id_penghuni);
        b.setText(nama);
        c.setText(tgl_lahir);
        d.setText(jenis_kelamin);
        e.setText(no_telp);
        f.setText(no_ruangan);
        g.setText(email);
        h.setText(prov);
        i.setText(kota);
        j.setText(jalan);
        k.setText(id_sr_pembina);
    }
    
    public void selectData(){
        
        int z = penghuni_asrama.getSelectedRow();
        if (z == -1){
            //tidak ada baris terpilih
            return ;
        }
        a.setText(""+model.getValueAt(z, 0));
        b.setText(""+model.getValueAt(z, 1));
        c.setText(""+model.getValueAt(z, 2));
        d.setText(""+model.getValueAt(z, 3));
        e.setText(""+model.getValueAt(z, 4));
        f.setText(""+model.getValueAt(z, 5));
        g.setText(""+model.getValueAt(z, 6));
        h.setText(""+model.getValueAt(z, 7));
        i.setText(""+model.getValueAt(z, 8));
        j.setText(""+model.getValueAt(z, 9));
        k.setText(""+model.getValueAt(z, 10));
    }
    
    public void updateData(){
        conect kon = new conect();
        this.con = kon.getConect();
        loadData();
        try{
            Statement stmt = (Statement) con.createStatement();
            String sql = "UPDATE penghuni_asrama SET id_penghuni = '" + id_penghuni + "',"
                                            + "nama = '"+ nama + "',"
                                            + "tgl_lahir = '"+ tgl_lahir + "',"
                                            + "jenis_kelamin = '"+ jenis_kelamin + "',"
                                            + "no_telp = '"+ no_telp + "',"
                                            + "no_ruangan = '"+ no_ruangan + "',"
                                            + "email = '"+ email + "',"
                                            + "prov = '"+ prov + "',"
                                            + "kota = '"+ kota + "',"
                                            + "jalan = '"+ jalan + "',"
                                            + "id_sr_pembina = '" + id_sr_pembina +"' WHERE id_penghuni = '"+id_penghuni+"'";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.executeUpdate();
            getData();
            reset();
            JOptionPane.showMessageDialog(null, "Update Berhasil");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void delete (){
        conect kon = new conect();
        this.con = kon.getConect();
        loadData();
    
        int pesan = JOptionPane.showConfirmDialog(null, "Anda yakin menghapus isi tabel'"+id_penghuni+"'", "Konfirmasi",
        JOptionPane.OK_CANCEL_OPTION);
        if (pesan==JOptionPane.OK_OPTION){
            try{
                Statement stat = (Statement) con.createStatement();
                String sql = "DELETE FROM penghuni_asrama WHERE id_penghuni = '"+ id_penghuni +"'";
                PreparedStatement pstmt =(PreparedStatement) con.prepareStatement(sql);
                pstmt.executeUpdate();
                getData();
                reset();
            
             }catch(SQLException err){
                JOptionPane.showMessageDialog(null, err.getMessage());
             }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        a = new javax.swing.JTextField();
        b = new javax.swing.JTextField();
        c = new javax.swing.JTextField();
        d = new javax.swing.JTextField();
        e = new javax.swing.JTextField();
        f = new javax.swing.JTextField();
        g = new javax.swing.JTextField();
        h = new javax.swing.JTextField();
        i = new javax.swing.JTextField();
        j = new javax.swing.JTextField();
        k = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        penghuni_asrama = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(194, 140, 83));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Data Penghuni");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Penghuni");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jenis Kelamin");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telepon");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("No. Ruangan");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Provinsi");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Kota");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Alamat");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ID SR Pembina");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tanggal Lahir");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));
        jPanel1.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 280, -1));
        jPanel1.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 280, -1));
        jPanel1.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 280, -1));
        jPanel1.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 280, -1));
        jPanel1.add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 280, -1));
        jPanel1.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 280, -1));
        jPanel1.add(g, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 280, -1));
        jPanel1.add(h, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 280, -1));
        jPanel1.add(i, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 280, -1));
        jPanel1.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 280, -1));
        jPanel1.add(k, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 280, -1));

        jButton1.setText("Save");
        jButton1.setPreferredSize(new java.awt.Dimension(67, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        jButton2.setText("Reset");
        jButton2.setPreferredSize(new java.awt.Dimension(67, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, -1, -1));

        jButton3.setText("Delete");
        jButton3.setPreferredSize(new java.awt.Dimension(67, 23));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, -1, -1));

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, -1, -1));

        jButton5.setText("Back");
        jButton5.setPreferredSize(new java.awt.Dimension(67, 23));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 980, 340));

        penghuni_asrama.setModel(new javax.swing.table.DefaultTableModel(
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
        penghuni_asrama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                penghuni_asramaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(penghuni_asrama);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 970, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        saveData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        updateData();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
        HalamanAdmin pageadmin = new HalamanAdmin();
        pageadmin.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void penghuni_asramaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_penghuni_asramaMouseClicked
        // TODO add your handling code here:
        selectData();
    }//GEN-LAST:event_penghuni_asramaMouseClicked

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
            java.util.logging.Logger.getLogger(KelolaPenghuni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KelolaPenghuni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KelolaPenghuni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KelolaPenghuni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KelolaPenghuni().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JTextField b;
    private javax.swing.JTextField c;
    private javax.swing.JTextField d;
    private javax.swing.JTextField e;
    private javax.swing.JTextField f;
    private javax.swing.JTextField g;
    private javax.swing.JTextField h;
    private javax.swing.JTextField i;
    private javax.swing.JTextField j;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField k;
    private javax.swing.JTable penghuni_asrama;
    // End of variables declaration//GEN-END:variables
}
