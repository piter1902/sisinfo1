package baseDatos;

import java.util.List;

public class pruebaDAO {

	public static void main(String[] args) {
		List<Vehiculo> lista = VehiculoDAO.findOverCondition("passenger_car", null, null, "gdi", "petrol", null);
		System.out.printf("%s , %s \n", "ID", "FUEL");
		for (Vehiculo v : lista) {
			System.out.printf("%s , %s \n", v.getId(), v.getFuel());
		}
	}

}
