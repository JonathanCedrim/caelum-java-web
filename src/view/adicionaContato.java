package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ContatoService;
import model.Contato;
import model.LogicaDeNegocioException;

@WebServlet("/adicionaContato")
public class adicionaContato extends HttpServlet {
	int contador = 0;
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
		
		contador++;
		
		PrintWriter out = arg1.getWriter();
		
		out.println("contador servlet " + contador);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();		
		contador++;
		System.out.println(contador);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Contato contato = new Contato();
		ContatoService contatoService = new ContatoService();

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
		} catch (ParseException e) {
			throw new LogicaDeNegocioException("Erro ao converter data: " + e);
		}
		contatoService.addContato(contato);
		
		PrintWriter out = resp.getWriter();
		
		out.println(contatoService.getContatos());
	}
}