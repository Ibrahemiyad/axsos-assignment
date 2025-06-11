<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,800"
	rel="stylesheet">
</head>
<body>

	<div class="container" id="container">

		<!-- Register Form -->
		<div class="form-container sign-up-container">
			<form:form action="/register" method="post" modelAttribute="newUser">
				<h1>Create Account</h1>
				<form:input path="userName" placeholder="Username" />
				<form:errors path="userName" cssClass="text-danger" />

				<form:input path="email" placeholder="Email" />
				<form:errors path="email" cssClass="text-danger" />

				<form:password path="password" placeholder="Password" />
				<form:errors path="password" cssClass="text-danger" />

				<form:password path="confirm" placeholder="Password" />
				<form:errors path="confirm" cssClass="text-danger" />

				<button type="submit">Register</button>
			</form:form>
		</div>

		<!-- Login Form -->
		<div class="form-container sign-in-container">
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<h1>Sign in</h1>

				<form:input path="email" placeholder="Email" />
				<form:errors path="email" cssClass="text-danger" />

				<form:password path="password" placeholder="Password" />
				<form:errors path="password" cssClass="text-danger" />

				<button type="submit">Login</button>
			</form:form>
		</div>

		<!-- Overlay Panel -->
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome Back!</h1>
					<p>To stay connected, please login with your credentials</p>
					<button class="ghost" id="signIn">Sign In</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Hello, Friend!</h1>
					<p>Enter your details and join us</p>
					<button class="ghost" id="signUp">Register</button>
				</div>
			</div>
		</div>
	</div>

	<!-- External JS -->
	<script src="${pageContext.request.contextPath}/js/script.js"></script>

</body>
</html>
