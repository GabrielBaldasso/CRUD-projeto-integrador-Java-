package dao;

import model.AtendimentosServicos;

import javax.persistence.EntityManager;
import java.util.List;

public class AtendimentosServicosDao {
    private static EntityManager em;
    public AtendimentosServicosDao (EntityManager em){
        this.em = em;
    }

    public void cadastrar(AtendimentosServicos atendimentosServicos){
        this.em.persist(atendimentosServicos);
    }

    public List<AtendimentosServicos> buscarTodos (){
        String jpql = "SELECT t FROM AtendimentosServicos t";
        return em.createQuery(jpql,AtendimentosServicos.class).getResultList();
    }

    public AtendimentosServicos buscarPorId(int id){
        return em.find(AtendimentosServicos.class,id);
    }

    public void excluir (AtendimentosServicos atendimentosServicos){
        em.merge(atendimentosServicos);
        this.em.remove(atendimentosServicos);
    }

    public void alterar(AtendimentosServicos atendimentosServicos){
        em.merge(atendimentosServicos);
    }

    public List<AtendimentosServicos> buscaAtendimento(int idAtendimento){
        return this.em.createQuery("SELECT at FROM atendimentosservicos at WHERE at.idAtendimentoServico = :idAtendimento", AtendimentosServicos.class)
                .setParameter("idAtendimento", idAtendimento)
                .getResultList();
    }


    public void excluirAtendimentoServico(int idAtendimento) {
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM AtendimentosServicos as s WHERE s.idAtendimento = :id")
                    .setParameter("id", idAtendimento)
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }
}
