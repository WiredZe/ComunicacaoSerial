/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.awt.BorderLayout;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import linechart.MeuLineChart;

/**
 *
 * @author José Luiz
 */
public class Teste {
    public static void main(String args[]){
        JFrame janela = new JFrame();
        BorderLayout layout = new BorderLayout();                   // Cria um novo Layout do tipo BorderLayout.
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // Define a operação padrão de fechamento da janela.
        janela.setSize(800, 600);                                   // Define o tamanho da janela como 800 x 600.
        janela.setLayout(layout);                                   // Seta o Layout da Janela como BorderLayout.
        janela.setResizable(false);                                 // Desabilita o redimensionamento da janela.
        janela.setVisible(true);                                    // Seta a visibilidade da janela.
        
        ArrayList<String> labels_x = new ArrayList<>();
        labels_x.add("0");
        labels_x.add("0,25");
        labels_x.add("0,5");
        labels_x.add("0,75");
        labels_x.add("1");
        
        ArrayList<String> labels_y = new ArrayList<>();
        labels_y.add("Critico");
        labels_y.add("Baixo");
        labels_y.add("Medio");
        labels_y.add("Cheio");
        
        String titulo = "Reservatório";
        String labelX = "Tempo s";
        String labelY = "água";
        
        ArrayList<Point2D> pontos = new ArrayList<>();
        
        MeuLineChart mlc = new MeuLineChart(pontos,labels_x,labels_y,titulo,labelX,labelY);
        
        janela.add(mlc);                                            // Adiciona o MeuLineChart mlc para a janela, sem esse comando o mls não será renderizado.
        mlc.requestFocusInWindow();                                 // Adiciona foco na janela para o MeuLineChart mlc.
    }
}
