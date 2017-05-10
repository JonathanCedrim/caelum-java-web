package control;

import java.sql.SQLException;
import java.util.Map;

import javafx.scene.control.TreeTableRow;
import model.Contato;
import model.LogicaDeNegocioException;

public class ContatoService  {
	private ContatoDAO dao = new ContatoDAO();

	public void addContato(Contato contato) {
		try {
			dao.addContato(contato);
		} catch (SQLException e) {
			throw new LogicaDeNegocioException("erro ao salvar: " + e);
		}
	}

	public Map getContatos() {
		try {
			Map contatos = dao.getContatos();
			return contatos;
		} catch (SQLException e) {
			throw new LogicaDeNegocioException("erro ao recuperar contatos: " + e);
		}
	}

	public void getContatoById(Long id) {
		try {
			dao.getContatoById(id);
		} catch (SQLException e) {
			throw new LogicaDeNegocioException("erro ao recuperar contato pelo id: " + e);
		}
	}

	public void removePorId(Long id) {
		try {
			dao.removeById(id);
		} catch (SQLException e) {
			throw new LogicaDeNegocioException("erro ao remover contato pelo id : " + e);
		}
	}
}
