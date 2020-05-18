<template>
  <v-app id="app">
    <Header />
    <router-view />
  </v-app>
</template>

<script>
import Header from './components/Header'
// import Login from './views/Login.vue'
export default {
  name: 'App',
  components: {
    Header
    // Login
  }
}
</script>
