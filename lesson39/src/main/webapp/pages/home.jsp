<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>lesson 39</title>
</head>
<body>

Enter the form for create your film collection!
<form action="/save" method = "post" modelAttribute="film">
    <input type="text" name = "name" placeholder="The film name"><br>
    <input type="text" name = "genre" placeholder="Genre"><br>
    <input type="date" name = "dateOfIssue" placeholder="Date of issue"><br>
    <input type="number" name = "rating" placeholder="Your rating"><br>
    <input type="submit" value="save">
</form>

<br>
${film.name}
<hr>

<ul>
    <c:forEach items="${films}" var="film">
        <li>${film.name}</li>
    </c:forEach>
</ul>
</body>
</html>