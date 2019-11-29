package baseDatos;

/**
 * Clase para representar los comentarios que pueden dejar los visitantes de la
 * p�gina. Estar�n provistos de: - ComentarioID - Texto del comentario - email
 * del usuario - nombre y apellidos del usuario - estado del comentario ->
 * respondida o no respondida
 * 
 * @author Pedro Tamargo
 */
public class Comentario {

	private int comentID;
	private String email, nombre, apellidos, text, asunto;
	private int antecesor;

	/**
	 * Constructor de la clase Comentario
	 * 
	 * @param comentID  id del comentario en la BD
	 * @param email     email de la persona que deja el comentario
	 * @param nombre    nombre de la persona que deja el comentario
	 * @param apellidos apellidos de la persona que deja el comentario
	 * @param text      texto del comentario
	 * @param antecesor id del comentario que precede a este (si es != -1 | NULL ->
	 *                  respuesta a comentario hecho por usuario)
	 */
	public Comentario(int comentID, String email, String nombre, String apellidos, String text, int antecesor, String asunto) {
		this.comentID = comentID;
		this.email = email;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.text = text;
		this.antecesor = antecesor;
		this.asunto = asunto;
	}

	/**
	 * Constructor copia
	 * 
	 * @param c comentario a copiar
	 */
	public Comentario(Comentario c) {
		this(c.comentID,c.email, c.nombre, c.apellidos, c.text, c.antecesor, c.asunto);
	}

	// Getters y Setters

	/**
	 * Getter de comentID
	 * 
	 * @return id del comentario
	 */
	public int getComentID() {
		return comentID;
	}

	/**
	 * Setter de comentID
	 * 
	 * @param comentID id actualizado
	 */
	public void setComentID(int comentID) {
		this.comentID = comentID;
	}

	/**
	 * Getter del email
	 * 
	 * @return email de la persona que hace el comentario
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter del email
	 * 
	 * @param email email actualizado
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter del nombre de la persona que ha hecho el comentario
	 * 
	 * @return nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter del nombre de la persona que ha hecho el comentario
	 * 
	 * @param nombre nombre actualizado
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter de los apellidos de la persona que ha hecho el comentario
	 * 
	 * @return apellidos de la persona
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Setter de los apellidos de la persona
	 * 
	 * @param apellidos apellidos actualizados
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Getter del texto del comentario
	 * 
	 * @return texto del comentario
	 */
	public String getText() {
		return text;
	}

	/**
	 * Setter del texto del comentario
	 * 
	 * @param text texto actualizado
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Getter del asunto del comentario
	 * 
	 * @return asunto del comentario
	 */
	public String getAsunto() {
		return asunto;
	}

	/**
	 * Setter del asunto del comentario
	 * 
	 * @param asunto asunto actualizado
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	/**
	 * Getter de antecesor
	 * 
	 * @return antecesor
	 */
	public int getAntecesor() {
		return antecesor;
	}

	/**
	 * Setter de antecesor
	 * 
	 * @param antecesor valor actualizado
	 */
	public void setRespondida(int antecesor) {
		this.antecesor = antecesor;
	}

}