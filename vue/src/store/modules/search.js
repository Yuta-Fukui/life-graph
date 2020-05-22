import axios from 'axios'

export default {
  state: {
    token: ''
  },
  mutations: {
    setSearch (state, data) {
      state.token = data.token
    }
  },
  actions: {
    fetchSearch ({ commit }, data) {
      const url = '/api/auth/search'
      axios.get(url, data).then((res) => {
        commit('setSearch', res.data)
      })
    }
  }
}

// import axios from 'axios'

// export default {
//   state: {
//     search: ''
//   },
//   mutations: {
//     setLogin (state, name, id, created, updated) {
//       state.search = name, id, created, updated.search
//     }
//   },
//   actions: {
//     fetchSearch ({ commit }, name, id, created, updated) {
//       const url = '/api/auth/life-graphs'
//       axios.get(name, id, created, updated).then((res) => {
//         commit('setSearch', res.name, id, created, updated)
//       })
//     }
//   }
// }
