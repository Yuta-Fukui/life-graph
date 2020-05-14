<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
      <div class="d-flex align-center">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
          transition="scale-transition"
          width="40"
        />

        <v-img
          alt="Vuetify Name"
          class="shrink mt-1 hidden-sm-and-down"
          contain
          min-width="100"
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-name-dark.png"
          width="100"
        />
      </div>

      <v-spacer />

      <v-btn
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
        text
      >
        <span class="mr-2">Latest Release</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
    </v-app-bar>

    <v-content>
      <router-view />
      <router-link to="/top">
        ログイン後のTop画面
      </router-link>
      <router-link to="/top2">
        ログイン前のTop画面
      </router-link>
      <router-link to="/reference">
        参照
      </router-link>
      <!-- <Top />
      <Top2 />
      <Chart />
      <New />
      <Login />
      <Reference /> -->
    </v-content>
  </v-app>
</template>

<script>
// import Login from './views/Login.vue'

// export default {
//   name: 'App',

//   components: {
//     Login,
//     },
//   data: () => ({
//
//   })
// }
</script>
