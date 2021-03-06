<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PanelAdmin</title>
<!-- <style>
@import
url(request.getContextPath()
+
'/css/style.css'
);
</style> -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/header.jsp"%>
	<div class="jumbotron">
		<span><a class="btn btn-info" href="addNewUserGroup">Dodaj
				nową grupę użytkowników&nbsp;</a></span>
		<table class="table table-hover">
			<tr align="center">
				<th>ID grupy</th>
				<th>Nazwa grupy</th>
				<th>Przejdź do edycji grup użytkowników</th>
			</tr>

			<c:forEach items="${userGroup}" var="userGroup">
				<tr align="center">
					<td>${userGroup.id}</td>
					<td>${userGroup.userGroupName}</td>
					<td><a class="btn btn-link"
						href="editUserGroup?id=${userGroup.id}"> Link do edycji</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="jumbotron">
		<span><a href="addNewUser" class="btn btn-info">Dodaj
				nowego użytkownika&nbsp;</a></span>
		<table class="table table-hover">
			<tr align="center">
				<th>ID użytkownika</th>
				<th>Nazwa użytkownika</th>
				<th>Email użytkownika</th>
				<th>Przejdź do edycji wybranego użytkownika</th>
			</tr>

			<c:forEach items="${user}" var="user">
				<tr align="center">
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td><a class="btn btn-link" href="editUser?id=${user.id}">Link
							do edycji</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="jumbotron">
		<span><a class="btn btn-info" href="AddNewExercise">Dodaj
				nowe zadanie&nbsp;</a></span>
		<table class="table table-hover">
			<tr align="center">
				<th>ID zadania</th>
				<th>Tytuł zadania</th>
				<th>Przejdź do edycji wybranego zadania</th>
			</tr>

			<c:forEach items="${exercise}" var="exercise">
				<tr align="center">
					<td>${exercise.id}</td>
					<td>${exercise.title}</td>
					<td><a class="btn btn-link"
						href="editExercise?id=${exercise.id}">Link do edycji</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@ include file="/parts/footer.jsp"%>
</body>
</html>