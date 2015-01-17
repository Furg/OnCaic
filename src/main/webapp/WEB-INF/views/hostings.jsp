<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<body>
<h2>Hostings List</h2>
<ul>
    <c:if test="${not empty hostings}">
        <c:forEach var="hosting" items="${hostings}">
            <li><a href="/hostings/${hosting.getUrlname()}">${hosting.getName()}</a></li>
        </c:forEach>
    </c:if>
</ul>
</body>
</html>