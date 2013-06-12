/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Administrador
 */
@Entity
public class Lance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idLance;
    @ManyToOne
    Partida partida;
    @Column(nullable = true)
    private String tempo;
    @Column(nullable = true)
    private String mensagemLance;
     @Column(nullable = true)
    private String minutos;
    
    
    
    public int getIdLance() {
        return idLance;
    }

    public void setIdLance(int idLance) {
        this.idLance = idLance;
    }

    public String getMensagemLance() {
        return mensagemLance;
    }

    public void setMensagemLance(String mensagemLance) {
        this.mensagemLance = mensagemLance;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }
    
    
}
