package dao;

import model.Atendimentos;

import javax.persistence.EntityManager;
import java.util.List;

public class AtendimentosDao {
    private static EntityManager em;
    public AtendimentosDao (EntityManager em){
        this.em = em;
    }

    public void cadastrar(Atendimentos atendimentos){
        this.em.persist(atendimentos);
    }

    public List<Atendimentos> buscarTodos (){
        String jpql = "SELECT t FROM Atendimentos t";
        return em.createQuery(jpql,Atendimentos.class).getResultList();
    }

    public Atendimentos buscarPorId(int id){
        return em.find(Atendimentos.class,id);
    }

    public void excluir (Atendimentos atendimentos){
        em.merge(atendimentos);
        this.em.remove(atendimentos);
    }

    public void alterar(Atendimentos atendimentos){
        em.merge(atendimentos);
    }
}
