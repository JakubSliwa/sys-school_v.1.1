<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new User</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/header.jsp"%>
	<div>
		<p>Wpisz w formularzu dane nowego użytkownika</p>

		<form class="form-group" action="addNewUser" method="post">
			Nazwa: <br class="form-control"> <input type="text"
				name="newName" /> <br> Email: <br> <input type="text"
				name="newEmail" /><br> Hasło: <br> <input type="text"
				name="newPassword" /><br> Podaj ID grupy, do której chcesz
			przypisać użytkownika: <br> <input type="text"
				name="newUserGroupId" /><br>
			<button type="submit">Dodaj użytkownika</button>
		</form>

	</div>
	<%@ include file="/parts/footer.jsp"%>
</body>
</html>