import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Vuetify from 'vuetify'
<<<<<<< HEAD
import vuetify from './plugins/vuetify'
=======
// import "vuetify/dist/vuetify.min.css";
>>>>>>> 04b84d9767654233fbca679c8c516501739d0bc6

Vue.config.productionTip = false

new Vue({
  router,
  store,
  Vuetify,
  vuetify,
  render: function (h) { return h(App) }
}).$mount('#app')
