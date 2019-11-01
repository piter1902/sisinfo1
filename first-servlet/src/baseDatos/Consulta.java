package baseDatos;
/**
 * Clase para representar una consulta de una ruta de un usuario, debe estar provista de:
 * - consultaID
 * - login
 * - fecha
 * - origen
 * - destino
 * @author Pedro Tamargo Allue
 */
import java.util.Date;

public class Consulta {

    private int consultaID;
    private String login, origen, destino;
    private Date fecha;

    /**
     * Constructor de Consulta
     * @param consultaID id de la consulta
     * @param login id del usuario que hace la consulta
     * @param origen direccion de origen de la consulta
     * @param destino direccion destino de la consulta
     * @param fecha fecha de la consulta
     */
    public Consulta(int consultaID, String login, String origen, String destino, Date fecha) {
        this.consultaID = consultaID;
        this.login = login;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
    }

    /**
     * Constructor copia de la consulta
     * @param orig consulta a copiar
     */
    public Consulta(Consulta orig) {
        this(orig.consultaID, orig.login, orig.origen, orig.destino, orig.fecha);
    }

    // Metodos setter y getter

    /**
     * Getter del id de la consulta
     * @return id de la consulta
     */
    public int getConsultaID() {
        return consultaID;
    }

    /**
     * Setter del id de la consulta
     * @param consultaID id actualizado
     */
    public void setConsultaID(int consultaID) {
        this.consultaID = consultaID;
    }

    /**
     * Getter del login name del usuario que hace la consulta
     * @return login del usuario
     */
    public String getLogin() {
        return login;
    }

    /**
     * Setter del login del usuario que hace la consulta
     * @param login login actualizado
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Getter de la direccion de origen de la consulta (inicio de recorrido)
     * @return direccion de origen de la consulta (inicio de recorrido)
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Setter de la direccion de origen de la consulta (inicio de recorrido)
     * @param origen direccion actualizada
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * Getter de la direccion de fin de la consulta (fin del recorrido)
     * @return direccion de fin de la consulta (fin del recorrido)
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Setter de la direccion de fin de la consulta (fin del recorrido)
     * @param destino direccion de final de recorrido actualizada
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Getter de la fecha en la que se realizo la consulta
     * @return fecha de consulta
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Setter de la fecha en la que se realizo la consulta
     * @param fecha actualizada
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}