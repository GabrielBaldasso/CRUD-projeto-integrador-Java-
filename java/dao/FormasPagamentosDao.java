package dao;

import model.FormasPagamentos;

import javax.persistence.EntityManager;
import java.util.List;

public class FormasPagamentosDao {
    private static EntityManager em;
    public FormasPagamentosDao (EntityManager em){
        this.em = em;
    }
    public void cadastrar(FormasPagamentos formasPagamentos){
        this.em.persist(formasPagamentos);
    }

    public List<FormasPagamentos> buscarTodos (){
        String jpql = "SELECT f FROM FormasPagamentos f";
        return em.createQuery(jpql,FormasPagamentos.class).getResultList();
    }

    public FormasPagamentos buscarPorId(int id){
        return em.find(FormasPagamentos.class,id);
    }

    public void excluir (FormasPagamentos formasPagamentos){
        em.merge(formasPagamentos);
        this.em.remove(formasPagamentos);
    }

    public void alterar(FormasPagamentos formasPagamentos){
        em.merge(formasPagamentos);
    }

}
