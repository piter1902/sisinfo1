
/**
 * Clase que abstrae la conexion con la base de datos.
 * 
 * @author
 *
 */
import java.sql.*;

public class ConnectionManager {
	// JDBC nombre del driver y URL de BD
	private static final String JDBC_DRIVER = "<DRIVER>";
	private static final String DB_URL = "jdbc:mysql://<IP>:3306/<nombreBD>";
	// Credenciales de la Base de Datos
	private static final String USER = "<USER>";
	private static final String PASS = "<PSSWD>";

	// Devuelve una nueva conexion.
	public final static Connection getConnection() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);
			// STEP 2: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Libera la conexion, devolviendola al pool
	public final static void releaseConnection(Connection conn) throws SQLException {
		conn.close();
	}
}