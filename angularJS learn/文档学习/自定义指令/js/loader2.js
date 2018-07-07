/**
 * Created by Administrator on 2017/4/20.
 */
var loaderModule = angular.module("loaderModule",[]);

loaderModule.controller("MyCtrl1",["$scope",function ($scope) {
    $scope.loadDataFn1=function () {
        console.log('张三加载中。。。');
    }
}]);
loaderModule.controller("MyCtrl2",["$scope",function ($scope) {
    $scope.loadDataFn2=function () {
        console.log('李四加载中。。。');
    }
}]);

loaderModule.directive("loader",function () {
    return {
        restrict:"AE",
        link:function(scope,element,attrs){
            //为元素绑定事件
            element.bind("mouseenter",function (event) {
                //scope.loadDataFn();

                //获取属性的值，调用controller的方法
                scope.$apply(attrs.howtoload);
            });
        }
    }

});