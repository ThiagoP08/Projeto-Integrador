package service;

import java.util.List;

import dao.UserDAO;
import model.User;

public class UserService {
	UserDAO dao = new UserDAO();
	
	public List<User> listarUsers() {
		return dao.listar();
	}
	
	public User buscarUserPorId(Integer id) {
		return dao.consultarPorId(id);
	}
	
	public boolean excluirUser(Integer id) {
		return dao.excluir(id);
	}
	
	public boolean incluirUser(User user) {
		return dao.incluir(user);
	}
	
	public boolean alterarUser(User user) {
		return dao.editar(user);
	}
}
