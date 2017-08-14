<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.08.2017
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/user/add" method="post" modelAttribute="user" commandName="user">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <%--<input type="checkbox" name="username" value="username">--%>
    <input type="text" name="username">
    <input type="password" name="password">

    <%--<select name="roles[0].id">--%>
        <%--<c:forEach items="${listRole}" var="role">--%>
            <%--<option value="${role.id}">--%>
                <%--<c:out value="${role.role}"/>--%>
            <%--</option>--%>
        <%--</c:forEach>--%>
    <%--</select>--%>

    <%--<c:forEach items="${listRole}" var="role">--%>
        <%--<form:checkboxes items="${listRole}" itemLabel="role" itemValue="id" name="roles[0].id"/>--%>
        <input type="checkbox" name="roles[0]" value="1">ROLE_ADMIN<br>
        <input type="checkbox" name="roles[1]" value="2">ROLE_USER<br>
        <input type="checkbox" name="roles[2]" value="3">ROLE_EDITOR
    <%--</c:forEach>--%>

    <%--<c:forEach items="${listRole}" var="role">--%>
        <%--<input type="checkbox" name="roles[0].id" value="${role.id}">${role.role}<br>--%>
    <%--</c:forEach>--%>

    <input type="submit" value="Add">
</form:form>
</body>
</html>