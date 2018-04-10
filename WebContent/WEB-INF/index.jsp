<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sys-school</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/header.jsp"%>
	<div class="jumbotron">
		<h2>Ostatnio dodane rozwiazania</h2>
		<table class="table table-hover">
			<tr align="center">
				<th>Opis</th>
				<th>Data utworzenia</th>
				<th>Data modyfikacji</th>
				<th>Identyfikator uzytkownika</th>
				<th>Identyfikator zadania</th>
				<th>Akcje</th>
			</tr>

			<c:forEach items="${solutions}" var="solution">
				<tr align="center">
					<td>${solution.description}</td>
					<td>${solution.created}</td>
					<td>${solution.updated}</td>
					<td>${solution.userId}</td>
					<td>${solution.exerciseId}</td>
					<td><a class="btn btn-link" href="show-solution?id=${solution.id}"> Wyswietl</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>



	<%@ include file="/parts/footer.jsp"%>
</body>
</html>