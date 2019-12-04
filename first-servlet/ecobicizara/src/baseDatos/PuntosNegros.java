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
 
public class PuntosNegros { 
 
    private double latitud, longitud; 
    private int contaminacion; 
 
    /** 
     * Constructor de Consulta 
     * @param latitud latitud del punto negro 
     * @param longitud longitud del punto negro 
     * @param contaminacion nivel de contaminación del punto. Determina su tamaño 
     */ 
    public PuntosNegros(double latitud, double longitud, int contaminacion) { 
		this.latitud = latitud; 
		this.longitud = longitud; 
		this.contaminacion = contaminacion; 
	} 
 
	/** 
     * Constructor copia de los puntosNegros 
     * @param orig puntosNegros a copiar 
     */ 
    public PuntosNegros(PuntosNegros orig) { 
        this(orig.latitud, orig.longitud, orig.contaminacion); 
    } 
     
    // Metodos setter y getter 
	 
    public double getLatitud() { 
		return latitud; 
	} 
 
	public void setLatitud(double latitud) { 
		this.latitud = latitud; 
	} 
 
	public double getLongitud() { 
		return longitud; 
	} 
 
	public void setLongitud(double longitud) { 
		this.longitud = longitud; 
	} 
 
	public int getContaminacion() { 
		return contaminacion; 
	} 
 
	public void setContaminacion(int contaminacion) { 
		this.contaminacion = contaminacion; 
	} 
 
     
 
}