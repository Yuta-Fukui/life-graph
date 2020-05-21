import axios from 'axios'

export default {
  state: {
    accountInfo: ''
  },
  mutations: {
    setAccountInfo (state, payload) {
      state.accountInfo = payload
    },
    resetAccountInfo (state) {
      state.accountInfo = ''
    }
  },
  actions: {
    async accountAction ({ commit }, userId) {
      const url = 'api/auth/accounts/' + userId
      await axios.get(url).then((res) => {
        commit('setAccountInfo', res.data)
      })
    }
  }
}
