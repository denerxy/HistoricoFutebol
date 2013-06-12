/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class GerenciadorEntidade {
     private static EntityManager gerenciadoEntidade=null;
    
    public static EntityManager getGereniciadoEntidade(){
        if(gerenciadoEntidade==null || !gerenciadoEntidade.isOpen()){
            gerenciadoEntidade = Persistence.createEntityManagerFactory("HistoricoFutebolPU").createEntityManager();
        }
        return gerenciadoEntidade;
        }
    
}
