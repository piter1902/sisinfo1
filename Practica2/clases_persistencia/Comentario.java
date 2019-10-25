
/**
 * Clase para representar los comentarios que pueden dejar los visitantes de la
 * página. Estarán provistos de: - ComentarioID - Texto del comentario -
 * UsuarioID
 * 
 * @author Pedro Tamargo
 */
public class Comentario {

    private int comentID;
    private String email, nombre, apellidos, text;

    public Comentario(int comentID, String email, String nombre, String apellidos, String text) {
        this.comentID = comentID;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.text = text;
    }

    public Comentario(Comentario c) {
        this(c.comentID, c.email, c.nombre, c.apellidos, c.text);
    }

    // Getters y Setters
    public int getComentID() {
        return comentID;
    }

    public void setComentID(int comentID) {
        this.comentID = comentID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    

}