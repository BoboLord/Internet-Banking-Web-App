<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html ng-app="AuthenticationModule" ng-controller="LoginController">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>
 	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>   
    <script src="https://rawgithub.com/gsklee/ngStorage/master/ngStorage.js"></script>

    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/common.css"/>"  rel="stylesheet">

	<script src="<c:url value="/resources/css/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/Authentication.js"/>"></script>

</head>

<body > 

<div class="container">

	<form:form role="form"  modelAttribute="userForm" class="form-signin">
	
        <div class="form-group">
            <input ng-model="email" type="text" class="form-control" placeholder="Email ID"
                   autofocus="true"/>
        </div>           
        <div class="form-group">
            <input ng-model="password" type="password" class="form-control" placeholder="Password"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 		</div>

            <button class="btn btn-lg btn-primary btn-block" href="login()">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        
     </form:form>
</div>
<!-- /container -->

</body>
</html>
