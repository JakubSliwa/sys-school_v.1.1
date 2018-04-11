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
	<img alt="avatar"
		src="https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg"
		style="width: 200px; height: 200px;">
	<div class="jumbotron" style="display: inline;">


		<span><a class="btn btn-info" href=""> Wyślij wiadomość</a></span> <span><a
			class="btn btn-info" href="">Sprawdź wiadomości</a> </span> <span><a
			class="btn btn-info" href="">Wyświetl listę Twoich zadań</a> </span> <span><a
			class="btn btn-warning" href="">Ustawienia konta</a> </span>




	</div>
	<h1 style="display: inline-block; float: right;">
		WITAJ UŻYTKOWNIKU!
		<%=name%>
		W PRZYSZŁOŚCI TUTAJ ZNAJDZIESZ DODATKOWE FUNKCJONALNOŚCI!
	</h1>
	<br>
	<div class="btn-group-vertical" data-toggle="buttons">
		<button type="button" class="btn btn-primary">Button</button>
		<button type="button" class="btn btn-primary">Button</button>
		<button type="button" class="btn btn-primary">Button</button>
		<button type="button" class="btn btn-primary">Button</button>
		<button type="button" class="btn btn-primary">Button</button>
		<button type="button" class="btn btn-primary">Button</button>
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