
angular.module("CssModule",[]).controller("CssController",["$scope",function($scope){
    $scope.color='red';
    $scope.changeBg=function(){
        $scope.color='green';
    }
}])