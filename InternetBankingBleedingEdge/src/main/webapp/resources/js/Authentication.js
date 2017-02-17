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
			$scope.login = function(){
				 $location.path('/successful_login');
				}
			
});
