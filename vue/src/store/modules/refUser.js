// import Vue from 'vue'
// import Vuex from 'vuex'
import axios from 'axios'
// Vue.use(Vuex)

export default {
  state: {
    contents: [],
    loaded: false
  },
  mutations: {
    usersContents (state, data) {
      state.contents = data
      state.loaded = !state.loaded
    },
    resetContents (state) {
      state.contents = []
      state.loaded = !state.loaded
    }
  },
  actions: {
    async usersContents ({ commit }, userId) {
      const url = '/api/auth/reference/' + userId
      await axios.get(url).then((res) => {
        commit('usersContents', res.data)
      })
    }
  }
}
