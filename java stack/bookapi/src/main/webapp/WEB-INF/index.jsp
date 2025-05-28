<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Details</title>
</head>
<body>
    <h1>Book Details</h1>
    <c:choose>
        <c:when test="${not empty book}">
            <h2><strong>${book.title}</strong></h2>
            <p>Description: ${book.description}</p>
            <p>Language: ${book.language}</p>
            <p>Number of Pages: ${book.pages}</p>
        </c:when>
        <c:otherwise>
            <p>No book details available.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>