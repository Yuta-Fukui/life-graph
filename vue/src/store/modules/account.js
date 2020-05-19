// import axios from 'axios'

// const config = {
//   headers: {
//     'Access-Control-Allow-Origin': '*'
//   }
// }
export default {
  state: {
    email: '',
    password: ''
  },
  mutations: {
    setLogin (state, data) {
      state.data = data
    }
  },
  actions: {
    fetchLogin ({ commit }, data) {
      commit('setLogin', data)
    }
  }
  // state: {
  //   account: {
  //     // TODO: delete because of test
  //     login: 'ng'
  //   }
  // },
  // mutations: {
  //   // TODO: delete because of test
  //   setLogin (state, payload) {
  //     state.login = payload.login
  //   }
  // },
  // actions: {
  //   // TODO: delete because of test
  //   fetchLogin ({ commit }) {
  //     const url = '/api/auth/login'
  //     axios.get(url, config).then((res) => {
  //       commit('setLogin', res.data)
  //     })
  //   }
  // }
}
