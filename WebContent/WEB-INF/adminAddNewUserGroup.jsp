<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new user group</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/header.jsp"%>
	<div class="jumbotron">
		<p>Wpisz w formularzu nazwę nowej grupy</p>
		<div class="form-group" style="width: 500px;">
			<form action="addNewUserGroup" method="post">
				Nowa nazwa grupy: <br> <input class="form-control"
					placeholder="Podaj nazwę grupy" type="text" name="newName" /> <br>
				<button class="btn btn-info" type="submit">Dodaj grupę</button>
			</form>
		</div>
	</div>
	<%@ include file="/parts/footer.jsp"%>
</body>
</html>