Vue.component('currency-input', {
    props:['value'],
    template:'<input type="text" ' +
    'v-bind:value="value" ' +
    'v-on:input="updateValue($event.target.value)"'+
    '/>',
    methods:{
        updateValue:function (value) {
            this.$emit('input', value);
        }
    }
});

//创建根实例
var v1 = new Vue({
    el:'#example1',
    data:{
        currency:'666',
    },
});