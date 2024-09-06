
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AlunoDAO extends GenericoDAO<Aluno, String> {

    //Reescrevendo os métodos abstratos atribuindo funcionalidades para modificações no banco de dados
    @Override
    public void incluir(Aluno entidade) {
       try {
            PreparedStatement ps = getConnection().prepareStatement("INSERT INTO ALUNO VALUES (?, ?, ?)");
            ps.setString(1, entidade.matricula);
            ps.setString(2, entidade.nome);
            ps.setInt(3, entidade.ano);
            ps.executeUpdate();
            
            //Finaliza a solicitação
            closeStatement(ps);
	    } catch (Exception erro) { 
                erro.getMessage();
           }
}

    @Override
    public void excluir(String chave) {
        try {
	    PreparedStatement ps = getConnection().prepareStatement("DELETE FROM ALUNO WHERE MATRICULA = ?");
            ps.setString(1, chave);
            ps.executeUpdate();
            closeStatement(ps);
	   } catch (Exception erro) {
               erro.getMessage();
          }
}

    @Override
    public void alterar(Aluno entidade) {
        try {
            PreparedStatement ps = getConnection().prepareStatement("UPDATE ALUNO SET NOME = ?, ENTRADA = ? " + " WHERE MATRICULA = ?");
            ps.setString(1, entidade.nome);
            ps.setInt(2, entidade.ano);
            ps.setString(3, entidade.matricula);
            ps.executeUpdate();
            closeStatement(ps);
	} catch (Exception erro) {
            erro.getMessage();
       }
}

    @Override
    public Aluno obter(String chave) {
       //Aluno começa recebendo valor nulo, para pegar os valores diretamente da tabela
       Aluno aluno = null;
       
	try {
            PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM ALUNO WHERE MATRICULA = ?");
            ps.setString(1, chave); 
            ResultSet resultado = ps.executeQuery();
            
            if (resultado.next()) { //Se tiver algo, execute o código abaixo pegando as colunas de matricula, aluno e entrada e adicione para a variavel "aluno"
                aluno = new Aluno(resultado.getString("MATRICULA"),
                                  resultado.getString("NOME"),
                                  resultado.getInt("ENTRADA"));
                }
           //Quando o if terminar feche a solicitação
	   closeStatement(ps);
           
	    } catch (Exception erro) {
                erro.getMessage();
           }
           //Retorna o aluno com os dados obtidos da tabela
	   return aluno;
    }

    @Override
    public List<Aluno> obterTodos() {
        List<Aluno> lista = new ArrayList<>();
        try {
            ResultSet resultado = getStatement().executeQuery("SELECT * FROM ALUNO"); //Vai executar essa query no nosso banco de dados
            
            while(resultado.next()) //tiver algo, execute o código abaixo
                
                //Adiciona no array um novo aluno pegando as colunas matricula, nome e entrada
                lista.add(new Aluno(resultado.getString("MATRICULA"),
                resultado.getString("NOME"), 
                resultado.getInt("ENTRADA")));
            
            //Termina a solicitação quando o while não for mais verdadeiro
            closeStatement(resultado.getStatement());
                
        } catch (Exception erro) {
            erro.getMessage();
        }
        //Importante colocar o return para poder retornar essa lista 
         return lista;
    }
    
}
