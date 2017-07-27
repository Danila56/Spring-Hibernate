<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.07.2017
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Список ролей пользователя ${username.username}<h1>
<table>
    <tr>
        <th>ID</th>
        <th>Role</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${listRole}" var="role">
        <tr>
            <td>${role.id}</td>
            <td>${role.role}</td>
            <td><a href="/role/delete/${role.id}">Delete</a></td>
            <td><a href="/role/update/${role.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
