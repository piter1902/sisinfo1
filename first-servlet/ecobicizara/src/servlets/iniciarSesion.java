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

		HttpSession session = request.getSession();

		Map<String, String> errores = new HashMap<>();
		String name = request.getParameter("name");
		String psswd = request.getParameter("password");
		boolean noVacio = true;
		if (name == null || name.trim().equals("")) {
			errores.put("nickPass", "Campo vacío");
			noVacio = false;
		}
		if (psswd == null || psswd.trim().equals("")) {
			errores.put("nickPass", "Campo vacío");
			noVacio = false;
		}
		if (noVacio) {
			Usuario user = new Usuario(name, psswd, null, null, null, 0);
			if (!UsuarioDAO.validateUser(user)) {
				errores.put("nickPass", "Email o contraseña incorrectos. Inténtelo de nuevo.");
			}
		}
		if (errores.size() == 0) {
			// Inicio de sesion correcto
			response.getWriter().write("Bienvenido " + name);
			session.setAttribute("nickname", name);
			response.sendRedirect("index.jsp");

		} else {
			// Hay errores
			request.setAttribute("errores", errores);
			// Enviamos la peticion a otra pagina
			RequestDispatcher dispatcher = request.getRequestDispatcher("iniciarSesion.jsp");
			dispatcher.forward(request, response);

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
