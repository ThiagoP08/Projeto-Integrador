package service;

import java.util.List;

import dao.AdminDAO;
import model.Admin;

public class AdminService {
	AdminDAO dao = new AdminDAO();
	
	public List<Admin> listarAdmins() {
		return dao.listar();
	}
	
	public Admin buscarAdminPorId(Integer id) {
		return dao.consultarPorId(id);
	}
	
	public boolean excluirAdmin(Integer id) {
		return dao.excluir(id);
	}
	
	public boolean incluirAdmin(Admin admin) {
		return dao.incluir(admin);
	}
	
	public boolean alterarAdmin(Admin admin) {
		return dao.editar(admin);
	}
}
