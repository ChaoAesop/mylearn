<template>
    <div>
        <main class="main-panel">
            ----默认插槽begin----
            <slot text="im from son" niubi="123" :person="sonObj"></slot> 
            ----默认插槽end-----
            <slot name="books" v-for="item in items" :item="item"></slot>
        </main>
    </div>
</template>

<script>
export default {
  props: ['items'],
  data() {
    return {
      sonObj: {
        name: "广东仔",
        age: 25
      },
    };
  }
};
</script>

<style>
.main-panel {
  background-color: yellowgreen;
  width: 400px;
  margin: 0 auto;
}
</style>
