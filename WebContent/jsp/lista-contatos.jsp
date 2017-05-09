<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="dao" class="control.ContatoService" />
<meta lang="charset-UTF8" />
<title>Contatos</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />


	<table>
		<tr>
			<th>ID</th>
			<th>NOME</th>
			<th>EMAIL</th>
			<th>ENDERECO</th>
			<th>NASCIMENTO</th>
		</tr>
		<%--usando if --%>
		<c:forEach var="contato" items="${dao.getContatos()}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td>${id.count}</td>
				<td><c:if test="${not empty contato.getValue().nome}">
					${contato.getValue().nome}</td>
				</c:if>
				<c:if test="${empty contato.getValue().nome}">
					<strong>Vazio</strong>
				</c:if>

				<td>${contato.getValue().email}</td>
				<td>${contato.getValue().endereco}</td>
				<td><fmt:formatDate
						value="${contato.getValue().dataNascimento.time}"
						pattern="dd/MM/y" /></td>
			</tr>
		</c:forEach>
	</table>

	<table>
		<tr>
			<th>ID</th>
			<th>NOME</th>
			<th>EMAIL</th>
			<th>ENDERECO</th>
			<th>NASCIMENTO</th>
		</tr>
		<%--usando switch --%>
		<c:forEach var="contato" items="${dao.getContatos()}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">

				<td>${id.count}</td>
				<c:choose>
					<c:when test="${not empty contato.getValue().nome}">
						<td>${contato.getValue().nome}</td>
					</c:when>
					<c:otherwise>
						<td><strong>Vazio </strong></td>
					</c:otherwise>
				</c:choose>

				<td>${contato.getValue().email}</td>
				<td>${contato.getValue().endereco}</td>
				<td><fmt:formatDate
						value="${contato.getValue().dataNascimento.time}"
						pattern="dd/MM/y" /></td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="rodape.jsp" />
</body>
</html>