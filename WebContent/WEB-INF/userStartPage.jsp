<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello!</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/userHeader.jsp"%>
	<%
		String name = (String) session.getAttribute("systemUsername");
		String email = (String) session.getAttribute("systemUserEmail");
		Integer id = (Integer) session.getAttribute("systemUserId");
	%>
	<h1>
		WITAJ UŻYTKOWNIKU!
		<%=name%>
		W PRZYSZŁOŚCI TUTAJ ZNAJDZIESZ DODATKOWE FUNKCJONALNOŚCI!
	</h1>

	<div>
		<span>Wyślij wiadomość </span><span>Sprawdź wiadomości </span><span>Wyświetl
			listę Twoich zadań </span><span>Ustawienia konta </span>
	</div>

	<div>
		Twoje id to:
		<%=id%></div>
	<div>
		Twoje mail to:
		<%=email%></div>
	<%@ include file="/parts/userFooter.jsp"%>
</body>
</html>