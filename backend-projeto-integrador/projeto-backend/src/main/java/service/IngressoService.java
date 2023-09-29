package service;

import dao.IngressoDAO;
import model.Ingresso;

import java.util.List;

public class IngressoService {

    private final IngressoDAO ingressoDAO = new IngressoDAO();

    public Ingresso consultarPorId(Integer id) {
        return ingressoDAO.consultarPorId(id);
    }

    public boolean incluir(Ingresso ingresso) {
        return ingressoDAO.incluir(ingresso);
    }

    public boolean excluir(Integer id) {
        return ingressoDAO.excluir(id);
    }

    public List<Ingresso> listar() {
        return ingressoDAO.listar();
    }
}
