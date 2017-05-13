package control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import model.ConnectionFactory;
import model.Contato;
import model.LogicaDeNegocioException;

public class ContatoDAO {

	private Connection conn = ConnectionFactory.getConnection();
	private PreparedStatement stmt = null;

	public void addContato(Contato contato) throws SQLException {
		String sql = "insert into contatos " + "(nome, email, endereco, dataNascimento)" + "values(?, ?, ?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			stmt.execute();
		} catch (SQLException e) {
			throw new LogicaDeNegocioException("erro ao inserir contato: " + e);
		} finally {
			closeConnection();
		}
	}

	public Map<String, Contato> getContatos() throws SQLException {
		try {
			String sql = "select * from contatos";

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			Map<String, Contato> contatos = new HashMap<String, Contato>();
			while (rs.next()) {
				Contato contato = createContato(rs);
				contatos.put(contato.getNome(), contato);
			}
			rs.close();
			return contatos;
		} catch (SQLException e) {
			throw new LogicaDeNegocioException("erro ao recuperar contatos: " + e);
		} finally {
			closeConnection();
		}
	}

	public Contato getContatoById(Long id) throws SQLException {
		try {
			String sql = "select * from contatos where id = ?";

			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Contato contato = createContato(rs);
				rs.close();
				return contato;
			}
		} catch (SQLException e) {
			throw new LogicaDeNegocioException("erro ao recuperar contato pelo id: " + e);
		} finally {
			closeConnection();
		}
		return null;
	}

	public Map<String, Contato> findByName(String nome) throws SQLException {
		String sql = "select * from contatos where lower(nome) like ?";
		try {			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + nome.toLowerCase() + "%");

			ResultSet rs = stmt.executeQuery();
			Map<String, Contato> contatos = new HashMap<String, Contato>();

			while (rs.next()) {
				Contato contato = createContato(rs);

				contatos.put(contato.getNome(), contato);
			}
			rs.close();
			return contatos;
		} catch (SQLException e) {
			throw new LogicaDeNegocioException("Erro ao buscar por contatos: " + e);
		} finally {
			closeConnection();
		}
	}

	public void removeById(Long id) throws SQLException {
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "delete from contatos where id=?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setLong(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new LogicaDeNegocioException("erro ao remover contato: " + e);
		} finally {
			closeConnection();
		}
	}

	public void removeByName(String name) throws SQLException {
		try {		
			String sql = "delete from contatos where nome=?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, name);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new LogicaDeNegocioException("erro ao remover contato: " + e);
		} finally {
			closeConnection();
		}
	}

	public void save(Contato contato) throws SQLException {
		try {
			if (contato.getId() == null) {
				String sql = "insert into contatos (nome, email,  endereco, dataNascimento) "
						+ "values (?, ?, ?, ?, ?)";
				stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			} else {
				stmt = conn.prepareStatement(
						"update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?");
			}
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			if (contato.getId() != null) {
				stmt.setLong(5, contato.getId());
			}
			stmt.execute();
		} catch (SQLException e) {
			throw new LogicaDeNegocioException("Erro ao salvar contato: " + e);
		} finally {
			closeConnection();
		}
	}

	private Contato createContato(ResultSet rs) throws SQLException {
		Contato contato = new Contato();
		Calendar c = Calendar.getInstance();

		contato.setId(rs.getLong("id"));
		contato.setNome(rs.getString("nome"));
		contato.setEmail(rs.getString("email"));
		contato.setEndereco(rs.getString("endereco"));
		c.setTime(new Date(rs.getDate("dataNascimento").getTime()));

		contato.setDataNascimento(c);

		return contato;
	}

	private void closeConnection() throws SQLException {
		if (this.stmt != null) {
			stmt.close();
		}
		if (this.conn != null) {
			conn.close();
		}
	}
}