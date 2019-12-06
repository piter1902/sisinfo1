package baseDatos;

/** 
 * Clase DAO para la clase Comentario. Permite comprobar que comentarios han sido respondidos. 
 *  
 * @author Pedro Tamargo Allue 
 */

import java.sql.*;
import java.util.List;

import com.google.gson.Gson;

import java.util.LinkedList;

public class ConsultaDAO {

	// Sentencia SQL para obtener todos los comentarios
	protected static final String findALL = "select * from Comentario";
	protected static final String findByDate = "select * from Consulta where login = ? and fecha = ?";
	protected static final String findID = "select * from Consulta where id = ?";
	// Sentencia SQL para introducir un comentario en la BD
	protected static final String insertConsulta = "insert into Consulta (login, fecha, origen, destino) values (?,?,?,?)";
	

	/**
	 * Metodo que devuelve una lista con todos los Comentarios de la BD
	 * 
	 * @return lista con todos los comentarios de la BD
	 */
	public static List<Comentario> findAllComentarios(String login) {
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
	 * Metodo que devuelve la consulta cuyo id concuerda con <id>
	 * 
	 * @param id identificador con el que comparar
	 * @return Consulta cuyo id concuerda con <id>. <null> en caso de que no
	 *         exista con el identificador dado.
	 */
	public static Consulta findByID(int id) {
		Consulta con = null;
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(findID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				con = new Consulta(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(5), rs.getDate(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * Metodo que devuelve una lista de consultas efectuadas en un día en concreto
	 * 
	 * @param login login del usuario que realiza la consulta
	 * @param fecha fecha de la/las consultas a obtener 
	 * @return Lista de consultas cuya fecha coincide con <fecha> del usuario <login>
	 * 
	 */
	public static List<Consulta> findByDate(String login, Date fecha) {
		List<Consulta> list_con = new LinkedList<>();
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(findByDate);
			ps.setString(1, login );
			ps.setDate(2, fecha);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list_con.add(new Consulta(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(5), rs.getDate(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list_con;
	}
	/**
	 * Metodo que devuelve una cadena en formato JSON
	 * 
	 * @param lista lista de consultas
	 * @return
	 */
	public static String getJSON(List<Consulta> lista) {
		return new Gson().toJson(lista);
	}
	
	/**
	 * Metodo que inserta una consulta en la BD
	 * 
	 * @param con consulta que contiene todos los campos a insertar
	 * @return true si se ha insertado, false en caso contrario
	 */
	public static boolean insertConsulta(Consulta con) {
		boolean ok = false;
		//Se necesita esta conversion para evitar fallos
		java.sql.Date fechaSQL = new java.sql.Date(con.getFecha().getTime());
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(insertConsulta);
			ps.setString(1, con.getLogin());
			ps.setDate(2, fechaSQL);
			ps.setString(3, con.getOrigen());
			ps.setString(4, con.getDestino());
			ok = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

}