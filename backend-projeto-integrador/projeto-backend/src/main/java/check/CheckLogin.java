package check;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Dao;
import hash.BCrypt;

public class CheckLogin {
	
	public boolean checkLogin(String email, String senha) {
		Connection cnx = Dao.getConexao();
		PreparedStatement ps;
		ResultSet rs;
		boolean check = false;
		
		String hash = "$2a$12$FN7exnLVO3fxespC9L2KI.";
		
		String hashSenha = BCrypt.hashpw(senha, hash);
		
		if(!email.isEmpty() && !senha.isEmpty()) {
			try {
				ps = cnx.prepareStatement("SELECT * FROM user WHERE email = ? and senha = ?");
				ps.setString(1, email);
				ps.setString(2, hashSenha);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					check = true;
				}
				
				rs.close();
				ps.close();
			} catch(SQLException e) {
				System.out.println(e);
			}
		}
		
		return check;
	}
}
// https://stackoverflow.com/questions/55156010/verify-bcrypt-hash-password-when-login
// https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/#5-1-creating-hash-using-bcrypt-with-salt
// https://cursos.alura.com.br/forum/topico-utilizando-bcrypt-228825
// https://stackoverflow.com/questions/6832445/how-can-bcrypt-have-built-in-salts