package email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Clase para el envío de emails
 * 
 * @author Pedro Tamargo Allue
 *
 */
public class EmailAdapter {

	private static final String remitente = "ecobicizara@gmail.com";
	private static final String clave = "sis_info_1920";

	/**
	 * Metodo que inicia un objeto Properties con las propiedades de la conexion
	 * 
	 * @return propiedades de la conexion
	 */
	private static Properties getProps() {
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // El servidor SMTP de Google
		props.put("mail.smtp.user", remitente);
		props.put("mail.smtp.clave", clave); // La clave de la cuenta
		props.put("mail.smtp.auth", "true"); // Usar autenticación mediante usuario y clave
		props.put("mail.smtp.starttls.enable", "true"); // Para conectar de manera segura al servidor SMTP
		props.put("mail.smtp.port", "587"); // El puerto SMTP seguro de Google
		// TODO: ESTA LINEA ES IMPORTANTE
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		return props;
	}

	/**
	 * Metodo que envía un email
	 * 
	 * @param email_destinatario email (o emails separados por ,) de los
	 *                           destinatarios
	 * @param asunto             asunto del email
	 * @param cuerpo             cuerpo del mensaje
	 * @return true si no ha habido ningun fallo
	 */
	public static boolean sendEmail(String email_destinatario, String asunto, String cuerpo) {
		boolean ok = false;
		Properties props = getProps();
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(remitente));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(email_destinatario));
			message.setSubject(asunto);
			message.setContent(cuerpo, "text/html");
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", remitente, clave);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			ok = true;
		} catch (MessagingException me) {
			me.printStackTrace(); // Si se produce un error
		}
		return ok;
	}
}
