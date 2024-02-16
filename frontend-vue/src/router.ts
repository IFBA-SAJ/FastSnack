import type { RouteRecordRaw } from 'vue-router'
import { createRouter, createWebHistory } from 'vue-router'

import Dashboard from './views/Dashboard.vue'
import GraficosInformacoes from './views/GraficosInformacoes.vue'
import Tables from './views/Tables.vue'
import Login from './views/Login.vue'
import Produtos from './views/Produtos.vue'
import Cardapios from './views/Cardapios.vue'
import Combos from './views/Combos.vue'
import Estabelecimento from './views/Estabelecimento.vue'

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    name: 'Login',
    component: Login,
    meta: { layout: 'empty' },
  },
  {
    path: '/dashboard',
    name: 'Dashboard',
    component: Dashboard,
  },
  {
    path: '/graficosInformacoes',
    name: 'GraficosInformacoes',
    component: GraficosInformacoes,
  },
  {
    path: '/tables',
    name: 'Tables',
    component: Tables,
  },
  {
    path: '/produtos',
    name: 'Produtos',
    component: Produtos,
  },
  {
    path: '/Cardapios',
    name: 'Cardapios',
    component: Cardapios,
  },
  {
    path: '/combos',
    name: 'Combos',
    component: Combos,
  },
  {
    path: '/estabelecimento',
    name: 'Estabelecimento',
    component: Estabelecimento,
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router
