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
import javax.websocket.Session;

import org.apache.catalina.startup.PasswdUserDatabase;

import baseDatos.*;

/**
 * Servlet implementation class ModifyUser
 */

public class ModifiyUser extends HttpServlet {

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
		String userNick = (String) request.getAttribute("nickname");
		Usuario currentUser = UsuarioDAO.findUserByLogin(userNick);
		String toChange = (String) request.getAttribute("toModify");

	}
}
