<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="home-container">
    <h1>${product.name}</h1>
    <div class="home-navbar">
        <a href="/">home</a>
    </div>
    <hr class="border border-primary border-3 opacity-75">
    <div class="home-table">
        <h2>Categories:</h2>
        <ul>
            <c:forEach var="category" items="${product.categories}" >
                <li>${category.name}</li>
            </c:forEach>
        </ul>
    </div>
    <hr class="border border-primary border-3 opacity-75">
    <div class="home-table">
        <h2>Add Category:</h2>
        <form:form action="/products/${product.id}/addCategory" method="post" modelAttribute="category">
            <div class="form-group">
                <form:select path="id" class="form-select">
                    <c:forEach var="categoryItem" items="${unassignedCategories}">
                        <form:option value="${categoryItem.id}">${categoryItem.name}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-primary">Add</button>
            </div>
        </form:form>
    </div>
</div>


<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>