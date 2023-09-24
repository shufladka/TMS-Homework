<%@ page import="java.util.List" %>
<%@ page import="domain.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Homepage</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>

<body> Book library
<hr>
<form action="/home" method="get">
    <input type="submit" value="Показать описание">
</form>
<hr>
<form action="/add" method="post">
    Автор: <input type="text" name="author"><br><br>
    Название: <input type="text" name="title"><br><br>
    Описание: <input type="text" name="description"><br><br>
    Страниц: <input type="number" name="pages"><br><br>
    <input type="submit" value="Добавить">

    <hr>
    <table>
        <colgroup>
            <col span="4" style="background: #FAE3E3">
        </colgroup>
        <thead>
        <tr>
            <th>Автор</th>
            <th>Название</th>
            <th>Описание</th>
            <th>Страниц</th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.books}" var="book">
            <tbody>
            <tr>
                <th scope="row">${book.author}</th>
                <td>${book.title}</td>
                <td>${book.description}</td>
                <td>${book.pages}</td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</form>
</body>
</html>