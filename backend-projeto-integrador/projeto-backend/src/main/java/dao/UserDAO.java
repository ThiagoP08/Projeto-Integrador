package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO {
	
	public User consultarPorId(Integer id) {
	    User user = new User();
	    
	    String SQL = "SELECT * FROM user WHERE id = ?";
	    
	    Connection cnx = Dao.getConexao();

	    try {
	        PreparedStatement ps = cnx.prepareStatement(SQL);
	        
	        ps.setInt(1, id);
	        
	        ResultSet rs = ps.executeQuery();

	        while(rs.next()) {
	            user.setId(rs.getInt("id"));
	            user.setEmail(rs.getString("email"));
	            user.setSenha(rs.getString("senha"));
	            user.setNome(rs.getString("nome"));
	            user.setUsername(rs.getString("username"));
	            user.setDtNascimento(rs.getString("dtNascimento"));
	            user.setCpf(rs.getString("cpf"));
	            user.setEndereco(rs.getString("endereco"));
	            user.setCep(rs.getString("cep"));
	            user.setStatus_admin(rs.getBoolean("status_admin"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        Dao.setFecharConexao();
	        return user;
	    }
	}

	public boolean incluir(User user) {
		boolean resultado = true;
		
		Connection cnx = Dao.getConexao();
		
		String SQL = "INSERT INTO user(email, senha, nome, username, dtNascimento, cpf, endereco, cep, status_admin) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getSenha());
			ps.setString(3, user.getNome());
            ps.setString(4, user.getUsername());
			ps.setString(5, user.getDtNascimento());
			ps.setString(6, user.getCpf());
			ps.setString(7, user.getEndereco());
            ps.setString(8, user.getCep());
			ps.setBoolean(9, user.getStatus_admin());
			
			
			int i = ps.executeUpdate();
			
			resultado = i > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public boolean editar(User user) {
	    boolean resultado = false;

	    Connection cnx = Dao.getConexao();

	    String SQL = "UPDATE user SET email = ?, nome = ?, username = ?, dtNascimento = ?, endereco = ?, cep = ?, status_admin = ? WHERE id = ?";

	    PreparedStatement ps;

	    try {
	        ps = cnx.prepareStatement(SQL);

			ps.setString(1, user.getEmail());
			ps.setString(2, user.getNome());
            ps.setString(3, user.getUsername());
			ps.setString(4, user.getDtNascimento());
			ps.setString(5, user.getCpf());
			ps.setString(6, user.getEndereco());
			ps.setString(7, user.getCep());
			ps.setBoolean(8, user.getStatus_admin());


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

	    String SQL = "DELETE FROM user WHERE id = ?";

	    PreparedStatement ps;

	    try {
	        ps = cnx.prepareStatement(SQL);

	        ps.setInt(1, id);

	        int i = ps.executeUpdate();

	        resultado = i > 0 ? true : false; //IF Terciario
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return resultado;
	}
	
	public List<User> listar() {
		List<User> listarUser = new ArrayList<User>();
		User user;
				
		String SQL = "SELECT * FROM user";
		
		Connection cnx = Dao.getConexao();
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new User();
	            user.setId(rs.getInt("id"));
	            user.setEmail(rs.getString("email"));
	            user.setSenha(rs.getString("senha"));
	            user.setNome(rs.getString("nome"));
	            user.setUsername(rs.getString("username"));
	            user.setDtNascimento(rs.getString("dtNascimento"));
	            user.setCpf(rs.getString("cpf"));
	            user.setEndereco(rs.getString("endereco"));
	            user.setCep(rs.getString("cep"));
	            user.setStatus_admin(rs.getBoolean("status_admin"));
				
				listarUser.add(user);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.setFecharConexao();
			return listarUser;
		}
	}

}
