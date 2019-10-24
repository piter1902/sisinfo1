/**
 * Clase para representar un vehículo de la BD, debe estar provisto de: - id -
 * tipo (puede ser: Camion, Moto, TransportePublico, Coche) - euro_star
 * (clasificacion ambiental en base a la contaminación del vehículo) - fuel
 * (tipo de combustible) - registr_year (año de registro)
 * 
 * @author Pedro Tamargo Allue
 */
public class Vehiculo {
    private int id, registr_year;
    private String tipo, euro_star, fuel;

    public Vehiculo(int id, String tipo, String euro_star, String fuel, int registr_year) {
        this.id = id;
        this.tipo = tipo;
        this.euro_star = euro_star;
        this.fuel = fuel;
        this.registr_year = registr_year;
    }

    public Vehiculo(Vehiculo orig) {
        this(orig.id, orig.tipo, orig.euro_star, orig.fuel, orig.registr_year);
    }


    // Metodos setter y getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegistr_year() {
        return registr_year;
    }

    public void setRegistr_year(int registr_year) {
        this.registr_year = registr_year;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEuro_star() {
        return euro_star;
    }

    public void setEuro_star(String euro_star) {
        this.euro_star = euro_star;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    
}