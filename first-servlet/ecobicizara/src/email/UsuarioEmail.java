package email;

import baseDatos.*;

import java.sql.*;

/**
 * Clase para el env�o de emails para las operaciones de un Usuario (cambios de
 * informaci�n), registros, eliminaciones...
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
	 * Metodo que envia un email al usuario, si email de <old> == <nuevo>, solo lo
	 * enviar� una vez, en caso contrario, lo enviar� a ambos para confirmar los
	 * cambios.
	 * 
	 * @param old   parametros del Usuario antes del cambio. Tiene que ser completo.
	 * @param nuevo parametros del Usuario tras los cambios. Tiene que contener, al
	 *              menos, el login del nuevo usuario.
	 * @return true si todo ha ido bien
	 */
	public static boolean sendChangesEmail(Usuario old, Usuario nuevo) {
		boolean ok = false;
		Usuario nuevo1 = UsuarioDAO.findUserByLogin(nuevo.getLogin());
		if (nuevo1 != null) {
			String asunto = "Cambios en la cuenta asociada a " + nuevo.getLogin();
			String cuerpo = generateUserChangesMail(old, nuevo1);
			if (old.getEmail().equals(nuevo.getEmail())) {
				// Los mails son iguales, solamente mandamos 1
				ok = EmailAdapter.sendEmail(old.getEmail(), asunto, cuerpo);
			} else {
				// No coinciden, enviamos 2 correos
				ok = EmailAdapter.sendEmail(old.getEmail(), asunto, cuerpo)
						&& EmailAdapter.sendEmail(nuevo1.getEmail(), asunto, cuerpo);
			}
		}
		return ok;
	}

	/**
	 * Metodo que genera el cuerpo de un correo electronico en el cual aparecen los
	 * cambios de una cuenta de Usuario.
	 * 
	 * @param old   parametros del usuario antiguos. Debe ser completo.
	 * @param nuevo parametros del nuevo usuario. Debe ser completo
	 * @return cuerpo del correo electronico.
	 */
	private static String generateUserChangesMail(Usuario old, Usuario nuevo) {
		String cuerpo = "<p> Hola " + nuevo.getLogin() + ", hemos detectado cambios en la configuracion de tu cuenta:</p>";
		cuerpo += "<table border=1>";
		cuerpo += "<tr>" + "<th>Atributo</th>" + "<th>Valor Viejo</th>" + "<th>Valor nuevo</th>" + "</tr>";
		cuerpo += "<tr>" + "<th>Login</th>" + "<td>" + old.getLogin() +"</td>" + "<td>" + nuevo.getLogin() +"</td>" + "</tr>";  
		cuerpo += "<tr>" + "<th>Nombre</th>" + "<td>" + old.getNombre() +"</td>" + "<td>" + nuevo.getNombre() +"</td>" + "</tr>";
		cuerpo += "<tr>" + "<th>Apellidos</th>" + "<td>" + old.getApellidos() +"</td>" + "<td>" + nuevo.getApellidos() +"</td>" + "</tr>";
		cuerpo += "<tr>" + "<th>Email</th>" + "<td>" + old.getEmail() +"</td>" + "<td>" + nuevo.getEmail() +"</td>" + "</tr>";
		if(!old.getPassword().equals(nuevo.getPassword())) {
			// Los password no coinciden
			cuerpo += "<tr>" + "<th>Password</th>" + "<td>Los valores han cambiado</td>" + "<td>Los valores han cambiado</td>" + "</tr>";  
			
		}
		cuerpo +="</table>";
		cuerpo += "<p> Gracias por confiar en nosotros. <br> El equipo de ecobicizara.</p>";
		return cuerpo; 
	}

	/**
	 * Metodo que genera un mensaje de bienvenida para ser enviado al usuario <user>
	 * 
	 * @param user usuario para el cual se personalizar� el mensaje
	 * @return el cuerpo del mensaje de bienvenida.
	 */
	private static String generateWelcomeMail(Usuario user) {
		String cuerpo = "<h5>Hola " + user.getNombre() + ",\nBienvenido a Ecobicizara.</h5>"
				+ "<br><p>Te has dado de alta correctamente en nuestro servicio con los siguientes datos:</p><br>";
		cuerpo += "<p>Nombre completo: " + user.getNombre() + " " + user.getApellidos() + "</p>";
		cuerpo += "<p>Login: " + user.getLogin() + "</p>";
		cuerpo += "<p>Email: " + user.getEmail() + "</p>";
		cuerpo += "<p>Muchas gracias por confiar en nosotros.<br>Un saludo.<br>El equipo de Ecobicizara</p>";
		return cuerpo;
	}
}
