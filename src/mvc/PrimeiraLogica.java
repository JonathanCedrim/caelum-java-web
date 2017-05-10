package mvc;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimeiraLogica
 */
@WebServlet("/PrimeiraLogica")
public class PrimeiraLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("Executando");
		return "/jsp/primeira-logica.jsp";
	}

}
