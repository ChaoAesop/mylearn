/**
 * Created by Administrator on 2017/7/3.
 */
var noteApp = angular.module('myNoteApp',[]);

noteApp.controller('myNoteCtrl',function ($scope) {
    $scope.message='';
    $scope.scopeFlag=false;
    var max=100;

    $scope.clear=function () {
        $scope.message='';
    }
    $scope.save=function () {
        alert('笔记已保存');
    }

    $scope.left=function () {
        return max-$scope.message.length;
    }

    $scope.check=function () {
        //键盘放开事件，如果输入的字符大于最大值，则，截取0到最大值的内容
        if($scope.message.length>max){
            $scope.message = $scope.message.substring(0,max);
        }

    }

});
