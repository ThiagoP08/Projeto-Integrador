package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;



public class CategoriaDAO {

	public Categoria consultarPorId(Integer id) {
		Categoria categoria = new Categoria();
		
		String SQL = "SELECT * FROM categorias WHERE id = ?";
		
		Connection cnx = Dao.getConexao();

		try {
			PreparedStatement ps = cnx.prepareStatement(SQL);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				categoria.setId(rs.getInt("id"));
				categoria.setCategoria(rs.getString("categoria"));
				categoria.setDescricao(rs.getString("descricao"));
				categoria.setImg_src(rs.getString("img_src"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.setFecharConexao();
			return categoria;
		}
	}

	public boolean incluir(Categoria categoria) {
		boolean resultado = true;

		Connection cnx = Dao.getConexao();

		String SQL = "INSERT INTO categorias(categoria, descricao, img_src) VALUES(?, ?, ?)";

		PreparedStatement ps;

		try {
			ps = cnx.prepareStatement(SQL);

			ps.setString(1, categoria.getCategoria());
			ps.setString(2, categoria.getDescricao());
			ps.setString(3, categoria.getImg_src());
			

			int i = ps.executeUpdate();

			resultado = i > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public boolean editar(Categoria categoria) {
		boolean resultado = false;

		Connection cnx = Dao.getConexao();

		String SQL = "UPDATE categorias SET categoria = ?, descricao = ?, img_src = ? WHERE id = ?";

		PreparedStatement ps;

		try {
			ps = cnx.prepareStatement(SQL);

			ps.setString(1, categoria.getCategoria());
			ps.setString(2, categoria.getDescricao());
			ps.setString(3, categoria.getImg_src());

			int i = ps.executeUpdate();

			resultado = i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public boolean excluir(Integer id) {
		boolean resultado = false;

		Connection cnx = Dao.getConexao();

		String SQL = "DELETE FROM categorias WHERE id = ?";

		PreparedStatement ps;

		try {
			ps = cnx.prepareStatement(SQL);

			ps.setInt(1, id);

			int i = ps.executeUpdate();

			resultado = i > 0 ? true : false; // IF Terciario
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public List<Categoria> listar() {
		List<Categoria> listarCategoria = new ArrayList<Categoria>();
		Categoria categoria;

		String SQL = "SELECT * FROM categorias";

		Connection cnx = Dao.getConexao();

		PreparedStatement ps;

		try {
			ps = cnx.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				categoria = new Categoria();
				categoria.setId(rs.getInt("id"));
				categoria.setCategoria(rs.getString("categoria"));
				categoria.setDescricao(rs.getString("descricao"));
				categoria.setImg_src(rs.getString("img_src"));

				listarCategoria.add(categoria);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.setFecharConexao();
			return listarCategoria;
		}

	}
	
}