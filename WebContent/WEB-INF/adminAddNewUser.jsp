<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new User</title>
</head>
<body>
	<%@ include file="/WEB-INF/parts/header.jsp"%>
	<div>
		<p>Wpisz w formularzu dane nowego użytkownika</p>

		<form action="addNewUser" method="post">
			Nazwa: <br> <input type="text" name="newName" /> <br>
			Email: <br> <input type="text" name="newEmail" /><br>
			Hasło: <br> <input type="text" name="newPassword" /><br>
			Podaj ID grupy, do której chcesz przypisać użytkownika: <br> <input
				type="text" name="newUserGroupId" /><br>
			<button type="submit">Dodaj użytkownika</button>
		</form>

	</div>
	<%@ include file="/WEB-INF/parts/footer.jsp"%>
</body>
</html>