<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="../resources/style.css"/>">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" type="text/css" rel="stylesheet" media="screen" />
</head>
<body>
        <h1>Time</h1>
        <hr>
        <form action="/time" method="get">
            <input type="text" class="timing" />
            <input type="submit" value="Add">
        </form>

        <form action="/action" method="get">
            <input type="time" name="time"/>
            <input type="submit" name="add" value="add">
        </form>

        <form:form method="get" modelAttribute="time" action="/action">
            <%--<form:input path="time" type="time" /> <!-- bind to user.name-->--%>
            <%--<form:label path="time">TimeList</form:label>--%>
            <%--<form:checkboxes items="${boxTimeList}" path="time" />--%>

            <form:label path="time">Time</form:label>
            <form:select path="time">
                <form:option value="NONE" label="Select Date"/>
                <form:options items="${downTimeList}"/>
            </form:select><br>

            <input type="submit" name="add" value="add"/>
            <input type="submit" name="delete" value="delete">
            <input type="submit" name="update" value="update">
        </form:form>

    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="<c:url value="../resources/timingfield.js"/>"></script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
        $(".timing").timingfield();
        });
    </script>
</body>
</html>