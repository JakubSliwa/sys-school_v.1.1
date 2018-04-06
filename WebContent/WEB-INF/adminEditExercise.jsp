<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/parts/header.jsp"%>
	<table>
		<tr>
			<th>Tytuł zadania</th>
			<th>Treść zadania</th>
			<th>Id zadania</th>

		</tr>
		<tr>
			<td>${editedExercise.title}</td>
			<td>${editedExercise.description}</td>
			<td>${editedExercise.id}</td>
		</tr>
		<tr>
			<td><a href="ChangeTitleExercise?id=${editedExercise.id}">
					Zmień tytuł zadania</a></td>
			<td><a href="ChangeDescriptionExercise?id=${editedExercise.id}">
					Zmień opis tego zadania</a></td>
			<td><a href="ShowSolutions?id=${editedExercise.id}"> Sprawdz
					rozwiązania</a></td>
			<td><a href="DeleteExercise?id=${editedExercise.id}"> Usuń
					zadanie</a></td>
		</tr>

	</table>

	<%@ include file="/WEB-INF/parts/footer.jsp"%>
</body>
</html>