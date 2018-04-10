<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zmień nazwę użytkownika</title>
</head>
<body>
	<%@ include file="/parts/header.jsp"%>
	<div class="jumbotron">
		<p>Zmień nazwę użytkownika o id ${loadedUser.id}. Obecna nazwa to
			${loadedUser.name}</p>
		<div class="form-group" style="width: 500px;">
			<form action="ChangeNameUser" method="post">
				Nowa nazwa użytkownika: <br> <input class="form-control"
					placeholder="Podaj nową nazwę użytkownika" type="text"
					name="newName" /> <input type="hidden" name="id"
					value="${loadedUser.id}" /> <br>
				<button class="btn btn-info" type="submit">Zmień</button>
			</form>

		</div>
	</div>
	<%@ include file="/parts/footer.jsp"%>
</body>
</html>