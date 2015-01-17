<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>

<p><a href="/hostings">Hostings</a></p>

<c:if test="${not empty hosting}">
    <h2>${hosting.getName()}</h2>
    <p><strong>Type: </strong>${hosting.getType()}</p>
    <p><strong>Email: </strong>${hosting.getEmail()}</p>
    <p><strong>Web: </strong>${hosting.getWeb()}</p>
    <p><strong>Province: </strong>${hosting.getProvince()}</p>
    <p><strong>Region: </strong>${hosting.getRegion()}</p>
    <p><strong>City: </strong>${hosting.getCity()}</p>
    <p><strong>Postal Code: </strong>${hosting.getPostalcode()}</p>
    <p><strong>Street: </strong>${hosting.getStreet()}</p>
    <p><strong>Phone Number: </strong>${hosting.getPhonenumber()}</p>
    <p><strong>Owner: </strong>${hosting.getOwner()}</p>
    <p><strong>Latitude: </strong>${hosting.getLatitude()}</p>
    <p><strong>Longitude: </strong>${hosting.getLongitude()}</p>

</c:if>

</body>
</html>
