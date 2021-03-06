<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserSolution</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/header.jsp"%>
	<div class="jumbotron">
		<h3>Szczegóły użytkownika ${user.name}</h3>
		<table class="table table-hover">
			<tr align="center">
				<th>ID zadania</th>
				<th>Tytuł zadania</th>
				<th>Treść</th>
				<th>Utworzone</th>
				<th>Zaktualizowane</th>
			</tr>
			<c:forEach items="${solutionByUserId}" var="userSolutions">
				<tr align="center">
					<td>${userSolutions.exerciseId}</td>
					<td>${userSolutions.getExercise().getTitle()}</td>
					<td>${userSolutions.description}</td>
					<td>${userSolutions.created}</td>
					<td>${userSolutions.updated}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@ include file="/parts/footer.jsp"%>
</body>
</html>