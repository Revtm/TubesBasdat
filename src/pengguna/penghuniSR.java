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
public class penghuniSR extends user {
    String tgl_lahir;
    String JK;
    String no_ruangan;
    String prov; 
    String kota;
    String jalan;
    String id_paket;
    String no_telp_ortu;
    
    public void setTglLahir(String x){
        this.tgl_lahir = x;
    }
    
    public String getTglLahir(){
        return this.tgl_lahir;
    }
    
    public void setJK(String x){
        this.JK = x;
    }
    
    public String getJK(){
        return this.JK;
    }
    
    public void setNoRuang(String x){
        this.no_ruangan = x;
    }
    
    public String getNoRuang(){
        return this.no_ruangan;
    }
    
    public void setProv(String x){
        this.prov = x;
    }
    
    public String getProv(){
        return this.prov;
    }
    
    public void setKota(String x){
        this.kota = x;
    }
    
    public String get(){
        return this.kota;
    }
    
    public void setJalan(String x){
        this.jalan = x;
    }
    
    public String getJalan(){
        return this.jalan;
    }
    
    public void setPaket(String x){
        this.id_paket = x;
    }
    
    public String getPaket(){
        return this.id_paket;
    }
    
    public void setTelpOrtu(String x){
        this.no_telp_ortu = x;
    }
    
    public String getTelpOrtu(){
        return this.no_telp_ortu;
    }
    
}
