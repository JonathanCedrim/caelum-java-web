<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta lang="charset-utf8"/>
	<title>adiciona idade</title>
</head>
<body>
	<strong>Digite sua idade e pressione o botao</strong>
	
	<form action="mostra-idade.jsp" method="POST">
		<strong>Idade: </strong>
			<input type="text" name="idade"/>
			<input type="submit"/>
	</form>
</body>
</html>