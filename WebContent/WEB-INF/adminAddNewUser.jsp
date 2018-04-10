<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodaj nowego użytkownika</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/header.jsp"%>


	<div class="jumbotron">
		Wpisz w formularzu dane nowego użytkownika
		<div class="form-group" style="width: 500px;">
			<form action="addNewUser" method="post">
				Nazwa: <br class="form-control"> <input class="form-control"
					placeholder="Wpisz nazwę użytkownika" type="text" name="newName" />
				<br> Email: <br> <input class="form-control"
					placeholder="Wpisz email" type="text" name="newEmail" /><br>
				Hasło: <br> <input class="form-control"
					placeholder="Wpisz hasło" type="text" name="newPassword" /><br>
				Podaj ID grupy, do której chcesz przypisać użytkownika: <br> <input
					class="form-control" placeholder="Wpisz ID grupy" type="text"
					name="newUserGroupId" /><br>
				<button class="btn btn-info" type="submit">Dodaj
					użytkownika</button>
			</form>
		</div>
	</div>
	<%@ include file="/parts/footer.jsp"%>
</body>
</html>