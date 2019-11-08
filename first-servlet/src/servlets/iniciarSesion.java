package servlets;

import java.io.IOException;
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
 * Servlet implementation class iniciarSesion
 */
@WebServlet("/iniciarSesion")
public class iniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public iniciarSesion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		Map<String, String> errores = new HashMap<>();
		String name = request.getParameter("name");
		String psswd = request.getParameter("password");

		if (name != null || name.trim().equals("")) {
			errores.put("Username", "Campo obligatorio");
		}
		if (psswd != null || psswd.trim().equals("")) {
			errores.put("Contrase�a", "Campo obligatorio");
		}

		if (errores.size() == 0) {
			// No hay errores -> Cotejamos con la BD
			Usuario user = new Usuario(name, psswd, null, null, null, 0);
			if (UsuarioDAO.validateUser(user)) {
				// Inicio de sesion correcto
				session.setAttribute("nickname", user.getLogin());
				response.sendRedirect("index.jsp");
			} else {
				// Error en el inicio de sesion
				// A�adimos como atributo de la peticion el mapa de errores
				errores.put("Error de inicio de sesion", "Usuario o contrase�a incorrecto");
				request.setAttribute("errores", errores);
				// Enviamos la peticion a otra pagina
				RequestDispatcher dispatcher = request.getRequestDispatcher("iniciarSesion.jsp");
				dispatcher.forward(request, response);
				//response.sendRedirect("iniciarSesion.html");
			}
		} else {
			// Hay errores
			// A�adimos como atributo de la peticion el mapa de errores
			request.setAttribute("errores", errores);
			// Enviamos la peticion a otra pagina
			RequestDispatcher dispatcher = request.getRequestDispatcher("iniciarSesion.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("iniciarSesion.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
