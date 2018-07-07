// 动态组件
<template>
    <div>
        <button @click="currComponet='MyComponent1'">组件一</button>
        <button @click="currComponet='MyComponent2'">组件二</button>
        <component :is="currComponet"></component>
    </div>
</template>

<script>
import MyComponent1 from "./MyComponent3.vue";
import MyComponent2 from "./MyComponent4.vue";
export default {
  components: { MyComponent1, MyComponent2 },
  data() {
    return {
      currComponet: "MyComponent1"
    };
  }
};
</script>
