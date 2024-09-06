package DAO;

//Aqui temos um POJO, uma classe que não possui métodos
public class Aluno {
    public String matricula;
    public String nome;
    public int ano;
    
    //Construtor vazio
    public Aluno() {}
    
    //Construtor com parâmetros
    public Aluno(String matricula, String nome, int ano) {
        this.matricula = matricula;
        this.nome = nome;
        this.ano = ano;
    }
}