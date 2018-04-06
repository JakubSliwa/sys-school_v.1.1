<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<%@ include file="/WEB-INF/parts/header.jsp"%>
	<br>
	<h3>Ostatnio dodane rozwiazania</h3>
	<table>
		<tr>
			<th>Opis</th>
			<th>Data utworzenia</th>
			<th>Data modyfikacji</th>
			<th>Identyfikator uzytkownika</th>
			<th>Identyfikator zadania</th>
			<th>Akcje</th>
		</tr>

		<c:forEach items="${solutions}" var="solution">
			<tr>
				<td>${solution.description}</td>
				<td>${solution.created}</td>
				<td>${solution.updated}</td>
				<td>${solution.userId}</td>
				<td>${solution.exerciseId}</td>
				<td><a href="show-solution?id=${solution.id}"> Wyswietl</a></td>
			</tr>
		</c:forEach>
	</table>


	<%@ include file="/WEB-INF/parts/footer.jsp"%>
</body>
</html>