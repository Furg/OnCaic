<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.min.js"></script>
    <script type="text/javascript" src="http://aba8.hol.es/app.js"></script>
    <script type="text/javascript"
            src="http://maps.googleapis.com/maps/api/js?key=AIzaSyD_ogE8QMq_yAcmVIcVWp8oPaq68JEXvxs&sensor=FALSE&v=3.exp">
    </script>
    <style type="text/css">
        #menu {
            position: absolute;
            height:40%;
            width:10%;
            top:10%;
            left:20%;
        }

        #map {
            position: absolute;
            height:50%;
            width:35%;
            top:10%;
            left:45%;
        }

        #details {
            position: absolute;
            height:50%;
            width:35%;
            top:60%;
            left:30%;
        }


        h2 {
            position: absolute;
            left:20%;
        }



    </style>
</head>
<body ng-app="mapsApp" ng-controller="MapCtrl as cont">
    <h2>Hostings List</h2>
        <ul id="menu">
        <c:if test="${not empty greetings}">
            <c:forEach var="greeting" items="${greetings}">
            <li ng-init="saveHosting(&quot;${greeting.name}&quot;,${greeting.latlong[0]},${greeting.latlong[1]})">
                <a href="#" ng-click="setCenter(${greeting.latlong[0]},${greeting.latlong[1]}); cont.setDetails(&quot;${greeting.name}&quot;,&quot;${greeting.email}&quot;,${greeting.latlong[0]},${greeting.latlong[1]})">
                    ${greeting.name}
                </a>
            </li>
            </c:forEach>
        </c:if>
        </ul>
        <div id="map"></div>
        <div id="details" ng-show="cont.selected">
            <h1>{{cont.details.name}}</h1>
            <p>{{cont.details.email}}</p>
            <p>{{cont.details.latitude}}</p>
            <p>{{cont.details.longitude}}</p>

        </div>
</body>
</html>