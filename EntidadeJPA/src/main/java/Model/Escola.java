package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ESCOLA")
@NamedQueries({
    @NamedQuery(name = "Escola.findAll", query = "SELECT e FROM Escola e"),
    @NamedQuery(name = "Escola.findByNome", query = "SELECT e FROM Escola e WHERE e.nome = :nome"),
    @NamedQuery(name = "Escola.findByMatr\u00edcula", query = "SELECT e FROM Escola e WHERE e.matr\u00edcula = :matr\u00edcula"),
    @NamedQuery(name = "Escola.findByEntrada", query = "SELECT e FROM Escola e WHERE e.entrada = :entrada")})
public class Escola implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "NOME")
    private String nome;
    @Id
    @Basic(optional = false)
    @Column(name = "MATR\u00cdCULA")
    private Integer matrícula;
    @Column(name = "ENTRADA")
    private Integer entrada;

    public Escola() {
    }

    public Escola(Integer matrícula) {
        this.matrícula = matrícula;
    }

    
    
    //Geters e Seters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatrícula() {
        return matrícula;
    }

    public void setMatrícula(Integer matrícula) {
        this.matrícula = matrícula;
    }

    public Integer getEntrada() {
        return entrada;
    }

    public void setEntrada(Integer entrada) {
        this.entrada = entrada;
    }

    public String getMatricula() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMatricula(String readLine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
