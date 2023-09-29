package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Evento;

public class EventoDAO {
	
	public Evento eventoRandom() {
		Evento evento = new Evento();
		
		String SQL = "SELECT * from evento ORDER BY RAND() LIMIT 1";
		
		Connection cnx = Dao.getConexao();
		
		try {
			PreparedStatement ps = cnx.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
	        while (rs.next()) {
	            evento.setId(rs.getInt("id"));
	            evento.setImg_src(rs.getString("img_src"));
	            evento.setTitulo(rs.getString("titulo"));
	            evento.setData_evento(rs.getString("data_evento"));
	            evento.setHora(rs.getString("hora"));
	            evento.setEstado(rs.getString("estado"));
	            evento.setBairro(rs.getString("bairro"));
	            evento.setRua(rs.getString("rua"));
	            evento.setDescricao(rs.getString("descricao"));
	            evento.setPolitica(rs.getString("politica"));
	            evento.setMin_lotacao(rs.getInt("min_lotacao"));
	            evento.setMax_lotacao(rs.getInt("max_lotacao"));
	            evento.setStatus(rs.getBoolean("status"));
	            evento.setMin_idade(rs.getInt("min_idade"));
	            evento.setCategoria_id(rs.getInt("categoria_id"));
	        }
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
	        Dao.setFecharConexao();
	        return evento;
	    }
	}
	
	public Evento consultarPorId(Integer id) {
	    Evento evento = new Evento();
	    
	    String SQL = "SELECT * FROM evento WHERE id = ?";
	    
	    Connection cnx = Dao.getConexao();
	    
	    PreparedStatement ps;

	    try {
	        ps = cnx.prepareStatement(SQL);
	        
	        ps.setInt(1, id);
	        
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            evento.setId(rs.getInt("id"));
	            evento.setImg_src(rs.getString("img_src"));
	            evento.setTitulo(rs.getString("titulo"));
	            evento.setData_evento(rs.getString("data_evento"));
	            evento.setHora(rs.getString("hora"));
	            evento.setEstado(rs.getString("estado"));
	            evento.setBairro(rs.getString("bairro"));
	            evento.setRua(rs.getString("rua"));
	            evento.setDescricao(rs.getString("descricao"));
	            evento.setPolitica(rs.getString("politica"));
	            evento.setMin_lotacao(rs.getInt("min_lotacao"));
	            evento.setMax_lotacao(rs.getInt("max_lotacao"));
	            evento.setStatus(rs.getBoolean("status"));
	            evento.setMin_idade(rs.getInt("min_idade"));
	            evento.setCategoria_id(rs.getInt("categoria_id"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        Dao.setFecharConexao();
	        return evento;
	    }
	}

	public boolean incluir(Evento evento) {
		boolean resultado = true;
		
		Connection cnx = Dao.getConexao();
		
		String SQL = "INSERT INTO evento(img_src, titulo, data_evento, hora, bairro, estado, rua, descricao, politica, min_lotacao, max_lotacao, status, min_idade, categoria_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ps.setString(1, evento.getImg_src());
			ps.setString(2, evento.getTitulo());
			ps.setString(3, evento.getData_evento());
			ps.setString(4, evento.getHora());
			ps.setString(5, evento.getBairro());
			ps.setString(6, evento.getEstado());
			ps.setString(7, evento.getRua());
			ps.setString(8, evento.getDescricao());
			ps.setString(9, evento.getPolitica());
			ps.setInt(10, evento.getMin_lotacao());
			ps.setInt(11, evento.getMax_lotacao());
			ps.setBoolean(12, evento.getStatus());
			ps.setInt(13, evento.getMin_idade());
			ps.setInt(14, evento.getCategoria_id());
			
			int i = ps.executeUpdate();
			
			resultado = i > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

	public boolean editar(Evento evento) {
	    boolean resultado = false;

	    Connection cnx = Dao.getConexao();

	    String SQL = "UPDATE evento SET img_src = ?, titulo = ?, data_evento = ?, hora = ?, bairro = ?, estado = ?, rua = ?, descricao = ?, politica = ?, min_lotacao = ?, max_lotacao = ?, status = ?, min_idade = ?, categoria_id = ? WHERE id = ?";

	    PreparedStatement ps;

	    try {
	        ps = cnx.prepareStatement(SQL);

	        ps.setString(1, evento.getImg_src());
	        ps.setString(2, evento.getTitulo());
	        ps.setString(3, evento.getData_evento());
			ps.setString(4, evento.getHora());
			ps.setString(5, evento.getBairro());
			ps.setString(6, evento.getEstado());
			ps.setString(7, evento.getRua());
			ps.setString(8, evento.getDescricao());
			ps.setString(9, evento.getPolitica());
			ps.setInt(10, evento.getMin_lotacao());
			ps.setInt(11, evento.getMax_lotacao());
			ps.setBoolean(12, evento.getStatus());
			ps.setInt(13, evento.getMin_idade());
			ps.setInt(14, evento.getCategoria_id());

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

	    String SQL = "DELETE FROM evento WHERE id = ?";

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
	
	public List<Evento> listar() {
		List<Evento> listarEventos = new ArrayList<Evento>();
		Evento evento;
				
		String SQL = "SELECT * FROM evento";
		
		Connection cnx = Dao.getConexao();
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				evento = new Evento();
				evento.setId(rs.getInt("id"));
		        evento.setImg_src(rs.getString("img_src"));
		        evento.setTitulo(rs.getString("titulo"));
		        evento.setData_evento(rs.getString("data_evento"));
		        evento.setHora(rs.getString("hora"));
		        evento.setEstado(rs.getString("estado"));
		        evento.setBairro(rs.getString("bairro"));
		        evento.setRua(rs.getString("rua"));
		        evento.setDescricao(rs.getString("descricao"));
		        evento.setPolitica(rs.getString("politica"));
		        evento.setMin_lotacao(rs.getInt("min_lotacao"));
		        evento.setMax_lotacao(rs.getInt("max_lotacao"));
		        evento.setStatus(rs.getBoolean("status"));
		        evento.setMin_idade(rs.getInt("min_idade"));
		        evento.setCategoria_id(rs.getInt("categoria_id"));
				
				listarEventos.add(evento);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.setFecharConexao();
			return listarEventos;
		}
	}
}