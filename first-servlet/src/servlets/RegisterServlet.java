package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import baseDatos.*;

public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nickName = req.getParameter("nickName");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		String pass1= req.getParameter("password");
		String pass2= req.getParameter("password1");
		String email = req.getParameter("email");
		String vehic = req.getParameter("vehiculo");
		if(pass1 != pass2) {
				resp.sendRedirect("registrarse.html");
		}
		Usuario introducido = new Usuario(nickName, pass1, nombre,apellidos, email, 0);
		if (UsuarioDAO.validateUser(introducido)) {
			//Faltaria especificar que hace si ha sido correcto el login
			UsuarioDAO.insertUser(nickName, pass1, nombre, apellidos, email, 0);
			response(resp, "registro ok");
			resp.sendRedirect("index.html");
		} else {
			response(resp, "invalid login");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
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