<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.07.2017
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="/role/add" method="get">
    <input hidden="true" type="text" name="id" value="${role.id}">
    <input type="text" name="role" value="${role.role}">
    <input type="submit" value="Edit">
</form>
</body>
</html>
