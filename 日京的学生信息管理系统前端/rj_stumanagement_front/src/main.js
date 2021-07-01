import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import axios from 'axios'
Vue.prototype.$http = axios //正确的使用

axios.defaults.baseURL='http://localhost:8080/stu' //设置一个基本路径

Vue.config.productionTip = false

// 入口文件
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
