package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Ingresso;

public class IngressoDAO {
	
	public Ingresso consultarPorId(Integer id) {
		Ingresso ingresso = new Ingresso();
		
		String SQL = "SELECT * FROM ingresso WHERE id = ?";
		
		Connection cnx = Dao.getConexao();

		try {
			PreparedStatement ps = cnx.prepareStatement(SQL);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ingresso.setId(rs.getInt("id"));
				ingresso.setValor(rs.getInt("valor"));
				ingresso.setQuantidade(rs.getInt("quantidade"));
				ingresso.setDescricao(rs.getString("descricao"));
				ingresso.setQrcode(rs.getString("qrcode"));
				ingresso.setUser_id(rs.getInt("user_id"));
				ingresso.setEvento_id(rs.getInt("evento_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.setFecharConexao();
			return ingresso;
		}
	}

	public boolean incluir(Ingresso ingresso) {
		boolean resultado = true;

		Connection cnx = Dao.getConexao();

		String SQL = "INSERT INTO ingresso(valor, quantidade, descricao, qrcode, user_id, evento_id) VALUES(?, ?, ?, ?, ?, ?)";

		PreparedStatement ps;

		try {
			ps = cnx.prepareStatement(SQL);

			ps.setInt(1, ingresso.getValor());
			ps.setInt(2, ingresso.getQuantidade());
			ps.setString(3, ingresso.getDescricao());
			ps.setString(4, ingresso.getQrcode());
			ps.setInt(5, ingresso.getUser_id());
			ps.setInt(6, ingresso.getEvento_id());

			int i = ps.executeUpdate();

			resultado = i > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public boolean excluir(Integer id) {
		boolean resultado = false;

		Connection cnx = Dao.getConexao();

		String SQL = "DELETE FROM ingresso WHERE id = ?";

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

	public List<Ingresso> listar() {
		List<Ingresso> listaringresso = new ArrayList<Ingresso>();
		Ingresso ingresso;

		String SQL = "SELECT * FROM ingresso";

		Connection cnx = Dao.getConexao();

		PreparedStatement ps;

		try {
			ps = cnx.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ingresso = new Ingresso();
				ingresso.setId(rs.getInt("id"));
				ingresso.setValor(rs.getInt("valor"));
				ingresso.setQuantidade(rs.getInt("quantidade"));
				ingresso.setDescricao(rs.getString("descricao"));
				ingresso.setQrcode(rs.getString("qrcode"));
				ingresso.setUser_id(rs.getInt("user_id"));
				ingresso.setEvento_id(rs.getInt("evento_id"));

				listaringresso.add(ingresso);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.setFecharConexao();
			return listaringresso;
		}

	}

}
