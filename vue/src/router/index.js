import Vue from 'vue'
import Router from 'vue-router'
// in development env not use Lazy Loading,because Lazy Loading too many pages will cause webpack hot update too slow.so only in production use Lazy Loading
/* layout */
import Layout from '../views/layout/Layout'

const _import = require('./_import_' + process.env.NODE_ENV)
Vue.use(Router)
export const constantRouterMap = [
  {path: '/login', component: _import('login/index'), hidden: true},
  {path: '/404', component: _import('404'), hidden: true},
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    name: '首页',
    hidden: true,
    children: [{
      path: 'dashboard', component: _import('dashboard/index')
    }]
  }
]
export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({y: 0}),
  routes: constantRouterMap
})
export const asyncRouterMap = [
  {
    path: '/system',
    component: Layout,
    redirect: '/system/article',
    name: '功能模块',
    meta: {title: '功能模块', icon: 'tree'},
    children: [
      {
        path: 'article',
        name: '公共信息管理',
        component: _import('article/article'),
        meta: {title: '公共信息管理', icon: 'gd'},
        menu: 'commoninfo'
      },
    ]
  },
  {
    path: '/system',
    component: Layout,
    redirect: '/system/community',
    name: '功能模块',
    meta: {title: '功能模块', icon: 'tree'},
    children: [
      {
        path: 'community',
        name: '小区基础信息',
        component: _import('community/community'),
        meta: {title: '小区基础信息', icon: 'example'},
        menu: 'community'
      },
    ]
  },
  {
    path: '/system',
    component: Layout,
    redirect: '/system/air',
    name: '功能模块',
    meta: {title: '社区环境质量', icon: 'tree'},
    children: [
      {
        path: 'air',
        name: '空气质量',
        component: _import('air/air'),
        meta: {title: '空气质量', icon: 'example'},
        menu: 'air'
      },
      {
        path: 'air',
        name: '空气质量',
        component: _import('air/air'),
        meta: {title: '基础环境信息', icon: 'form'},
        menu: 'air'
      },
    ]
  },
  {
    path: '/system',
    component: Layout,
    redirect: '/system/air',
    name: '功能模块',
    meta: {title: '功能模块', icon: 'tree'},
    children: [
      {
        path: 'air',
        name: '居民投诉信箱',
        component: _import('air/air'),
        meta: {title: '居民投诉信箱', icon: 'xiaoxi'},
        menu: 'air'
      },
    ]
  },
  {
    path: '/user',
    component: Layout,
    redirect: '/user/',
    name: '',
    meta: {title: '用户权限', icon: 'table'},
    children: [
      {
        path: '', name: '用户列表', component: _import('user/user'), meta: {title: '用户列表', icon: 'user'}, menu: 'user'
      },
      {
        path: 'role',
        name: '权限管理',
        component: _import('user/role'),
        meta: {title: '权限管理', icon: 'password'},
        menu: 'role'
      },
    ]
  },
  {path: '*', redirect: '/404', hidden: true}
]
