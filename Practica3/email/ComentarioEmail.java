package email;

import baseDatos.*;

import java.sql.*;

/**
 * Clase para el envío de Comentarios de la BD al usuario que los ha hecho por
 * la pagina web
 * 
 * @author Pedro Tamargo Allue
 *
 */
public class ComentarioEmail {

	private static final String getComent = "select * from Comentario where id = ?";

	/**
	 * Metodo que dado un comentario (que puede solo contener el identificador unico
	 * comentID, envía un correo con una estructura html dada al usuario que lo puso
	 * en la pagina web.
	 * 
	 * @param com comentario que contiene (al menos) el identificador de comentario
	 * @return true si ha ido todo bien
	 */
	public static boolean sendRespuestaAComentario(Comentario com) {
		boolean ok = false;
		Comentario com2 = null, com3 = null;
		try {
			Connection c = ConnectionManager.getConnection();
			PreparedStatement ps = c.prepareStatement(getComent);
			ps.setInt(1, com.getComentID());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				com2 = new Comentario(rs.getInt("comentarioId"), rs.getString("email"), rs.getString("nombre"),
						rs.getString("apellidos"), rs.getString("texto"), rs.getInt("antecesor"));
			}
			// Com2 es el comentario completo que el usuario puso
			com3 = ComentarioDAO.getParent(com2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (com2 != null && com3 != null) {
			// Ninguno de los comentarios buscados == null
			// Establecemos el envío del correo
			String asunto = "Respuesta a su duda";
			String cuerpo = generateEmailRespuesta(com2, com3);
			ok = EmailAdapter.sendEmail(com2.getEmail(), asunto, cuerpo);
		}
		return ok;
	}

	/**
	 * Metodo que genera un mensaje de respuesta para un comentario dado
	 * 
	 * @param com
	 * @return
	 */
	private static String generateEmailRespuesta(Comentario com_orig, Comentario com_respuesta) {
		String cabecera = "Estimad@ " + com_orig.getNombre() + ",\n";
		String cuerpo = "Nuestro equipo de atención al cliente ha resuelto su duda y le escribimos en relación a ello.\n"
				+ "A continuación, se le muestra la respuesta del seguido de su pregunta.";

		return cabecera + cuerpo + com_respuesta.getText() + "\n" + com_orig.getText() + "\n"
				+ "Muchas gracias.\nEl equipo de ecobicizara.";
	}
}
