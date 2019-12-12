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
import email.UsuarioEmail;

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
		// ----------------------------------------------
		// Obtenemos los distintos parametros introducidos en las listas desplegables
		String tipo_vehiculo = req.getParameter("tipo_vehiculo");
		String combustible = req.getParameter("combustible");
		String contaminante = req.getParameter("contaminante");
		String motor = req.getParameter("motor");
		// Comprobacion de errores de los parametros
		// 1. tipo_vehiculo
		if (tipo_vehiculo == null || tipo_vehiculo.trim().equals("")) {
			// Mal introducido (No debería de llegar aqui.)
			error.put("tipo_vehiculo", "Campo obligatorio.");
		} else {
			// Bien introducido -> Miramos si el campo es valido
			if (tipo_vehiculo.equals("mal")) {
				error.put("tipo_vehiculo", "Campo obligatorio.");
			}
		}
		// 2. combustible
		if (combustible == null || combustible.trim().equals("")) {
			// Mal introducido (No debería de llegar aqui.)
			error.put("combustible", "Campo obligatorio.");
		} else {
			// Bien introducido -> Miramos si el campo es valido
			if (combustible.equals("mal")) {
				error.put("combustible", "Campo obligatorio.");
			}
		}
		// 3. contaminante
		if (contaminante == null || contaminante.trim().equals("")) {
			// Mal introducido (No debería de llegar aqui.)
			error.put("contaminante", "Campo obligatorio.");
		} else {
			// Bien introducido -> Miramos si el campo es valido
			if (contaminante.equals("mal")) {
				error.put("contaminante", "Campo obligatorio.");

			} else if (contaminante.equals("desconocido")) {
				contaminante = null;
			}
		}
		// 4. motor
		if (motor == null || motor.trim().equals("")) {
			// Mal introducido (No debería de llegar aqui.)
			error.put("motor", "Campo obligatorio.");

		} else {
			// Bien introducido -> Miramos si el campo es valido
			if (motor.equals("mal")) {
				error.put("motor", "Campo obligatorio.");
				
			} else if (motor.equals("desconocido")) {
				motor = null;
			}
		}
		// ----------------------------------------------
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
		if (email == null || email.trim().equals("")) {
			error.put("email", "email - Campo obligatorio.");
		} else { // Solo se comprueba si el campo no es nulo.
			if (!match.find()) {
				error.put("email", "email - Email incorrecto.");
			} else if (UsuarioDAO.findIfEmailExists(email)) {
				error.put("email", "El email " + email + " ya esta en uso"); // TODO: sacar este error
			}
		}
		if (passNN && !pass1.trim().equals(pass2.trim())) { // Para añadir el error, ninguna contraseña debe ser nula.
			error.put("password1", "passwordss - Contraseñas no coinciden.");
		}

		if (error.size() == 0) {
			System.out.println("HOLA - NO errors");
			// id y emission_factor se calculan al introducirse a la BD
			Vehiculo v = new Vehiculo(-1, tipo_vehiculo, null, null, motor, combustible, contaminante, -1);
			// Insertamos el vehiculo en funcion de los datos estadisticos y obtenemos su
			// identificador
			System.out.format("%s | %s | %s | %s |\n", tipo_vehiculo, motor, combustible, contaminante);
			int id_vehiculo = VehiculoDAO.insertStadistic(v, VehiculoDAO.findOverCondition(v));

			// Insertamos al usuario en la BD
			UsuarioDAO.insertUser(nickName, pass1, nombre, apellidos, email, id_vehiculo);
			UsuarioEmail.sendSignUpMail(UsuarioDAO.findUserByLogin(nickName));
			resp.sendRedirect("index.jsp");
		} else {
			System.out.println("HOLA - SI errors");
			for (String s : error.keySet()) {
				System.out.format("%30s | %30s\n", s, error.get(s));
			}
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