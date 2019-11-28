/**
 * Clase para representar un vehículo de la BD, debe estar provisto de: - id -
 * tipo (puede ser: Camion, Moto, TransportePublico, Coche) - segment (segmento
 * comercial) - euro_star (clasificacion ambiental en base a la contaminación
 * del vehículo) - engine_type (tecnologia del motor) - fuel (tipo de
 * combustible) - pollutant (tipo de emision) - emission_factor (factor de
 * emision del compuesto <pollutant>)
 * 
 * @author Pedro Tamargo Allue
 */
public class Vehiculo {
    private int id;
    private String tipo, euro_star, fuel, engine_type, segment, pollutant;
    private float emission_factor;

    /**
     * Constructor de la clase vehiculo
     * 
     * @param id              identificador del vehiculo
     * @param tipo            tipo del vehiculo
     * @param segment         segmento comercial del vehiculo
     * @param euro_star       clasificacion ambiental del vehiculo
     * @param engine_type     tipo del motor (NULL si no se conoce)
     * @param fuel            tipo de combustible del vehiculo
     * @param pollutant       compuesto contaminante del vehiculo
     * @param emission_factor factor de emision del contaminante <pollutant> del
     *                        vehiculo
     */
    public Vehiculo(int id, String tipo, String segment, String euro_star, String engine_type, String fuel,
            String pollutant, float emission_factor) {
        this.id = id;
        this.tipo = tipo;
        this.segment = segment;
        this.euro_star = euro_star;
        this.engine_type = engine_type;
        this.fuel = fuel;
        this.pollutant = pollutant;
        this.emission_factor = emission_factor;
    }

    /**
     * Constructor copia del vehiculo
     * 
     * @param orig vehiculo a copiar
     */
    public Vehiculo(Vehiculo orig) {
        this(orig.id, orig.tipo, orig.segment, orig.euro_star, orig.engine_type, orig.fuel, orig.pollutant,
                orig.emission_factor);
    }

    // Metodos setter y getter

    /**
     * Getter del identificador del vehiculo
     * 
     * @return identificador del vehiculo
     */
    public int getId() {
        return id;
    }

    /**
     * Setter del identificador del vehiculo
     * 
     * @param id identificador actualizado
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter del tipo de vehiculo
     * 
     * @return tipo de vehiculo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Setter del tipo de vehiculo
     * 
     * @param tipo tipo actualizado
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Getter de la clasificacion ambiental del vehiculo
     * 
     * @return clasificacion ambiental del vehiculo
     */
    public String getEuro_star() {
        return euro_star;
    }

    /**
     * Setter de la clasificacion ambiental del vehiculo
     * 
     * @param euro_star clasificacion ambiental actualizada
     */
    public void setEuro_star(String euro_star) {
        this.euro_star = euro_star;
    }

    /**
     * Getter del tipo de combustible del vehiculo
     * 
     * @return tipo de combustible del vehiculo
     */
    public String getFuel() {
        return fuel;
    }

    /**
     * Setter del tipo de combustible del vehiculo
     * 
     * @param fuel tipo de combustible actualizado
     */
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    /**
     * Getter de la tecnología del motor del vehiculo
     * 
     * @return tecnologia del motor
     */
    public String getEngine_type() {
        return engine_type;
    }

    /**
     * Setter de la tecnologia del motor del vehiculo
     * 
     * @param engine_type tecnologia actualizada
     */
    public void setEngine_type(String engine_type) {
        this.engine_type = engine_type;
    }

    /**
     * Getter del segmento comercial del vehiculo
     * 
     * @return segmento del vehiculo
     */
    public String getSegment() {
        return segment;
    }

    /**
     * Setter del segmento comercial del vehiculo
     * 
     * @param segment segmento actualizado
     */
    public void setSegment(String segment) {
        this.segment = segment;
    }

    /**
     * Getter del compuesto contaminante del vehiculo
     * 
     * @return compuesto contaminante del vehiculo
     */
    public String getPollutant() {
        return pollutant;
    }

    /**
     * Setter del compuesto contaminante del vehiculo
     * 
     * @param pollutant compuesto contaminante actualizado
     */
    public void setPollutant(String pollutant) {
        this.pollutant = pollutant;
    }

    /**
     * Getter del factor de emision de <pollutant> del vehiculo
     * 
     * @return factor de emision del vehiculo
     */
    public float getEmission_factor() {
        return emission_factor;
    }

    /**
     * Setter del factor de emision de <pollutant> del vehiculo
     * 
     * @param emission_factor factor de emision actualizado
     */
    public void setEmission_factor(float emission_factor) {
        this.emission_factor = emission_factor;
    }

}