import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Demo1 from './../page/Demo1.vue'
import Demo2 from './../page/Demo2.vue'
import Demo3 from './../page/Demo3.vue'

Vue.use(Router)

export default new Router({
  routes: [{
    path: '/',
    name: 'HelloWorld',
    component: HelloWorld
  }, {
    path: '/Demo1',
    component: Demo1,
    name: '实例一'
  },{
    path: '/Demo2',
    component: Demo2,
    name: '实例二'
  },{
    path: '/Demo3',
    component: Demo3
  }]
})
