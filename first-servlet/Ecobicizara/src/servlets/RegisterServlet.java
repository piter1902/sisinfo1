package servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
		 * No se debe permitir que se llame mediante un método Get
		 */
		resp.sendRedirect("registrarse.html");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Sesión que devolveremos al final de la operación.
		 */
		HttpSession respuesta = req.getSession(true);
		String nickName = req.getParameter("nickName");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		String pass1 = req.getParameter("password");
		String pass2 = req.getParameter("password1");
		String email = req.getParameter("email");
		String vehic = req.getParameter("vehiculo");
		if (pass1 != pass2) {
			respuesta.setAttribute("error", "contraseñas no coinciden");
		}
		Usuario introducido = new Usuario(nickName, pass1, nombre, apellidos, email, 0);
		String error = null;
		if (UsuarioDAO.validateUser(introducido)) {
			respuesta.setAttribute("error", error);
			UsuarioDAO.insertUser(nickName, pass1, nombre, apellidos, email, 0);
			resp.sendRedirect("index.html");
		} else {
			respuesta.setAttribute("error", error);
			response(resp, "invalid login");
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