package mvc;

import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ContatoService;
import model.Contato;

@WebServlet("/ListaContatos")
public class ListaContatos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection conn = (Connection) req.getAttribute("connection");
		ContatoService dao = new ContatoService(conn);

		Map<String, Contato> contatos = dao.getContatos();
		req.setAttribute("contatos", contatos);

		RequestDispatcher rq = req.getRequestDispatcher("/jsp/lista-contatos.jsp");
		rq.forward(req, resp);
	}
}
