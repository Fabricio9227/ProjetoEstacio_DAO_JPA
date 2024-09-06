package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;


public abstract class GenericoDAO<E,K> { //E será nossa entidade (classe) e K a nossa chave (key)
    
    protected Connection getConnection() throws Exception { //Método protegido que cria uma conexão com o BD
        Class.forName("\"com.mysql.cj.jdbc.Driver\"");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/ALUNO", "ESCOLA", "esc");
    }
    protected Statement getStatement() throws Exception{ //Método protegido que 
        return getConnection().createStatement();
    }
    protected void closeStatement(Statement statement) throws Exception{ //Método protegido que fecha a conexão com o BD
        statement.getConnection().close();
    }
    
    //Métodos abstratos para serem implementados para fazer o CRUD e mais algumas ações no nosso Banco de Dados
    public abstract void incluir(E entidade);
    public abstract void excluir(K chave);
    public abstract void alterar(E entidade);
    public abstract E obter(K chave);
    public abstract List<E> obterTodos();
    
}