/**
 * Created by Administrator on 2017/4/21 0021.
 */
var myModule = angular.module("MyModule",[]);
myModule.directive("hello",function () {
    return{
        restrict:'AE',
        scope:{},//独立scope,使得指令之间的数据数据绑定变的独立
        template:'<div><input type="text" ng-model="info"/><span>{{info}}</span></div>',
        replace:true
    }
});