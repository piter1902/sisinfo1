package email;

import baseDatos.*;

import java.sql.*;

/**
 * Clase para el envío de emails para las operaciones de un Usuario (cambios de
 * información), registros, eliminaciones...
 * 
 * @author Pedro Tamargo Allue
 *
 */
public class UsuarioEmail {

	/**
	 * Metodo que envia un email a un usuario cuando se da de alta en el servicio
	 * 
	 * @param user usuario que se da de alta. No tiene por que ser completo, al
	 *             menos debe contener el <login>.
	 * @return true si todo ha ido bien
	 */
	public static boolean sendSignUpMail(Usuario user) {
		boolean ok = false;
		Usuario user2 = UsuarioDAO.findUserByLogin(user.getLogin());
		if (user2 != null) {
			String asunto = "Bienvenido a Ecobicizara";
			String cuerpo = generateWelcomeMail(user2);
			ok = EmailAdapter.sendEmail(user2.getEmail(), asunto, cuerpo);
		}
		return ok;
	}

	/**
	 * Metodo que genera un mensaje de bienvenida para ser enviado al usuario <user>
	 * 
	 * @param user usuario para el cual se personalizará el mensaje
	 * @return el cuerpo del mensaje de bienvenida.
	 */
	private static String generateWelcomeMail(Usuario user) {
		String cuerpo = "Hola " + user.getNombre() + ",\nBienvenido a Ecobicizara."
				+ "Te has dado de alta correctamente en nuestro servicio con los siguientes datos:\n";
		cuerpo += "Nombre completo: " + user.getNombre() + " " + user.getApellidos() + "\n";
		cuerpo += "Login: " + user.getLogin() + "\n";
		cuerpo += "Email: " + user.getEmail() + "\n";
		cuerpo += "Muchas gracias por confiar en nosotros.\nUn saludo.\nEl equipo de Ecobicizara";
		return cuerpo;
	}
}
