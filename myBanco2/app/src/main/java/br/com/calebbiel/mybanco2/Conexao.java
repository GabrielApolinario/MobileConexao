package br.com.calebbiel.mybanco2;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Classe responsavel pela interacao da aplicacao com o banco de dados
 */
public class Conexao {
    private String servidor = "com.mysql.cj.jdbc.Driver";
    // url que identifica o banco
    private String urlBanco = "jdbc:mysql://localhost:3307/teste";
    // login de usuario no banco
    private String usuarioBanco = "root";
    // senha do usuario no banco
    private String senhaBanco = "root";
    private Statement statement;
    Connection con = null;


    public boolean conectar() {
        boolean ret = false;
        try {
            Class.forName(servidor);
            con = DriverManager.getConnection(urlBanco, usuarioBanco, senhaBanco);
            ret = true;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();// se ClassNotFoundException o servidor (MySql) n�o foi encontrado
        } catch (SQLException e) {
            e.printStackTrace(); // se der outro erro, apresenta a descri��o do erro utilizando
            // a classe SQLException que trata de erros scripts slq
        }
        return ret;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    // *** Metodo de teste de conexao
    public boolean testaConexao() {
        // Declaracao e inicializacao de uma variavel de retorno ("true" se conectou ou "false" se ocorreu erro)
        boolean ret = false;
        // Declaracao e inicializacao de uma variavel do tipo Connection que armazenara a conexao estabelecida
        //Connection con = null;

        // Tenta executar as instrucoes em try
        try {
            // Quando o metodo estatico Class.forName()  utilizado, o Class Loader tenta inicializar esta classe.
            // Esta classe (que � o nosso driver jdbc) possui um bloco inicializador estatico que ir� registrar
            // essa classe como um driver JDBC, avisando o java.sql.DriverManager, pelo mtodo registerDriver.
            Class.forName(servidor);

            // A classe DriverManager abre uma conexao com o banco de dados.
            // A classe Connection designa um objeto, no caso con, para receber a conexao estabelecida
            con = DriverManager.getConnection(urlBanco, usuarioBanco, senhaBanco);

            // Seta a variavel de retorno com true
            ret = true;

            // Se der erro no try verifica qual erro foi gerado
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // se ClassNotFoundException o servidor (MySql) n�o foi encontrado,

        } catch (SQLException e) {
            e.printStackTrace();
            // se der outro erro, apresenta a descri��o do erro utilizando
            // a classe SQLException que trata de erros scripts slq
        }

        return ret;
    }
    // *** Metodo de inclusao de clientes
    public void Incluir(Cliente cliente) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName(servidor);
            con = DriverManager.getConnection(urlBanco, usuarioBanco, senhaBanco);

            // O campo usuCod na tabela usuarios eh do tipo int.
            // Para inserir um novo usuario eh necessario obter o proximo codigo
            // A funcao max() retorna o maior valor da coluna especificada
            // (nesse caso o ultimo codigo armazenado)
            Statement stmt = con.createStatement();
            String sql = "select max(id) from cliente";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            // Incrementando o ultimo codigo armazenado temos o codigo do novo usuario
            int proximoCodigo = rs.getInt(1) + 1;
            rs.close();

            // Aqui utilizamos a classe PreparedStatement que permite a insercao de
            // parametros (?) na construcao da string de SQL
            String sqlInsert = "insert into cliente values(?, ?, ?, ?, ?);";

            ps = con.prepareStatement(sqlInsert);
            ps.setInt(1, proximoCodigo);
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getCelular());
            ps.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            try {
                ps.close();
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }



}