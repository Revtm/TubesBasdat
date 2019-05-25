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
    
    private DefaultTableModel model, model1, model2;
    Connection con;
    String id_penghuni, nama, tgl_lahir, jenis_kelamin, no_telp, no_ruangan,
           email, prov, kota, jalan, id_paket, id_sr_pembina;
    String id_akun, password, jenis;
    String id_jr, id_tutor;
    String id_admin;
    
    public KelolaPenghuni(){
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public KelolaPenghuni(String id) {
        initComponents();
        setLocationRelativeTo(null);
        
        conect kon = new conect();
        con = kon.getConect();
        
        model = new DefaultTableModel();
        model1 = new DefaultTableModel();
        model2 = new DefaultTableModel();
        
        penghuni_asrama.setModel(model);
        akun.setModel(model1);
        belajar.setModel(model2);
        
        try{
            Statement stmt = (Statement) con.createStatement();
            String sql ="SELECT id_admin FROM admin WHERE id_admin = '" + id +"';";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                this.jLabel14.setText(rs.getString("id_admin"));
            }
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        
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
        model.addColumn("ID Paket");
        model.addColumn("ID SR");
        getData();
        
        model1.addColumn("ID Akun");
        model1.addColumn("Password");
        model1.addColumn("Jenis");
        getData1();
        
        model2.addColumn("ID Jr");
        model2.addColumn("ID Tutor");
        getData2();
    }
    
    private void getData(){
        conect kon = new conect();
        con = kon.getConect();
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            Statement stmt = (Statement) con.createStatement();
            String sql ="SELECT * FROM penghuni_asrama WHERE id_penghuni LIKE 'JR%';";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){ 
                Object[] obj = new Object[12];
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
                obj[10] = rs.getString("id_paket");
                obj[11] = rs.getString("id_sr_pembina");
                
                model.addRow(obj);
            }
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    
    }
    
    private void getData1(){
        conect kon = new conect();
        con = kon.getConect();
        
        model1.getDataVector().removeAllElements();
        model1.fireTableDataChanged();
        
        try{
            Statement stmt = (Statement) con.createStatement();
            String sql ="SELECT * FROM akun WHERE id_akun LIKE 'JR%';";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){ 
                Object[] obj = new Object[3];
                obj[0] = rs.getString("id_akun");
                obj[1] = rs.getString("password");
                obj[2] = rs.getString("jenis");

                model1.addRow(obj);
            }
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    
    }
    
    private void getData2(){
        conect kon = new conect();
        con = kon.getConect();
        
        model2.getDataVector().removeAllElements();
        model2.fireTableDataChanged();
        
        try{
            Statement stmt = (Statement) con.createStatement();
            String sql ="SELECT * FROM belajar;";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){ 
                Object[] obj = new Object[2];
                obj[0] = rs.getString("id_jr");
                obj[1] = rs.getString("id_tutor");

                model2.addRow(obj);
            }
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    
    }
    
    private void loadData(){
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
        id_paket = k.getText();
        id_sr_pembina = l.getText();
    }
    
    private void loadData1(){
        id_akun = m.getText(); 
        password  = n.getText();
        jenis = o.getText();
    }
    
    private void loadData2(){
        id_jr = p.getText(); 
        id_tutor  = q.getText();
    }
    
    private void saveData(){
        conect kon = new conect();
        con = kon.getConect();
        loadData();
        
        try{
            Statement stmt = (Statement) con.createStatement();
            String sql = "INSERT INTO penghuni_asrama "
                         + "VALUES ('" + id_penghuni +"','" + nama + "','" + tgl_lahir + "','" 
                         + jenis_kelamin + "','" + no_telp + "','" + no_ruangan + "','" + email + "','" 
                         + prov + "','" + kota + "','" + jalan + "','" + id_paket + "','"+ id_sr_pembina + "');";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.executeUpdate();
            getData();
            reset();
            JOptionPane.showMessageDialog(null, "Penambahan Data Berhasil");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    private void saveData1(){
        conect kon = new conect();
        con = kon.getConect();
        loadData1();
        
        try{
            Statement stmt = (Statement) con.createStatement();
            String sql = "INSERT INTO akun "
                         + "VALUES ('" + id_akun +"','" + password + "','" + jenis + "');";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.executeUpdate();
            getData1();
            reset1();
            JOptionPane.showMessageDialog(null, "Penambahan Data Berhasil");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    private void saveData2(){
        conect kon = new conect();
        con = kon.getConect();
        loadData2();
        
        try{
            Statement stmt = (Statement) con.createStatement();
            String sql = "INSERT INTO belajar "
                         + "VALUES ('" + id_jr + "','" + id_tutor + "');";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.executeUpdate();
            getData2();
            reset2();
            JOptionPane.showMessageDialog(null, "Penambahan Data Berhasil");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    private void reset(){
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
        id_paket = "";
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
        k.setText(id_paket);
        l.setText(id_sr_pembina);
    }
    
    private void reset1(){
        id_akun = "";
        password = "";
        jenis = "";
        
        id_jr = "";
        id_tutor = "";
        
        m.setText(id_akun);
        n.setText(password);
        o.setText(jenis);
        
        p.setText(id_jr);
        q.setText(id_tutor);
    }
    
    private void reset2(){
        id_jr = "";
        id_tutor = "";
        
        p.setText(id_jr);
        q.setText(id_tutor);
    }
    
    private void selectData(){
        
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
        l.setText(""+model.getValueAt(z, 11));
    }
    
    private void selectData1(){
        
        int z = akun.getSelectedRow();
        if (z == -1){
            //tidak ada baris terpilih
            return ;
        }
        m.setText(""+model1.getValueAt(z, 0));
        n.setText(""+model1.getValueAt(z, 1));
        o.setText(""+model1.getValueAt(z, 2));
    }
    
    private void selectData2(){
        
        int z = belajar.getSelectedRow();
        if (z == -1){
            //tidak ada baris terpilih
            return ;
        }
        p.setText(""+model2.getValueAt(z, 0));
        q.setText(""+model2.getValueAt(z, 1));
    }
    
    private void updateData(){
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
                                            + "id_paket = '"+ id_paket + "',"
                                            + "id_sr_pembina = '" + id_sr_pembina +"' WHERE id_penghuni = '"+id_penghuni+"';";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.executeUpdate();
            getData();
            reset();
            JOptionPane.showMessageDialog(null, "Update Berhasil");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    private void updateData1(){
        conect kon = new conect();
        this.con = kon.getConect();
        loadData1();
        try{
            Statement stmt = (Statement) con.createStatement();
            String sql = "UPDATE akun SET id_akun = '" + id_akun + "',"
                                            + "password = '"+ password + "',"
                                            + "jenis = '" + jenis +"' WHERE id_akun = '"+id_akun+"';";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.executeUpdate();
            getData1();
            reset1();
            JOptionPane.showMessageDialog(null, "Update Berhasil");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    private void updateData2(){
        conect kon = new conect();
        this.con = kon.getConect();
        loadData2();
        try{
            Statement stmt = (Statement) con.createStatement();
            String sql = "UPDATE belajar SET id_jr = '" + id_jr + "',"
                                            + "id_tutor = '" + id_tutor +"' WHERE id_jr = '"+id_jr+"';";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.executeUpdate();
            getData2();
            reset2();
            JOptionPane.showMessageDialog(null, "Update Berhasil");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    private void delete (){
        conect kon = new conect();
        this.con = kon.getConect();
        loadData();
    
        int pesan = JOptionPane.showConfirmDialog(null, "Anda yakin menghapus isi tabel'"+id_penghuni+"'", "Konfirmasi",
        JOptionPane.OK_CANCEL_OPTION);
        if (pesan==JOptionPane.OK_OPTION){
            try{
                Statement stat = (Statement) con.createStatement();
                String sql = "DELETE FROM penghuni_asrama WHERE id_penghuni = '"+ id_penghuni +"';";
                PreparedStatement pstmt =(PreparedStatement) con.prepareStatement(sql);
                pstmt.executeUpdate();
                getData();
                reset();
                JOptionPane.showMessageDialog(null, "Delete Berhasil");
             }catch(SQLException err){
                JOptionPane.showMessageDialog(null, err.getMessage());
             }
        }
        
    }
    
    private void delete1(){
        conect kon = new conect();
        this.con = kon.getConect();
        loadData1();
    
        int pesan = JOptionPane.showConfirmDialog(null, "Anda yakin menghapus isi tabel'"+id_akun+"'", "Konfirmasi",
        JOptionPane.OK_CANCEL_OPTION);
        if (pesan==JOptionPane.OK_OPTION){
            try{
                Statement stat = (Statement) con.createStatement();
                String sql = "DELETE FROM akun WHERE id_akun = '"+ id_akun +"';";
                PreparedStatement pstmt =(PreparedStatement) con.prepareStatement(sql);
                pstmt.executeUpdate();
                getData1();
                reset1();
                JOptionPane.showMessageDialog(null, "Delete Berhasil");
             }catch(SQLException err){
                JOptionPane.showMessageDialog(null, err.getMessage());
             }
        }
        
    }
    
    private void delete2(){
        conect kon = new conect();
        this.con = kon.getConect();
        loadData2();
    
        int pesan = JOptionPane.showConfirmDialog(null, "Anda yakin menghapus isi tabel'"+id_jr+"'", "Konfirmasi",
        JOptionPane.OK_CANCEL_OPTION);
        if (pesan==JOptionPane.OK_OPTION){
            try{
                Statement stat = (Statement) con.createStatement();
                String sql = "DELETE FROM belajar WHERE id_jr = '"+ id_jr +"';";
                PreparedStatement pstmt =(PreparedStatement) con.prepareStatement(sql);
                pstmt.executeUpdate();
                getData2();
                reset2();
                JOptionPane.showMessageDialog(null, "Delete Berhasil");
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
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
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
        l = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        m = new javax.swing.JTextField();
        n = new javax.swing.JTextField();
        o = new javax.swing.JTextField();
        p = new javax.swing.JTextField();
        q = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        akun = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        belajar = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        penghuni_asrama = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(194, 140, 83));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Penghuni");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jenis Kelamin");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telp Ortu");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("No. Ruangan");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Provinsi");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Kota");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Alamat");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ID SR Pembina");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tanggal Lahir");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ID Paket");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, -1, -1));

        jLabel14.setForeground(new java.awt.Color(194, 140, 83));
        jLabel14.setText("jLabel14");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));
        jPanel1.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 280, -1));
        jPanel1.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 280, -1));
        jPanel1.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 280, -1));
        jPanel1.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 280, -1));
        jPanel1.add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 280, -1));
        jPanel1.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 280, -1));
        jPanel1.add(g, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 280, -1));
        jPanel1.add(h, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 280, -1));
        jPanel1.add(i, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 280, -1));
        jPanel1.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 280, -1));
        jPanel1.add(k, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 280, -1));
        jPanel1.add(l, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 280, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ID Akun");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Password");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Jenis");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("ID JR");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("ID Tutor");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Isi Data Penghuni");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Isi Data Akun");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Isi Data Tutor");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));
        jPanel1.add(m, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 280, -1));
        jPanel1.add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 280, -1));
        jPanel1.add(o, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 280, -1));
        jPanel1.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 280, -1));
        jPanel1.add(q, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 280, -1));

        jButton2.setText("Reset");
        jButton2.setPreferredSize(new java.awt.Dimension(67, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, -1, -1));

        jButton5.setText("Back");
        jButton5.setPreferredSize(new java.awt.Dimension(67, 23));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 390, -1, -1));

        jButton8.setText("Save");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        jButton13.setText("Update");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, -1));

        jButton14.setText("Delete");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        jButton9.setText("Save");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, -1, -1));

        jButton15.setText("Delete");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, -1, -1));

        jButton16.setText("Update");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, -1, -1));

        jButton10.setText("Save");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, -1, -1));

        jButton17.setText("Delete");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, -1, -1));

        jButton18.setText("Update");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 980, 420));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Kelola Penghuni Junior Asrama");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, -1));

        akun.setModel(new javax.swing.table.DefaultTableModel(
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
        akun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                akunMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(akun);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 380, 100));

        belajar.setModel(new javax.swing.table.DefaultTableModel(
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
        belajar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                belajarMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(belajar);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, 100));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 970, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        reset();
        reset1();
        reset2();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
        HalamanAdmin pageadmin = new HalamanAdmin(jLabel14.getText());
        pageadmin.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void penghuni_asramaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_penghuni_asramaMouseClicked
        // TODO add your handling code here:
        selectData();
    }//GEN-LAST:event_penghuni_asramaMouseClicked

    private void akunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_akunMouseClicked
        // TODO add your handling code here:
        selectData1();
    }//GEN-LAST:event_akunMouseClicked

    private void belajarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_belajarMouseClicked
        // TODO add your handling code here:
        selectData2();
    }//GEN-LAST:event_belajarMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        saveData1();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        updateData1();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        delete1();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        saveData2();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        delete2();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        updateData2();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        saveData();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        updateData();
    }//GEN-LAST:event_jButton18ActionPerformed

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
    private javax.swing.JTable akun;
    private javax.swing.JTextField b;
    private javax.swing.JTable belajar;
    private javax.swing.JTextField c;
    private javax.swing.JTextField d;
    private javax.swing.JTextField e;
    private javax.swing.JTextField f;
    private javax.swing.JTextField g;
    private javax.swing.JTextField h;
    private javax.swing.JTextField i;
    private javax.swing.JTextField j;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField k;
    private javax.swing.JTextField l;
    private javax.swing.JTextField m;
    private javax.swing.JTextField n;
    private javax.swing.JTextField o;
    private javax.swing.JTextField p;
    private javax.swing.JTable penghuni_asrama;
    private javax.swing.JTextField q;
    // End of variables declaration//GEN-END:variables
}
