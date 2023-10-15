<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    Add new car
    <form action="/home" method="post">
        <br>
        <input type="text" name="model" placeholder="car model"><br>
        <input type="text" name="condition" placeholder="condition"><br>
        <input type="number" name="age" placeholder="age"><br><br>
        <input type="submit" value="Add to database">
    </form>
</body>
</html>
