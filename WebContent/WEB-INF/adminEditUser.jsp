<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit user</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/header.jsp"%>
	<div class="jumbotron">

		<table class="table table-hover">
			<tr align="center">
				<th>Nazwa użytkownika</th>
				<th>Email użytkownika</th>
				<th>Id grupy użytkownika</th>
				<th>Id użytkownika</th>

			</tr>
			<tr align="center">
				<td>${editedUser.name}</td>
				<td>${editedUser.email}</td>
				<td>${editedUser.userGroupId}</td>
				<td>${editedUser.id}</td>
			</tr>
			<tr align="center">
				<td><a class="btn btn-success"
					href="ChangeNameUser?id=${editedUser.id}"> Zmień nazwę
						użytkownika</a></td>
				<td><a class="btn btn-success"
					href="ChangeEmailUser?id=${editedUser.id}"> Zmień email tego
						uzytkownika</a></td>
				<td><a class="btn btn-success"
					href="ChangeUserGroup?id=${editedUser.id}"> Przypisz do innej
						grupy</a></td>
				<td><a class="btn btn-danger"
					href="DeleteUser?id=${editedUser.id}"> Usuń tego użytkownika</a></td>
			</tr>

		</table>
	</div>
	<%@ include file="/parts/footer.jsp"%>
</body>
</html>