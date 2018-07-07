<template>
  <div id="app">
    <img src="./assets/logo.png">
    <HelloWorld/>
    <hr>
    <MyVue/>
    <hr>
    <Demo1Layout/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld'
import MyVue from './components/MyVue.vue'
import Demo1Layout from './components/demo1-layout.vue'

export default {
  name: 'App',
  components: {
    HelloWorld,
    MyVue,
    Demo1Layout
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
