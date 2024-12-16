package dao;

import model.Profissionais;
import model.ServicoProfissionais;

import javax.persistence.EntityManager;
import java.util.List;

public class ServicoProfissionaisDao {
    private static EntityManager em;
    public ServicoProfissionaisDao (EntityManager em){
        this.em = em;
    }
    public void cadastro(ServicoProfissionais servicoProfissionais){
        this.em.persist(servicoProfissionais);
    }
    public List<ServicoProfissionais> buscarTodos (){
        String jpql = "SELECT f FROM ServicoProfissionais f";
        return em.createQuery(jpql,ServicoProfissionais.class).getResultList();
    }

    public ServicoProfissionais buscarPorId(int id){
        return em.find(ServicoProfissionais.class,id);
    }

    public void excluir (ServicoProfissionais servicoProfissionais){
        em.merge(servicoProfissionais);
        this.em.remove(servicoProfissionais);
    }

    public void alterar(ServicoProfissionais servicoProfissionais){
        em.merge(servicoProfissionais);
    }
}
