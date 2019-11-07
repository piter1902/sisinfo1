package baseDatos;
/**
 * Clase DAO para la clase vehiculo. Permitira hacer comprobaciones de factores
 * de emision sobre distintos parametros.
 * 
 * @author Pedro Tamargo Allue
 */

import java.sql.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.LinkedList;

public class UsuarioDAO {

	// Sentencias SQL para la seleccion de BD
	protected static final String findALL = "select * from Usuario";
	protected static final String findByLogin = "select * from Usuario where login = ?";
	// Sentencias SQL para actualizar un usuario de la BD
	protected static final String updateUser = "update Usuario set password = ?, nombre = ?, apellidos = ?, email = ?, vehic_id = ? where login = ?";
	protected static final String insertUser = "insert into Usuario (login, password, nombre, apellidos, email, vehic_id) VALUES (?, ?, ?, ?, ?, ?)";

	/**
	 * Metodo para buscar todos los usuarios de la BD
	 * 
	 * @return lista con todos los usuarios de la BD
	 */
	public static List<Usuario> findAllUsers() {
		List<Usuario> lista = new LinkedList<>();
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(findALL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	/**
	 * Metodo que devuelve el Usuario cuyo login coincide con el dado
	 * 
	 * @param login login con el que comparar
	 * @return <usuario> si existe un usuario en la BD cuyo login coincide con
	 *         <login>. null si no existe ninguno.
	 */
	public static Usuario findUserByLogin(String login) {
		Usuario user = null;
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(findByLogin);
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * Metodo que dado un Usuario <user> comprueba si existe en la BD y si su
	 * <password> coincide con el de la BD
	 * 
	 * @param user  usuario a validar
	 * @param error En caso de que hay un error en la validación, se modifica el
	 *              valor por una cadena correspondiente al error
	 * @return true si coincide. false en caso contrario.
	 */
	public static boolean validateUser(Usuario user, String error) {
		String login = user.getLogin();
		String password = user.getPassword();
		String nombre = user.getNombre();
		String apellidos = user.getApellidos();
		String email = user.getEmail();
		int vehicle_id = user.getVehicle_id();
		// Patrón para comprobar si el email es correcto
		Pattern patron = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher match = patron.matcher(email);
		// Comprobamos que no hay ningun campo vacío.
		if (login.isEmpty() || password.isEmpty() || email.isEmpty() || apellidos.isEmpty()) {
			error = "Debe completar todos campos.";
			return false;
		} else {
			// Comprobamos patrón
			if (match.find()) {
				// Caso de que el patrón es válido, comprobamos si ya existía ese usuario.
				if (UsuarioDAO.findUserByLogin(login) == null) {
					error = null;
					return true;
				} else {
					error = "El usuario " + login + " ya esta registrado.";
					return false;
				}
			} else {
				error = "email incorrecto";
				return false;
			}
		}
	}

	/**
	 * Metodo que actualiza la información de un usuario existente en la BD.
	 * 
	 * @param user usuario con informacion actualizada
	 * @return true si se ha actualizado. false en caso contrario.
	 */
	public static boolean updateUsuario(Usuario user) {
		boolean correcto = false;
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(updateUser);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getNombre());
			ps.setString(3, user.getApellidos());
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getVehicle_id());
			ps.setString(6, user.getLogin());
			correcto = ps.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return correcto;
	}

	/**
	 * Metodo para insertar un nuevo usuario en la BD
	 * 
	 * @param login      login name del usuario
	 * @param password   password encriptada del usuario
	 * @param nombre     nombre del usuario
	 * @param apellidos  apllidos del usuario
	 * @param email      email del usuario
	 * @param vehicle_id id del vehiculo del usuario (TODO: cambiar esta referencia
	 *                   por surco de datos ? -> Tabla nueva que almacene estos
	 *                   datos?)
	 * 
	 * @return Si los parámetros son correctos, inserta el usuario en la BD
	 */
	public static void insertUser(String login, String password, String nombre, String apellidos, String email,
			int vehicle_id) {
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(insertUser);
			ps.setString(1, login);
			ps.setString(2, password);
			ps.setString(3, nombre);
			ps.setString(4, apellidos);
			ps.setString(5, email);
			ps.setInt(6, vehicle_id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}