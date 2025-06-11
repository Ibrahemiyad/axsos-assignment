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
    <h1>New Category</h1>
    <div class="home-navbar">
        <a href="/">home</a>
    </div>
    <hr class="border border-primary border-3 opacity-75">
    <div class="home-table">
        <table class="table align-middle table-bordered">
            <tbody>
            <form:form action="/addNewCategory" method="post" modelAttribute="newCategory">
                <tr>
                    <td>
                        <h2>
                            <form:label path="name" for="name" class="form-label">Name:</form:label>
                        </h2>
                    </td>
                    <td>
                        <div class="mb-3">
                            <form:input path="name" type="text" class="form-control" id="name" />
                            <form:errors path="name" cssClass="error-message" />
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="text-center">
                        <div class="mb-3">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </td>
                </tr>
            </form:form>
            </tbody>
        </table>
    </div>
</div>


<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>