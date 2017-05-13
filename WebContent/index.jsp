<%@page import="model.Contato"%>
<%@page import="control.ContatoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta lang=charset-UTF8 />
<title>Agenda</title>
</head>
<body>
	<c:import url="jsp/cabecalho.jsp" />

	<%@page import="java.util.*, control.*, model.*"%>

	<%
		String desenvolvido = "Desenvolvido por Jonathan Cedrim";
	%>
	<h1>Agenda</h1>
	<nav>
		<ul>
			<li><a href="jsp/adiciona-contato.jsp">adicionar</a></li>
		</ul>
	</nav>
	<section>
		<table>
			<tr>
				<th>NOME</th>
				<th>EMAIL</th>
				<th>ENDERECO</th>
				<th>NASCIMENTO</th>
			</tr>
			<%
				ContatoService dao = new ContatoService();
				Contato contato = null;

				Map<String, ?> contatos = dao.getContatos();

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
	<footer>
		<c:import url="jsp/rodape.jsp" />
		<%=desenvolvido%>
	</footer>
</body>
</html>