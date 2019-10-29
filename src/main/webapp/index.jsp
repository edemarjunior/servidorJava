
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<title>Pesquisa de presença</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {
		$("#inf").fadeOut(6000);
	});
</script>
</head>

<body>
	<center>
		<div class="container" style="width: 50%;">
			<h2>Pesquisa de presença do professor</h2>
			<form action="/WebServiceRest/rest/service/presencas" method="post">
				<div class="form-group" style="text-align: left;">
					<label for="email">usuário:</label> <input class="form-control"
						id="usu" placeholder="Informe usuário" name="usu" required>
				</div>
				<div class="form-group" style="text-align: left;">
					<label for="pwd">Senha:</label> <input type="password"
						class="form-control" id="senha" placeholder="Informe senha"
						name="senha" required>
				</div>
				<div class="form-group" style="text-align: left;">
					<label for="pwd">De:</label> <input type="datetime-local"
						class="form-control" id="dataini"
						placeholder="Informe a data inicial" name="dataini" required>
				</div>
				<div class="form-group" style="text-align: left;">
					<label for="pwd">Até:</label> <input type="datetime-local"
						class="form-control" id="datafim"
						placeholder="Informe a data final" name="datafim" required>
				</div>
				<div class="form-group" style="text-align: left;">
					<label for="pwd">Sala:</label> <input class="form-control"
						id="sala" placeholder="Informe a sala" name="sala" required>
				</div>

				<button type="submit" class="btn btn-primary"
					style="text-align: left;">Pesquisar</button>
				<c:if test="${fn:length(it.items) > 0}">
					<br> <br>
					<div class="alert alert-danger" id="inf">
						<strong>Usuário ou senha errado!</strong>
					</div>
				</c:if>
			</form>
		</div>
	</center>
</body>
</html>
