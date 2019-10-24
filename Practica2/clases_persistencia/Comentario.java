
/**
 * Clase para representar los comentarios que pueden dejar los visitantes de la
 * página. Estarán provistos de: - ComentarioID - Texto del comentario -
 * UsuarioID
 * 
 * @author Pedro Tamargo
 */
public class Comentario {

    private int comentID, userID;
    private String text;

    public Comentario(int comentID, int userID, String text) {
        this.comentID = comentID;
        this.userID = userID;
        this.text = text;
    }

    public Comentario(Comentario orig) {
        this(orig.comentID, orig.userID, orig.text);
    }

    // Metodos setter y getter
    public int getComentID() {
        return comentID;
    }

    public void setComentID(int comentID) {
        this.comentID = comentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}