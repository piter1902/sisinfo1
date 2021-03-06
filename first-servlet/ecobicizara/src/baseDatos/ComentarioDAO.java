package baseDatos;

/** 
 * Clase DAO para la clase Comentario. Permite comprobar que comentarios han sido respondidos. 
 *  
 * @author Pedro Tamargo Allue 
 */

import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class ComentarioDAO {

	// Sentencia SQL para obtener todos los comentarios
	protected static final String findALL = "select * from Comentario";
	protected static final String findID = "select * from Comentario where comentarioId = ?";
	// Sentencia SQL para introducir un comentario en la BD
	protected static final String insertComentario = "insert into Comentario (texto, email, nombre, apellidos, antecesor, asunto) values (?,?,?,?,?,?)"; // comentId
																																							// es
	// auto_increment

	/**
	 * Metodo que devuelve una lista con todos los Comentarios de la BD
	 * 
	 * @return lista con todos los comentarios de la BD
	 */
	public static List<Comentario> findAllComentarios() {
		List<Comentario> lista = new LinkedList<>();
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(findALL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new Comentario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	/**
	 * Metodo que devuelve el comentario cuyo id concuerda con <id>
	 * 
	 * @param id identificador con el que comparar
	 * @return Comentario cuyo id concuerda con <id>. <null> en caso de que no
	 *         exista con el identificador dado.
	 */
	public static Comentario findByID(int id) {
		Comentario com = null;
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(findID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				com = new Comentario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return com;
	}

	/**
	 * Metodo que inserta un comentario en la BD
	 * 
	 * @param com comentario que contiene todos los campos a insertar
	 * @return true si se ha insertado, false en caso contrario
	 */
	public static boolean insertComentario(Comentario com) {
		boolean ok = false;
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(insertComentario);
			ps.setString(1, com.getText());
			ps.setString(2, com.getEmail());
			ps.setString(3, com.getNombre());
			ps.setString(4, com.getApellidos());
			ps.setInt(5, com.getAntecesor());
			ps.setString(6, com.getAsunto());
			ok = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	/**
	 * Metodo que devuelve el padre de un comentario (referenciado por <antecesor>)
	 * 
	 * @param com comentario a buscar el padre. Es completo, es decir, tiene todos
	 *            los campos asignados. (nada a <null>)
	 * @return <comentario> si existe. <null> en caso contrario
	 */
	public static Comentario getParent(Comentario com) {
		return findByID(com.getAntecesor());
	}

}