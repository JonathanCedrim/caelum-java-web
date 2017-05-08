package test;

import java.util.Calendar;

import control.ContatoService;
import model.Contato;

public class TestaDAO {
	public static void main(String[] args) {
		ContatoService dao = new ContatoService();
		Contato contato = new Contato("Jonathan", "jonathan.cedrim.souza@gmail.com", "floriano", Calendar.getInstance());
		
		dao.addContato(contato);		
		System.out.println(dao.getContatos());
				
	}
}
