<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change user group name</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/header.jsp"%>
	<div class="jumbotron">
		<p>Zmień nazwę groupy o id ${userGroup.id}. Aktualna nazwa to
			${userGroup.userGroupName}</p>
		<div class="form-group" style="width: 500px;">
			<form action="ChangeNameUserGroup" method="post">
				Nowa nazwa grupy: <br> <input class="form-control"
					placeholder="Podaj nową nazwę grupy" type="text" name="newName" />
				<input type="hidden" name="id" value="${userGroup.id}" /> <br>
				<button class="btn btn-info" type="submit">Zmień</button>
			</form>
		</div>
	</div>
	<%@ include file="/parts/footer.jsp"%>
</body>
</html>