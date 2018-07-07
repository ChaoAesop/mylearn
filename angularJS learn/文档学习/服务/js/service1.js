
var myApp = angular.module('myApp',[]);
myApp.controller('timeCtrl',function ($scope,$timeout,$interval) {
    $scope.myHeader = 'Hello world!';

    /*2秒后执行*/
    $timeout(function () {
        $scope.myHeader = 'How are you today?';
    },2000);

    /*每一秒显示*/
    $scope.theTime = new Date().toLocaleTimeString();
    $interval(function () {
        $scope.theTime = new Date().toLocaleTimeString();
    }, 1000);
});
