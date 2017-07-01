<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.07.2017
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="/user/add" method="get">
    <input type="text" name="id" value="${user.id}">
    <input type="text" name="username" value="${user.username}">
    <input type="text" name="password" value="${user.password}">
    <input type="submit" value="Edit">
</form>
</body>
</html>
