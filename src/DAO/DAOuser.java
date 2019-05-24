/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import pengguna.penghuniSR;
import pengguna.user;

/**
 *
 * @author revan
 */
public class DAOuser {
    Connection con;
    user Pengguna; 
    
    public DAOuser(Connection con, user pengguna){
        this.con = con;
        this.Pengguna = pengguna;
    }
    
    public ResultSet tampilTutorialSR(){
        String sql = "select * from kelastutor where id_sr_tutor='"+this.Pengguna.getID()+"';";
        
        Statement stmt;
        ResultSet rs = null;
        try {
            stmt = this.con.createStatement();
            rs = stmt.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOuser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    private ArrayList<String> getPenyakit(String id){
        ArrayList<String> penghuni = new ArrayList();
        
        String sql = "select penyakit from riwayat_penyakit_Penghuni where id = '"+id +"';";
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                penghuni.add(rs.getString("penyakit"));
            }
            
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOuser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return penghuni;
    }
    
    public HashMap tampilBinaanSR(){
        String sql = "select * from Penghuni_Asrama where id_sr_pembina='"+this.Pengguna.getID()+"';";
        String sql2;
        
        Statement stmt,stmt2;
        ResultSet rs;
        HashMap <String ,user> all_penghuni= new HashMap();
                
        user penghuni;
        
        try {
            stmt = this.con.createStatement();

            rs = stmt.executeQuery(sql);
            while(rs.next()){
                penghuni = new penghuniSR();
                
                penghuni.setNama(rs.getString("nama"));
                penghuni.setID(rs.getString("id_penghuni"));
                ((penghuniSR)penghuni).setPenyakit(this.getPenyakit(penghuni.getID()));               
                penghuni.setEmail(rs.getString("email"));
                penghuni.setNoTelp(rs.getString("no_telp"));
                ((penghuniSR)penghuni).setJK(rs.getString("Jenis_kelamin"));
                ((penghuniSR)penghuni).setJalan(rs.getString("jalan"));
                ((penghuniSR)penghuni).setKota(rs.getString("kota"));
                ((penghuniSR)penghuni).setProv(rs.getString("prov"));
                ((penghuniSR)penghuni).setTglLahir(rs.getString("tgl_lahir"));
                ((penghuniSR)penghuni).setNoRuang(rs.getString("no_ruangan"));
                
                all_penghuni.put(penghuni.getID(),penghuni);
                
            }
            
            stmt.close();
             
             
        } catch (SQLException ex) {
            Logger.getLogger(DAOuser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return all_penghuni;
    }
    
    public ResultSet cariPenghuniAdv(String cari){
        String sql = "select id_penghuni,nama,no_ruangan from Penghuni_Asrama where nama like '%"+cari+"%' OR id_penghuni like '%"+cari+"%';";
        
        Statement stmt;
        ResultSet rs = null;
        try {
            stmt = this.con.createStatement();
            rs = stmt.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOuser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
    }
}
