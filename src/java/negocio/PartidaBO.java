/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Partida;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import persistencia.PartidaDAO;

/**
 *
 * @author Administrador
 */
public class PartidaBO {

    public void salvarPartida(Partida partida) {

        Date dataAtual = new Date();
        if (dataAtual.after(partida.getDataPartida())) {
            throw new RuntimeException("Não é permitido cadastrar datas antigas (apenas data atual ou futura)");
        }


        PartidaDAO partidaDAO = new PartidaDAO();
        partidaDAO.persistir(partida);
    }

    public void salvar(Partida partida) {

        PartidaDAO partidaDAO = new PartidaDAO();
        partidaDAO.persistir(partida);
    }

    public List<Partida> listarPartidas() {
        PartidaDAO listarPartidas = new PartidaDAO();
        List<Partida> todasPartidas = listarPartidas.obterPartidas();
        return todasPartidas;
    }

    public List<Partida> listarPartidasIniciadas() {
        List<Partida> partidasRetorno = new ArrayList<Partida>();
        PartidaDAO listarPartidas = new PartidaDAO();
        List<Partida> todasPartidas = listarPartidas.obterPartidas();
        for (int i = 0; i < todasPartidas.size(); i++) {
            if (todasPartidas.get(i).getStatus() != 2) {
                partidasRetorno.add(todasPartidas.get(i));
            }
        }
        return partidasRetorno;
    }
    GregorianCalendar dataOntem = new GregorianCalendar();
    GregorianCalendar dataAmanha = new GregorianCalendar();

    public List<Partida> listarPartidasdoDia() {

        List<Partida> partidasDia = new ArrayList<Partida>();
        PartidaDAO listarPartidas = new PartidaDAO();
        List<Partida> todasPartidas = listarPartidas.obterPartidas();
        dataOntem.add(GregorianCalendar.DAY_OF_MONTH, -1);
        dataAmanha.add(GregorianCalendar.DAY_OF_MONTH, +1);
        // Date dataHoje = new Date();
        for (int i = 0; i < todasPartidas.size(); i++) {
            if ((todasPartidas.get(i).getDataPartida().after(dataOntem.getTime())) && (todasPartidas.get(i).getDataPartida().before(dataAmanha.getTime()))) {
                partidasDia.add(todasPartidas.get(i));
            }
        }
        return partidasDia;
    }

    public List<Partida> listarPartidasEncerradas() {
        List<Partida> partidasRetorno = new ArrayList<Partida>();
        PartidaDAO listarPartidas = new PartidaDAO();
        List<Partida> todasPartidas = listarPartidas.obterPartidas();
        for (int i = 0; i < todasPartidas.size(); i++) {
            if (todasPartidas.get(i).getStatus() == 2) {
                partidasRetorno.add(todasPartidas.get(i));
            }
        }
        return partidasRetorno;
    }

    public List<Partida> listarProximasPartidas() {
        List<Partida> partidasRetorno = new ArrayList<Partida>();
        PartidaDAO listarPartidas = new PartidaDAO();
        List<Partida> todasPartidas = listarPartidas.obterPartidas();
        for (int i = 0; i < todasPartidas.size(); i++) {
            if (todasPartidas.get(i).getStatus() == 0) {
                partidasRetorno.add(todasPartidas.get(i));
            }
        }
        return partidasRetorno;
    }

    public Partida listarPartidasTempoRealLanceLance(Partida partidaSelecionada) {
        Partida partidaRetorno = null;
        PartidaDAO listarPartidas = new PartidaDAO();
        List<Partida> todasPartidas = listarPartidas.obterPartidas();
        for (int i = 0; i < todasPartidas.size(); i++) {
            if (todasPartidas.get(i).getIdPartida() == partidaSelecionada.getIdPartida()) {
                partidaRetorno = todasPartidas.get(i);
            }
        }
        return partidaRetorno;
    }
}
