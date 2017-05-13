package mvc;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveContatoLogic
 */
@WebServlet("/RemoveContatoLogic")
public class RemoveContatoLogic implements Logica {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {


		return "jsp/remove-contato.jsp";
	}
}
