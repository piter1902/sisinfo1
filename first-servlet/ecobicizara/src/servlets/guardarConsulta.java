package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
import email.ComentarioEmail;

/**
 * Servlet implementation class ModifyUser
 */

public class guardarConsulta extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * No se debe permitir que se llame mediante un mÃ©todo Get
		 */
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// userNick contiene el login del usuario conectado.
		HttpSession session = request.getSession(false);
		Map<String, String> error = new HashMap<String, String>();
		String userNick = (String)session.getAttribute("nickname");
		String origen = request.getParameter("origen");
		String destino = request.getParameter("destino");
		if (origen == null || origen.trim().equals("")) {
			error.put("origen", "Por favor, introduzca origen.");
		}
		if (destino == null || destino.trim().equals("")) {
			error.put("destino", "Por favor, introduzca destino.");
		}
		if (userNick == null || userNick.trim().equals("")) {
			error.put("nickname", "Para realizar operación, debe iniciar sesión.");
		}
		if (error.size() == 0) {
			java.util.Date fecha = new Date();
			Consulta con = new Consulta(1, userNick, origen, destino, fecha);
			ConsultaDAO.insertConsulta(con);
			response.sendRedirect("index.jsp");

		} else {
			request.setAttribute("errores", error);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
}
