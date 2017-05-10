package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ContatoService;
import mvc.Logica;
import mvc.PrimeiraLogica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parametro = req.getParameter("logica");
		String nomeDaClasse = "mvc." + parametro;

		try {
			
			Class classe = Class.forName(nomeDaClasse);

			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(req, resp);

			ContatoService dao = new ContatoService();
			req.getRequestDispatcher(pagina).forward(req, resp);

		} catch (Exception e) {
			throw new ServletException("A logica de negocios causou uma excecao " + e);
		}

	}
}
