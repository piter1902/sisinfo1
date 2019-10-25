
/**
 * Clase que representa la tabla Usuario de la BD
 * 
 * @author Pedro Tamargo Allue
 */
public class Usuario {

    private String login, password, nombre, apellidos, email;
    private int vehicle_id;

    public Usuario(String login, String password, String nombre, String apellidos, String email, int vehicle_id) {
        this.login = login;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.vehicle_id = vehicle_id;
    }

    public Usuario(Usuario orig) {
        this(orig.login, orig.password, orig.nombre, orig.apellidos, orig.email, orig.vehicle_id);
    }

    // Metodos setters y getters
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }public Str
    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

}