package mvc;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ContatoService;
import model.Contato;
import model.LogicaDeNegocioException;

@WebServlet("/AdicionaContato")
public class AdicionaContato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = (Connection) req.getAttribute("connection");
		ContatoService dao = new ContatoService(conn);
		Contato contato = createContato(req);

		dao.addContato(contato);

		RequestDispatcher rq = req.getRequestDispatcher("/jsp/contato-adicionado.jsp");

		rq.forward(req, resp);
	}

	private Contato createContato(HttpServletRequest req) {
		Contato contato = new Contato();
		Calendar c = Calendar.getInstance();

		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setEndereco(req.getParameter("endereco"));

		try {
			String data = req.getParameter("dataNascimento");
			data = data.replaceAll("-", "/");

			Date date = new SimpleDateFormat("dd/MM/y").parse(data);

			c.setTime(date);
			contato.setDataNascimento(c);

			return contato;
		} catch (ParseException e) {
			throw new LogicaDeNegocioException("Erro ao converter data: " + e);
		}
	}
}