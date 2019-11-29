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
import java.util.List;
import java.util.LinkedList;
import org.apache.catalina.startup.PasswdUserDatabase;
import email.ComentarioEmail; 

import baseDatos.*;

/**
 * Servlet implementation class logout
 */

public class AddComment extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Impedimos que se llame con el método GET
		response.sendRedirect("contact.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Estoy en addcoment.");
		Map<String, String> error = new HashMap<String, String>();
		HttpSession session = request.getSession(true);
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String asunto = request.getParameter("asunto");
		String msg = request.getParameter("msg");
		Pattern patron = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		if (nombre == null || nombre.trim().equals("")) {
			error.put("nickname", "Por favor, introduzca nombre.");
		}
		if (email == null || email.trim().equals("")) {
			error.put("email", "Por favor, introduzca dirección de correo.");
		}else{
			Matcher match = patron.matcher(email);
			if (!match.find()) {
				error.put("email", "Por favor, introduzca dirección de correo válida.");
			}
		}
		if (asunto == null || asunto.trim().equals("")) {
			error.put("asunto", "Debe añadir un asunto.");
		}else {
			if (asunto.length() > 30)
				error.put("asunto", "Asundto demasiado largo. Máximo 30 carácteres.");
		}
		if (msg == null || msg.trim().equals("")) {
			error.put("msg", "Cuerpo de mensaje vacío. Introduzca texto.");
		} else {
			if (msg.length() > 250)
				error.put("msg", "Cuerpo de mensaje demasiado largo. Máximo 250 carácteres.");
		}

		if (error.size() == 0) {
//			System.out.println("Metemos mensaje");
//			List<Comentario> list = ComentarioDAO.findAllComentarios();
//			if (list.size() != 0) {
//				Comentario lastComment = list.get(list.size());
//				int antecesor = lastComment.getComentID();
//				Comentario coment = new Comentario(-1,email, nombre, null, msg, antecesor);
//				ComentarioDAO.insertComentario(coment);
//			} else {
			Comentario coment = new Comentario(1, email, nombre, null, msg, 1, asunto);
			ComentarioDAO.insertComentario(coment);
			ComentarioEmail.sendPregunta(coment); 
			response.sendRedirect("contact.jsp");

		} else {
			request.setAttribute("errores", error);
			RequestDispatcher dispatcher = request.getRequestDispatcher("contact.jsp");
			dispatcher.forward(request, response);
		}
	}
}
