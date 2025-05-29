<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<link rel="stylesheet" type="text/css" href="/css/style.css" />

<h1>All Books</h1>
<table class="styled-table">
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td><a href="/details/${book.id}">${book.title}</a></td>
                <td>${book.language}</td>
                <td>${book.pages}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
