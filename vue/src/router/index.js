import Vue from 'vue'
import VueRouter from 'vue-router'
// 未ログイン状態の時にログイン画面に飛ばす設定
// import Store from '@/store/index.js'

Vue.use(VueRouter)

const routes = [
  {
    path: '/', // new add
    name: 'Login', // new add
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/Login.vue')
    },
    meta: {
      isPublic: true
    }
  },
  {
    path: '/signup', // new add
    name: 'SignUp', // new add
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/SignUp.vue')
    },
    meta: {
      isPublic: true
    }
  },
  {
    path: '/top',
    name: 'Top',
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/Top.vue')
    }
    // function () {
    //   return import(/* webpackChunkName: "top" */ '../views/Top.vue')
  },
  {
    path: '/about',
    name: 'About',
    //  route level code-splitting
    //  this generates a separate chunk (about.[hash].js) for this route
    //  which is lazy-loaded when the route is visited.
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/About.vue')
    }
  },
  {
    path: '/new',
    name: 'New',
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/New.vue')
    }
  },
  {
    path: '/reference',
    name: 'Reference',
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/Reference.vue')
    }
  },
  {
    path: '/life-graph/lists',
    name: 'Search',
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/Search.vue')
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 未ログイン状態の時にログイン画面に飛ばす設定
// router.beforeEach((to, from, next) => {
//   // ログイン画面以外の画面かつ未ログインの時
//   if (to.matched.some(page => page.meta.isPublic) || Store.state.auth.token) {
//     next()
//   } else {
//     next('/')
//   }
// })

export default router
