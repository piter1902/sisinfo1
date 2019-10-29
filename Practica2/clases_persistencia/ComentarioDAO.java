
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
    static final String findALL = "select * from Comentario";
    static final String findID = "select * from Comentario where comentarioId = ?";

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
                        rs.getString(5), rs.getBoolean(6)));
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
                        rs.getBoolean(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return com;
    }
}