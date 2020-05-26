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
    setContents (state, data) {
      state.contents = data
      state.loaded = !state.loaded
    }
  },
  actions: {
    async setContents ({ commit }, userId) {
      const url = 'api/auth/reference/' + userId
      await axios.get(url).then((res) => {
        commit('setContents', res.data)
      })
    },
    updateContents ({ commit }, userId) {
      const url = 'api/auth/reference/' + userId
      axios.get(url).then((res) => {
        commit('setContents', res.data)
      })
    }
  }
}
