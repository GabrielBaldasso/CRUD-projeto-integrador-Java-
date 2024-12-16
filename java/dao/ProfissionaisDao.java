package dao;
import model.Profissionais;


import javax.persistence.EntityManager;
import java.util.List;

public class ProfissionaisDao {
    private static EntityManager em;
    public ProfissionaisDao (EntityManager em){
        this.em = em;
    }
    public void cadastro(Profissionais profissionais){
        this.em.persist(profissionais);
    }
    public List<Profissionais> buscarTodos (){
        String jpql = "SELECT f FROM Profissionais f";
        return em.createQuery(jpql,Profissionais.class).getResultList();
    }

    public Profissionais buscarPorId(int id){
        return em.find(Profissionais.class,id);
    }

    public void excluir (Profissionais profissionais){
        em.merge(profissionais);
        this.em.remove(profissionais);
    }

    public void alterar(Profissionais profissionais){
        em.merge(profissionais);
    }

}
