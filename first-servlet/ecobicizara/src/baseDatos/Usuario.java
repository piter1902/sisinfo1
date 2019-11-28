package baseDatos;
/**
 * Clase que representa la tabla Usuario de la BD
 * 
 * @author Pedro Tamargo Allue
 */
public class Usuario {

    private String login, password, nombre, apellidos, email;
    private int vehicle_id;

    /**
     * Constructor de la clase Usuario
     * @param login login name del usuario
     * @param password password encriptada del usuario (TODO: COMO HACERLO)
     * @param nombre nombre del usuario
     * @param apellidos apllidos del usuario
     * @param email email del usuario
     * @param vehicle_id id del vehiculo del usuario (TODO: cambiar esta referencia por surco de datos ? -> Tabla nueva que almacene estos datos?)
     */
    public Usuario(String login, String password, String nombre, String apellidos, String email, int vehicle_id) {
        this.login = login;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.vehicle_id = vehicle_id;
    }

    /**
     * Constructor copia
     * @param orig Usuario a copiar
     */
    public Usuario(Usuario orig) {
        this(orig.login, orig.password, orig.nombre, orig.apellidos, orig.email, orig.vehicle_id);
    }

    // Metodos setters y getters

    /**
     * Getter del login name del usuario
     * @return login del usuario
     */
    public String getLogin() {
        return login;
    }

    /**
     * Setter del login del usuario
     * @param login login del usuario actualizado
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Getter del password encriptado del usuario
     * @return password encriptado
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter del password encriptado del usuario
     * @param password password actualizado
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter del nombre del usuario
     * @return nombre actualizado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre del usuario
     * @param nombre nombre actualizado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de los apellidos del usuario 
     * @return apellidos del usuario
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Setter de los apellidos del usuario
     * @param apellidos apellidos actualizados
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Getter del email del usuario
     * @return email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter del email del usuario
     * @param email email actualizado
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter del identificador del vehiculo del usuario
     * @return id del vehiculo del usuario
     */
    public int getVehicle_id() {
        return vehicle_id;
    }

    /**
     * Setter del identificador del vehiculo del usuario
     * @param vehicle_id identificador del vehiculo actualizado
     */
    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

}