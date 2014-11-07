/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serial;
import gnu.io.CommPortIdentifier;
import java.util.Enumeration;
/**
 *
 * @author José Luiz
 */
public class SerialCom {
    protected String[] portas;
    protected Enumeration listaDePortas;
    
    public SerialCom(){
        this.listaDePortas = CommPortIdentifier.getPortIdentifiers();
    }
    
    public String[] getPortas(){
        return portas;
    }
    
    protected void listarPortas(){
        int i = 0;
        portas = new String[10];
        while(listaDePortas.hasMoreElements()){
            CommPortIdentifier ips = (CommPortIdentifier)listaDePortas.nextElement();
            portas[i] = ips.getName();
            i++;
        }
    }
    
    public boolean isPorta(String com){
        String temp;
        boolean e = false;
        while (listaDePortas.hasMoreElements()) {
            CommPortIdentifier ips = (CommPortIdentifier)listaDePortas.nextElement();
            temp = ips.getName();
            if (temp.equals(com)== true) {
            e = true;
        }
    }
        return e;

    }
    
}
