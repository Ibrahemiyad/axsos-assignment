<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Ninja Gold Game</title>
</head>
<body>
    <h1>Ninja Gold Game</h1>
    <p>Your Gold: <span th:text="${gold}"></span></p>

    <form action="#" method="post">
        <button type="submit">Find Gold (Farm)</button>
    </form>

    <form action="#" method="post">
        <button type="submit">Find Gold (Cave)</button>
    </form>

    <form action="#" method="post">
        <button type="submit">Find Gold (House)</button>
    </form>

    <form action="#" method="post">
        <button type="submit">Find Gold (Quest)</button>
    </form>

    <form action="#" method="post">
        <button type="submit">Reset</button>
    </form>

    <h2>Activities:</h2>
    <ul>
        <li th:each="activity : ${activities}" th:text="${activity}"></li>
    </ul>
</body>
</html>
