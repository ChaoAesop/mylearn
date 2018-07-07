/**
 * Created by Administrator on 2018/2/4.
 */
//1.注册全局组件
Vue.component("my-component", {
    template:'<div>A customer component</div>'
});
Vue.component('simple-counter', {
    template: '<button v-on:click="count += 1">{{count}}</button>',
    //组件内使用data，data必须是一个函数
    data:function () {
        return {
            count:0
        }
    }
});
Vue.component('child', {
    //声明子组件预期的数据，这是单向绑定的
    props:['message','myLove', 'number'],
    template:'<span>{{message}} - {{myLove}} x {{number}}</span>'
});
Vue.component('complex-counter', {
    props:['size'],
    template:'<span>10倍结果：{{calcSize}}</span>',
    computed:{
        calcSize:function () {
            return this.size*10;
        }
    }
});
Vue.component('my-form', {
    props:{
        propA:{
            type:Number,
            required:true
        }
    },
    template:'<span>{{propA}}</span>',

});

var child = {
    template:'<div>child component</div>'
}
//创建根实例
var v1 = new Vue({
    el:'#component1',
    data:{
        inLove:'',
        todo:{
            message:'大哥',
            myLove:'鱼头'
        }
    },
    //2.局部组件
    components:{
        'child-component':child
    }
});