package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.startup.PasswdUserDatabase;

import baseDatos.*;

/**
 * Servlet implementation class logout
 */
//@WebServlet("/logout")
public class DeleteUser extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Impedimos que se llame con el método GET
		response.sendRedirect("datosPersonales.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> error = new HashMap<String, String>();
		HttpSession session = request.getSession(true);
		String userNick = (String) session.getAttribute("nickname");
		System.out.println("Usuario a eliminar: " + userNick);
		Usuario user = UsuarioDAO.findUserByLogin(userNick);
		String resultado = request.getParameter("decision");
		System.out.println("resultado :" + resultado);
		if (resultado == null || resultado.trim().equals("")) {
			error.put("decision", "Elija una de las dos opciones.");
		}
		if (error.size() == 0) {
			if (resultado.equals("si")) {
				session.invalidate();
				UsuarioDAO.deleteUsuario(user);
				response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("datosPersonales.jsp");
			}
			
		} else {
			request.setAttribute("errores", error);
			RequestDispatcher dispatcher = request.getRequestDispatcher("datosPersonales.jsp");
			dispatcher.forward(request, response);
		}
	}
}
