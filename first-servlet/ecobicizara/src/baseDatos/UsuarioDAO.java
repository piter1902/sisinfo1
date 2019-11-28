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
	protected static final String findIfEmailIsUsed = "select count(*) as veces from Usuario where email = ?"; 
	// Sentencia SQL para la validacion del usuario 
	protected static final String findIfPasswordMatchs = "select count(*) as veces from Usuario where login = ? and password = MD5(?)"; 
	// Sentencias SQL para actualizar un usuario de la BD 
	protected static final String updateUser = "update Usuario set login = ?, password = ?, nombre = ?, apellidos = ?, email = ?, vehic_id = ? where login = ?"; 
	protected static final String insertUser = "insert into Usuario (login, password, nombre, apellidos, email, vehic_id) VALUES (?, MD5(?), ?, ?, ?, ?)"; 
	// Sentencias SQL para borrar un usuario de una BD 
	protected static final String deleteUser = "delete from Usuario where login = ?"; 
 
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
	
	
	public static boolean findIfEmailExists(String email) { 
		Usuario user = null; 
		boolean exist = false;
		try { 
			Connection c = ConnectionManager.getConnection(); 
			PreparedStatement ps = c.prepareStatement(findIfEmailIsUsed); 
			ps.setString(1, email); 
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				exist = rs.getInt("veces") > 1;
			} 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return exist; 
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
	public static boolean validateUser(Usuario user) { 
		boolean correcto = false; 
		try { 
			Connection c = ConnectionManager.getConnection(); 
			PreparedStatement ps = c.prepareStatement(findIfPasswordMatchs); 
			ps.setString(1, user.getLogin()); 
			ps.setString(2, user.getPassword()); 
			ResultSet rs = ps.executeQuery(); 
			// correcto = rs.next(); // Esto no esta bien 
			rs.next(); 
			correcto = rs.getInt("veces") == 1; 
			// Solo deberia haber un resultado -> correcto = true 
			// Podria no haber resultado -> correcto = false 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return correcto; 
	} 
 
	/** 
	 * Metodo que actualiza la información de un usuario existente en la BD. 
	 *  
	 * @param user usuario con informacion actualizada 
	 * @return true si se ha actualizado. false en caso contrario. 
	 */ 
	public static boolean updateUsuario(Usuario user, String login ) { 
		boolean correcto = false; 
		try { 
			Connection c = ConnectionManager.getConnection(); 
			PreparedStatement ps = c.prepareStatement(updateUser); 
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword()); 
			ps.setString(3, user.getNombre()); 
			ps.setString(4, user.getApellidos()); 
			ps.setString(5, user.getEmail()); 
			ps.setInt(6, user.getVehicle_id()); 
			ps.setString(7, login);
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
			System.out.println("iniciando"); 
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
 
	public static void insertUser(Usuario user) { 
		insertUser(user.getLogin(), user.getPassword(), user.getNombre(), user.getApellidos(), user.getEmail(), 
				user.getVehicle_id()); 
	} 
 

	public static boolean deleteUsuario(Usuario user) {
		boolean ok = false;
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(deleteUser);
			ps.setString(1, user.getLogin());
			ok = ps.executeUpdate() > 0 && (numUsuariosConVehicId(user.getVehicle_id()) > 0? VehiculoDAO
					.deleteVehiculo(new Vehiculo(user.getVehicle_id(), null, null, null, null, null, null, 0)) : true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	private static int numUsuariosConVehicId(int vehicle_id) {
		int nUser = 0;
		try{
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement("select count(*) as num_usuarios from Usuario where vehic_id = ?");
			ps.setInt(1, vehicle_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				nUser = rs.getInt("num_usuarios");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return nUser;
	}

}