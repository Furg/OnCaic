<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>

<p><a href="/hostings">Hostings</a></p>

<c:if test="${not empty greeting}">
    <h2>Hosting name ${greeting.getName()}</h2>
</c:if>

</body>
</html>
