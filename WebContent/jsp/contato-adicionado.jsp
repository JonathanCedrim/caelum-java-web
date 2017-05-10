<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta lang="charset-UTF8" />

<title>Agenda</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<p>Contato ${param.nome} adicionado com sucesso</p>
	<c:import url="rodape.jsp" />
</body>
</html>