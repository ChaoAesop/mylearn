/**
 * Created by Administrator on 2017/4/20 0020.
 */
var NgControoler = angular.module("ngController",[]);
NgControoler.controller("helloController",function ($scope) {
    $scope.myname = "张杰";
});
NgControoler.controller("namesController",function ($scope) {
    $scope.names=["role","json","make"];
});