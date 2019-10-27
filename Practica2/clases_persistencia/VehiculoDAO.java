
/**
 * Clase DAO para la clase vehiculo. Permitira hacer comprobaciones de factores
 * de emision sobre distintos parametros.
 * 
 * @author Pedro Tamargo Allue
 */

import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class VehiculoDAO {

    protected static final String findALL = "select * from Vehiculo";
    // protected static final String findOverCondition_flat = "select * from
    // Vehiculo where ";
    protected static final String findOverCondition_tipo = "select * from Vehiculo where tipo = ? ",
            findOverCondition_segment = "select * from Vehiculo where segment = ? ",
            findOverCondition_euro_star = "select * from Vehiculo where euro_star = ? ",
            findOverCondition_engine_type = "select * from Vehiculo where engine_type = ? ",
            findOverCondition_fuel = "select * from Vehiculo where fuel = ? ",
            findOverCondition_pollutant = "select * from Vehiculo where pollutant = ? ";

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
        List<Vehiculo> lista = new LinkedList<>();
        try {
            Connection c = ConnectionManager.getConnection();
            if (tipo != null) {
                //TODO: Acabar esto con intersecciones
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lista;
    }
}