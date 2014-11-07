// Classe para conexão com o banco de dados.
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {
    private String DRIVER = "com.mysql.jdbc.Driver"; // Driver do MySql.
    private String BD = "linechart"; // Nome do banco.
    private String URL = "jdbc:mysql://localhost:3306/"+BD; //Localização do banco, numero da porta + nome do banco.
    private String USERNAME = "root"; // Usuario.
    private String PASSWORD = "root"; // Senha do root.
    private Connection conexao; //Objeto para conexão com o banco.
    private Statement stm; //Objeto que executa as transações SQL.
    private String msg; //String que retorna a mensagem do banco.
    
    // Construtores da classe Banco.
    public Banco() {
        this.msg = this.iniciaConexao(); // Inicia a conexão atribuindo a mensagem para a variavel msg.
                
    }

    public Banco(String bd, String user, String senha) {
        //Construtor que seta as variaveis globais com as passadas por parametro.
        this.BD = bd;
        this.USERNAME = user;
        this.PASSWORD = senha;
        this.msg = this.iniciaConexao();

    }

    //Metodo que inicia a conexão com o banco.
    public String iniciaConexao() {
        try {
            Class.forName(this.DRIVER); //Pega a classe do Driver MySQL.
            this.conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD); // Inicia a conexão passando como parametro o nome do banco, usuario e senha.
            // Definimos o objeto responsÃ¡vel por executar os comandos
            this.stm = this.getConexao().createStatement(); //Cria uma variavel Statement para a conexão, essa variavel é responsavel por executar os comandos MySQL.
            return "sucesso"; //Retorna a mensagem sucesso caso consiga conectar com o banco.
             
        } catch (ClassNotFoundException e) {
            this.conexao = null;
            return "Não foi possivel encontrar o driver de banco: " + e.getMessage(); //Caso ocorra alguma excessão retorna mensagem de erro.
        } catch (SQLException e) {
            this.conexao = null;
            return "SQLException Erro!" + e.getMessage(); //Caso ocorra alguma excessão retorna mensagem de erro.
        }
    }

    //Metodo que encerra a conexão.
    public String fechaConexao() {
        try {
            if (this.getConexao() != null) {
                this.getConexao().close();
                this.conexao = null;
            }
            if (this.getStm() != null) {
                this.stm = null;
            }
            return "Conexão Encerrada";
        } catch (SQLException ex) {
            return "Houve erro no fechamento da conexão! "+ex.getMessage();
        }
    }

    /**
     * Metodo que retorna a conexão.
     * @return objeto do tipo Connection.
     */
    public Connection getConexao() {
        return conexao;
    }

    /**
     * Metodo que retorna o Statement para uma conexão,
     * esse objeto é responsavel por executar os comando MySQL.
     * @return objeto do tipo Statement.
     */
    public Statement getStm() {
        return stm;
    }
    
    /**
     * Metodo que retorna a mensagem,
     * caso consiga conectar ao banco msg = 'sucesso',
     * caso não retorna o erro ocorrido.
     * @return String com a mensagem do banco.
     */
    public String getMsg() {
        return msg;
    }
}
