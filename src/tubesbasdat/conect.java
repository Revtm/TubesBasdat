/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesbasdat;
import java.sql.*;
/**
 *
 * @author Windows 10
 */
public class conect {
    private static Connection con ;
    public static Connection getConect(){
        try{
            con =  DriverManager.getConnection("jdbc:mysql://localhost/asrama","root","");
        }catch (SQLException err){
            System.out.println(err.getMessage());
        }
        return con;
    }
}
