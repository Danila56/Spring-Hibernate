<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/update" method="get">
    <input type="text" name="id" value="${time.id}">
    <input type="time" name="time" value="${time.time}">
    <input type="submit" value="Update">
</form>

</body>
</html>
