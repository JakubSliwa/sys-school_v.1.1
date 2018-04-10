<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zarejestruj się!</title> <link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/userHeader.jsp"%>
	<div>
		<p>Wpisz w formularzu swoje dane</p>

		<form action="RegisterNewUser" method="post">
			Nazwa: <br> <input type="text" name="registerName" /> <br>
			Email: <br> <input type="text" name="registerEmail" /><br>
			Hasło: <br> <input type="text" name="registerPassword" /><br>
			<button type="submit">Zarejestruj się!</button>
		</form>
		<div>Po zarejestrowaniu wrócisz do ekranu logowania</div>
	</div>
	<%@ include file="/parts/userFooter.jsp"%>
</body>
</html>