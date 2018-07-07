/**
 * css与Style绑定
 */
var app1= new Vue({
    el:'#app-1',
    data:{
        isActive:true,
        isError:true,
        error:{},
        activeColor: 'red',
        fontSize: 30,
        classObj:{
            active:true,
            'is-error':true
        }
    },
    computed: {
        classCondition: function () {
            return {
                active: this.isActive && !this.error,
                'text-danger': this.error && this.error.type === 'fatal'
            }
        }
    }
});