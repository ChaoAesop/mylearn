
var myApp = angular.module('myApp',[]);
myApp.controller('personCtrl',['$scope',function ($scope) {
    $scope.lastname='Jack';
    $scope.names = [
        {name:'Jani',country:'Norway'},
        {name:'Hege',country:'Sweden'},
        {name:'Kai',country:'Denmark'}
    ];
}]);
