var bookStoreApp = angular.module("bookStoreApp",["ngRoute","ngHello"]);

bookStoreApp.config(function($routeProvide){
	$routeProvide.when("/hello",{
		templateUrl:"tpls/hello.html",
		controller:"helloController"
	})
	
});