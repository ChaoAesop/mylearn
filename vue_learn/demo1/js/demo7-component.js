
Vue.component('button-counter', {
    template:'<button v-on:click="incrementOne">{{count}}</button>',
    data:function () {
        return {
            count:0
        }
    },
    methods:{
        incrementOne:function () {
            this.count +=1 ;
            this.$emit('addparentcount')//注意：这个自定义事件名称不能有大写
        }
    }
});
Vue.component('click-area', {
    template:'<div style="width:100px;height:100px;background-color:red;color:#fff">点我啊</div>'
});

//创建根实例
var v1 = new Vue({
    el:'#example1',
    data:{
        pcount:0
    },
    methods:{
        reAdd:function () {
            this.pcount += 1;
        },
        showSomthing:function(){
            alert('哈哈哈哈');
        }
    }
});