<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>New Dojo</title>
</head>
<body>
    <h1>Create a New Dojo</h1>
    <form action="/dojos" method="POST" modelattribute="dojo">
        Name: <input type="text" name="name" />
        <button type="submit">Create Dojo</button>
    </form>
</body>
</html>
