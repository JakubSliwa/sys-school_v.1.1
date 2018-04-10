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
		<p>Zmień tytuł zadania o id ${loadedExercise.id}. Obecny tytuł to
			${loadedExercise.title}</p>
		<div class="form-group" style="width: 500px;">
			<form action="ChangeTitleExercise" method="post">
				Nowy tytuł <br> <input class="form-control"
					placeholder="Podaj nowy tytuł zadania" type="text" name="newTitle" />
				<input type="hidden" name="id" value="${loadedExercise.id}" /> <br>
				<button class="btn btn-info" type="submit">Zmień</button>
			</form>

		</div>
	</div>
	<%@ include file="/parts/footer.jsp"%>
</body>
</html>