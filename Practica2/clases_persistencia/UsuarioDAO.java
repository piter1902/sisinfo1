
/**
 * Clase DAO para la clase vehiculo. Permitira hacer comprobaciones de factores
 * de emision sobre distintos parametros.
 * 
 * @author Pedro Tamargo Allue
 */

import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class UsuarioDAO {

    // Sentencias SQL para la seleccion de BD
    protected static final String findALL = "select * from Usuario";
    protected static final String findByLogin = "select * from Usuario where login = ?";
    // Sentencia SQL para la validacion del usuario
    protected static final String findIfPasswordMatchs = "select count(*) as veces from Usuario where login = ? and password = MD5(?)";
    // Sentencias SQL para actualizar un usuario de la BD
    protected static final String updateUser = "update Usuario set password = MD5(?), nombre = ?, apellidos = ?, email = ?, vehic_id = ? where login = ?";

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
     * @param user usuario a validar
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
            correcto = rs.next();
            // Solo deberia haber un resultado -> correcto = true
            // Podria no haber resultado -> correcto = false
        } catch (SQLException e) {
            // TODO Auto-generated catch block
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
}