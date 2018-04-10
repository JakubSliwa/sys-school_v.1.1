<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello!</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/userHeader.jsp"%>
	<h1>WITAJ UŻYTKOWNIKU! ${loadedUser.name} W PRZYSZŁOŚCI TUTAJ
		ZNAJDZIESZ DODATKOWE FUNKCJONALNOŚCI!</h1>

	<div>
		<span>Wyślij wiadomość </span><span>Sprawdź wiadomości </span><span>Wyświetl
			listę Twoich zadań </span><span>Ustawienia konta </span>
	</div>

	<div>Twoje id to: ${loadedUser.id}</div>
	<%@ include file="/parts/userFooter.jsp"%>
</body>
</html>