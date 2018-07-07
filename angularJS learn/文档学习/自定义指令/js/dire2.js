
var myModule2 = angular.module("MyModule2",[]);
myModule2.run(function($templateCache){
    //定义一个全局的模板
    $templateCache.put("hello.html","<div>hello my cache!!!</div>");
})
myModule2.directive("hello",function($templateCache){
    return {
        restrict:'AEMC', // 匹配模式 A:属性 E：元素 M:注释 C:Class
        template:$templateCache.get("hello.html"),//使用全局的模板
        replace:true
    }
});

/*不替换dom原有的内容*/
myModule2.directive("info",function () {
    return {
        restrict:'AE',
        transclude:true,
        template:"<div>hello my dear!!<div ng-transclude></div></div>"
    }
})