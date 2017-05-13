package mvc;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ContatoDAO;

@WebServlet("/RemoveContatoById")
public class RemoveContatoById implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		System.out.println("executando");
		ContatoDAO dao = new ContatoDAO();
		Long id = Long.parseLong(req.getParameter("id"));

		dao.removeById(id);

		return "/jsp/remove-contato.jsp";

	}
}
