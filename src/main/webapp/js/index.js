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
			$scope.cart = [];
			CartServer.get(1).then(function(data) {
				$scope.cart.push(data);
			});
			/*var item = {};
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
			$scope.cart = items;*/
			
		});
	}]).
	controller("EditCtrl",["$scope","$location","$routeParams","CartServer", function($scope,$location,$routeParams,CartServer){
		CartServer.get($routeParams.itemId).then(function(data) {
			$scope.item = data;
		});
		$scope.save = function() {
				CartServer.update($scope.item).then(function(data) {
				$location.path("/");
			});
		};
	}]).
	controller("CreateCtrl",["$scope","$location","CartServer", function($scope,$location,CartServer){
		$scope.save = function() {
			CartServer.add($scope.item).then(function(data) {
				$location.path("/");
			});
		};
	}]);

//Services
angular.module("services",[]).
	factory("CartServer",["$http", function($http) {
		return {
			getAllItems : function() {
				return $http({method:"GET", url:"api/cart/getAll",
					cache : false}).
				then(function(response) {
					return response.data;
				}, function(error) {
					console.log("Error occured while fetching items!");
				});
			},
			get : function(itemId) {
				return $http({method:"GET", url:"api/cart/get/"+itemId,
					cache : false}).
				then(function(response) {
					return response.data;
				}, function(error) {
					console.log("Error occured while fetching item!");
				});
			},
			update : function(item) {
				return $http({method:"PUT", url:"api/cart/updateItem",
					cache : false}).
				then(function(response) {
					return response.data;
				}, function(error) {
					console.log("Error occured while updating item!");
				});
			},
			add : function(item) {
				return $http({method:"POST", url:"api/cart/addItem",
					data : item, cache : false}).
				then(function(response) {
					return response.data;
				}, function(error) {
					console.log("Error occured while adding item!");
				});
			}
		};
	}]);