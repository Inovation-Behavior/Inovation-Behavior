<template>
  <div style="display: flex; justify-content: center;width: 100%;">
    <div style="padding: 20px;width: 100%; max-width: 1600px;">
      <TopNav style="width: 100%;"></TopNav>
      <div style="width: 100%;">
        <router-view></router-view>
      </div>
    </div>
  </div>
  <el-backtop :right="100" :bottom="100" />
</template>


<script setup>
import TopNav from './components/TopNav.vue';
</script>

<style>
body {
  font-family: Arial, sans-serif;
}
</style>
