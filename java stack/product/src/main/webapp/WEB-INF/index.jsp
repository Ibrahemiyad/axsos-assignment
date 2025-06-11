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
        <h1>Home Page</h1>
        <div class="home-navbar">
            <a href="/products/new">New Product</a>
            <a href="/categories/new">New Category</a>
        </div>
        <hr class="border border-primary border-3 opacity-75">
        <div class="home-table">
            <table class="table align-middle table-bordered">
                <thead>
                <tr>
                    <th scope="col" class="text-center">
                        <h2>Products</h2>
                    </th>
                    <th scope="col" class="text-center">
                        <h2>Categories</h2>
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <ul>
                            <c:forEach var = "product" items="${products}">
                                <li><a href="/products/${product.id}">${product.name}</a></li>
                            </c:forEach>
                        </ul>
                    </td>
                    <td>
                        <ul>
                            <c:forEach var = "category" items="${categories}">
                                <li><a href="/categories/${category.id}">${category.name}</a></li>
                            </c:forEach>
                        </ul>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>


    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>
</body>
</html>