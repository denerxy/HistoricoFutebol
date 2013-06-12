/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Partida;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import negocio.PartidaBO;

/**
 *
 * @author Administrador
 */
@ManagedBean
@SessionScoped
public class MostrarPartidasController implements Serializable {

    private List<Partida> partidas;
    private Partida partida;

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    public String mostrarTelaPartidas() {
        this.obterTabelaPartidas();
        return "mostrarPartidas";
    }
    
    public String mostrarPartidasTempoReal() {
        this.obterTabelaPartidas();
        return "partidaTempoReal";
    }
    
     public String mostrarTodasPartidas() {
        this.obterTodasPartidas();
        return "partidasdoDia";
    }
     
      public String mostrarPartidasEncerradas(){
        this.obterPartidasEncerradas();
        return "historicodePartidas";
    }
      
        public String mostrarProximasPartidas(){
        this.obterProximasPartidas();
        return "proximasPartidas";
    }
     
      public void obterTodasPartidas() {
        PartidaBO listarPartidas = new PartidaBO();
        partidas = listarPartidas.listarPartidasdoDia();
    }
      
       public void obterPartidasEncerradas(){
        PartidaBO listarPartidas = new PartidaBO();
        partidas = listarPartidas.listarPartidasEncerradas();
    }
      
         public void obterProximasPartidas(){
        PartidaBO listarPartidas = new PartidaBO();
        partidas = listarPartidas.listarProximasPartidas();
    }

    public void obterTabelaPartidas() {
        PartidaBO listarPartidas = new PartidaBO();
        partidas = listarPartidas.listarPartidasIniciadas();
    }

    
}
