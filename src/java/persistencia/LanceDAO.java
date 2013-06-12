/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Lance;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class LanceDAO {
    
    
     public void persistir(Lance lance){
        EntityManager em = GerenciadorEntidade.getGereniciadoEntidade();
        em.getTransaction().begin();
        em.persist(lance);
        em.getTransaction().commit();
        
    }
     
     
     public List<Lance> obterLances() {
        EntityManager gerenciadorEntidade = GerenciadorEntidade.getGereniciadoEntidade();
        Query query = gerenciadorEntidade.createQuery("SELECT L FROM Lance L");
        List<Lance> lances = query.getResultList();
        return lances;
    }
    
}
