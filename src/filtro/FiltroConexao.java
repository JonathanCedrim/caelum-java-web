package filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import model.ConnectionFactory;
import model.LogicaDeNegocioException;

@WebFilter("/*")
public class FiltroConexao implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		try {
			Connection connection = ConnectionFactory.getConnection();

			req.setAttribute("connection", connection);

			chain.doFilter(req, resp);

			connection.close();

		} catch (SQLException e) {
			throw new LogicaDeNegocioException("erro ao requerir conexao: " + e);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
