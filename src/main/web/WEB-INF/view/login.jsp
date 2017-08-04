<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.08.2017
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="Login">
</form>
${error}
</body>
</html>
