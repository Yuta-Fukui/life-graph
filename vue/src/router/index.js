import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

const routes = [
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
    path: '/login', // new add
    name: 'Login', // new add
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/Login.vue')
    }
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
      return import(/* webpackChunkName: "new" */ '../views/New.vue')
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
