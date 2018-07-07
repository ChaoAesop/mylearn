<template>
    <div>
        <h2 style="color:blue">我是子组件</h2>
        <header class="header-panel">
            <slot name="header"></slot>
        </header>

        <main class="main-panel">
            <slot>
                <span style="color:blue"> 默认内容 </span>
            </slot>
        </main>

        <footer class="footer-panel">
            <slot name="footer"></slot>
        </footer>
    </div>
</template>

<style>
.header-panel {
  background-color: thistle;
  height: 100px;
  width: 400px;
  margin: 0 auto;
}
.main-panel {
  background-color: yellowgreen;
  height: 100px;
  width: 400px;
  margin: 0 auto;
}
.footer-panel {
  background-color:tomato;
  height: 100px;
  width: 400px;
  margin: 0 auto;
}
</style>
