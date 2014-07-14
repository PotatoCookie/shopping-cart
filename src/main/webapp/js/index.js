var app = angular.module("cartApp",["controllers"]);

// Controllers
angular.module("controllers",["services"]).
controller("CartCtrl",["$scope","CartServer", function($scope,CartServer){
	CartServer.getItem().then(function(data) {
		$scope.value = data; 
	});
}]);

//Services
angular.module("services",[]).
	factory("CartServer",["$http", function($http) {
		return {
			getItem : function() {
				return $http({method:"GET", url:"api/cart/get",
					cache : false}).
				then(function(response) {
					return response.data;
				}, function(error) {
					console.log("Error occured while fetching items !");
				});
			}
		};
	}]);