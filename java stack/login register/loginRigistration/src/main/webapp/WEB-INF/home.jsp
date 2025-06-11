<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<h2>Welcome, ${user.userName}!</h2>

	<%@ page session="true"%>
	<%
	if (session.getAttribute("userId") == null) {
		response.sendRedirect("/");
	}
	%>
	<a href="/logout" class="btn btn-danger">Logout</a>

</body>
</html>