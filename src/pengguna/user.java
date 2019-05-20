/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengguna;

/**
 *
 * @author revan
 */
public class user {
   private String id_user;
   private String nama_user;
   private String email;
   private String no_telp;
   
   public void setID(String x){
       this.id_user = x;
   }
   
   public String getID (){
       return this.id_user;
   }
   
   public void setNama(String x){
       this.nama_user = x;
   }
   
   public String getNama (){
       return this.nama_user;
   }
   public void setEmail(String x){
       this.email = x;
   }
   
   public String getEmail (){
       return this.email;
   }
   public void setNoTelp(String x){
       this.no_telp = x;
   }
   
   public String getNoTelp (){
       return this.no_telp;
   }
   
    
}
