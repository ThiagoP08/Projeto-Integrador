package check;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Dao;

public class CheckEmail {

	public boolean checkEmail(String email) {
		Connection cnx = Dao.getConexao();
		PreparedStatement ps;
		ResultSet rs;
		boolean check = false;
		
		if(!email.isEmpty()) {
			try {
				ps = cnx.prepareStatement("SELECT * FROM user WHERE email = ?");
				ps.setString(1, email);
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
