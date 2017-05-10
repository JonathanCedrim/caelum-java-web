package mvc;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ContatoService;

/**
 * Servlet implementation class ListaContatosLogica
 */
@WebServlet("/ListaContatosLogica")
public class ListaContatosLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ContatoService dao = new ContatoService();
		req.setAttribute("dao", dao);

		return "/jsp/lista-contatos.jsp";
	}
}
