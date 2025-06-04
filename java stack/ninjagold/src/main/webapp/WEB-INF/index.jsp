<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ninja Gold Game</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>

<body>
	<div class="container">

		<div class="your-gold">
			<label for="gold"> Your Gold: <input type="text"
				name="total_gold" value="<c:out value="${gold}"/>" readonly>
			</label>
		</div>
		<div class="forms">
			<form class="form-box" action="/earngold" method="post">
				<h2>Farm</h2>
				<p>(earns 10-20 gold)</p>
				<input type="hidden" name="place" value="farm"> <input
					type="submit" value="Find Gold">
			</form>
			<form class="form-box" action="/earngold" method="post">
				<h2>Cave</h2>
				<p>(earns 5-10 gold)</p>
				<input type="hidden" name="place" value="cave"> <input
					type="submit" value="Find Gold">
			</form>
			<form class="form-box" action="/earngold" method="post">
				<h2>House</h2>
				<p>(earns 2-5 gold)</p>
				<input type="hidden" name="place" value="house"> <input
					type="submit" value="Find Gold">
			</form>
			<form class="form-box" action="/earngold" method="post">
				<h2>Quest</h2>
				<p>(earns/takes 0-50 gold)</p>
				<input type="hidden" name="place" value="quest"> <input
					type="submit" value="Find Gold">
			</form>
		</div>
		<section>
			<p>Activities :</p>
			<div name="activities" id="activities">
				<c:forEach var="msg" items="${messages}">
					<c:choose>
						<c:when test="${fn:contains(msg, 'lost')}">
							<p class="msg" style="color: ${sessionScope.red};">
								<c:out value="${msg}" />
							</p>
						</c:when>
						<c:otherwise>
							<p class="msg" style="color: ${sessionScope.green};">
								<c:out value="${msg}" />
							</p>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
		</section>
	</div>
</body>

</html>