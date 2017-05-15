package test;

import java.util.Calendar;

import control.ContatoService;
import model.ConnectionFactory;
import model.Contato;

public class TestaDAO {
	public static void main(String[] args) {
		ContatoService dao = new ContatoService(ConnectionFactory.getConnection());
		Contato contato = new Contato("Jonathan", "jonathan.cedrim.souza@gmail.com", "floriano",
				Calendar.getInstance());

		
		/*
		 * exemplo que demonstra que a conexao esta realmente 
		 * sendo fechada e é preciso abrir a cada requisição uma nova.
		 */
		
		dao.addContato(contato);
		Long id = Long.parseLong("5");
		dao = new ContatoService(ConnectionFactory.getConnection());
		dao.removePorId(id);
		dao = new ContatoService(ConnectionFactory.getConnection());
		System.out.println(dao.getContatos());

	}
}