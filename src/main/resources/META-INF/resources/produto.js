document.addEventListener("DOMContentLoaded", () => {
    document.getElementById('formproduto').addEventListener('submit', (event) => {
        let formData = new FormData(document.getElementById('formproduto'));
    
    
    var methodType;
    if(formData.get('id').trim() == "")
        methodType = 'POST';
    else
        methodType = 'PUT';

    fetch('http://localhost:8080/produtos', {
        method: methodType,
        headers: [
            ["Content-Type", "application/json"],
        ],
        credentials: 'include',
        body: JSON.stringify(Object.fromEntries(formData))
    }).then(() => {
        getProdutos();
    }).catch(erro => console.log('Erro no submit'));
    document.getElementById('formproduto').reset();
    event.preventDefault();
    })

    getProdutos();
})

function getProdutos(){
    fetch('http://localhost:8080/produtos', {
        method: 'GET',
        headers: [
            ["Content-Type", "application/json"],
        ],
        credentials: 'include',
    }).then(response => {response.json().then(produto => {
        let tabela = limparTabela();
        produto.forEach((produto) => {
            var novaLinha = tabela.insertRow();
            novaLinha.innerHTML = `
            <td>${produto.descricao}</td>
            <td>${produto.codigoBarras}</td>
            <td>${produto.preco}</td>
            <td>
                <a href="#" onclick="return load('${produto.id}')">
                    <!--span style='font-size:40px;'>&#x270D;</span-->
                    <i class="fa-solid fa-pencil"></i>
                </a>
                <a href="#" onclick="return remove('${produto.id}')">
                    <i class="fa-solid fa-eraser"></i>
                </a>
            </td>
        `
        })
    })})
}

function limparTabela(){
    let table = document.getElementById("tableproduto");
    var rowCount = table.rows.length;
    for (var x = rowCount - 1; x > 0; x--) {
        table.deleteRow(x);
    }
    return table;
}

function remove(id){
    fetch("http://localhost:8080/produtos/"+id, {
        method: "DELETE",
        headers: [
            ["Content-Type", "application/json"],
        ],
        credentials: "include"
    }).then(response => {
        getProdutos();
    }).catch(erro => {
        console.log(erro);
    }); 
}

function load(id){
    fetch("http://localhost:8080/produtos/"+id, {
        method: "GET",
        headers: [
            ["Content-Type", "application/json"],
        ],
        credentials: "include"
    }).then(response => {
        response.json().then(produto=>{
            document.getElementById("id").value = produto.id;
            document.getElementById("txdescricao").value = produto.descricao;
            document.getElementById("txcodigobarras").value = produto.codigoBarras;
            document.getElementById("txpreco").value = produto.preco;
        })
    }).catch(erro => {
        console.log("erro no load");
    });
}
