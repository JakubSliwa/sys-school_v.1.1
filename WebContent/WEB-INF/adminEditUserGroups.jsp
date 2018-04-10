<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edytuj grupę</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/header.jsp"%>
	<div class="jumbotron">

		<table class="table table-hover">
			<tr align="center">
				<th>Nazwa grupy</th>
			</tr>
			<tr align="center">
				<td>${userGroup.userGroupName}</td>

			</tr>
			<tr align="center">
				<td><a class="btn btn-success"
					href="ChangeNameUserGroup?id=${userGroup.id}"> Zmień nazwę
						grupy</a></td>
				<td><a class="btn btn-success"
					href="show-users-group?id=${userGroup.id}"> Zobacz użytkowników
						grupy</a></td>
				<td><a class="btn btn-danger"
					href="DeleteUserGroup?id=${userGroup.id}"> Usuń tą grupę</a></td>
			</tr>

		</table>
	</div>
	<%@ include file="/parts/footer.jsp"%>
</body>
</html>