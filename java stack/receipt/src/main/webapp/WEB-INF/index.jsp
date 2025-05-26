<!DOCTYPE html>
<html lang="en">
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <head>
    <meta charset="UTF-8" />
    <title>Purchase Receipt</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
    <h2>Purchase Receipt</h2>
    <p>Customer: <c:out value="${name}"/></p>
    <p>Item: <c:out value="${itemName}"/></p>
    <p>Description: <c:out value="${description}"/></p>
    <p>Vendor: <c:out value="${vendor}"/></p>
    <p>Price: $<c:out value="${price}"/></p>
</body>
</html>
