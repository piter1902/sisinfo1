package baseDatos;

public class pruebaDAO {

	public static void main(String[] args) {
		Usuario user = new Usuario("jtambo", "pollaGorda", "Juan Jose", "Tambo Tambo", "jtambo@live.com", 4);
		//UsuarioDAO.insertUser(user);
		System.out.println(UsuarioDAO.validateUser(new Usuario("piter", "sis_info_1920", null, null, null, 0)));
	}

}
