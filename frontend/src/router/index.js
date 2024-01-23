import { createRouter, createWebHashHistory } from 'vue-router'

const routes = [
  {
    // OpenLicensingPlatform
    path: '/',
    name: 'OpenLicensingPlatform',
    component: () => import('../views/OpenLicensingPlatform/Platform.vue')
  },
  {
    // News
    path: '/news',
    name: 'news',
    component: () => import('../views/News/news.vue')
  },
  {
    // TeamMember
    path: '/team',
    name: 'team',
    component: () => import('../views/TeamMember/TeamMember.vue')
  },
  {
    // IP_Economics
    path: '/economics',
    name: 'economics',
    component: () => import('../views/IP_Economics/index.vue')
  },
  ,
  {
    // IP_Economics
    path: '/intelligence',
    name: 'intelligence',
    component: () => import('../views/IP_Intelligence/index.vue')
  },
  ,
  {
    // Patent_Value_Survey
    path: '/survey',
    name: 'survey',
    component: () => import('../views/Patent_Value_Survey/index.vue')
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

// router.beforeEach((to, from, next) => {

// })

export default router
