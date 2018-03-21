<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/parts/header.jsp"%>
	<table>
		<tr>
			<th>Nazwa Grupy</th>
			<th>Akcja</th>
		</tr>
		<c:forEach items="${groups}" var="group">
			<tr>
				<td>${group.name}</td>

				<td><a href="user-groups?id=${group.id}"> Wyswietl użytkowników tej grupy</a></td>
			</tr>
		</c:forEach>
	</table>

	<%@ include file="/WEB-INF/parts/footer.jsp"%>
</body>
</html>