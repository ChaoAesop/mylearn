/**
 * Created by Administrator on 2017/4/21 0021.
 */
var myModule = angular.module("MyModule", []);
myModule.controller('MyCtrl', ['$scope', function($scope){
    $scope.ctrlFlavor="百威";

}]);

myModule.directive("drink", function() {
    return{
        restrict:'AE',
        scope:{
            flavor:'='
        },
        template:'<input ng-model="flavor"/>'
    }
});