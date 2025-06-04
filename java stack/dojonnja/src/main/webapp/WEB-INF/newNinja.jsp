<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>New Ninja</title>
</head>
<body>
    <h1>Create a New Ninja</h1>

    <form:form action="/ninjas" method="post" modelAttribute="ninja">
        
        <p>
            <form:label path="firstName">First Name:</form:label>
            <form:input path="firstName" />
            <form:errors path="firstName" cssClass="error"/>
        </p>

        <p>
            <form:label path="lastName">Last Name:</form:label>
            <form:input path="lastName" />
            <form:errors path="lastName" cssClass="error"/>
        </p>

        <p>
            <form:label path="age">Age:</form:label>
            <form:input path="age" type="number" />
            <form:errors path="age" cssClass="error"/>
        </p>

        <p>
            <form:label path="dojo">Dojo:</form:label>
            <form:select path="dojo.id">
                <form:options items="${dojos}" itemValue="id" itemLabel="name" />
            </form:select>
            <form:errors path="dojo" cssClass="error"/>
        </p>

        <button type="submit">Create Ninja</button>
    </form:form>

</body>
</html>
