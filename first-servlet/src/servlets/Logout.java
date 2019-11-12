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
public class Logout extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession sesion = request.getSession(true);
		System.out.println("Cerrando sesion...");
		// Cerrar sesion
		sesion.invalidate();

		// Redirecciono a index.jsp
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession sesion = request.getSession(true);

		// Cerrar sesion
		sesion.invalidate();

		// Redirecciono a index.jsp
		response.sendRedirect("index.jsp");
	}
}
