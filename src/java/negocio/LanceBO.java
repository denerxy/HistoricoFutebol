/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Lance;
import entidade.Partida;
import java.util.ArrayList;
import java.util.List;
import persistencia.LanceDAO;

/**
 *
 * @author Administrador
 */
public class LanceBO {

    public void salvar(Lance lance) {
        LanceDAO lanceDAO = new LanceDAO();
        lanceDAO.persistir(lance);
    }

    public List<Lance> listarLance() {
        LanceDAO listarLances = new LanceDAO();
        List<Lance> todosLances = listarLances.obterLances();
        return todosLances;
    }

    public List<Lance> listarLanceAdministrador(Partida partida) {
        List<Lance> lancesRetorno = new ArrayList<Lance>();
               
        LanceDAO listarLances = new LanceDAO();
        List<Lance> todosLances = listarLances.obterLances();
        for(int i = 0;i<todosLances.size();i++){
            if(todosLances.get(i).getPartida()==partida){
                lancesRetorno.add(todosLances.get(i));
            }
        }
        return lancesRetorno;
    }
}
