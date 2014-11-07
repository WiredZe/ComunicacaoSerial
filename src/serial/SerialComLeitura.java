/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serial;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author José Luiz
 */
public class SerialComLeitura implements Runnable, SerialPortEventListener{
    public String dadosLidos;
    public int nodeBytes;
    private int baudrate;
    private int timeout;
    private CommPortIdentifier cp;
    private SerialPort porta;
    private OutputStream saida;
    private InputStream entrada;
    private Thread threadLeitura;
    private boolean IDPortaOK;
    private boolean PortaOK;
    private boolean Leitura;
    private boolean Escrita;
    private String Porta;
    protected String peso;
    
    private int novoDado;

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public SerialComLeitura(String Porta, int baudrate, int timeout) {
        this.baudrate = baudrate;
        this.timeout = timeout;
        this.Porta = Porta;
    }
    
    public void enableWrite(){
        this.Escrita = true;
        this.Leitura = false;
    }
    
    public void enableRead(){
        this.Escrita = false;
        this.Leitura = true;
    }
    
    public void getIdDaPorta(){
        try {
            cp = CommPortIdentifier.getPortIdentifier(Porta);
            if ( cp == null ) {
                System.out.println("Erro na porta");
                IDPortaOK = false;
                System.exit(1);
            }
            IDPortaOK = true;
        } catch (Exception e) {
            System.out.println("Erro obtendo ID da porta: " + e);
            IDPortaOK = false;
            System.exit(1);
        }
    }
    
    public void openCOMPort(){
        try {
            porta = (SerialPort)cp.open("SerialComLeitura", timeout);
            PortaOK = true;
            //configurar parâmetros
            porta.setSerialPortParams(baudrate,
            porta.DATABITS_8,
            porta.STOPBITS_1,
            porta.PARITY_NONE);
            porta.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
        }catch(Exception e){
            PortaOK = false;
            System.out.println("Erro abrindo comunicação: " + e);
            System.exit(1);
        }
    }

    public void LerDados(){
        if (Escrita == false){
            try {
                entrada = porta.getInputStream();

            } catch (Exception e) {
                System.out.println("Erro de stream: " + e);
                System.exit(1);
            }
            try {
                porta.addEventListener(this);

            } catch (Exception e) {
                System.out.println("Erro de listener: " + e);
                System.exit(1);
            }
            porta.notifyOnDataAvailable(true);
            try {
                threadLeitura = new Thread(this);
                threadLeitura.start();
               run();

            } catch (Exception e) {
                System.out.println("Erro de Thred: " + e);
            }
        }
    }
    
    public void EnviarUmaString(String msg){
        if (Escrita==true) {
            try {
                saida = porta.getOutputStream();
                System.out.println("FLUXO OK!");
            } catch (Exception e) {
                System.out.println("Erro.STATUS: " + e );
            }
            try {
                System.out.println("Enviando um byte para " + Porta );
                System.out.println("Enviando : " + msg );
                saida.write(msg.getBytes());
                Thread.sleep(100);
                saida.flush();
            } catch (Exception e) {
                System.out.println("Houve um erro durante o envio. ");
                System.out.println("STATUS: " + e );
                System.exit(1);
            }
        } else {
            System.exit(1);
        }
    }
    
    @Override
    public void run(){
        try {
            Thread.sleep(5);
        } catch (Exception e) {
            System.out.println("Erro de Thred: " + e);
        }
    }

    @Override
    public void serialEvent(SerialPortEvent ev){       
        StringBuffer bufferLeitura = new StringBuffer();
        novoDado = 0;
        switch (ev.getEventType()) {
            case SerialPortEvent.BI:
            case SerialPortEvent.OE:
            case SerialPortEvent.FE:
            case SerialPortEvent.PE:
            case SerialPortEvent.CD:
            case SerialPortEvent.CTS:
            case SerialPortEvent.DSR:
            case SerialPortEvent.RI:
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
            break;
            case SerialPortEvent.DATA_AVAILABLE:
                //Novo algoritmo de leitura.
                while(novoDado != -1){
                    try{
                        novoDado = entrada.read();
                        if(novoDado == -1){
                            break;
                        }
                        if('\r' == (char)novoDado){
                            bufferLeitura.append('\n');
                        }else{
                            bufferLeitura.append((char)novoDado);
                        }
                    }catch(IOException ioe){

                        System.out.println("Erro de leitura serial: " + ioe);
                    }
                }
                setPeso(new String(bufferLeitura));
                System.out.println(getPeso());
            break;
        }
    }

    public void closeCOMPort(){
            try {
                porta.close();
            } catch (Exception e) {
                System.out.println("Erro fechando porta: " + e);
                System.exit(0);
            }
    }

    public String getPorta(){
        return Porta;
    }

    public int getBaudrate(){

        return baudrate;
    }

    public int getNovoDado() {
        return novoDado;
    }
    
    
}

