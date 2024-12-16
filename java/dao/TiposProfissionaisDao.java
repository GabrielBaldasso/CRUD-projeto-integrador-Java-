package dao;

import model.TiposProfissionais;

import javax.persistence.EntityManager;
import java.util.List;

public class TiposProfissionaisDao {
    private static EntityManager em;
    public TiposProfissionaisDao (EntityManager em){
        this.em = em;
    }

    public void cadastrar(TiposProfissionais tiposProfissionais){
        this.em.persist(tiposProfissionais);
    }

    public List<TiposProfissionais> buscarTodos (){
        String jpql = "SELECT t FROM TiposProfissionais t";
        return em.createQuery(jpql,TiposProfissionais.class).getResultList();
    }

    public TiposProfissionais buscarPorId(int id){
        return em.find(TiposProfissionais.class,id);
    }

    public void excluir (TiposProfissionais tiposProfissionais){
        em.merge(tiposProfissionais);
        this.em.remove(tiposProfissionais);
    }

    public void alterar(TiposProfissionais tiposProfissionais){
        em.merge(tiposProfissionais);
    }




}
