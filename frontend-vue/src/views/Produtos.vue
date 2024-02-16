
<template>
    <!-- Start block -->
    <section class="sm:p-5 antialiased">
        <div class="mx-auto max-w-screen-xl">

            <!-- Start coding here -->
            <div class="bg-white dark:bg-gray-800 relative shadow-md sm:rounded-lg">
                <div class="flex flex-col md:flex-row items-center justify-between space-y-3 md:space-y-0 md:space-x-4 p-4">

                    <!-- Barra de Pesquisa -->
                    <div class="w-full md:w-1/2">
                        <form class="flex items-center">
                            <label for="simple-search" class="sr-only">Nome de produto</label>
                            <div class="flex flex-row relative w-full space-x-2">
                                <input v-model="this.produtoPesquisa" type="text" id="simple-search"
                                    class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full pl-5 p-2"
                                    placeholder="Nome de produto" required>
                                <button
                                    class="flex items-center justify-center text-white bg-gray-300 hover:bg-gray-200 focus:ring-4 focus:ring-gray-300 font-medium rounded-lg text-sm px-4 py-2"
                                    type="button" @click="pesquisarProdutos()">
                                    <svg aria-hidden="true" class="w-5 h-5 text-gray-600" fill="currentColor"
                                        viewbox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                            d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"
                                            clip-rule="evenodd" />
                                    </svg>
                                    <span class="text-gray-600 ml-2 font-medium"> Buscar </span>
                                </button>
                            </div>
                        </form>
                    </div>

                    <!-- Barra de utilidades -->
                    <div
                        class="w-full md:w-auto flex flex-col md:flex-row space-y-2 md:space-y-0 items-stretch md:items-center justify-end md:space-x-3 flex-shrink-0">

                        <!-- Barra de utilidades- Botão Add Produtos -->
                        <button type="button" @click="openModal('createProductModal')"
                            class="flex flex-row itens-center text-white w-auto h-10 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                            <svg class="h-4 w-4 mr-2" fill="currentColor" viewbox="0 0 20 20"
                                xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                                <path clip-rule="evenodd" fill-rule="evenodd"
                                    d="M10 3a1 1 0 011 1v5h5a1 1 0 110 2h-5v5a1 1 0 11-2 0v-5H4a1 1 0 110-2h5V4a1 1 0 011-1z" />
                            </svg>
                            Adicionar Produto
                        </button>
                    </div>
                </div>

                <!-- Tabela -->
                <div class="overflow-x-auto">
                    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">

                        <!-- Tabela - Cabeçalho -->
                        <thead class="text-xs text-gray-700 uppercase bg-gray-200">
                            <tr>
                                <th scope="col" class="px-4 py-4 border-2 border-gray-300">Nome</th>
                                <th scope="col" class="px-4 py-3 border-2 border-gray-300">fila</th>
                                <th scope="col" class="px-4 py-3 border-2 border-gray-300">Descrição</th>
                                <th scope="col" class="px-4 py-3 border-2 border-gray-300">Preço</th>
                                <th scope="col" class="px-4 py-3 border-2 border-gray-300">Código</th>
                                <th scope="col" class="px-4 py-3 border-2 border-gray-300">Ações</th>
                            </tr>
                        </thead>

                        <!-- Tabela - Corpo (registros) -->
                        <tbody>

                            <!-- Modais -->

                            <!-- Update modal -->
                            <div id="updateProductModal" aria-hidden="true"
                                class="hidden fixed z-50 bg-white rounded-lg shadow-md overflow-y-auto overflow-x-hidden 
                                                top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 w-2/5 h-auto max-w-1/3">
                                <!-- Modal content -->
                                <div class="relative p-4 bg-white rounded-lg shadow dark:bg-gray-800 sm:p-5">
                                    <!-- Modal header -->
                                    <div
                                        class="flex justify-between items-center pb-4 mb-4 rounded-t border-b sm:mb-5 dark:border-gray-600">
                                        <h3 class="text-lg font-semibold text-gray-900 dark:text-white">
                                            Atualizar
                                            produto</h3>
                                        <button @click="closeModal('updateProductModal')" type="button"
                                            class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white">
                                            <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewbox="0 0 20 20"
                                                xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                                                    clip-rule="evenodd" />
                                            </svg>
                                            <span class="sr-only">Fechar modal</span>
                                        </button>
                                    </div>
                                    <!-- Modal body -->
                                    <form action="#">
                                        <div class="grid gap-4 mb-4 sm:grid-cols-2">
                                            <div>
                                                <label for="nome"
                                                    class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Nome</label>
                                                <input type="text" name="nome" id="nome"
                                                    v-model="this.produtoSelecionado.nome"
                                                    class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                                    placeholder="Ex. Apple iMac 27&ldquo;">
                                            </div>

                                            <div>
                                                <label for="preco"
                                                    class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Preço</label>
                                                <input type="number" step="any" min="0"
                                                    v-model="this.produtoSelecionado.preco" nome="preco" id="preco"
                                                    class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                                    placeholder="$299,99">
                                            </div>
                                            <div>
                                                <label for="codigo"
                                                    class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Código</label>
                                                <input type="text" v-model="this.produtoSelecionado.codigo" nome="codigo"
                                                    id="codigo"
                                                    class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                                    placeholder="#123456">
                                            </div>

                                            <div>
                                                <label for="fila"
                                                    class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Fila</label>
                                                <div class="flex flex-row space-x-2">
                                                    <select id="fila"
                                                        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-2/3 h-10">
                                                        <option selected>Selecione a fila
                                                        </option>
                                                        <option value="TV">Fila Lanches</option>
                                                        <option value="PC">Fila Massas</option>
                                                        <option value="GA">Fila Comida Japonesa</option>
                                                        <option value="PH">Fila Drinks</option>
                                                    </select>

                                                    <!-- Botão Modal Criar -->
                                                    <button @click="openModal('modalFila')"
                                                        class="block text-white w-1/3 h-10 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
                                                        type="button">
                                                        Criar
                                                    </button>

                                                    <!-- Fila modal -->
                                                    <div id="modalFila" tabindex="-1" aria-hidden="true"
                                                        class="hidden fixed inset-0 flex items-center justify-center">
                                                        <div class="relative p-4 max-h-full">
                                                            <!-- Modal content -->
                                                            <div class="relative bg-white rounded-lg shadow w-full">
                                                                <!-- Modal body -->
                                                                <div>
                                                                    <div>
                                                                        <div
                                                                            class="w-full max-w-sm overflow-hidden bg-white border rounded-md shadow-md">
                                                                            <form>
                                                                                <div
                                                                                    class="flex items-center justify-between px-5 py-3 text-gray-700 border-b">
                                                                                    <h3 class="text-sm font-semibold">
                                                                                        Adicionar
                                                                                        fila
                                                                                    </h3>

                                                                                    <button type="button"
                                                                                        class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
                                                                                        @click="closeModal('modalFila')">
                                                                                        <svg class="w-3 h-3"
                                                                                            aria-hidden="true"
                                                                                            xmlns="http://www.w3.org/2000/svg"
                                                                                            fill="none" viewBox="0 0 14 14">
                                                                                            <path stroke="currentColor"
                                                                                                stroke-linecap="round"
                                                                                                stroke-linejoin="round"
                                                                                                stroke-width="2"
                                                                                                d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
                                                                                        </svg>
                                                                                        <span class="sr-only">Fechar</span>
                                                                                    </button>
                                                                                </div>

                                                                                <div
                                                                                    class="px-5 py-6 text-gray-700 bg-gray-200 border-b">
                                                                                    <label class="text-xs">Nome</label>

                                                                                    <div
                                                                                        class="relative mt-2 rounded-md shadow-sm">
                                                                                        <span
                                                                                            class="absolute inset-y-0 left-0 flex items-center pl-3 text-gray-600">
                                                                                            <svg class="w-6 h-6" fill="none"
                                                                                                viewBox="0 0 24 24"
                                                                                                stroke="currentColor">
                                                                                                <path stroke-linecap="round"
                                                                                                    stroke-linejoin="round"
                                                                                                    stroke-width="2"
                                                                                                    d="M11 4a2 2 0 114 0v1a1 1 0 001 1h3a1 1 0 011 1v3a1 1 0 01-1 1h-1a2 2 0 100 4h1a1 1 0 011 1v3a1 1 0 01-1 1h-3a1 1 0 01-1-1v-1a2 2 0 10-4 0v1a1 1 0 01-1 1H7a1 1 0 01-1-1v-3a1 1 0 00-1-1H4a2 2 0 110-4h1a1 1 0 001-1V7a1 1 0 011-1h3a1 1 0 001-1V4z" />
                                                                                            </svg>
                                                                                        </span>

                                                                                        <input type="text"
                                                                                            class="w-full px-12 py-2 border-transparent rounded-md appearance-none focus:border-indigo-600 focus:ring focus:ring-opacity-40 focus:ring-indigo-500">
                                                                                    </div>
                                                                                </div>
                                                                            </form>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <!-- Modal footer -->
                                                                <div
                                                                    class="flex items-center p-4 md:p-5 border-t border-gray-200 rounded-b dark:border-gray-600">
                                                                    <button @click="closeModal('modalFila')" type="button"
                                                                        class="text-red-500 bg-gray-200 hover:bg-gray-300 focus:ring-4 focus:outline-none focus:ring-gray-200 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Cancelar</button>
                                                                    <button @click="closeModal('modalFila')" type="button"
                                                                        class="ms-3 text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-gray-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">Adicionar</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>

                                            <div class="sm:col-span-2"><label for="descrição"
                                                    class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Descrição</label><textarea
                                                    id="descrição" rows="5"
                                                    class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-primary-500 focus:border-primary-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                                    placeholder="Insira uma descrição..." required
                                                    v-model="this.produtoSelecionado.descricao"></textarea>
                                            </div>
                                        </div>
                                        <div class="flex items-center space-x-4">

                                            <button @click="EditarProduto()" type="button"
                                                class="flex flex-row itens-center text-white w-auto h-10 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                                                <svg class="w-5 h-5 mr-2" xmlns="http://www.w3.org/2000/svg"
                                                    viewbox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                                    <path
                                                        d="M17.414 2.586a2 2 0 00-2.828 0L7 10.172V13h2.828l7.586-7.586a2 2 0 000-2.828z" />
                                                    <path fill-rule="evenodd" clip-rule="evenodd"
                                                        d="M2 6a2 2 0 012-2h4a1 1 0 010 2H4v10h10v-4a1 1 0 112 0v4a2 2 0 01-2 2H4a2 2 0 01-2-2V6z" />
                                                </svg>
                                                Atualizar
                                                produto</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <!-- Read modal -->
                            <div id="readProductModal" tabindex="-1" aria-hidden="true"
                                class="hidden fixed z-50 bg-white rounded-lg shadow-md overflow-y-auto overflow-x-hidden 
                                            top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 w-2/5 h-auto max-w-1/3">
                                <!-- Modal content -->
                                <div class="relative p-4 bg-white rounded-lg shadow dark:bg-gray-800 sm:p-5">
                                    <!-- Modal header -->
                                    <div class="flex justify-between mb-4 rounded-t sm:mb-5">
                                        <div class="text-lg text-gray-900 md:text-xl dark:text-white">
                                            <h3 class="font-semibold ">{{ this.produtoSelecionado.nome }}</h3>
                                            <p class="font-bold">${{ this.produtoSelecionado.preco }}</p>
                                        </div>
                                        <div>
                                            <button @click="closeModal('readProductModal')" type="button"
                                                class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 inline-flex dark:hover:bg-gray-600 dark:hover:text-white">
                                                <svg aria-hidden="true" class="w-5 h-5" fill="currentColor"
                                                    viewbox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                                    <path fill-rule="evenodd"
                                                        d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                                                        clip-rule="evenodd" />
                                                </svg>
                                                <span class="sr-only">Fechar Modal</span>
                                            </button>
                                        </div>
                                    </div>
                                    <dl>
                                        <dt class="mb-2 font-semibold leading-none text-gray-900 dark:text-white">
                                            Detalhes</dt>
                                        <dd class="mb-4 font-light text-gray-500 sm:mb-5 dark:text-gray-400">
                                            {{ this.produtoSelecionado.descricao }}</dd>
                                        <dt class="mb-2 font-semibold leading-none text-gray-900 dark:text-white">
                                            Categoria</dt>
                                        <dd class="mb-4 font-light text-gray-500 sm:mb-5 dark:text-gray-400">
                                            Electronics/PC</dd>
                                    </dl>
                                </div>
                            </div>
                            <!-- Delete modal -->
                            <div id="deleteModal" tabindex="-1" aria-hidden="true"
                                class="hidden fixed z-50 bg-white rounded-lg shadow-md overflow-y-auto overflow-x-hidden 
                                                top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 w-1/5 h-auto max-w-1/3">
                                <!-- Modal content -->
                                <div class="relative p-4 text-center bg-white rounded-lg shadow dark:bg-gray-800 sm:p-5">
                                    <button @click="closeModal('deleteModal')" type="button"
                                        class="text-gray-400 absolute top-2.5 right-2.5 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white">
                                        <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewbox="0 0 20 20"
                                            xmlns="http://www.w3.org/2000/svg">
                                            <path fill-rule="evenodd"
                                                d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                                                clip-rule="evenodd" />
                                        </svg>
                                        <span class="sr-only">Fechar modal</span>
                                    </button>
                                    <svg class="text-gray-400 dark:text-gray-500 w-11 h-11 mb-3.5 mx-auto"
                                        aria-hidden="true" fill="currentColor" viewbox="0 0 20 20"
                                        xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                            d="M9 2a1 1 0 00-.894.553L7.382 4H4a1 1 0 000 2v10a2 2 0 002 2h8a2 2 0 002-2V6a1 1 0 100-2h-3.382l-.724-1.447A1 1 0 0011 2H9zM7 8a1 1 0 012 0v6a1 1 0 11-2 0V8zm5-1a1 1 0 00-1 1v6a1 1 0 102 0V8a1 1 0 00-1-1z"
                                            clip-rule="evenodd" />
                                    </svg>
                                    <p class="mb-4 text-gray-500 dark:text-gray-300">Você tem certeza que
                                        deseja
                                        deletar esse item?</p>
                                    <div class="flex justify-center items-center space-x-4">
                                        <button @click="closeModal('deleteModal')" type="button"
                                            class="py-2 px-3 text-sm font-medium text-gray-500 bg-white rounded-lg border border-gray-200 hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-primary-300 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">Não,
                                            cancelar</button>
                                        <button type="button"
                                            class="text-red-600 inline-flex items-center hover:text-white border border-red-600 hover:bg-red-600 focus:ring-4 focus:outline-none focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:border-red-500 dark:text-red-500 dark:hover:text-white dark:hover:bg-red-600 dark:focus:ring-red-900"
                                            @click="deletarProduto()">
                                            <svg class="mr-1 -ml-1 w-5 h-5" fill="currentColor" viewbox="0 0 20 20"
                                                xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M9 2a1 1 0 00-.894.553L7.382 4H4a1 1 0 000 2v10a2 2 0 002 2h8a2 2 0 002-2V6a1 1 0 100-2h-3.382l-.724-1.447A1 1 0 0011 2H9zM7 8a1 1 0 012 0v6a1 1 0 11-2 0V8zm5-1a1 1 0 00-1 1v6a1 1 0 102 0V8a1 1 0 00-1-1z"
                                                    clip-rule="evenodd" />
                                            </svg>
                                            Deletar
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal backdrop -->
                            <div id="modalBackdrop"
                                class="hidden fixed top-0 left-0 z-40 w-full h-full bg-black bg-opacity-50">
                            </div>
                            <!-- Add Product modal -->
                            <div id="createProductModal" tabindex="-1" aria-hidden="true"
                                class="hidden fixed z-50 bg-white rounded-lg shadow-md overflow-y-auto overflow-x-hidden 
                                            top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 h-auto w-auto max-w-1/3">
                                <div class="relative p-4 w-full max-w-2xl max-h-full">
                                    <!-- Modal content- add Produto -->
                                    <div class="relative p-4 bg-white rounded-lg shadow dark:bg-gray-800 sm:p-5">
                                        <!-- Modal header- add Produto -->
                                        <div
                                            class="flex flex-col justify-between itens-center pb-4 mb-4 rounded-t border-b sm:mb-5 dark:border-gray-600">
                                            <div class="flex flex-row justify-between itens-center">
                                                <h3 class="text-lg font-semibold text-gray-900 dark:text-white">
                                                    Adicionar Produto</h3>

                                                <button type="button"
                                                    class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white"
                                                    @click="closeModal('createProductModal')">
                                                    <svg aria-hidden="true" class="w-5 h-5" fill="currentColor"
                                                        viewbox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                                        <path fill-rule="evenodd"
                                                            d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                                                            clip-rule="evenodd" />
                                                    </svg>
                                                    <span class="sr-only">Close modal</span>
                                                </button>
                                            </div>

                                            <form action="#" @submit.prevent="salvarProduto()">
                                                <div class="grid gap-4 mb-4 sm:grid-cols-2">
                                                    <div>
                                                        <label for="nome"
                                                            class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Nome</label>
                                                        <input type="text" v-model="this.enviaProduto.nome" name="nome"
                                                            id="nome"
                                                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                                            placeholder="Nome do produto" required>
                                                    </div>
                                                    <div>
                                                        <label for="preco"
                                                            class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Preço</label>
                                                        <input type="number" step="any" min="0"
                                                            v-model="this.enviaProduto.preco" name="preco" id="preco"
                                                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                                            placeholder="$299,99" required>
                                                    </div>
                                                    <div>
                                                        <label for="codigo"
                                                            class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Código</label>
                                                        <input v-model="this.enviaProduto.codigo" type='' name="codigo"
                                                            id="codigo"
                                                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                                            placeholder="#12345" required>
                                                    </div>
                                                    <div>
                                                        <label for="fila"
                                                            class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Fila</label>
                                                        <div class="flex flex-row space-x-2">
                                                            <select id="fila"
                                                                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-2/3 h-10">
                                                                <option selected>Selecione a fila
                                                                </option>
                                                                <option value="TV">Fila Lanches</option>
                                                                <option value="PC">Fila Massas</option>
                                                                <option value="GA">Fila Comida Japonesa</option>
                                                                <option value="PH">Fila Drinks</option>
                                                            </select>

                                                            <!-- Botão Modal Criar -->
                                                            <button @click="openModal('modalFila2')"
                                                                class="block text-white w-1/3 h-10 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
                                                                type="button">
                                                                Criar
                                                            </button>

                                                            <!-- Fila modal -->
                                                            <div id="modalFila2" tabindex="-1" aria-hidden="true"
                                                                class="hidden fixed inset-0 flex items-center justify-center">
                                                                <div class="relative p-4 max-h-full">
                                                                    <!-- Modal content -->
                                                                    <div class="relative bg-white rounded-lg shadow w-full">
                                                                        <!-- Modal body -->
                                                                        <div>
                                                                            <div>
                                                                                <div
                                                                                    class="w-full max-w-sm overflow-hidden bg-white border rounded-md shadow-md">
                                                                                    <form>
                                                                                        <div
                                                                                            class="flex items-center justify-between px-5 py-3 text-gray-700 border-b">
                                                                                            <h3
                                                                                                class="text-sm font-semibold">
                                                                                                Adicionar
                                                                                                fila
                                                                                            </h3>

                                                                                            <button type="button"
                                                                                                class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
                                                                                                @click="closeModal('modalFila2')">
                                                                                                <svg class="w-3 h-3"
                                                                                                    aria-hidden="true"
                                                                                                    xmlns="http://www.w3.org/2000/svg"
                                                                                                    fill="none"
                                                                                                    viewBox="0 0 14 14">
                                                                                                    <path
                                                                                                        stroke="currentColor"
                                                                                                        stroke-linecap="round"
                                                                                                        stroke-linejoin="round"
                                                                                                        stroke-width="2"
                                                                                                        d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
                                                                                                </svg>
                                                                                                <span
                                                                                                    class="sr-only">Fechar</span>
                                                                                            </button>
                                                                                        </div>

                                                                                        <div
                                                                                            class="px-5 py-6 text-gray-700 bg-gray-200 border-b">
                                                                                            <label
                                                                                                class="text-xs">Nome</label>

                                                                                            <div
                                                                                                class="relative mt-2 rounded-md shadow-sm">
                                                                                                <span
                                                                                                    class="absolute inset-y-0 left-0 flex items-center pl-3 text-gray-600">
                                                                                                    <svg class="w-6 h-6"
                                                                                                        fill="none"
                                                                                                        viewBox="0 0 24 24"
                                                                                                        stroke="currentColor">
                                                                                                        <path
                                                                                                            stroke-linecap="round"
                                                                                                            stroke-linejoin="round"
                                                                                                            stroke-width="2"
                                                                                                            d="M11 4a2 2 0 114 0v1a1 1 0 001 1h3a1 1 0 011 1v3a1 1 0 01-1 1h-1a2 2 0 100 4h1a1 1 0 011 1v3a1 1 0 01-1 1h-3a1 1 0 01-1-1v-1a2 2 0 10-4 0v1a1 1 0 01-1 1H7a1 1 0 01-1-1v-3a1 1 0 00-1-1H4a2 2 0 110-4h1a1 1 0 001-1V7a1 1 0 011-1h3a1 1 0 001-1V4z" />
                                                                                                    </svg>
                                                                                                </span>

                                                                                                <input type="text"
                                                                                                    class="w-full px-12 py-2 border-transparent rounded-md appearance-none focus:border-indigo-600 focus:ring focus:ring-opacity-40 focus:ring-indigo-500">
                                                                                            </div>
                                                                                        </div>
                                                                                    </form>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <!-- Modal footer -->
                                                                        <div
                                                                            class="flex items-center p-4 md:p-5 border-t border-gray-200 rounded-b dark:border-gray-600">
                                                                            <button @click="closeModal('modalFila2')"
                                                                                type="button"
                                                                                class="text-red-500 bg-gray-200 hover:bg-gray-300 focus:ring-4 focus:outline-none focus:ring-gray-200 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Cancelar</button>
                                                                            <button @click="closeModal('modalFila2')"
                                                                                type="button"
                                                                                class="ms-3 text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-gray-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">Adicionar</button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                        </div>
                                                    </div>
                                                    <div class="sm:col-span-2"><label for="descrição"
                                                            class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Descrição</label><textarea
                                                            v-model="this.enviaProduto.descricao" id="descrição" rows="4"
                                                            required
                                                            class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-primary-500 focus:border-primary-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                                            placeholder="Insira a descrição do produto"></textarea>
                                                    </div>
                                                </div>

                                                <button type="submit"
                                                    class="flex flex-row itens-center text-white w-1/3 h-10 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                                                    <svg class="h-4 w-4 mr-2" fill="currentColor" viewbox="0 0 20 20"
                                                        xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                                                        <path clip-rule="evenodd" fill-rule="evenodd"
                                                            d="M10 3a1 1 0 011 1v5h5a1 1 0 110 2h-5v5a1 1 0 11-2 0v-5H4a1 1 0 110-2h5V4a1 1 0 011-1z" />
                                                    </svg>
                                                    Adicionar Produto
                                                </button>

                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <!-- V-for (Puxa tabela do servidor) -->
                            <tr v-for="produto in produtos" :key="produto.id" class="border-b dark:border-gray-700">
                                <th scope="row"
                                    class="px-4 py-3 font-medium border-2 border-gray-300 text-gray-900 whitespace-nowrap">
                                    {{ produto.nome }}</th>
                                <td class="px-4 py-3 border-2 border-gray-300">PC</td>
                                <td class="px-4 py-3 border-2 border-gray-300 max-w-[12rem] truncate">{{ produto.descricao
                                }}</td>
                                <td class="px-4 py-3 border-2 border-gray-300">{{ produto.preco }}</td>
                                <td class="px-4 py-3 border-2 border-gray-300">{{ produto.codigo }}</td>
                                <td class="px-4 py-3 border-2 border-gray-300 items-center">
                                    <!-- Buttons section -->
                                    <div class="flex items-center">
                                        <!-- Update button -->
                                        <button type="button" @click="openModal('updateProductModal', produto)"
                                            class="items-center hover:bg-gray-100 text-gray-700">
                                            <svg class="w-5 h-5 mr-2" xmlns="http://www.w3.org/2000/svg" viewbox="0 0 20 20"
                                                fill="currentColor" aria-hidden="true">
                                                <path
                                                    d="M17.414 2.586a2 2 0 00-2.828 0L7 10.172V13h2.828l7.586-7.586a2 2 0 000-2.828z" />
                                                <path fill-rule="evenodd" clip-rule="evenodd"
                                                    d="M2 6a2 2 0 012-2h4a1 1 0 010 2H4v10h10v-4a1 1 0 112 0v4a2 2 0 01-2 2H4a2 2 0 01-2-2V6z" />
                                            </svg>
                                        </button>
                                        <!-- Preview button -->
                                        <button type="button" @click="openModal('readProductModal', produto)"
                                            class="items-center hover:bg-gray-100 text-gray-700">
                                            <svg class="w-5 h-5 mr-2" xmlns="http://www.w3.org/2000/svg" viewbox="0 0 20 20"
                                                fill="currentColor" aria-hidden="true">
                                                <path d="M10 12a2 2 0 100-4 2 2 0 000 4z" />
                                                <path fill-rule="evenodd" clip-rule="evenodd"
                                                    d="M.458 10C1.732 5.943 5.522 3 10 3s8.268 2.943 9.542 7c-1.274 4.057-5.064 7-9.542 7S1.732 14.057.458 10zM14 10a4 4 0 11-8 0 4 4 0 018 0z" />
                                            </svg>
                                        </button>
                                        <!-- Delete button -->
                                        <button type="button" @click="openModal('deleteModal', produto)"
                                            class="items-center hover:bg-gray-100 text-red-500">
                                            <svg class="w-4 h-4 mr-2" viewbox="0 0 14 15" fill="none"
                                                xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                                                <path fill-rule="evenodd" clip-rule="evenodd" fill="currentColor"
                                                    d="M6.09922 0.300781C5.93212 0.30087 5.76835 0.347476 5.62625 0.435378C5.48414 0.523281 5.36931 0.649009 5.29462 0.798481L4.64302 2.10078H1.59922C1.36052 2.10078 1.13161 2.1956 0.962823 2.36439C0.79404 2.53317 0.699219 2.76209 0.699219 3.00078C0.699219 3.23948 0.79404 3.46839 0.962823 3.63718C1.13161 3.80596 1.36052 3.90078 1.59922 3.90078V12.9008C1.59922 13.3782 1.78886 13.836 2.12643 14.1736C2.46399 14.5111 2.92183 14.7008 3.39922 14.7008H10.5992C11.0766 14.7008 11.5344 14.5111 11.872 14.1736C12.2096 13.836 12.3992 13.3782 12.3992 12.9008V3.90078C12.6379 3.90078 12.8668 3.80596 13.0356 3.63718C13.2044 3.46839 13.2992 3.23948 13.2992 3.00078C13.2992 2.76209 13.2044 2.53317 13.0356 2.36439C12.8668 2.1956 12.6379 2.10078 12.3992 2.10078H9.35542L8.70382 0.798481C8.62913 0.649009 8.5143 0.523281 8.37219 0.435378C8.23009 0.347476 8.06631 0.30087 7.89922 0.300781H6.09922ZM4.29922 5.70078C4.29922 5.46209 4.39404 5.23317 4.56282 5.06439C4.73161 4.8956 4.96052 4.80078 5.19922 4.80078C5.43791 4.80078 5.66683 4.8956 5.83561 5.06439C6.0044 5.23317 6.09922 5.46209 6.09922 5.70078V11.1008C6.09922 11.3395 6.0044 11.5684 5.83561 11.7372C5.66683 11.906 5.43791 12.0008 5.19922 12.0008C4.96052 12.0008 4.73161 11.906 4.56282 11.7372C4.39404 11.5684 4.29922 11.3395 4.29922 11.1008V5.70078ZM8.79922 4.80078C8.56052 4.80078 8.33161 4.8956 8.16282 5.06439C7.99404 5.23317 7.89922 5.46209 7.89922 5.70078V11.1008C7.89922 11.3395 7.99404 11.5684 8.16282 11.7372C8.33161 11.906 8.56052 12.0008 8.79922 12.0008C9.03791 12.0008 9.26683 11.906 9.43561 11.7372C9.6044 11.5684 9.69922 11.3395 9.69922 11.1008V5.70078C9.69922 5.46209 9.6044 5.23317 9.43561 5.06439C9.26683 4.8956 9.03791 4.80078 8.79922 4.80078Z" />
                                            </svg>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>



        <!-- Paginação -->
        <div class="flex flex-row items-center justify-center space-x-4 space-y-3 p-4" aria-label="Table navigation">
            <span class="text-sm font-normal text-gray-500 dark:text-gray-400">
                Total de Produtos:
                <span class="font-semibold text-gray-900 dark:text-white">{{ this.totalProdutos }}</span>
            </span>
            <ul class="flex flex-row justify-center pb-3">
                <li>
                    <button @click="decrementarPagina()" href="#"
                        class="flex items-center justify-center h-full py-1.5 px-3 ml-0 text-gray-500 bg-white rounded-l-lg border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">
                        <span class="sr-only">Anterior</span>
                        <svg class="w-5 h-5" aria-hidden="true" fill="currentColor" viewbox="0 0 20 20"
                            xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                d="M12.707 5.293a1 1 0 010 1.414L9.414 10l3.293 3.293a1 1 0 01-1.414 1.414l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 0z"
                                clip-rule="evenodd" />
                        </svg>
                    </button>
                </li>
                <li
                    class="flex items-center justify-center h-full py-1.5 px-3 ml-0 text-gray-500 bg-white border border-gray-300">
                    <span>Página {{this.page + 1}}</span>
                </li>
                <li>
                    <button @click="incrementarPagina()"
                        class="flex items-center justify-center h-full py-1.5 px-3 leading-tight text-gray-500 bg-white rounded-r-lg border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">
                        <span class="sr-only">Próximo</span>
                        <svg class="w-5 h-5" aria-hidden="true" fill="currentColor" viewbox="0 0 20 20"
                            xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
                                clip-rule="evenodd" />
                        </svg>
                    </button>
                </li>
            </ul>
        </div>
    </section>


    <!-- Paginação -->
</template>

<script>

import axios from "axios"
export default {
    data() {
        return {
            enviaProduto: {
                nome: '',
                preco: 0,
                descricao: '',
                codigo: '',
                estabelecimento: null
            },
            produtoSelecionado: {},
            produtos: [],
            produtoPesquisa: '',
            totalProdutos: 0,
            limitePagina: 20,
            page: 0,
            pagePesquisa: 0,
            ListaFilas: []
        }
    },

    methods: {
        async buscarProdutos() {
            try {
                const response = await axios.get("http://localhost:8080/produto", {
                    params: {
                        page: this.page,
                        size: 20,
                    }
                })
                this.produtos = response.data;
                this.getProdutoCount();
            } catch (error) {
                console.log(error);
            };
        },

        pesquisarProdutos() {
            this.produtoPesquisa = this.produtoPesquisa.toUpperCase();
            if (this.produtoPesquisa) {
                try {
                    axios
                        .get("http://localhost:8080/produto/ByNomeProduto", {
                            params: {
                                nome: this.produtoPesquisa,
                                quantidade: 99,
                            }
                        })
                        .then((response) => {
                            console.log(response.data);
                            this.produtos = response.data;
                            this.totalProdutos = response.data.length;
                        });
                } catch (error) {
                    console.log(error);
                };
            } else {
                this.buscarProdutos();
            }

        },

        async getProdutoCount() {
            const response = await axios.get('http://localhost:8080/produto/count');
            this.totalProdutos = response.data;
        },

        salvarProduto() {
            this.enviaProduto.nome = this.enviaProduto.nome.toUpperCase();

            try {
                axios
                    .post("http://localhost:8080/produto", this.enviaProduto)
                    .then(() => {
                        this.buscarProdutos();
                        this.closeModal('createProductModal');
                        this.enviaProduto = {
                            nome: '',
                            preco: 0,
                            descricao: '',
                            codigo: '',
                            estabelecimento: null
                        };
                    });
            } catch (error) {
                console.log('Erro ao salvar produto:', error);
            }
        },

        deletarProduto() {
            try {
                axios
                    .delete(`http://localhost:8080/produto/${this.produtoSelecionado.id}`)
                    .then(() => {
                        this.closeModal('deleteModal');
                        this.buscarProdutos();
                    });
            } catch (error) {
                console.log('Impossivel deletar produto:', error);
            };
        },

        EditarProduto() {
            try {
                this.produtoSelecionado.nome = this.produtoSelecionado.nome.toUpperCase();
                axios
                    .put(`http://localhost:8080/produto/${this.produtoSelecionado.id}`, this.produtoSelecionado)
                    .then(() => {
                        this.closeModal('updateProductModal');
                        this.buscarProdutos();
                    });
            } catch (error) {
                console.log('Impossivel deletar produto:', error);
            };
        },

        incrementarPagina() {
            if (this.totalProdutos >= this.limitePagina) {
                this.page += 1;
                this.limitePagina += 20;
                this.buscarProdutos();
            }

        },

        decrementarPagina() {
            if (this.page > 0) {
                this.page -= 1;
                this.limitePagina -= 20;
                this.buscarProdutos();
            }
        },

        openModal(idModal, produto) {
            var modalBackdrop = document.getElementById('modalBackdrop');
            var modal = document.getElementById(`${idModal}`);
            modalBackdrop.classList.remove('hidden');
            modal.classList.remove('hidden');
            this.produtoSelecionado = Object.assign({}, produto);
        },

        // Função para fechar o modal
        closeModal(idModal) {
            var modalBackdrop = document.getElementById('modalBackdrop');
            var modal = document.getElementById(idModal);

            modal.classList.add('hidden');
            if (idModal !== 'modalFila' && idModal !== 'modalFila2') {
                modalBackdrop.classList.add('hidden');
            }
        }
    },

    mounted() {
        this.buscarProdutos();
    },
}
</script>       