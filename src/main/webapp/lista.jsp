
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
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body>
	<center>
		<div class="container">
			<h2>Pesquisa de presença do professor</h2>
			<c:if test="${fn:length(it.items) > 0}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Data</th>
							<th>Usuário Aluno</th>
							<th>Mac</th>
							<th>Sala</th>
							<th>Dispostivo</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${it.items}">
							<tr>
								<td>${item.data_pre}</td>
								<td>${item.aluno_pre}</td>
								<td>${item.endmac_pre}</td>
								<td>${item.sala_pre}</td>
								<td>${item.nmesp_pre}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${fn:length(it.items) == 0}">
				<h4 style="color: red;">Nenhum registro encontrado conforme filtro informado.</h4>
			</c:if>
		</div>
	</center>
	       
</body>
</html>
