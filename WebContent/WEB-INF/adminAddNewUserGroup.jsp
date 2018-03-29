<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new user group</title>
</head>
<body>
	<%@ include file="/WEB-INF/parts/header.jsp"%>
	<div>
		<p>Wpisz w formularzu nazwę nowej grupy</p>

		<form action="addNewUserGroup" method="post">
			Nowa nazwa grupy: <br> <input type="text" name="newName" /> <br>
			<button type="submit">Dodaj grupę</button>
		</form>

	</div>
	<%@ include file="/WEB-INF/parts/footer.jsp"%>
</body>
</html>