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
		<p>Wpisz w formularzu dane nowego zadania</p>
		<div class="form-group" style="width: 500px;">
			<form action="AddNewExercise" method="post">
				Tytuł zadania: <br> <input class="form-control"
					placeholder="Podaj tytuł" type="text" name="newTitle" /> <br>
				Treść zadania: <br> <input class="form-control"
					placeholder="Dodaj opis" type="text" name="newDescription" /><br>
				<button class="btn btn-info" type="submit">Dodaj zadanie do
					bazy</button>
			</form>

		</div>
	</div>
	<%@ include file="/parts/footer.jsp"%>
</body>
</html>