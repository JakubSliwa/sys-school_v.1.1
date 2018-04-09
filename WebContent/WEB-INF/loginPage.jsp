<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
@import url('css/style.css');
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>

<body>

	<%@ include file="/WEB-INF/parts/unloggedHeader.jsp"%>
	<div>
		<div>
			<p>
				Zaloguj się, żeby przejść dalej. <span>Jeżeli nie posiadasz
					konta, <a href="RegisterNewUser">zarejestruj się tutaj.</a>
				</span>
			</p>

		</div>
		<div class="form-group">
			<form class="form-horizontal" action="StartServlet" method="post">
				Podaj swój email: <br> <input type="text" name="loginEmail" /><br>
				Podaj swoje hasło: <br> <input type="password"
					name="loginPassword" /><br>

				<button class="btn-primary" type="submit">Zaloguj się</button>
			</form>
		</div>

	</div>



	<%@ include file="/WEB-INF/parts/unloggedFooter.jsp"%>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</body>

</html>
