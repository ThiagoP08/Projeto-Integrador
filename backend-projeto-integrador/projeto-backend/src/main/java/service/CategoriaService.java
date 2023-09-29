package service;

import java.util.List;

import dao.CategoriaDAO;
import model.Categoria;

public class CategoriaService {

	CategoriaDAO dao = new CategoriaDAO();
	
	public List<Categoria> listarCategoria() {
		return dao.listar();
	}
	
	public Categoria buscarCategoriaPorId(Integer id) {
		return dao.consultarPorId(id);
	}
	
	public boolean excluirCategoria(Integer id) {
		return dao.excluir(id);
	}
	
	public boolean incluirCategoria(Categoria categoria) {
		return dao.incluir(categoria);
	}
	
	public boolean alterarCategoria(Categoria categoria) {
		return dao.editar(categoria);
	}
}
