/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.util.ArrayList;
import pengguna.penghuniSR;
import pengguna.user;
import tubesbasdat.conect;

/**
 *
 * @author revan
 */
public class testDAO {
    public static void main(String[] args) {
        conect kon = new conect();
        Connection con = kon.getConect();
        
        user pengguna = new user();
        pengguna.setID("SR211170801");
        
        
        DAOuser dao = new DAOuser(con, pengguna);
        
        ArrayList <user> p = new ArrayList();
        
        p = dao.tampilBinaanSR();
       
        for(user x : p){
            System.out.println(x.getNama());
            System.out.println(((penghuniSR)x).getPenyakit());
        }
    }
}
