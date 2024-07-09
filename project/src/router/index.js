import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)



const routes = [
  {
    path: '/emp',
    name: 'emp',
    component: () => import( '../tlias/EmpView.vue')
  },
  {
    path: '/sup',
    name: 'supplier',
    component: () => import('../tlias/SupView.vue')
  },

  {
    path: '/goods_info',
    name: 'goods_info',
    component: () => import('../tlias/goods_info.vue')
  },
  {
    path: '/TyPe',
    name: 'TyPe',
    component: () => import('../tlias/TyPe.vue')
  },
  {
    path: '/goods_sales',
    name: 'goods_sales',
    component: () => import('../tlias/goods_sales.vue')
  },
  {
    path: '/WareHouse',
    name: 'WareHouse',
    component: () => import('../tlias/WareHouse.vue')
  },
  {
    path: '/goods_warehouse',
    name: 'goods_warehouse',
    component: () => import('../tlias/goods_warehouse.vue')
  },
  {
    path: '/PurChase',
    name: 'PurChase',
    component: () => import('../tlias/PurChase.vue')
  },
  {
    path: '/StoRage',
    name: 'StoRage',
    component: () => import('../tlias/StoRage.vue')
  },
  {
    path: '/ReTrieval',
    name: 'ReTrieval',
    component: () => import('../tlias/ReTrieval.vue')
  },
  {
    path: '/MoVe',
    name: 'MoVe',
    component: () => import('../tlias/MoVe.vue')
  },
  {
    path: '/ReTurn',
    name: 'ReTurn',
    component: () => import('../tlias/ReTurn.vue')
  },
  {
    path: '/Emp_Info',
    name: 'Emp_Info',
    component: () => import('../tlias/emp_info.vue')
  },
  {
    path: '/LoginFirst',
    name: 'LoginFirst',
    component: () => import('../tlias/LoginFirst.vue')
  },
  
  {
    path: '/goods_info2',
    name: 'goods_info2',
    component: () => import('../tlias/goods_info2.vue')
  },
  {
    path: '/TyPe2',
    name: 'TyPe2',
    component: () => import('../tlias/TyPe2.vue')
  },
  {
    path: '/goods_sales2',
    name: 'goods_sales2',
    component: () => import('../tlias/goods_sales2.vue')
  },
  {
    path: '/WareHouse2',
    name: 'WareHouse2',
    component: () => import('../tlias/WareHouse2.vue')
  },
  {
    path: '/goods_warehouse2',
    name: 'goods_warehouse2',
    component: () => import('../tlias/goods_warehouse2.vue')
  },
  {
    path: '/PurChase2',
    name: 'PurChase2',
    component: () => import('../tlias/PurChase2.vue')
  },
  {
    path: '/StoRage2',
    name: 'StoRage2',
    component: () => import('../tlias/StoRage2.vue')
  },
  {
    path: '/ReTrieval2',
    name: 'ReTrieval2',
    component: () => import('../tlias/ReTrieval2.vue')
  },
  {
    path: '/MoVe2',
    name: 'MoVe2',
    component: () => import('../tlias/MoVe2.vue')
  },
  {
    path: '/ReTurn2',
    name: 'ReTurn2',
    component: () => import('../tlias/ReTurn2.vue')
  },

  {
    path: '/',
    redirect:'/LoginFirst'
  },

]

const router = new VueRouter({
  routes
})


export default router
