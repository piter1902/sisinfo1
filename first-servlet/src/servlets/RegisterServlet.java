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
		 * No se debe permitir que se llame mediante un método Get
		 */
		resp.sendRedirect("registrarse.html");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Sesión que devolveremos al final de la operación.
		 */
		HttpSession respuesta = req.getSession(true);
		Map<String, String> error = new HashMap<String, String>();
		String nickName = req.getParameter("nickName");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		String pass1 = req.getParameter("password");
		String pass2 = req.getParameter("password1");
		String email = req.getParameter("email");
		String vehic = req.getParameter("vehiculo");

		// Patrón para comprobar si el email es correcto
		Pattern patron = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher match = patron.matcher(email);
		if (nickName.isEmpty())
			error.put("nickname", "Campo obligatorio.");
		if (pass1.isEmpty())
			error.put("password", "Campo obligatorio.");
		if (pass2.isEmpty())
			error.put("password1", "Campo obligatorio.");
		if (email.isEmpty())
			error.put("email", "Campo obligatorio.");
		if (apellidos.isEmpty())
			error.put("apellidos", "Campo obligatorio.");
		if (vehic.isEmpty())
			error.put("vehiculo", "Campo obligatorio.");
		if (pass1 != pass2)
			error.put("password1", "Contraseñas no coinciden.");
		if (!match.find())
			error.put("email", "Email incorrecto.");
		if (UsuarioDAO.findUserByLogin(nickName) != null)
			error.put("nickName", "El usuario " + nickName + " ya ha sido registrado");

		if (error.isEmpty()) {
			UsuarioDAO.insertUser(nickName, pass1, nombre, apellidos, email, 0);
			resp.setContentType("text/html; charset=ISO-8859-1");
			PrintWriter out = resp.getWriter();
			out.println("<html><head><title>Inserción usuario</title></head>");
			out.println("<body><p>El usuario con nick " + nickName + " se ha registrado correctamente.</p>");
			out.println("</body></html>");
		} else {
			req.setAttribute("errores", error);
			RequestDispatcher dispatcher = req.getRequestDispatcher("registrarse.html");
			dispatcher.forward(req, resp);
			resp.sendRedirect("registrarse.html");
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