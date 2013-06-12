/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Partida;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class PartidaDAO {
    
     public void persistir(Partida partida){
        EntityManager em = GerenciadorEntidade.getGereniciadoEntidade();
        em.getTransaction().begin();
        em.persist(partida);
        em.getTransaction().commit();
        
    }
     
     
     public List<Partida> obterPartidas() {
        EntityManager gerenciadorEntidade = GerenciadorEntidade.getGereniciadoEntidade();
        Query query = gerenciadorEntidade.createQuery("SELECT P FROM Partida P");
        List<Partida> partidas = query.getResultList();
        return partidas;
    }
    
}
