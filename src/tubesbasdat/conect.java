/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesbasdat;
import java.sql.*;

public class conect {
    private Connection con ;
    public Connection getConect(){
        try{
            con =  DriverManager.getConnection("jdbc:mysql://localhost/asrama_v4","root","");
        }catch (SQLException err){
            System.out.println(err.getMessage());
        }
        return con;
    }
}
