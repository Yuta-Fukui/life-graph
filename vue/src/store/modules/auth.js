import axios from 'axios'

export default {
  state: {
    token: '',
    userId: ''
  },
  mutations: {
    setLogin (state, data) {
      state.token = data.token
      state.userId = data.id
    },
    delete (state) {
      state.token = ''
      state.userId = ''
    }
  },
  actions: {
    fetchLogin ({ commit }, data) {
      const url = '/api/auth/login'
      axios.post(url, data).then((res) => {
        commit('setLogin', res.data)
      })
    }
  }
}
