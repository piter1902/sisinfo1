package baseDatos; 
 
/**  
 * Clase DAO para la clase Comentario. Permite comprobar que comentarios han sido respondidos.  
 *   
 * @author Pedro Tamargo Allue  
 */ 
 
import java.sql.*; 
import java.util.List; 
import java.util.LinkedList; 

import com.google.gson.Gson;
 
public class PuntosNegrosDAO { 
 
	// Sentencia SQL para obtener todos los comentarios 
	protected static final String findALL = "select * from PuntosNegros"; 
 
	/** 
	 * Metodo que devuelve una lista con todos los Comentarios de la BD 
	 *  
	 * @return lista con todos los comentarios de la BD 
	 */ 
	public static List<PuntosNegros> findAllPuntos() { 
		List<PuntosNegros> lista = new LinkedList<>(); 
		try { 
			Connection c = ConnectionManager.getConnection(); 
			PreparedStatement ps = c.prepareStatement(findALL); 
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				lista.add(new PuntosNegros(rs.getDouble(1), rs.getDouble(2), rs.getInt(3))); 
			} 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return lista; 
	} 
	
	public static String getJSON(List<PuntosNegros> lista) {
		return new Gson().toJson(lista);
	}
}