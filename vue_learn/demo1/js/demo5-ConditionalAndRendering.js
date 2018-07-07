/**
 * Created by Administrator on 2018/1/17.
 */
var app1=new Vue({
    el:'#app-1',
    data:{
        ok:true
    }
})
var app2=new Vue({
    el:'#app-2',
    data:{
        loginType:'username'
    },
    methods:{
        toggleBtn:function(){
            if(this.loginType=='username'){
                this.loginType = 'aaa'
            }else{
                this.loginType = 'username'
            }
        }
    }
});

var app3=new Vue({
    el:'#app-3',
    data:{
        price:'',
        items:[
            {bookName:'java从入门到精通', price:332},
            {bookName:'c#从入门到精通', price:332},
            {bookName:'activiti权威指南', price:50},
            {bookName:'springmvc 框架技术', price:699},
            {bookName:'c++从入门到精通', price:400},
        ]
    },
    methods:{
        filterItem:function(){
            this.items = this.items.filter(function(item){
                // return item.bookName.match("从入门到精通");
                if(item.price>=400){
                    return item;
                }
            });
        },
        changeValue:function(){
            /*//更新第一本书的价格*/

            //更新方式一：
            this.items[0].price=this.price;

            //更新方式二：
            // var value = {bookName:this.items[0].bookName, price:this.price};
            // Vue.set(this.items, 0, value);
        }

    }
});

var app4=new Vue({
    el:'#app-4',
    data:{
        yes:false,
        a:111,
        b:{
            name:'老狗'
        }
    },
    methods:{
        addMethods:function(){
            this.yes=true;

            //新添加的属性不是响应式的
            // this.b.age=23;

            //需要这样绑定新属性
            Vue.set(this.b, 'age', 23)
            //可用别名：Vue.$set(....)
        }
    }
});

var app5=new Vue({
    el:'#app-5',
    data:{
        numbers:[1,2,3,4,5,6]
    },
    computed:{
        evenNumbers:function(){
            return this.numbers.filter(function(n){
                return n%2===0;
            });
        }
    }
});