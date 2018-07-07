<template>
    <div>
        <h1>我是父组件</h1>
        <my-component2 :items="items">
            <template slot-scope="props">
                <p>哈哈哈大</p>
                <p>{{props.text}}</p>
                <p>{{props.niubi}}</p>
                <p>{{props.person.name}} {{props.person.age}}岁</p>
            </template>
            <li slot="books" slot-scope="props">{{props.item.name}}</li>
        </my-component2>
    </div>
</template>

<script>
import MyComponent2 from "./MyComponent2.vue";
export default {
  components: { MyComponent2 },
  data() {
    return {
      items: [
        {
          name: "java从入门到精通",
          price: 199
        },
        {
          name: "编程思想",
          price: 888
        }
      ]
    };
  }
};
</script>
