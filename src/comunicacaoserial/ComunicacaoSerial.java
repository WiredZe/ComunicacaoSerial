/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacaoserial;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import serial.SerialCom;
import serial.SerialComLeitura;
/**
 *
 * @author José Luiz
 */
public class ComunicacaoSerial extends SerialCom{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Iniciando leitura serial
        SerialComLeitura leitura = new SerialComLeitura("COM4", 9600, 0);
        leitura.enableRead();
        leitura.getIdDaPorta();
        leitura.openCOMPort();
        leitura.LerDados();
        //Controle de tempo da leitura aberta na serial
        try {
            while(true)
            Thread.sleep(250);

        } catch (InterruptedException ex) {
            System.out.println("Erro na Thread: " + ex);
        }
        leitura.closeCOMPort();
    }
}
    

