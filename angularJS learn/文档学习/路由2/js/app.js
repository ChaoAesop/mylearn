/**
 * Created by Administrator on 2017/4/20 0020.
 */
angular.module("routingDemoApp",["ngRoute"]).controller("helloController",function ($scope) {
    $scope.myname = "张杰";
}).controller("namesController",function ($scope) {
    $scope.names=["role","json","make"];
}).config(["$routeProvider",function($routeProvider){
    $routeProvider.when("/",{
        template:"这是首页页面"
    }).when("/computers",{
        template:"这是电脑分类页面"
    }).when("/printers",{
        template:"这是打印机页面"
    }).when("/hello",{
        templateUrl:"tpls/hello.html"
    }).when("/sayHello",{
        templateUrl:"tpls/sayHello.html",
        controller:"helloController"
    }).when("/showAll",{
        templateUrl:"tpls/all.html",
        controller:"namesController"
    }).otherwise({
        redirectTo:"/"
    })
}]);
