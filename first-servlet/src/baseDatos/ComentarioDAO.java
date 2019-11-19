package baseDatos;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ComentarioDAO {

	// Sentencias de busqueda
	protected static final String findAll = "select * from Comentario";
	protected static final String findById = "select * from Comentario where id = ?";
	protected static final String maxElem = "select max(comentId) from Comentario";
	// Sentencias de insercion -> id con auto_increment
	protected static final String insertComentario = "insert into Comentario(texto,email,nombre,apellidos,respondida) values (?,?,?,?,?)";
	// Update respondida
	protected static final String updateRespondida = "update Comentario set respondida = true where comentarioId = ?";

	public static List<Comentario> findAll() {
		List<Comentario> lista = new LinkedList<>();
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(findAll);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new Comentario(rs.getInt("id"), rs.getString("email"), rs.getString("nombre"),
						rs.getString("apellidos"), rs.getString("texto"), rs.getBoolean("respondida")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public static Comentario findById(int id) {
		Comentario com = null;
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(findById);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				com = new Comentario(rs.getInt("id"), rs.getString("email"), rs.getString("nombre"),
						rs.getString("apellidos"), rs.getString("texto"), rs.getBoolean("respondida"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return com;
	}

	public static int insertComentario(Comentario c) {
		return insertComentario(c.getEmail(), c.getNombre(), c.getApellidos(), c.getText(), c.isRespondida());
	}

	private static int insertComentario(String email, String nombre, String apellidos, String text,
			boolean respondida) {
		int id = -1;
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(insertComentario);
			ps.setString(1, text);
			ps.setString(2, email);
			ps.setString(3, nombre);
			ps.setString(4, apellidos);
			ps.setBoolean(5, respondida);
			ps.executeUpdate();
			ps = c.prepareStatement(maxElem);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public static boolean updateRespondida(Comentario c) {
		return updateRespondida(c.getComentID());
	}

	private static boolean updateRespondida(int id) {
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(updateRespondida);
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
}
