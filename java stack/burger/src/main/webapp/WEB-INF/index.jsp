<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Burger Experiences</title>
</head>
<body>
    <h1>Track Your Burger Experiences</h1>
    
    <!-- Display validation errors if any -->
    <c:if test="${not empty org.springframework.validation.BindingResult.burger}">
        <div style="color:red;">
            <ul>
                <form:errors path="*" element="li"/>
            </ul>
        </div>
    </c:if>
    
    <!-- Burger input form -->
    <form:form method="post" action="/add" modelAttribute="burger">

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
                    <button type="submit">Add Burger</button>
                </div>
    </form:form>
    
    <hr/>
    
    <!-- Display list of burgers -->
    <h2>My Burger List</h2>
    <c:if test="${not empty burgers}">
        <table border="1" cellpadding="5" cellspacing="0">
            <tr>
                <th>Burger Name</th>
                <th>Restaurant</th>
                <th>Rating</th>
                <th>Actions</th>
                
            </tr>
            <c:forEach var="burger" items="${burgers}">
                <tr>
                    <td>${burger.name}</td>
                    <td>${burger.restaurant}</td>
                    <td>${burger.rating}</td>
                    <td><a href="/edit/${burger.id}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty burgers}">
        <p>No burger experiences recorded yet.</p>
    </c:if>
</body>
</html>
