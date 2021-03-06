import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    },
    {
      path: '/blog',
      name: 'blog',
      component: () => import('./views/Blog.vue'),
      children: [
        {
          path: '/blog/:id',
          name: 'blogPost', component: () => import('./components/BlogPost.vue')
        }
      ]
    },
    {
      path: '*',
      name: 'notFound',
      component: () => import('./views/NotFound.vue')
    }
  ]
})
