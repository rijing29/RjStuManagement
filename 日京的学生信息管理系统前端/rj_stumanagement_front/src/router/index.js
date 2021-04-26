import Vue from 'vue'
import VueRouter from 'vue-router'
import Studisplay from '../components/Studisplay.vue'
import login from '../components/login.vue'
import register from '../components/register.vue'
import test from '../components/test.vue'
import home from '../components/home.vue'
import welcome from '../components/welcome.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'login',
    component: login
  },
  {
    path: '/register',
    name: 'register',
    component: register
  },
  {
    path: '/test',
    name: 'test',
    component: test
  },
  // 菜单导航栏中二级菜单的路由
  {
    path: '/home',
    component: home,
    redirect:'/welcome',
    children:[
    {
      path:'/welcome',
      component:welcome
    },{
      path:'/Studisplay',
      component:Studisplay
    }]
  }
]

const router = new VueRouter({
  mode:'history',
  routes
})

export default router
