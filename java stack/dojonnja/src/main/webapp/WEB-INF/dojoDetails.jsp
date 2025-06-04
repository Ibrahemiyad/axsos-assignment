<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Dojo Details</title>
</head>
<body>
    <h1>${dojo.name}</h1>
    <table border="1">
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <c:forEach var="ninja" items="${dojo.ninjas}">
            <tr>
                <td>${ninja.firstName}</td>
                <td>${ninja.lastName}</td>
                <td>${ninja.age}</td>
            </tr>
        </c:forEach>
</body>
</html>
