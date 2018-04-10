<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- <style>
@import url('css/style.css');
</style> -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>

<body>
	<%@ include file="/parts/unloggedHeader.jsp"%>
	<div class="jumbotron" style="text-align: center">



		<fieldset>
			<div>
				<p>
					Zaloguj się, żeby przejść dalej. <span>Jeżeli nie posiadasz
						konta, <a href="RegisterNewUser">zarejestruj się tutaj.</a>
					</span>
				</p>

			</div>


			<center>
				<div class="form-group" style="width: 500px;">
					<form action="StartServlet" method="post">
						Podaj swój email: <br> <input class="form-control"
							placeholder="Enter email" type="text" name="loginEmail" /><br>
						Podaj swoje hasło: <br> <input class="form-control"
							placeholder="Password" type="password" name="loginPassword" /><br>

						<button type="submit" class="btn btn-primary">Zaloguj się</button>
					</form>
				</div>
			</center>
		</fieldset>
	</div>

	<%@ include file="/parts/unloggedFooter.jsp"%>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</body>

</html>
