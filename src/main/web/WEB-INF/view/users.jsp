<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.07.2017
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Список пользователей с ролью ${role2.role}
<table>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Password</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${listUser}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td><a href="/user/delete/${user.id}">Delete</a></td>
            <td><a href="/user/update/${user.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
