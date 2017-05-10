<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />

<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- jquery-ui -->
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<title>Adicionar</title>

</head>
<body>
	<c:import url="cabecalho.jsp" />

	<form action=../adicionaContato method="POST">
		<p>
			NOME: <input type="text" name="nome" />
		</p>
		<p>
			EMAIL: <input type="email" name="email" />
		</p>
		<p>
			ENDERECO: <input type="text" name="endereco" />
		</p>
		<p>
			DATA NASCIMENTO:
			<caelum:campoData id="dataNascimento" />
		</p>

		<input type="submit" value="Gravar" />
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>