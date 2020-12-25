import Vue from 'vue'
import Router from 'vue-router'
import {clearLoginInfo} from '@/utils'

Vue.use(Router)

// 开发环境不使用懒加载, 因为懒加载页面太多的话会造成webpack热更新太慢, 所以只有生产环境使用懒加载
const _import = require('./import-' + process.env.NODE_ENV)

// 全局路由(无需嵌套上左右整体布局)
const globalRoutes = [
  {path: '/404', component: _import('common/404'), name: '404', meta: {title: '404未找到'}},
  {path: '/login', component: _import('common/login'), name: 'login', meta: {title: '登录'}}
]

// 主入口路由（需嵌套上左右整体布局）
const mainRoutes = {
  path: '/',
  component: _import('main'),
  name: 'main',
  redirect: {name: 'home'},
  meta: {title: '主入口整体布局'},
  children: [
    {path: '/home', component: _import('common/home'), name: 'home', meta: {title: '首页'}},
    {path: '/student', component: _import('modules/student'), name: 'student', meta: {title: '学生信息管理'}},
    {path: '/course', component: _import('modules/course'), name: 'course', meta: {title: '课程信息管理'}},
    {path: '/score', component: _import('modules/score'), name: 'score', meta: {title: '成绩信息管理'}}
  ],
  beforeEnter (to, from, next) {
    let token = Vue.cookie.get('token')
    if (!token || !/\S/.test(token)) { // 正则：非空白就匹配
      clearLoginInfo()
      next({name: 'login'})
    }
    next()
  }
}

// 路由信息
const router = new Router({
  base: '/',
  mode: 'hash',
  scrollBehavior: () => ({y: 0}), // 每次访问滚动条都置0
  routes: globalRoutes.concat(mainRoutes)
})

// 404页面
router.addRoutes([
  {path: '*', redirect: {name: '404'}}
])

export default router
