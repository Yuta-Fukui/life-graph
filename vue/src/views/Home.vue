<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <!-- <Chart id="chart" msg="Welcome to Your Vue.js App" /> -->
    <Vuetify />
  </div>
</template>

<script>
// @ is an alias to /src
// import Chart from '@/chart/Chart.vue'
import Vuetify from 'vuetify'

export default {
  name: 'Home',
  components: {
    // Chart,
    Vuetify
  },

  created () {
    this.$store.dispatch('fetchLogin')
  }
}
</script>

<style scoped>
  /* #chart {
    width: 100px;
    height: 100px;
    margin: 0 auto;
  } */
</style>
