import axios from 'axios'

export default {
  state: {
    token: ''
  },
  mutations: {
    setLogin (state, data) {
      state.token = data.token
    }
  },
  actions: {
    fetchLogin ({ commit }, data) {
      const url = '/api/auth/signin'
      axios.post(url, data).then((res) => {
        commit('setLogin', res.data)
      })
    }
  }
}
