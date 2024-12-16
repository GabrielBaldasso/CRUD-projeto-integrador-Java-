package dao;

import model.Servicos;

import javax.persistence.EntityManager;
import java.util.List;

public class ServicosDao {
    private static EntityManager em;
    public ServicosDao (EntityManager em){
        this.em = em;
    }
    public void cadastrar(Servicos servicos){
        this.em.persist(servicos);
    }

    public List<Servicos> buscarTodos (){
        String jpql = "SELECT f FROM Servicos f";
        return em.createQuery(jpql,Servicos.class).getResultList();
    }

    public Servicos buscarPorId(int id){
        return em.find(Servicos.class,id);
    }

    public void excluir (Servicos servicos){
        em.merge(servicos);
        this.em.remove(servicos);
    }

    public void alterar(Servicos servicos){
        em.merge(servicos);
    }
}
