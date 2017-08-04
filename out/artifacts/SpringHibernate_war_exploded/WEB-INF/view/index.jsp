<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Database</title>
    <%--<link rel="stylesheet" type="text/css" href="<c:url value="../resources/bootstrap.min.css"/>">--%>
    <%--<link rel="stylesheet" type="text/css" href="<c:url value="../resources/bootstrap-theme.min.css"/>">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="../../resources/style.css"/>">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
</head>
<body>
<table width="100%" border="1">
    <tr>
        <td height="50">
            <form:form action="/user/add" method="get" modelAttribute="roles">
                <input path="username" type="text" name="username" placeholder="Введите имя пользователя" size="30">
                <input path="password" type="password" name="password" placeholder="Введите пароль">

                <form:label path="role">Role</form:label>
                <form:select path="role">
                    <form:option value="NONE" label="Select Role"/>
                    <form:options items="${downRoleList}"/>
                </form:select>

                <input type="submit" value="Add User">
            </form:form>
        </td>

        <td>
            <form action="/role/add">
                <input type="text" name="role" placeholder="Введите новую роль">
                <input type="submit" value="Add Role">
            </form>
        </td>
    </tr>
    <tr>
        <td width="50%">
            <table id="example" class="display" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listUser}" var="listUser">
                    <tr>
                        <td>${listUser.id}</td>
                        <td><a href="/user/roles/${listUser.id}">${listUser.username}</a></td>
                        <td>${listUser.password}</td>
                        <td><a href="/user/delete/${listUser.id}">Delete</a></td>
                        <td><a href="/user/update/${listUser.id}">Edit</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </td>

        <td width="50%">
            <table id="example2" class="display" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Role</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listRole}" var="listRole">
                    <tr>
                        <td>${listRole.id}</td>
                        <td><a href="/role/users/${listRole.id}">${listRole.role}</a></td>
                        <td><sec:authorize access="hasRole('ROLE_ADMIN')"><a href="/role/delete/${listRole.id}">Delete</a></sec:authorize></td>
                        <td><a href="/role/update/${listRole.id}">Edit</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </td>
    </tr>
</table>

<script>
    $(function(){
        $("#example").dataTable();
    });
</script>
<script>
    $(function(){
        $("#example2").dataTable();
    });
</script>
</body>
</html>
