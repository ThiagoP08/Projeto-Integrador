package service;

import java.util.List;

import dao.EventoDAO;
import model.Evento;

public class EventoService {
	EventoDAO dao = new EventoDAO();
	
	public List<Evento> listarEventos() {
		return dao.listar();
	}
	
	public Evento buscarEventoPorId(Integer id) {
		return dao.consultarPorId(id);
	}
	
	public Evento listarRandom() {
		return dao.eventoRandom();
	}
	
	public boolean excluirEvento(Integer id) {
		return dao.excluir(id);
	}
	
	public boolean incluirEvento(Evento evento) {
		return dao.incluir(evento);
	}
	
	public boolean alterarEvento(Evento evento) {
		return dao.editar(evento);
	}
}
