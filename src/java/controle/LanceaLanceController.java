/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Lance;
import entidade.Partida;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import negocio.LanceBO;
import negocio.PartidaBO;

/**
 *
 * @author Administrador
 */
@ManagedBean
@SessionScoped
public class LanceaLanceController implements Serializable {

    private Lance novoLance;
    private Partida partidaSelecionada;
    private List<Lance> lancesPartida;

    public List<Lance> getLancesPartida() {
        return lancesPartida;
    }

    public void setLancesPartida(List<Lance> lancesPartida) {
        this.lancesPartida = lancesPartida;
    }

    public Partida getPartidaSelecionada() {
        return partidaSelecionada;
    }

    public void setPartidaSelecionada(Partida partidaSelecionada) {
        this.partidaSelecionada = partidaSelecionada;
    }

    public Lance getNovoLance() {
        return novoLance;
    }

    public void setNovoLance(Lance novoLance) {
        this.novoLance = novoLance;
    }

    
    
    
    
    public String mostrarLanceaLance() {
        novoLance = new Lance();
        this.obterLancesPartida();
        partidaSelecionada.setStatus(1);
        PartidaBO salvarStatus = new PartidaBO();
        salvarStatus.salvar(partidaSelecionada);
        return "lanceaLance";
    }
    
    
     public String mostrarLanceInternauta() {
        novoLance = new Lance();
        this.obterLancesPartida();
        partidaSelecionada.setStatus(1);
        PartidaBO visualizarPlacar = new PartidaBO();
        partidaSelecionada = visualizarPlacar.listarPartidasTempoRealLanceLance(partidaSelecionada);
        return "lanceInternauta";
    }

    public String finalizarPartida() {
        partidaSelecionada.setStatus(2);
        PartidaBO salvarStatus = new PartidaBO();
        salvarStatus.salvar(partidaSelecionada);
        return "mostrarPartidas";
    }

    public void salvarLances() {
        novoLance.setPartida(partidaSelecionada);
        LanceBO salvarLances = new LanceBO();
        salvarLances.salvar(novoLance);
        this.mostrarLanceaLance();
    }

    public void salvarPlacar() {
        PartidaBO salvarPartida = new PartidaBO();
        salvarPartida.salvar(partidaSelecionada);
    }

    public void obterLancesPartida() {
        lancesPartida = new ArrayList<Lance>();
        LanceBO obterLances = new LanceBO();
        lancesPartida = obterLances.listarLanceAdministrador(partidaSelecionada);

    }

    public void validarEspacoBranco(FacesContext contexto, UIComponent componente, Object valor) {
        String valorString = (String) valor;
        if (valorString.trim().equals("")) {
            ((UIInput) componente).setValid(false);
            String mensagem = componente.getAttributes().get("label")
                    + ":Valor inválido, preencha com caracteres diferentes de espaço.";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
            contexto.addMessage(componente.getClientId(contexto), facesMessage);
        }



    }
}
