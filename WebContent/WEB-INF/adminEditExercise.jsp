<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edytuj zadanie</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/header.jsp"%>
	<div class="jumbotron">
		<table class="table table-hover">
			<tr align="center">
				<th>Tytuł zadania</th>
				<th>Treść zadania</th>
				<th>Id zadania</th>

			</tr>
			<tr align="center">
				<td>${editedExercise.title}</td>
				<td>${editedExercise.description}</td>
				<td>${editedExercise.id}</td>
			</tr>
			<tr align="center">
				<td><a class="btn btn-success"
					href="ChangeTitleExercise?id=${editedExercise.id}"> Zmień tytuł
						zadania</a></td>
				<td><a class="btn btn-success"
					href="ChangeDescriptionExercise?id=${editedExercise.id}"> Zmień
						opis tego zadania</a></td>
				<td><a class="btn btn-success"
					href="ShowSolutions?id=${editedExercise.id}"> Sprawdz
						rozwiązania</a></td>
				<td><a class="btn btn-danger"
					href="DeleteExercise?id=${editedExercise.id}"> Usuń zadanie</a></td>
			</tr>

		</table>
	</div>
	<%@ include file="/parts/footer.jsp"%>
</body>
</html>