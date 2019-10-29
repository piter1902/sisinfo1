
/**
 * Clase DAO para la clase Consulta. Permite comprobar que Consultas han sido respondidos.
 * 
 * @author Pedro Tamargo Allue
 */

import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class ConsultaDAO {

    // Sentencia SQL para obtener todos las Consultas
    static final String findALL = "select * from Consulta";
    static final String findID = "select * from Consulta where id = ?";

    /**
     * Metodo que devuelve una lista con todos las Consultas de la BD
     * 
     * @return lista con todos los Consultas de la BD
     */
    public static List<Consulta> findAllConsultas() {
        List<Consulta> lista = new LinkedList<>();
        try {
            Connection c = ConnectionManager.getConnection();
            PreparedStatement ps = c.prepareStatement(findALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Consulta(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Metodo que devuelve la Consulta cuyo id concuerda con <id>
     * 
     * @param id identificador con el que comparar
     * @return Consulta cuyo id concuerda con <id>. <null> en caso de que no exista
     *         con el identificador dado.
     */
    public static Consulta findByID(int id) {
        Consulta com = null;
        try {
            Connection c = ConnectionManager.getConnection();
            PreparedStatement ps = c.prepareStatement(findID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                com = new Consulta(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return com;
    }
}