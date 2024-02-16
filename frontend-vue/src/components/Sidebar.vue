<script setup lang="ts">
import { ref } from 'vue'
import { useSidebar } from '../composables/useSidebar'

const { isOpen } = useSidebar()
const activeClass = ref(
  'bg-gray-600 bg-opacity-25 text-gray-100 border-gray-100',
)
const inactiveClass = ref(
  'border-gray-900 text-gray-500 hover:bg-gray-600 hover:bg-opacity-25 hover:text-gray-100',
)
</script>

<template>
  <div class="flex">
    <!-- Backdrop -->
    <div :class="isOpen ? 'block' : 'hidden'" class="fixed inset-0 z-20 transition-opacity bg-black opacity-50 lg:hidden"
      @click="isOpen = false" />
    <!-- End Backdrop -->

    <div :class="isOpen ? 'translate-x-0 ease-out' : '-translate-x-full ease-in'"
      class="fixed inset-y-0 left-0 z-30 w-64 overflow-y-auto transition duration-300 transform bg-gray-900 lg:translate-x-0 lg:static lg:inset-0">
      <div class="flex items-center justify-center mt-8">
        <div class="flex items-center -space-x-3">
          <span class=" mx-2 text-3xl font-semibold text-white">Fast</span>
          <img src="../img/icons8-lightning-bolt-96.png" alt="" class="h-16 w-16">
          <span class=" mx-2 text-3xl font-semibold text-white">Snack</span>
        </div>
      </div>

      <nav class="mt-10">

        <!-- Atalho Dashboard -->
        <router-link class="flex items-center px-6 py-2 mt-4 duration-200 border-l-4"
          :class="[$route.name === 'Dashboard' ? activeClass : inactiveClass]" to="/dashboard">
          <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20">
            <path
              d="M3 4a1 1 0 011-1h12a1 1 0 011 1v2a1 1 0 01-1 1H4a1 1 0 01-1-1V4zM3 10a1 1 0 011-1h6a1 1 0 011 1v6a1 1 0 01-1 1H4a1 1 0 01-1-1v-6zM14 9a1 1 0 00-1 1v6a1 1 0 001 1h2a1 1 0 001-1v-6a1 1 0 00-1-1h-2z" />
          </svg>

          <span class="mx-4">Dashboard</span>
        </router-link>


        <!-- Tables / Cruds -->
        <div
          class="flex flex-row items-center px-6 py-2 mt-4 transition duration-75 text-gray-500 hover:bg-gray-600 hover:bg-opacity-25 hover:text-gray-100">
          <svg class="w-5 h-5 flex" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path
              d="M7 3C6.44772 3 6 3.44772 6 4C6 4.55228 6.44772 5 7 5H13C13.5523 5 14 4.55228 14 4C14 3.44772 13.5523 3 13 3H7Z"
              fill="currentColor" />
            <path
              d="M4 7C4 6.44772 4.44772 6 5 6H15C15.5523 6 16 6.44772 16 7C16 7.55228 15.5523 8 15 8H5C4.44772 8 4 7.55228 4 7Z"
              fill="currentColor" />
            <path
              d="M2 11C2 9.89543 2.89543 9 4 9H16C17.1046 9 18 9.89543 18 11V15C18 16.1046 17.1046 17 16 17H4C2.89543 17 2 16.1046 2 15V11Z"
              fill="currentColor" />
          </svg>

          <button type="button" class="flex items-center w-full p-2 transition duration-75 rounded-lg group"
            aria-controls="dropdown-example" data-collapse-toggle="dropdown-example">
            <span class="flex-1 ms-3 text-left rtl:text-right">Tabelas e Cadastros</span>
            <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6">
              <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                d="m1 1 4 4 4-4" />
            </svg>
          </button>

        </div>
        <ul id="dropdown-example" class="hidden py-2 space-y-2 items-center">

          <!-- Produtos -->
          <li>
            <router-link class="flex justify-center items-center"
              :class="[$route.name === 'UIElements' ? activeClass : inactiveClass]" to="/produtos">
              <span
                class="flex w-full justify-center p-2 transition duration-75 text-gray-500 hover:bg-gray-600 hover:bg-opacity-25 hover:text-gray-100">Produtos</span>
            </router-link>
          </li>

          <!-- Cardapios -->
          <li>
            <router-link :class="[$route.name === 'UIElements' ? activeClass : inactiveClass]" to="/cardapios">
              <span
                class="flex w-full justify-center p-2 transition duration-75 text-gray-500 hover:bg-gray-600 hover:bg-opacity-25 hover:text-gray-100">Cardapios</span>
            </router-link>
          </li>

          <!-- Combos -->
          <li>
            <router-link :class="[$route.name === 'UIElements' ? activeClass : inactiveClass]" to="/combos">
              <span
                class="flex w-full justify-center p-2 transition duration-75 text-gray-500 hover:bg-gray-600 hover:bg-opacity-25 hover:text-gray-100">Combos</span>
            </router-link>
          </li>
        </ul>

        <!-- Graficos e Informações -->
        <router-link class="flex items-center px-6 py-2 mt-4 duration-200 border-l-4"
          :class="[$route.name === 'GraficosInformacoes' ? activeClass : inactiveClass]" to="/graficosInformacoes">
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" class="h-5 w-5">
            <path d="M2 10a8 8 0 018-8v8h8a8 8 0 11-16 0z"></path>
            <path d="M12 2.252A8.014 8.014 0 0117.748 8H12V2.252z"></path>
          </svg>

          <span class="ml-4">Gráficos e Informações</span>
        </router-link>

        <!-- Atalho Estabelecimento -->
        <router-link class="flex items-center px-6 py-2 mt-4 duration-200 border-l-4"
          :class="[$route.name === 'Blank' ? activeClass : inactiveClass]" to="/blank">
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" class="h-5 w-5">
            <path fill-rule="evenodd"
              d="M6 6V5a3 3 0 013-3h2a3 3 0 013 3v1h2a2 2 0 012 2v3.57A22.952 22.952 0 0110 13a22.95 22.95 0 01-8-1.43V8a2 2 0 012-2h2zm2-1a1 1 0 011-1h2a1 1 0 011 1v1H8V5zm1 5a1 1 0 011-1h.01a1 1 0 110 2H10a1 1 0 01-1-1z"
              clip-rule="evenodd"></path>
            <path d="M2 13.692V16a2 2 0 002 2h12a2 2 0 002-2v-2.308A24.974 24.974 0 0110 15c-2.796 0-5.487-.46-8-1.308z">
            </path>
          </svg>

          <span class="mx-4">Estabelecimento</span>
        </router-link>
      </nav>
    </div>
  </div>
</template>
