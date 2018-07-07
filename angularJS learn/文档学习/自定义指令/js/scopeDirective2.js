/**
 * Created by Administrator on 2017/4/21 0021.
 */
var myModule = angular.module("MyModule", []);
myModule.controller('MyCtrl', ['$scope', function($scope){
    $scope.ctrlFlavor="百威";
}])

myModule.directive("drink",function () {
    return{
        restrict:'AE',
        scope:{
            flavor:'@'
        },
        template:"<div>{{flavor}}</div>",//获取控制器的值

       /* link:function (scope,element,attrs) {
            //为scope关联到控制器，即为控制器设置了值
            scope.flavor=attrs.flavor;
        }*/
    }
});