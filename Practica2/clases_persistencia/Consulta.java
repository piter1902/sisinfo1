
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

    public Consulta(int consultaID, String login, String origen, String destino, Date fecha) {
        this.consultaID = consultaID;
        this.login = login;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
    }

    public Consulta(Consulta orig) {
        this(orig.consultaID, orig.login, orig.origen, orig.destino, orig.fecha);
    }

    // Metodos setter y getter
    public int getConsultaID() {
        return consultaID;
    }

    public void setConsultaID(int consultaID) {
        this.consultaID = consultaID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}