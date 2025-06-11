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
    <h1>${category.name}</h1>
    <div class="home-navbar">
        <a href="/">home</a>
    </div>
    <hr class="border border-primary border-3 opacity-75">
    <div class="home-table">
        <h2>Products:</h2>
        <ul>
            <c:forEach var="product" items="${category.products}" >
                <li>${product.name}</li>
            </c:forEach>
        </ul>
    </div>
    <hr class="border border-primary border-3 opacity-75">
    <div class="home-table">
        <h2>Add Product:</h2>
        <form:form action="/categories/${category.id}/addProduct" method="post" modelAttribute="product">
            <div class="form-group">
                <form:select path="id" class="form-select">
                    <c:forEach var="productItem" items="${unassignedProducts}">
                        <form:option value="${productItem.id}">${productItem.name}</form:option>
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