<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.07.2017
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/add" method="get">
    <input type="text" name="username" placeholder="Введите имя пользователя" size="35">
    <input type="password" name="password" placeholder="Введите пароль">
    <input type="submit" value="Add User">
</form>
<form action="/role/add">
    <input type="text" name="role" placeholder="Введите новую роль">
    <input type="submit" value="Add Role">
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Password</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${listUser}" var="listUser">
        <tr>
            <td>${listUser.id}</td>
            <td><a href="/user/roles/${listUser.id}">${listUser.username}</a></td>
            <td>${listUser.password}</td>
            <td><a href="/user/delete/${listUser.id}">Delete</a></td>
            <td><a href="/user/update/${listUser.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>

<table>
    <tr>
        <th>ID</th>
        <th>Role</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${listRole}" var="listRole">
        <tr>
            <td>${listRole.id}</td>
            <td><a href="/role/users/${listRole.id}">${listRole.role}</a></td>
            <td><a href="/role/delete/${listRole.id}">Delete</a></td>
            <td><a href="/role/update/${listRole.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
