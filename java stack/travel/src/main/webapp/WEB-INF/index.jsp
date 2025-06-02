<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Travel</title>
</head>
<body>
    <h1>Add an Expense</h1>
    
    <!-- Display validation errors if any -->
    <c:if test="${not empty org.springframework.validation.BindingResult.burger}">
        <div style="color:red;">
            <ul>
                <form:errors path="*" element="li"/>
            </ul>
        </div>
    </c:if>
    
    <!-- Burger input form -->
    <form:form method="post" action="/add" modelAttribute="travel">

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
    
    <hr/>
    
    <!-- Display list of burgers -->
    <h2>Save Travels</h2>
    <c:if test="${not empty burgers}">
        <table border="1" cellpadding="5" cellspacing="0">
            <tr>
                <th>Expense</th>
                <th>Vendor</th>
                <th>Amount</th>
                <th>Actions</th>
                
            </tr>
            <c:forEach var="travel" items="${travels}">
                <tr>
                    <td>${travel.name}</td>
                    <td>${travel.restaurant}</td>
                    <td>${travel.rating}</td>
                    <td><a href="/edit/${travel.id}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty travels}">
        <p>No burger experiences recorded yet.</p>
    </c:if>
</body>
</html>
