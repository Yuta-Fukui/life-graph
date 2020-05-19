// import Vue from 'vue'
// import Vuex from 'vuex'
// Vue.use(Vuex)
export default {
  state: {
    contents: [],
    load: false
  },
  mutations: {
    setContents (state, contents) {
      state.contents = contents
    }
  },
  actions: {
    setContents ({ commit }, contents) {
      commit('setContents', contents)
    }
  }
}
