<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login Successful!</title>
 	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>   

    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/common.css"/>"  rel="stylesheet">

	 <script src="<c:url value="/resources/js/Authentication.js"/>"></script>
<!--
<script>

var app = angular.module('AuthenticationModule', []);

app.controller("LoginController", function($scope, $rootScope, $http) {
		
			var dataObj = {
					"email" : "1",
					"password" : "1",
			};		
			
			var response = $http.post('authentication', dataObj);
			response.success(function(data, status, headers, config) {
				$rootScope.email = data.email;
				$rootScope.password = data.password;
				$rootScope.firstname = data.firstname;
				$rootScope.phone = data.phone;
				$rootScope.DOB = data.DOB;
				
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
			//
		//	$scope.login = function(){
		//		 $location.path("successful_login");
		//		}
			
});
</script>
-->
</head>

<body > 
	<h1>Successfully Logged in!</h1>

	<div ng-app="AuthenticationModule" ng-controller="LoginController">
		<h4>Profile: </h4>
		<p>Email: {{$root.email}}</p>		
		<p>Password: {{$root.password}}</p>		
		<p>First Name: {{$root.firstname}}</p>		
		<p>Phone: {{$root.phone}}</p>	
		<p>DOB: {{$root.DOB}}</p>		
	</div>

</body>
</html>
