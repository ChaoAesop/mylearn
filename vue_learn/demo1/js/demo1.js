/**
 * Created by Administrator on 2018/1/17.
 */
var app=new Vue({
    el:'#app',
    data:{
        message:'Hello Vue!'
    }
});
var app2=new Vue({
    el:'#app-2',
    data:{
        message:'页面加载于' + new Date().toLocaleString()
    }
});
var app3 = new Vue({
    el:'#app-3',
    data:{
        seen:true
    }
});
var app4 = new Vue({
    el:'#app-4',
    data:{
        books:[
            {text:'java从入门到精通'},
            {text:'学习vue.js'},
            {text:'大数据时代'}
        ]
    }
})
var app5 = new Vue({
    el:'#app-5',
    data : {
        message:'Hello Vue.js!'
    },
    methods : {
        reverseMessage:function () {
            this.message = this.message.split('').reverse().join('')
        }
    }
})
var app6 = new Vue({
    el:'#app-6',
    data : {
        message:''
    },
})

var app7 = new Vue({
    el:'#app-7',
    data : {
        message:''
    },
})
