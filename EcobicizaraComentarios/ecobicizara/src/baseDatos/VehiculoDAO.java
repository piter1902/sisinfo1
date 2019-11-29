package baseDatos;

/**
 * Clase DAO para la clase vehiculo. Permitira hacer comprobaciones de factores
 * de emision sobre distintos parametros.
 * 
 * @author Pedro Tamargo Allue
 */

import java.sql.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class VehiculoDAO {

	protected static final String findALL = "select * from Vehiculo";

	// Sentencia de busqueda sobre una condicion
	// Se tienen en cuenta los primeros 8506 elementos (los obtenidos de lafuente de
	// datos para calcular los factores de emision)
	private static final int MAX_ELEM_MIRAR = 8506;
	protected static final String findOverCondition_tipo = "select * from Vehiculo where tipo = ? and id < " + MAX_ELEM_MIRAR,
			findOverCondition_segment = "select * from Vehiculo where segment = ? and id < " + MAX_ELEM_MIRAR,
			findOverCondition_euro_star = "select * from Vehiculo where euro_star = ? and id < " + MAX_ELEM_MIRAR,
			findOverCondition_engine_type = "select * from Vehiculo where engine_type = ? and id < " + MAX_ELEM_MIRAR,
			findOverCondition_fuel = "select * from Vehiculo where fuel = ? and id < " + MAX_ELEM_MIRAR,
			findOverCondition_pollutant = "select * from Vehiculo where pollutant = ? and id < " + MAX_ELEM_MIRAR;
	// Para insertar un vehiculo en la BD -> la clave tiene auto_increment
	protected static final String insertOnDB = "insert on Vehiculo values (?,?,?,?,?,?,?)";
	// Para obtener el factor de emision de forma estadistica en funcion de los
	// parametros especificados
	protected static final String obtainEmFactor = "select emission_factor as em from ";
	// Obtener el elemento maximo de la tabla Vehiculo
	protected static final String getMaxId = "select max(id) as maximo from Vehiculo";
	// Sentencia SQL para borrar eliminar un vehiculo de la BD
	protected static final String deleteVehiculo = "delete from Vehiculo where id = ?";

	/**
	 * Metodo que devuelve una lista con todos los elementos de la tabla Vehiculo
	 * 
	 * @return lista de vehiculos que contiene todos los elementos de la tabla
	 *         Vehiculo de la BD
	 */
	public static List<Vehiculo> findAllVehiculos() {
		List<Vehiculo> lista = new LinkedList<>();
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement stmnt = c.prepareStatement(findALL);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				lista.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getFloat(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	/**
	 * Metodo que devuelve una lista con todos los elementos de la tabla vehiculo
	 * que cumplen la condicion de que sus campos son iguales a los de los
	 * parametros pasados si estos son distintos de null.
	 * 
	 * Metodo wrapper de findOverCondition
	 * 
	 * @param v vehiculo con los atributos a inferir
	 * @return lista con los vehiculos que cumplen las caracteristicas descritas.
	 */
	public static List<Vehiculo> findOverCondition(Vehiculo v) {
		return findOverCondition(v.getTipo(), v.getSegment(), v.getEngine_type(), v.getEngine_type(), v.getFuel(),
				v.getPollutant());
	}

	/**
	 * Metodo que devuelve una lista con todos los elementos de la tabla vehiculo
	 * que cumplen la condicion de que sus campos son iguales a los de los
	 * parametros pasados si estos son distintos de null.
	 * 
	 * @param tipo        tipo del vehiculo
	 * @param segment     segmento comercial del vehiculo
	 * @param euro_star   clasificacion ambiental del vehiculo
	 * @param engine_type tecnologia del motor del vehiculo
	 * @param fuel        tipo de combustible del vehiculo
	 * @param pollutant   compuesto contaminante del vehiculo
	 * @return lista con los vehiculos que cumplen las caracteristicas descritas.
	 */
	public static List<Vehiculo> findOverCondition(String tipo, String segment, String euro_star, String engine_type,
			String fuel, String pollutant) {
		final String intersect = "intersect ";
		List<Vehiculo> lista = new LinkedList<>();
		int index = 1;
		try {
			Connection c = ConnectionManager.getConnection();
			String sqlStmnt = "";
			Map<Integer, String> mapa = new TreeMap<>();
			if (tipo != null) {
				sqlStmnt += (index == 1 ? findOverCondition_tipo : intersect + findOverCondition_tipo);
				mapa.put(index, tipo);
				index++;
			}
			if (segment != null) {
				sqlStmnt += (index == 1 ? findOverCondition_segment : intersect + findOverCondition_segment);
				mapa.put(index, segment);
				index++;
			}
			if (euro_star != null) {
				sqlStmnt += (index == 1 ? findOverCondition_euro_star : intersect + findOverCondition_euro_star);
				mapa.put(index, euro_star);
				index++;
			}
			if (engine_type != null) {
				sqlStmnt += (index == 1 ? findOverCondition_engine_type : intersect + findOverCondition_engine_type);
				mapa.put(index, engine_type);
				index++;
			}
			if (fuel != null) {
				sqlStmnt += (index == 1 ? findOverCondition_fuel : intersect + findOverCondition_fuel);
				mapa.put(index, fuel);
				index++;
			}
			if (pollutant != null) {
				sqlStmnt += (index == 1 ? findOverCondition_pollutant : intersect + findOverCondition_pollutant);
				mapa.put(index, pollutant);
				index++;
			}
			System.out.println(sqlStmnt);
			PreparedStatement ps = c.prepareStatement(sqlStmnt);
			// Ahora recorremos el map para saber los valores de los indices a aplicar
			for (int i = 1; i <= 6 && mapa.containsKey(i); i++) {
				String value = mapa.get(i);
				ps.setString(i, value);
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getFloat(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	public static boolean deleteVehiculo(Vehiculo v) {
		boolean ok = false;
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(deleteVehiculo);
			ps.setInt(1, v.getId());
			ok = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	public static int insertStadistic(Vehiculo v, List<Vehiculo> lista) {
		int index = 1;
		int id = -1;
		try {
			Connection c = ConnectionManager.getConnection();
			Map<Integer, String> mapa = new TreeMap<>();
			mapa.put(1, v.getTipo());
			mapa.put(2, v.getSegment());
			mapa.put(3, v.getEuro_star());
			mapa.put(4, v.getEngine_type());
			mapa.put(5, v.getFuel());
			mapa.put(6, v.getPollutant());
			float emission_factor = calcularMedia_emissionFactor(lista);
			mapa.put(7, Float.toString(emission_factor));
			PreparedStatement ps = c.prepareStatement(insertOnDB);
			for (int i = 1; i <= 7 && mapa.containsKey(i); i++) {
				String value = mapa.get(i);
				if (i == 7) {
					ps.setFloat(i, Float.parseFloat((String) mapa.get(i)));
				} else {
					ps.setString(i, value);
				}
			}
			ps.executeUpdate();
			// El maximo elemento de la tabla count deberia ser el id de nuestro vehiculo
			ps = c.prepareStatement(getMaxId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("maximo");
			}
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		return id;
	}

	private static float calcularMedia_emissionFactor(List<Vehiculo> lista) {
		float ret = 0;
		for (Vehiculo v : lista) {
			ret += v.getEmission_factor();
		}
		return ret / lista.size();
	}

}