var NgHello = angular.module("ngHello",[]);
NgHello.controller("helloController",["$scope",function($scope){
	$scope.world = "xiaoming";
}]);