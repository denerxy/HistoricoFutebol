/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Administrador
 */
@Entity
public class Partida implements Serializable{
    
     
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idPartida;
        
    @Column(nullable=true)
    private String placar1;
    
    @Column(nullable=true)
    private String placar2;
      
    @Column(nullable=false)
    private String time1;
    
    @Column(nullable=false)
    private String time2; 
    
    @Column(nullable=false)
    private String estadio;
    
    @Column (nullable=false)
    private String campeonato;
    
        
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(nullable=false)
    private Date dataPartida;
    
    @Column (nullable=true)
    private Integer status;

    @OneToMany(mappedBy="partida")
    private List<Lance> lance;
    
    

    public List<Lance> getLance() {
        return lance;
    }

    public void setLance(List<Lance> lance) {
        this.lance = lance;
    }
      
    
     public String getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(String campeonato) {
        this.campeonato = campeonato;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

   
   
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

  

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getPlacar1() {
        return placar1;
    }

    public void setPlacar1(String placar1) {
        this.placar1 = placar1;
    }

    public String getPlacar2() {
        return placar2;
    }

    public void setPlacar2(String placar2) {
        this.placar2 = placar2;
    }
    
             
}
