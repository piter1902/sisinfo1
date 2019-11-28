package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseDatos.*;

public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * No se debe permitir que se llame mediante un mÃ©todo Get
		 */
		resp.sendRedirect("registrarse.jsp");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * SesiÃ³n que devolveremos al final de la operaciÃ³n.
		 */
		HttpSession respuesta = req.getSession(true);
		Map<String, String> error = new HashMap<String, String>();
		String nickName = req.getParameter("nickname");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		String pass1 = req.getParameter("password");
		String pass2 = req.getParameter("password1");
		String email = req.getParameter("email");
		String vehic = req.getParameter("vehiculo");
		Boolean passNN = true;
		// PatrÃ³n para comprobar si el email es correcto
		Pattern patron = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher match = patron.matcher(email);
		if (nickName == null || nickName.trim().equals("")) {
			error.put("nickname", "Campo obligatorio.");
		} else {
			if (UsuarioDAO.findUserByLogin(nickName) != null)
				error.put("nickname", "El usuario " + nickName + " ya ha sido registrado");
		}
		if (nickName == null || nickName.trim().equals(""))
			error.put("password", "password - Campo obligatorio.");
		if (nombre == null || nombre.trim().equals(""))
			error.put("nombre", "nombre - Campo obligatorio.");
		if (pass1 == null || pass1.trim().equals("")) {
			error.put("password", "password - Campo obligatorio.");
			passNN = false;
		}
		if (pass2 == null || pass2.trim().equals("")) {
			error.put("password1", "password1 - Campo obligatorio.");
			passNN = false;
		}
		if (apellidos == null || apellidos.trim().equals(""))
			error.put("apellidos", "apellidos - Campo obligatorio.");
		if (vehic == null || vehic.trim().equals(""))
			error.put("vehiculo", "vehiculo - Campo obligatorio.");
		if (email == null || email.trim().equals("")) {
			error.put("email", "email - Campo obligatorio.");
		} else { // Solo se comprueba si el campo no es nulo.
			if (!match.find()) {
				error.put("email", "email - Email incorrecto.");
			} else if (UsuarioDAO.findIfEmailExists(email))
				error.put("email_in_use", "El email " + email + " ya esta en uso"); // TODO: sacar este error
		}
		if (passNN && !pass1.trim().equals(pass2.trim())) { // Para añadir el error, ninguna contraseña debe ser nula.
			error.put("password1", "passwordss - Contraseñas no coinciden.");
		}

		if (error.size() == 0) {
			// TODO descomentar esto,es para pruebas.
			Vehiculo v = new Vehiculo(-1, "datos", "datos", "datos", "datos", "datos", "datos", 11);
			// Insertamos el vehiculo en funcion de los datos estadisticos y obtenemos su
			// identificador
			//int id_vehiculo = VehiculoDAO.insertStadistic(v, VehiculoDAO.findOverCondition(v));
			
			// Insertamos al usuario en la BD
			UsuarioDAO.insertUser(nickName, pass1, nombre, apellidos, email, 11);
			resp.sendRedirect("index.jsp");
		} else {
			req.setAttribute("errores", error);
			RequestDispatcher dispatcher = req.getRequestDispatcher("registrarse.jsp");
			dispatcher.forward(req, resp);
		}

	}

	private void response(HttpServletResponse resp, String msg) throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
	}
}