<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title> <link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/header.jsp"%>
	<div>
		<p>Zmień email użytkownika o id ${loadedUser.id}. Obecna email to
			${loadedUser.email}</p>

		<form action="ChangeEmailUser" method="post">
			Nowy email użytkownika: <br> <input type="text" name="newEmail" />
			<input type="hidden" name="id" value="${loadedUser.id}" /> <br>
			<button type="submit">Zmień</button>
		</form>

	</div>
	<%@ include file="/parts/footer.jsp"%>
</body>
</html>