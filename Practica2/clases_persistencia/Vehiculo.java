/**
 * Clase para representar un vehículo de la BD, debe estar provisto de: 
 * - id
 * - tipo (puede ser: Camion, Moto, TransportePublico, Coche)
 * - euro_star (clasificacion ambiental en base a la contaminación del vehículo)
 * - fuel (tipo de combustible)
 * - registr_year (año de registro)
 * 
 * @author Pedro Tamargo Allue
 */
public class Vehiculo {
    private int id, registr_year;
    private String tipo, euro_star, fuel;

    /**
     * Constructor de la clase vehiculo
     * @param id identificador del vehiculo
     * @param tipo tipo del vehiculo
     * @param euro_star clasificacion ambiental del vehiculo
     * @param fuel tipo de combustible del vehiculo
     * @param registr_year año de registro del vehiculo
     */
    public Vehiculo(int id, String tipo, String euro_star, String fuel, int registr_year) {
        this.id = id;
        this.tipo = tipo;
        this.euro_star = euro_star;
        this.fuel = fuel;
        this.registr_year = registr_year;
    }

    /**
     * Constructor copia del vehiculo
     * @param orig vehiculo a copiar
     */
    public Vehiculo(Vehiculo orig) {
        this(orig.id, orig.tipo, orig.euro_star, orig.fuel, orig.registr_year);
    }


    // Metodos setter y getter

    /**
     * Getter del identificador del vehiculo
     * @return identificador del vehiculo
     */
    public int getId() {
        return id;
    }

    /**
     * Setter del identificador del vehiculo
     * @param id identificador actualizado
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter del año de registro del vehiculo
     * @return año de registro del vehiculo
     */
    public int getRegistr_year() {
        return registr_year;
    }

    /**
     * Setter del año de registro del vehiculo
     * @param registr_year año de registro del vehiculo actualizado
     */
    public void setRegistr_year(int registr_year) {
        this.registr_year = registr_year;
    }

    /**
     * Getter del tipo de vehiculo
     * @return tipo de vehiculo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Setter del tipo de vehiculo
     * @param tipo tipo actualizado
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Getter de la clasificacion ambiental del vehiculo
     * @return clasificacion ambiental del vehiculo
     */
    public String getEuro_star() {
        return euro_star;
    }

    /**
     * Setter de la clasificacion ambiental del vehiculo
     * @param euro_star clasificacion ambiental actualizada
     */
    public void setEuro_star(String euro_star) {
        this.euro_star = euro_star;
    }

    /**
     * Getter del tipo de combustible del vehiculo
     * @return tipo de combustible del vehiculo
     */
    public String getFuel() {
        return fuel;
    }

    /**
     * Setter del tipo de combustible del vehiculo
     * @param fuel tipo de combustible actualizado
     */
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    
}