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
        html, body {
            width: 100%;
            height: 100%;
            margin: 0;
            padding: 0;
            background-color: #BDC3C7;
        }

        #container {
            position: absolute;
            height: auto;
            bottom: 0;
            top: 0;
            left: 0;
            right: 0;
            margin-top: 1%;
            margin-bottom: 3%;
            margin-left: 5%;
            margin-right: 5%;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 10px 10px 5px #888888;
            overflow:auto;
        }

        #map {
            position: absolute;
            height:50%;
            width:45%;
            top:10%;
            left:45%;
            border-radius: 10px;
        }

        #details {
            position: absolute;
            height:auto;
            top:60%;
            width: 70%;
            margin-left: 10%
        }


        h2 {
            position: fixed;
            background-color: #22313F;
            width: 90%;
            padding-top: 1%;
            padding-bottom: 1%;
            text-align:center;
            margin: 0;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            color: white;
            letter-spacing:10px;
            z-index: 1;
        }

        /* LIST #4 */
        #list4 { position: absolute;
            height:40%;
            overflow-y: scroll;
            width:15%;
            top:10%;
            left:20%; font-family:Georgia, Times, serif; font-size:15px; }
        #list4 ul { list-style: none; }
        #list4 ul li { }
        #list4 ul li a { display:block; text-decoration:none; color:#000000; background-color:#FFFFFF; line-height:30px;
            border-bottom-style:solid; border-bottom-width:1px; border-bottom-color:#CCCCCC; padding-left:10px; cursor:pointer; }
        #list4 ul li a:hover { color:#FFFFFF; background-color: #2908f5;   }
        #list4 ul li a strong { margin-right:10px; }




    </style>
</head>
<body  ng-app="mapsApp" ng-controller="MapCtrl as cont">
    <div id="container">
        <h2>HOSTING FINDER</h2>
        <div id="list4">
            <ul>
                <c:if test="${not empty greetings}">
                    <c:forEach var="greeting" items="${greetings}">
                        <li ng-init="saveHosting(&quot;${greeting.name}&quot;,${greeting.latlong[0]},${greeting.latlong[1]})">
                            <a href="#" id="try" ng-click="setCenter(${greeting.latlong[0]},${greeting.latlong[1]});
                            cont.setDetails(&quot;${greeting.name}&quot;,&quot;${greeting.email}&quot;,&quot;${greeting.tipus}&quot;,&quot;${greeting.web}&quot;,&quot;${greeting.carrer}&quot;,&quot;${greeting.cp}&quot;,&quot;${greeting.municipi}&quot;,&quot;${greeting.comarca}&quot;,&quot;${greeting.provincia}&quot;,&quot;${greeting.telefon}&quot;,&quot;${greeting.nom_t}&quot;,${greeting.latlong[0]},${greeting.latlong[1]})">
                                    ${greeting.name}
                            </a>
                        </li>
                    </c:forEach>
                </c:if>
            </ul>
        </div>
        <div id="map"></div>
        <div id="details" ng-show="cont.selected">
            <h1>{{cont.details.name}}</h1>
            <p>{{cont.details.email}}</p>
            <p>{{cont.details.tipus}}</p>
            <p>{{cont.details.web}}</p>
            <p>{{cont.details.carrer}}</p>
            <p>{{cont.details.cp}}</p>
            <p>{{cont.details.municipi}}</p>
            <p>{{cont.details.comarca}}</p>
            <p>{{cont.details.provincia}}</p>
            <p>{{cont.details.telefon}}</p>
            <p>{{cont.details.nom_t}}</p>
            <p>{{cont.details.latitude}}</p>
            <p>{{cont.details.longitude}}</p>
        </div>
    </div>
</body>
</html>