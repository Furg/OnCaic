<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<body>
<h2>Hostings List</h2>
<ul>
    <c:if test="${not empty greetings}">
        <c:forEach var="greeting" items="${greetings}">
            <li><a href="/hostings/${greeting.getUrlname()}">${greeting.getName()}</a>: ${greeting.getWeb()}</li>
        </c:forEach>
    </c:if>
</ul>
</body>
</html>