package Manager;

import Manager.exceptions.PreexistingEntityException;
import Model.Escola;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EscolaJpaController implements Serializable {

    public EscolaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Escola aluno) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager(); //´Pega qual é minha entidade
            em.getTransaction().begin(); //Começa uma transação
            em.persist(aluno); //Faz um INSERT
            em.getTransaction().commit(); //Se tudo der certo, ele irá fazer um commit no banco
        } catch (Exception erro) {
            if(findAluno(aluno.getMatrícula()) != null) {
                throw new PreexistingEntityException("Aluno " + aluno + " já existe.", erro);
            }
            erro.getMessage();
        } finally {
            if(em != null) {
                em.close();
            }
        }
    }

    private Object findAluno(Integer matrícula) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void destroy(String matricula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object findAlunoEntities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
