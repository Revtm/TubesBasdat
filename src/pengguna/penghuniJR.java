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
public class penghuniJR extends penghuniSR {
    private String id_SR_Pembina;
    
    public void setIDSR (String x){
        this.id_SR_Pembina = x;
    }
    
    public String getIDSR (){
        return this.id_SR_Pembina;
    }
}
