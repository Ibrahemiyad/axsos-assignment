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
        <c:when test="${not empty travel}">
            <h2><strong>Expense Details</strong></h2>
            <p>Expense Name:: ${travel.name}</p>
            <p>Vendor: ${travel.vendor}</p>
            <p>Amount : ${travel.amount}</p>
            <p>Description: ${travel.description}</p>

        </c:when>
        <c:otherwise>
            <p>No travel details available.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>