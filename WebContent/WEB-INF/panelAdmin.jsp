<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PanelAdmin</title>
</head>
<body>
	<%@ include file="/WEB-INF/parts/header.jsp"%>
	<div>
		<span><a href="addNewUserGroup">Dodaj nową grupę
				użytkowników&nbsp;</a></span>
		<table>
			<tr>
				<th>ID grupy</th>
				<th>Nazwa grupy</th>
				<th>Przejdź do edycji grup użytkowników</th>
			</tr>

			<c:forEach items="${userGroup}" var="userGroup">
				<tr>
					<td>${userGroup.id}</td>
					<td>${userGroup.userGroupName}</td>
					<td><a href="editUserGroup?id=${userGroup.id}"> Link do
							edycji</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<hr width="100%" color="green" align="left">
	<div>
		<span><a href="addNewUser">Dodaj nowego użytkownika&nbsp;</a></span>
		<table>
			<tr>
				<th>ID użytkownika</th>
				<th>Nazwa użytkownika</th>
				<th>Email użytkownika</th>
				<th>Przejdź do edycji wybranego użytkownika</th>
			</tr>

			<c:forEach items="${user}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td><a href="editUser?id=${user.id}">Link do edycji</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<hr width="100%" color="green" align="left">
	<div>
		<span><a href="">Dodaj nowe zadanie&nbsp;</a></span>
		<table>
			<tr>
				<th>ID zadania</th>
				<th>Tytuł zadania</th>
				<th>Przejdź do edycji wybranego zadania</th>
			</tr>

			<c:forEach items="${exercise}" var="exercise">
				<tr>
					<td>${exercise.id}</td>
					<td>${exercise.title}</td>
					<td>Link do edycji</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@ include file="/WEB-INF/parts/footer.jsp"%>
</body>
</html>