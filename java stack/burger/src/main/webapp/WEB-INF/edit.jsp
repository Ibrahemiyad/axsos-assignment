<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Burger</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

    <h1>Edit Burger</h1>
    <form:form action="/burger/${burger.id}" method="post" modelAttribute="burger">
        <input type="hidden" name="_method" value="put">
        <div>
            <form:label path="name">Burger Name:</form:label>
            <form:input path="name"/>
            <form:errors path="name" cssClass="error"/>
        </div>
        <div>
            <form:label path="restaurant">Restaurant:</form:label>
            <form:input path="restaurant"/>
            <form:errors path="restaurant" cssClass="error"/>
        </div>
        <div>
            <form:label path="rating">Rating (1-5):</form:label>
            <form:input path="rating" type="number" min="1" max="5"/>
            <form:errors path="rating" cssClass="error"/>
        </div>
        <div>
            <form:label path="notes">Notes:</form:label>
            <form:textarea path="notes" rows="3" cols="20"/>
            <form:errors path="notes" cssClass="error"/>
        </div>
        <div>
            <button type="submit"> Update</button>
        </div>
</form:form>
    </body>
</html>