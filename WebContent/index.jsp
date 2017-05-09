<%@page import="model.Contato"%>
<%@page import="control.ContatoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta lang=charset-UTF8 />
<title>Agenda</title>
</head>
<body>
	<%--comentario--%>
	<%@page import="java.util.*, control.*, model.*"%>

	<%
		String desenvolvido = "Desenvolvido por Jonathan Cedrim";
	%>
	<h1>Agenda</h1>
	<nav>
		<ul>
			<li><a href="html/adicionaContato.html">adicionar</a></li>
		</ul>
	</nav>
	<section>
		<table>
			<tr>
				<th>nome</th>
				<th>email</th>
				<th>endereco</th>
				<th>nascimento</th>
			</tr>
			<%
				ContatoService dao = new ContatoService();
				Contato contato = null;

				Map contatos = dao.getContatos();

				Set<String> chaves = contatos.keySet();

				for (String chave : chaves) {
			%>
			<%
				contato = (Contato) contatos.get(chave);
			%>

			<tr>
				<td><%=contato.getNome()%></td>
				<td><%=contato.getEmail()%></td>
				<td><%=contato.getEndereco()%></td>
				<td><%=contato.getDataNascimentoFormatada("dd/MM/y")%></td>
			</tr>
			<%
				}
			%>
		</table>
	</section>
	<footer><%=desenvolvido%></footer>
</body>
</html>