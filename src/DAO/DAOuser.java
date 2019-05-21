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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public ResultSet tampilBinaanSR(){
        String sql = "select * from Penghuni_Asrama where id_sr_pembina='"+this.Pengguna.getID()+"';";
        
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
