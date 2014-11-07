package linechart;

import dao.LineChartDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*A classe MeuLineChart é responsavel por desenhar o grafico
  ela estende de JPanel e implementa a interface Chart passada
  definida no pdf do trabalho*/
public class MeuLineChart extends JPanel implements Chart{
    
Graphics2D g2d;                                 // Objeto do tipo Graphics2D responsavel por renderizar os componentes Java2D na tela.
ArrayList<Point2D> pontos;                      // ArrayList de Point2d, representa as coordenadas do grafico. 
ArrayList<String> labels_x;                     // ArrayList de String, representa os valores do eixo X.
ArrayList<String> labels_y;                     // ArrayList de String, representa os valores do eixo Y.
String titulo;                                  // String que representa o titulo do grafico.
String labelX;                                  // String que represneta o valor do eixo X.
String labelY;                                  // String que representa o valor do eixo Y.
Color cor;                                      // Objeto do tipo Color que representa o cor do grafico.

// Construtor da classe.
/*Busca os valores no banco e atribui as variaveis globais atraves do id passado por parametro
  definindo uma cor padrão*/
public MeuLineChart(int id){
    LineChartDAO lcd = new LineChartDAO();
    this.pontos = lcd.buscarCoordenadas(id);
    this.labels_x = lcd.buscarLabelsX(id);
    this.labels_y = lcd.buscarLabelsY(id);
    this.titulo = lcd.buscarTitulo(id);
    this.labelX = lcd.buscarNomeX(id);
    this.labelY = lcd.buscarNomeY(id);
    cor = new Color(255, 52, 179);
}

// Construtor da classe.
/*Busca os valores no banco e atribui as variaveis globais atraves do id passado por parametro
  definindo a cor passada por parametro*/
public MeuLineChart(int id, Color c){
    LineChartDAO lcd = new LineChartDAO();
    this.pontos = lcd.buscarCoordenadas(id);
    this.labels_x = lcd.buscarLabelsX(id);
    this.labels_y = lcd.buscarLabelsY(id);
    this.titulo = lcd.buscarTitulo(id);
    this.labelX = lcd.buscarNomeX(id);
    this.labelY = lcd.buscarNomeY(id);
    cor = (c);
}

    public MeuLineChart(Graphics2D g2d, ArrayList<Point2D> pontos, ArrayList<String> labels_x, ArrayList<String> labels_y, String titulo, String labelX, String labelY, Color cor) {
        this.g2d = g2d;
        this.pontos = pontos;
        this.labels_x = labels_x;
        this.labels_y = labels_y;
        this.titulo = titulo;
        this.labelX = labelX;
        this.labelY = labelY;
        this.cor = cor;
    }

    public MeuLineChart(ArrayList<Point2D> pontos, ArrayList<String> labels_x, ArrayList<String> labels_y, String titulo, String labelX, String labelY) {
        this.pontos = pontos;
        this.labels_x = labels_x;
        this.labels_y = labels_y;
        this.titulo = titulo;
        this.labelX = labelX;
        this.labelY = labelY;
    }
    
    

    public MeuLineChart() {
    }



/*Metodo paintComponent responsavel por renderizar todos os elementos na tela atraves de 
  um objeto do tipo Graphics2D*/
@Override
public void paintComponent(Graphics g){
    super.paintComponent(g);                    // Chama o construtor da classe 'pai' atraves da palavra super.
    g2d = (Graphics2D) g;                       // Faz o casting do objeto Graphics padrão do metodo paintComponent para um objeto Graphics2D.
    this.setTitulo(this.titulo);                // Chama o metodo setTitulo da interface Chart passando a variavel global titulo como parametro.
    this.setLabelX(this.labelX);                // Chama o metodo setLabelX da interface Chart passando a variavel global labelX como parametro.
    this.setLabelY(this.labelY);                // Chama o metodo setLabelY da interface Chart passando a variavel global labelY como parametro.
    g2d.setColor(new Color(255, 250, 205 ));    // Define uma nova cor para o objeto Graphics2D.
    
    g2d.fillRect(120, 50, 650, 470);            // Desenha a area do gráfico.
    
    g2d.setColor(this.cor);                     // Atribui uma nova cor para o Graphics2D passada por parametro.
    this.setEixoX(this.labels_x);               // Chama o metodo setEixoX da interface Chart passando a variavel global labels_x.
    this.setEixoY(this.labels_y);               // Chama o metodo setEixoY da interface Chart passando a variavel global labels_y.
    
    this.adicionarSerie(this.pontos, this.cor); // Chama o metodo adicionarSerie da interface Chart passando a variavel pontos e a cor definida por parametro.
    
}

    /*Implementa o metodo adicionarSerie da interface Chart responsavel por desenhar os pontos do grafico.*/
    @Override
    public void adicionarSerie(ArrayList<Point2D> serie, Color cor) {
        this.g2d.setColor(cor);                      // Seta a cor do objeto Graphics2D.  
        for(int i = 1; i <= serie.size(); i++){ // Percore os elementos do ArrayList serie.
            /*  *Desenha uma linha entre o elemento de i-1 e o elemento de i.
                *Os elementos são desenhados atraves dos metodos getX e getY que retornam a posição de cada ponto.
                *Após obter as posições dos elementos é traçada uma linha entre eles.
            */
            this.g2d.drawLine((int) serie.get(i-1).getX(), (int) serie.get(i-1).getY(), (int) serie.get(i).getX(), (int) serie.get(i).getY());
            if(i == (serie.size()-1))           // Para o loop caso o fim do ArrayList tenha sido atingido, isso evita a exessão ArrayIndexOutOfBounds.
                break;
        }
    }

    /*Implementa o metodo setEixoX da interface Chart responsavel por desenhar os valores do eixo de X.*/
    @Override
    public void setEixoX(ArrayList<String> valores) {
        /*  *Define a largura dos componentes.
            *650px é a largura do gráfico dividindo esse valor pelo numero de labels-1 é possivel obter a largura de cada elemento.
            *Conforme mais elementos a largura será menor.
        */
        int largura = 650/(valores.size()-1);
        int temp = 0;                                   // Variavel temporária.
        for(int i = 0; i < valores.size(); i ++){       // Laço que percorre o ArratList valores.
            JLabel x = new JLabel(valores.get(i));      // Cria um JLabel para cada componente do ArrayList.
                /*  *Seta a posição de cada JLabel sendo 120px a posição inicial do gráfico e 520px a posição em Y dos elementos.
                    *Cada elemento será posicionado na posição 120+temp, temp possui o valor de X do ultimo elemento.
                    *Assim sendo os elementos são posicionados a partir de 120+largura calculada.
                */
                x.setBounds(120+temp, 520, largura, 20);
                temp = temp + largura;                  // Atribui a posição X do ultimo elemento percorrido a variavel temp.
                this.add(x);                            // Adiciona o elemento JLabel x no componente JPanel, sem essa instrução o JPanel não é renderizado. 
            }
        }
 

    /*Implementa o metodo setEixoY da interface Chart responsavel por desenhar os valores do eixo de Y.*/
    @Override
    public void setEixoY(ArrayList<String> valores) {
        /*  *Define a altura dos componentes.
            *470px é a altura do gráfico dividindo esse valor pelo numero de labels-1 é possivel obter a altura de cada elemento.
            *Conforme mais elementos a altura será menor
        */
        int altura = 470/(valores.size()-1);
        int temp = 0;                                   // Variavel temporária.
        this.g2d.setColor(Color.BLACK);
        for(int i = 0; i < valores.size() ; i++){       // Laço que percorre o ArrayList valores.
            JLabel y = new JLabel(valores.get(i));      // Cria um JLabel para cada componente do ArrayList
            /*  *Sera a posição de cada JLabel sendo 470px a posicao inicial do gráfico e 90px a posição em X dos elementos.
                *Cada elemento será posicionado na posição 470+temp, temp possui o valor em Y do ultimo elemento.
                *Assim sendo os elemento são posicionados de 470+altura calculada.
            */
            y.setBounds(90, 470+temp, 30, altura);
            g2d.drawLine(120, 520+temp, 770, 520+temp); // Desenha uma linha na posição de cada JLabel para distiguir cada elemento no gráfico.
            temp = temp - altura;                       // Decrementa a variavel temp com a altura de cada elemento.
            this.add(y);                                // Adiciona o elemento JLabel y no componente JPanel, sem essa instrução o JPanel não é renderizado. 
        }
    }

    /*Implementa o metodo setLabelX da interface Chart responsavel por desenhar o nome do eixo X.*/
    @Override
    public void setLabelX(String nome) {
        JLabel x = new JLabel(nome);                            // Cria um JLabel para o nome do eixo X.
        x.setFont(new Font("Times New Roman", Font.PLAIN, 25)); // Seta o tipo e tamanho da fonte do JLabel
        x.setBounds(350, 540, 100, 20);                         // Seta a posição do JLabel embaixo da area do gráfico.
        this.add(x);                                            // Adiciona o elemento JLabel x no componente JPanel, sem essa instrução o JPanel não é renderizado.
    }

    /*Implementa o metodo setLabelY da interface Chart responsavel por desenhar o nome do eixo Y.*/
    @Override
    public void setLabelY(String nome) {
        JLabel y = new JLabel(nome);                            // Cria um JLabel para o nome do eixo Y.
        y.setFont(new Font("Times New Roman", Font.PLAIN, 25)); // Seta o tipo e tamanho da fonte do JLabel
        y.setBounds(10, 250, 100, 20);                          // Seta a posição do JLabel ao lado da area do gráfico.
        this.add(y);                                            // Adiciona o elemento JLabel y no componente JPanel, sem essa instrução o JPanel não é renderizado.
    }

    /*Implementa o metodo setTitulo da interface Chart responsavel por desenhar o titulo do gráfico.*/
    @Override
    public void setTitulo(String titulo) {
        JLabel t = new JLabel(titulo);                          // Cria um JLabel para o titulo.
        t.setFont(new Font("Times New Roman", Font.PLAIN, 30)); // Seta o tipo e tamanho da fonte do JLabel
        t.setBounds(350, 10, 200, 20);                          // Seta a posição do JLabel acima da area do gráfico.
        this.add(t);                                            // Adiciona o elemento JLabel t no componente JPanel, sem essa instrução o JPanel não é renderizado.
    }
    
}
