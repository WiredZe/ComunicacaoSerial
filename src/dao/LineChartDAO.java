// Classe DAO(Data Acess Object), essa classe separa os comandos do banco da aplicação.
// Responsável por executar os SELECTS no banco.
package dao;

import conexao.Banco;
import java.awt.List;
import java.awt.geom.Point2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LineChartDAO {
    
    // Metodo que retorna as coordenadas presentes em um determinado gráfico passado pelo id.
    public ArrayList<Point2D> buscarCoordenadas(int id){
        ArrayList<Point2D> coordenadas = new ArrayList<>(); // Cria um ArrayList de Point2D responsavel por armazernar os dados retornados do banco.
        
        Banco b = new Banco(); // Cria um objeto do tipo Banco.
        
            if ("sucesso".equals(b.getMsg())) { // Caso consiga conectar com o banco executa os comandos;

                // Vamos preparar o comando SQL:
                // Seleciona as coordenadas X e Y armazenadas na tabela coordenadas para um determinado grafico passando o id do gráfico.
                String sql = "SELECT coordenadas.valor_x,coordenadas.valor_y FROM coordenadas WHERE coordenadas.id_grafico = "+id+";";

                // Definido o Statement, executamos o comando no banco de dados.
                // Objeto do tipo ResultSet que armazena os dados retornados do banco.
                ResultSet rs;
                    
            try {
                rs = b.getStm().executeQuery(sql); // Executa o comando SQL atraves do objeto Statement do objeto Banco e armazena no objeto rs.
            
                    // caso existir resultados, percorremos a lista.
                    while (rs.next()) { // Percorre a lista de resultados do ResultSet rs.
                        //leitura dos campos da tabela em variáveis
                        Double x = rs.getDouble("coordenadas.valor_x"); // Le o campo coordenadas.valor_x do select e armazena em uma variavel do tipo Double.
                        Double y = rs.getDouble("coordenadas.valor_y"); // Le o campo coordenadas.valor_y do select e armazena em uma variavel do tipo Double.
                        coordenadas.add(new Point2D.Double(x, y)); // Adiciona o resultado em no ArrayList de Point2D.
                    }
                
            } catch (SQLException ex) {
            }
        return coordenadas;
    }
        return coordenadas;        
    }

//Metodo que retorna o titulo de um gráfico pelo id dele.    
public String buscarTitulo(int id){
        String nome = new String(); // Variavel do tipo String que armazena o titulo do gráfico.
        
        Banco b = new Banco(); // Cria um objeto do tipo Banco.
        
            if ("sucesso".equals(b.getMsg())) { // Caso consiga conectar com o banco executa os comandos;

                // Vamos preparar o comando SQL:
                // Seleciona o titulo de um grafico passado por id.
                String sql = "SELECT grafico.titulo FROM grafico WHERE grafico.id_grafico = "+id+";";

                // Definido o Statement, executamos o comando no banco de dados.
                // Objeto do tipo ResultSet que armazena os dados retornados do banco.
                ResultSet rs;
                    
            try {
                rs = b.getStm().executeQuery(sql); // Executa o comando SQL atraves do objeto Statement do objeto Banco e armazena no objeto rs.
      
                    // caso existir resultados, percorremos a lista.
                    while (rs.next()) { // Percorre a lista de resultados do ResultSet.
                        //leitura dos campos da tabela em variáveis
                        nome = rs.getString("grafico.titulo"); // Armazena o titulo do grafico.
                        
                    }
                
            } catch (SQLException ex) {
            }
        return nome;
    }
        return nome;    
}

// Metodo que retorna o label do eixo X.
public String buscarNomeX(int id){
        String nome = new String(); // Variavel do tipo String que armazena o nome do Eixo X.
        
        Banco b = new Banco(); // Objeto do tipo Banco.
        
            if ("sucesso".equals(b.getMsg())) { // Caso consiga conectar com o banco executa os comandos;

                // Vamos preparar o comando SQL:
                // Seleciona o nome do eixo X de um determinado gráfico pelo id dele.
                String sql = "SELECT grafico.nomex FROM grafico WHERE grafico.id_grafico = "+id+";";

                // Definido o Statement, executamos o comando no banco de dados.
                // Objeto do tipo ResultSet que armazena os dados retornados do banco.
                ResultSet rs;
                    
            try {
                rs = b.getStm().executeQuery(sql); // Executa o comando SQL atraves do objeto Statement do objeto Banco e armazena no objeto rs.
 
                    // caso existir resultados, percorremos a lista.
                    while (rs.next()) { // Percorre a lista de resultados do ResultSet.
                        //leitura dos campos da tabela em variáveis
                        nome = rs.getString("grafico.nomex"); // Armazena o nomex do grafico.
                        
                    }
                
            } catch (SQLException ex) {
            }
        return nome;
    }
        return nome;    
}

// Metodo que retorna o label do eixo Y.
public String buscarNomeY(int id){
        String nome = new String(); // Variavel do tipo String que armazena o nome do Eixo Y.
        
        Banco b = new Banco(); // Objeto do tipo Banco.
        
            if ("sucesso".equals(b.getMsg())) { // Caso consiga conectar com o banco executa os comandos;

                // Vamos preparar o comando SQL:
                // Seleciona o nome do eixo Y de um determinado gráfico pelo id dele.
                String sql = "SELECT grafico.nomey FROM grafico WHERE grafico.id_grafico = "+id+";";

                // Definido o Statement, executamos o comando no banco de dados.
                // Objeto do tipo ResultSet que armazena os dados retornados do banco.
                ResultSet rs;
                    
            try {
                rs = b.getStm().executeQuery(sql); // Executa o comando SQL atraves do objeto Statement do objeto Banco e armazena no objeto rs.

                    // caso existir resultados, percorremos a lista.
                    while (rs.next()) { // Percorre a lista de resultados do ResultSet.
                        //leitura dos campos da tabela em variáveis
                        nome = rs.getString("grafico.nomey"); // Armazena o nomey do grafico.
                        
                    }
                
            } catch (SQLException ex) {
            }
        return nome;
    }
        return nome;    
}

// Metodo responsavel por buscar os valores do eixo X.
public ArrayList<String> buscarLabelsX(int id){
        ArrayList<String> label = new ArrayList<>(); // ArrayList de String que armazena os valores de eixo X.
        
        Banco b = new Banco(); // Objeto do tipo Banco.
        
            if ("sucesso".equals(b.getMsg())) { // Caso consiga conectar com o banco executa os comandos;

                // Vamos preparar o comando SQL:
                // Seleciona os valores dos rotulos do eixo X na tabela rotulo_x com o id do grafico passado por parametro.
                String sql = "SELECT rotulo_x.valor FROM rotulo_x WHERE rotulo_x.id_grafico = "+id+";";

                // Definido o Statement, executamos o comando no banco de dados.
                // Objeto do tipo ResultSet que armazena os dados retornados do banco.
                ResultSet rs;
                    
            try {
                rs = b.getStm().executeQuery(sql); // Executa o comando SQL atraves do objeto Statement do objeto Banco e armazena no objeto rs.

                    // caso existir resultados, percorremos a lista.
                    while (rs.next()) { // Percorre a lista de resultados do ResultSet.
                        //leitura dos campos da tabela em variáveis
                        String valor = rs.getString("rotulo_x.valor"); // Pega o valor do rotulo_x e atribui a uma variavel temporaria.
                        label.add(valor); // Adiciona o valor no ArrayList que ira ser retornado.
                    }
                
            } catch (SQLException ex) {
            }
        return label;
    }
        return label;    
}

// Metodo responsavel por buscar os valores do eixo Y.
public ArrayList<String> buscarLabelsY(int id){
        ArrayList<String> label = new ArrayList<>(); // ArrayList de String que armazena os valores de eixo Y.
        
        Banco b = new Banco(); // Objeto do tipo Banco.
        
            if ("sucesso".equals(b.getMsg())) { // Caso consiga conectar com o banco executa os comandos;

                // Vamos preparar o comando SQL:
                // Seleciona os valores dos rotulos do eixo Y na tabela rotulo_y com o id do grafico passado por parametro.
                String sql = "SELECT rotulo_y.valor FROM rotulo_y WHERE rotulo_y.id_grafico = "+id+";";

                // Definido o Statement, executamos o comando no banco de dados.
                // Objeto do tipo ResultSet que armazena os dados retornados do banco.
                ResultSet rs;
                    
            try {
                rs = b.getStm().executeQuery(sql); // Executa o comando SQL atraves do objeto Statement do objeto Banco e armazena no objeto rs.

                    // caso existir resultados, percorremos a lista.
                    while (rs.next()) {
                        //leitura dos campos da tabela em variáveis
                        String valor = rs.getString("rotulo_y.valor"); // Pega o valor do rotulo_y e atribui a uma variavel temporaria.
                        label.add(valor); // Adiciona o valor no ArrayList que ira ser retornado.
                    }
                
            } catch (SQLException ex) {
            }
        return label;
    }
        return label;    
}
}
