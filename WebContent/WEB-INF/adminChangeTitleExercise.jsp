<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/parts/header.jsp"%>
	<div>
		<p>Zmień tytuł zadania o id ${loadedExercise.id}. Obecny tytuł to
			${loadedExercise.title}</p>

		<form action="ChangeTitleExercise" method="post">
			Nowy tytuł <br> <input type="text" name="newTitle" /> <input
				type="hidden" name="id" value="${loadedExercise.id}" /> <br>
			<button type="submit">Zmień</button>
		</form>

	</div>
	<%@ include file="/WEB-INF/parts/footer.jsp"%>
</body>
</html>