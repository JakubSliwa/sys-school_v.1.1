<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit user</title>
</head>
<body>
	<%@ include file="/WEB-INF/parts/header.jsp"%>
	<table>
		<tr>
			<th>Nazwa użytkownika</th>
			<th>Email użytkownika</th>
			<th>Hasło użytkownika</th>
			<th>Id grupy użytkownika</th>
		</tr>
		<tr>
			<td>${editedUser.name}</td>
			<td>${editedUser.email}</td>
			<td>${editedUser.password}</td>
			<td>${editedUser.userGroupId}</td>
			<td><a href="ChangeNameUser?id=${editedUser.id}"> Zmień
					nazwę użytkownika</a></td>
			<td><a href="ChangeEmailUser?id=${editedUser.email}"> Zmień
					email tego uzytkownika</a></td>
			<td><a href="DelateUser?id=${editedUser.id}"> Usuń tego
					użytkownika</a></td>
		</tr>

	</table>

	<%@ include file="/WEB-INF/parts/footer.jsp"%>
</body>
</html>