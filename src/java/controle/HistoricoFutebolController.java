/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;


import entidade.Partida;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import negocio.PartidaBO;

/**
 *
 * @author Administrador
 */
@ManagedBean
@SessionScoped
public class HistoricoFutebolController implements Serializable {
    
     //Objeto que será usado para mapear os campos da tela
    private Partida partida;
    
    public String iniciarTela(){
        this.partida = new Partida();
        return "historicoFutebol";
    }
    
    
    public void salvar(){
        //Obtem o contexto do JSF
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        partida.setStatus(0);
        partida.setPlacar1("0");
        partida.setPlacar2("0");
        
        try{
            //Aciona a camada de negocio para salvar a partida
            PartidaBO partidaBO = new PartidaBO();
            partidaBO.salvarPartida(this.partida);
            //exibe mensagem de sucesso
             facesContext.addMessage(null, new FacesMessage("Partida: "+this.partida.getTime1()+" X "+this.partida.getTime2()+ " cadastrado com sucesso"));
             //Instancia um novo objeto de partida para inicar um novo cadastro
             this.partida=new Partida();
        }catch(Exception e){
            //Caso exista algum erro exibe menssagem de falha
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),e.getMessage());
            facesContext.addMessage(null, facesMessage);
        }
       
    }
    
    public void validarEspacoBranco(FacesContext contexto, UIComponent componente, Object valor){
        String valorString = (String) valor;
        if(valorString.trim().equals("")){
            ((UIInput) componente).setValid(false);
            String mensagem = componente.getAttributes().get("label")
                    +":Valor inválido, preencha com caracteres diferentes de espaço.";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
            contexto.addMessage(componente.getClientId(contexto), facesMessage);
        }
        
        
        
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
    
}
