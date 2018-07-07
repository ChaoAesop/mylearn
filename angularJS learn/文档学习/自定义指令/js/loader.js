/**
 * Created by Administrator on 2017/4/20.
 */
var loaderModule = angular.module("loaderModule",[]);

loaderModule.controller("MyCtrl",["$scope",function ($scope) {
    $scope.loadDataFn=function () {
        console.log('加载中。。。');
    }
}]);
loaderModule.directive("loader",function () {
    return {
        restrict:"AE",
        link:function(scope,element,attrs){
            //为元素绑定事件
            element.bind("mouseenter",function () {
                //调用域范围内的控制器中的方法
                scope.loadDataFn();
            });
        }
    }

});