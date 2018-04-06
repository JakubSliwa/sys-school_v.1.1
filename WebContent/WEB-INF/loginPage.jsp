<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<%@ include file="/WEB-INF/parts/unloggedHeader.jsp"%>
	<div>
		<p>
			Zaloguj się, żeby przejść dalej. <span>Jeżeli nie posiadasz
				konta, <a href="RegisterNewUser">zarejestruj się tutaj.</a>
			</span>
		</p>

		<form action="StartServlet" method="post">
			Podaj swój email: <br> <input type="text" name="loginEmail" /><br>
			Podaj swoje hasło: <br> <input type="password"
				name="loginPassword" /><br>

			<button type="submit">Zaloguj się</button>
		</form>
	</div>



	<%@ include file="/WEB-INF/parts/unloggedFooter.jsp"%>
</body>
</html>