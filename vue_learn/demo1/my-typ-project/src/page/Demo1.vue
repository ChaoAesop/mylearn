<template>
  <div>
    <h1>父组件标题</h1>
    <my-component1>
      <p slot="header">头头头</p>
      <p>普通内容</p>
      <p>普通内容</p>
      <p slot="footer">脚脚脚</p>
    </my-component1>
  </div>
</template>

<script>
import MyComponent1 from './Mycomponent1.vue';
export default {
  components: {MyComponent1},
  data() {
    return {};
  }
};
</script>
