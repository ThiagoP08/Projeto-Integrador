package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Admin;

public class AdminDAO {

	public Admin consultarPorId(Integer id) {
		Admin admin = new Admin();
		
		String SQL = "SELECT * FROM admin WHERE id = ?";
		
		Connection cnx = Dao.getConexao();

		try {
			PreparedStatement ps = cnx.prepareStatement(SQL);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				admin.setId(rs.getInt("id"));
				admin.setUser_id(rs.getInt("user_id"));
				admin.setStatus(rs.getBoolean("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.setFecharConexao();
			return admin;
		}
	}

	public boolean incluir(Admin admin) {
		boolean resultado = true;

		Connection cnx = Dao.getConexao();

		String SQL = "INSERT INTO admin(status, user_id) VALUES(?, ?, ?)";

		PreparedStatement ps;

		try {
			ps = cnx.prepareStatement(SQL);

			ps.setBoolean(1, admin.getStatus());
			ps.setInt(2, admin.getUser_id());

			int i = ps.executeUpdate();

			resultado = i > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public boolean editar(Admin admin) {
		boolean resultado = false;

		Connection cnx = Dao.getConexao();

		String SQL = "UPDATE admin SET status = ?, user_id = ? WHERE id = ?";

		PreparedStatement ps;

		try {
			ps = cnx.prepareStatement(SQL);

			ps.setBoolean(1, admin.getStatus());
			ps.setInt(2, admin.getUser_id());

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

		String SQL = "DELETE FROM admin WHERE id = ?";

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

	public List<Admin> listar() {
		List<Admin> listarAdmin = new ArrayList<Admin>();
		Admin admin;

		String SQL = "SELECT * FROM admin";

		Connection cnx = Dao.getConexao();

		PreparedStatement ps;

		try {
			ps = cnx.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setStatus(rs.getBoolean("status"));
				admin.setUser_id(rs.getInt("user_id"));

				listarAdmin.add(admin);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.setFecharConexao();
			return listarAdmin;
		}

	}
}
