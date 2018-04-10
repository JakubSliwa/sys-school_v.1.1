<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/header.jsp"%>
	<div class="jumbotron">
		<p>Zmień opis zadania o id ${loadedExercise.id}. Obecny opis to
			${loadedExercise.description}</p>
		<div class="form-group" style="width: 500px;">
			<form action="ChangeDescriptionExercise" method="post">
				Nowy opis <br> <input class="form-control"
					placeholder="Wpisz nowy opis" type="text" name="newDescription" />
				<input type="hidden" name="id" value="${loadedExercise.id}" /> <br>
				<button class="btn btn-info" type="submit">Zmień</button>
			</form>

		</div>
	</div>
	<%@ include file="/parts/footer.jsp"%>
</body>
</html>