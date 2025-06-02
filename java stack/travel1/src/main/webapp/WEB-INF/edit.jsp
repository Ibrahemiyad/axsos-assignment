<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Travel</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

    <h1>Edit Travel</h1>
    <form:form action="/travel/${burger.id}" method="post" modelAttribute="travel">
        <input type="hidden" name="_method" value="put">
        <div>
            <form:label path="name">Expense Name:</form:label>
            <form:input path="name"/>
            <form:errors path="name" cssClass="error"/>
        </div>
        <div>
            <form:label path="vendor">Vendor:</form:label>
            <form:input path="vendor"/>
            <form:errors path="vendor" cssClass="error"/>
        </div>
        <div>
            <form:label path="amount">Amount:</form:label>
            <form:input path="amount" type="number" min="1" max="5"/>
            <form:errors path="amount" cssClass="error"/>
        </div>
        <div>
            <form:label path="description">Description:</form:label>
            <form:textarea path="description" rows="3" cols="20"/>
            <form:errors path="description" cssClass="error"/>
        </div>
        <div>
            <button type="submit">Submit</button>
        </div>
</form:form>
    <a href="/">Back to List</a>
</body>
</html>