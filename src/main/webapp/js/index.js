var app = angular.module("cartApp",["ngRoute","controllers"]);

app.config(function($routeProvider) {
	$routeProvider
		.when('/', {
			controller:'CartCtrl',
			templateUrl:'list.html'
		})
		.when('/edit/:itemId', {
			controller:'EditCtrl',
			templateUrl:'detail.html'
		})
		.when('/new', {
			controller:'CreateCtrl',
			templateUrl:'detail.html'
		})
		.otherwise({
			redirectTo:'/'
		});
});

// Controllers
angular.module("controllers",["services"]).
	controller("CartCtrl",["$scope","CartServer", function($scope,CartServer){
		CartServer.getAllItems().then(function(data) {
			$scope.cart = data;
			var item = {};
			var items = [];
			item.id = 1;
			item.name = "Watch";
			item.qty = 2;
			item.price = "20.00";
			items.push(item);
			var item2 = {};
			item2.id = 2;
			item2.name = "Laptop";
			item2.qty = 1;
			item2.price = "1000.00";
			items.push(item2);
			$scope.cart = items;
			
		});
	}]).
	controller("EditCtrl",["$scope","$location","$routeParams","CartServer", function($scope,$location,$routeParams,CartServer){
		
	}]);

//Services
angular.module("services",[]).
	factory("CartServer",["$http", function($http) {
		return {
			getAllItems : function() {
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