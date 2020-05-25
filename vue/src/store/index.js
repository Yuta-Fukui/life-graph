import Vue from 'vue'
import Vuex from 'vuex'
import auth from './modules/auth.js'
import chart from './modules/chart.js'
import account from './modules/account.js'
import refUser from './modules/refUser.js'

// import axios from 'axios'
Vue.use(Vuex)
export default new Vuex.Store({
  modules: {
    auth,
    chart,
    account,
    refUser
  }
})
