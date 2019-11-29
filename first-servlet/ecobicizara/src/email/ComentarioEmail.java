package email;

import baseDatos.*;

import java.sql.*;
import java.util.Date;

/**
 * Clase para el env�o de Comentarios de la BD al usuario que los ha hecho por
 * la pagina web
 * 
 * @author Pedro Tamargo Allue
 *
 */
public class ComentarioEmail {

	private static final String ourMail = "ecobicizara@gmail.com, pedro.tamargo.allue@gmail.com, jtambo@live.com";

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
		Comentario com2 = ComentarioDAO.findByID(com.getComentID());
		// Com2 es el comentario completo que el usuario puso
		Comentario com3 = com2 != null ? ComentarioDAO.getParent(com2) : null;
		if (com2 != null && com3 != null) {
			// Ninguno de los comentarios buscados == null
			// Establecemos el env�o del correo
			String asunto = "Respuesta a su duda";
			String cuerpo = generateEmailRespuesta(com2, com3);
			ok = EmailAdapter.sendEmail(com2.getEmail(), asunto, cuerpo);
		}
		return ok;
	}

	/**
	 * Metodo que genera un mensaje de respuesta para un comentario dado.
	 * 
	 * @param com_orig      comentario inicial (pregunta)
	 * @param com_respuesta comentario respuesta a <com_orig>
	 * @return cuerpo del mensaje de respuesta sobre el comentario <com_orig>
	 */
	private static String generateEmailRespuesta(Comentario com_orig, Comentario com_respuesta) {
		String cabecera = "Estimad@ " + com_orig.getNombre() + ",\n";
		String cuerpo = "Nuestro equipo de atención al cliente ha resuelto su duda y le escribimos en relación a ello.\n"
				+ "A continuación, se le muestra la respuesta del seguido de su pregunta.";

		return cabecera + cuerpo + com_respuesta.getText() + "\n" + com_orig.getText() + "\n"
				+ "Muchas gracias.\nEl equipo de ecobicizara.";
	}

	/**
	 * Metodo que envia un email a los administradores con la pregunta que un
	 * usuario ha efectuado <coment>.
	 * 
	 * @param coment comentario efectuado. Debe ser completo
	 * @return true si todo ha ido bien
	 */
	public static boolean sendPregunta(Comentario coment) {
		
		String asunto = "PREGUNTA EFECTUADA EN " + new Date();
		String cuerpo = "<h4>Se ha realizado la pregunta: </h4><br>";
		cuerpo += "<div style=\"border-style:solid\"> <p>" + coment.getNombre() + "(" + coment.getEmail() + ")"
				+ " pregunta: </p><br>";
		cuerpo += "<p>" + coment.getText() + "</p> </div>";
		return EmailAdapter.sendEmail(ourMail + ", " + coment.getEmail(), asunto, cuerpo);
	}
}
