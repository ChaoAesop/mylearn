/**
 * Created by Administrator on 2018/1/18.
 */
/*
    组件
 */
Vue.component('todo-item',{
    props:['todo'],
    template:'<li> {{todo.text}} </li>'
})

var app1 = new Vue({
    el:'#app1',
    data:{
        msg:'Hello Vue.js!',
        groceryList:[
            { id: 0, text: '蔬菜' },
            { id: 1, text: '奶酪' },
            { id: 2, text: '随便其它什么人吃的东西' }
        ],
        rawHtml:'<em style="color:red">这是红色的字</em>',
        dynamicId:'divid',
        isButtonDisabled:true,
        doSomething:function(){
            console.info(111);
        },
        onSumbit:function(){
            alert('提交表单');
        }

    },
    computed:{
        // 计算属性的 getter
        /*
         当 app1.msg 发生改变时，所有依赖 app1.reversedMessage 的绑定也会更新。
         反之，app.msg不改变时，第二次的访问会直接返回缓存好的值
         */
        reversedMessage:function(){
            return this.msg.split('').reverse().join('');
        }
    },
    methods:{
        reversedMessage2: function () {
            return this.msg.split('').reverse().join('')
        }
    }
})

/*实例生命周期例子*/
new Vue({
    data:{
        a:1
    },
    created:function () {
        console.info('a is '+this.a);// a=>1
    }
});
