<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="dao"%>

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
		
		<dao:listaContatos dao="${param.dao}"/>
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
		<dao:listaContatosSwitch dao="${param.dao}" />
	</table>
	<c:import url="rodape.jsp" />
</body>
</html>