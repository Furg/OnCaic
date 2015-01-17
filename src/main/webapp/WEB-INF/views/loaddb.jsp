<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Database up to date</title>
</head>
<body>
    <c:if test="${empty hostings}">
        <h1>Empty Database</h1>
    </c:if>
    <c:if test="${not empty hostings}">
        <h1>Database up to date</h1>
    </c:if>

</body>
</html>
