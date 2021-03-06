<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>groups</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
</head>
<body>
	<%@ include file="/parts/header.jsp"%>

	<div class="jumbotron">


		<table class="table table-hover">
			<tr align="center">
				<th>Nazwa grupy</th>
				<th>Akcja</th>
			</tr>
			<c:forEach items="${groups}" var="group">
				<tr align="center">
					<td>${group.userGroupName}</td>
					<td><a class="btn btn-link"
						href="show-users-group?id=${group.id}"> Wyswietl</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@ include file="/parts/footer.jsp"%>
</body>
</html>