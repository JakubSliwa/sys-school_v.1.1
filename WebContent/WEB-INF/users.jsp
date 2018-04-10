<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/header.jsp"%>
	<div class="jumbotron">
		<table class="table table-hover">
			<tr align="center">
				<th>Identyfikator</th>
				<th>Nazwa</th>
				<th>Email</th>
				<th>Zobacz szczegóły użytkownika</th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr align="center">
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td><a class="btn btn-link" href="show-user?id=${user.id}">
							Wyswietl</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<%@ include file="/parts/footer.jsp"%>
</body>
</html>