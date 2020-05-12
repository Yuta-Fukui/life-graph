import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
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
<<<<<<< HEAD
  },
  {
    path: '/new',
    name: 'New',
    component: function () {
      return import(/* webpackChunkName: "new" */ '../views/New.vue')
    }
=======
    // path: '/'
>>>>>>> 04b84d9767654233fbca679c8c516501739d0bc6
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
