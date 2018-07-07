
var myApp = angular.module('myApp',[]);
myApp.controller('myCtrl',['$scope',function ($scope) {
    $scope.msg = 'abcde';
}]);
myApp.filter('reverser',function () {//可以注入依赖
    return function (text) {
        return text.split('').reverse().join('');
    }
});