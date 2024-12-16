package dao;

import model.Clientes;
import model.TiposProfissionais;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientesDao {
    private static EntityManager em;
    public ClientesDao (EntityManager em){
        this.em = em;
    }

    public void cadastrar(Clientes clientes){
        this.em.persist(clientes);
    }

    public List<Clientes> buscarTodos (){
        String jpql = "SELECT t FROM Clientes t";
        return em.createQuery(jpql,Clientes.class).getResultList();
    }

    public Clientes buscarPorId(int id){
        return em.find(Clientes.class,id);
    }

    public void excluir (Clientes clientes){
        em.merge(clientes);
        this.em.remove(clientes);
    }

    public void alterar(Clientes clientes){
        em.merge(clientes);
    }
}
