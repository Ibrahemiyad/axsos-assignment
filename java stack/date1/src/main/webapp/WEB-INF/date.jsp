<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Date</title>
    <link rel="stylesheet" href="/css/style.css">
    <script src="/js/script.js"></script>
</head>
<body>
    <h1>Date</h1>
    <p><c:out value="${formattedDate}"/></p>
    <script>
        displayDateAlert("<c:out value='${formattedDate}'/>");
    </script>
</body>
</html>