<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en" ng-app="myApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome to NO Bank Internet Banking</title>
 	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>   
	<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <link href="<c:url value="/resources/css/common.css"/>"  rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Page 1</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
    </ul>
  </div>
</nav>
Try it Yourself »
	<div ng-controller="evtController as ctrl">
		<div class="jumbotron">
			
				<h1>Welcome to NO Bank Internet Banking!</h1>
				<p>To get started, you need to press "Register" button to register with
					us. Or login to access your details, if you are already registered.</p>
			<div></div>

			<a class="btn btn-primary" href="registration">Register » </a> 
			<a	class="btn btn-primary" href="login">Login » </a>
			<a	class="btn btn-primary" href="useraccounts">Show Users Spring » </a>
			<a	class="btn btn-primary" href="successful_login">Demo Angular Login » </a>
			
		</div>

		<div></div>
	</div>
	

	<script src="<c:url value="/resources/js/myApp.js"/>"></script>
	<script src="<c:url value="/resources/js/UserCtrl.js"/>"></script>
	<script src="<c:url value="/resources/js/Authentication.js"/>"></script>
	
</body>
<!-- 
<script>
var app = angular.module('myApp',[]);
app.controller('evtController',['$scope','$http',function(){
	var vm = this;
	this.a = 5;
	this.someData = [];
	this.fn = function(){
	$scope.b = 10;
	$http.get('http://localhost:8080/InternetBanking/useraccounts1')
	.then(function(respond){
		vm.someData = rese.data;
	},function(error){
	});
	}
}])
</script> -->
</html>
