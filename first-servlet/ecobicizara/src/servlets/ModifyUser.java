package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

//import org.apache.catalina.startup.PasswdUserDatabase;

import baseDatos.*;
import email.UsuarioEmail;

/**
 * Servlet implementation class ModifyUser
 */

public class ModifyUser extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * No se debe permitir que se llame mediante un mÃ©todo Get
		 */
		response.sendRedirect("datosPersonales.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// userNick contiene el login del usuario conectado.
		HttpSession session = request.getSession(true);
		String userNick = (String)session.getAttribute("nickname");
		Usuario currentUser = UsuarioDAO.findUserByLogin(userNick);
		Usuario oldUser = new Usuario(currentUser);
		Map<String, String> error = new HashMap<String, String>();
		String nickName = request.getParameter("newnickname");
		String nombre = request.getParameter("newnombre");
		String apellidos = request.getParameter("newapellidos");
		String pass1 = request.getParameter("newpassword");
		String pass2 = request.getParameter("newpassword1");
		String email = request.getParameter("newemail");
		String vehic = request.getParameter("newvehiculo");
		Pattern patron = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		boolean okPass1 = pass1 != null && !pass1.trim().equals("");
		boolean okPass2 = pass2 != null && !pass2.trim().equals("");
		if (nickName != null && !nickName.trim().equals("")) {
			if (UsuarioDAO.findUserByLogin(nickName) != null) {
				error.put("nickname", "El usuario " + nickName + " ya ha sido registrado");				
			}else {
				currentUser.setLogin(nickName);				
			}
		}
		if (nombre != null && !nombre.trim().equals("")) {
			currentUser.setNombre(nombre);
		}
		if (apellidos != null && !apellidos.trim().equals("")) {
			currentUser.setApellidos(apellidos);
		}
		if( okPass2 && !okPass1) { //Caso de introducir contraseña repetida y la primera contraseña no.
			error.put("password", "password - Contraseñas no coinciden.");
		}
		if (okPass1) { // Se comprueba si se ha introducido la primera contraseña
			if (!pass1.trim().equals(pass2.trim())) { // Para añadir el error, ninguna contraseña debe ser nula.
				error.put("password", "password - Contraseñas no coinciden.");
			} else {
				currentUser.setPassword(pass1);
			}
		}
		if (email != null && !email.trim().equals("")) {
			Matcher match = patron.matcher(email);
			if (!match.find()) {
				error.put("email", "email - Email incorrecto.");
			} else {
				currentUser.setEmail(email);
			}
		}
		if (vehic != null && !vehic.trim().equals("")) {
			currentUser.setVehicle_id(0); // TODO:Está incompleto
		}
		if (error.size() == 0) {
			if (nickName != null && !nickName.trim().equals("")) { //Si se va a modificar el user, se cambia el user de la session
				session.setAttribute("nickname", nickName);				
			}
			UsuarioDAO.updateUsuario(currentUser, userNick);
			UsuarioEmail.sendChangesEmail(oldUser, UsuarioDAO.findUserByLogin(nickName));
			response.sendRedirect("datosPersonales.jsp");
		} else {
			
			request.setAttribute("errores", error);
			RequestDispatcher dispatcher = request.getRequestDispatcher("datosPersonales.jsp");
			dispatcher.forward(request, response);
		}

	}
}
