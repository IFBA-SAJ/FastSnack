document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("formcliente").addEventListener("reset", (evt) => {
        document.getElementById("erromensage").style.visibility = "hidden";
        document.getElementById("id").value = "";
    });
    document.getElementById("formcliente").addEventListener("submit", (evt) => {
        let formData = new FormData(document.getElementById("formcliente"));

        if (formData.get("id").trim() == "") {
            methodType = "POST";
            fetch("/cliente", {
                method: methodType,
                headers: [
                    ["Content-Type", "application/json"]
                ],
                credentials: "include",
                body: JSON.stringify(Object.fromEntries(formData))
            }).then((response) => {
                if(response.status === 400){
                    response.json().then((errorObj) => setErrors(errorObj));
                }else{
                    if(response.status === 201){
                        getClientes();                     
                    }
                    document.getElementById("formcliente").reset();
                }
            }).catch(erro => {
                console.log("erro no submit");    
            });        
    
        }else{
            id = formData.get("id").trim();
            methodType = "PUT";
            fetch("/cliente/"+id, {
                method: methodType,
                headers: [
                    ["Content-Type", "application/json"]
                ],
                credentials: "include",
                body: JSON.stringify(Object.fromEntries(formData))
            }).then((response) => {
                if(response.status === 400){
                    response.json().then((errorObj) => setErrors(errorObj));
                }else{
                    if(response.status === 204){
                        getClientes();                     
                    }
                    document.getElementById("formcliente").reset();
                }
            }).catch(erro => {
                console.log("erro no submit");
    
            });        

        }
        //enviar os dados para o sevidor
        evt.preventDefault();// evita o submit para não dar reload na tela já que os dados serão enviados pelo fetch
    });

    getClientes();
});


function showClientes(clientes){
    let table = limparTabela();
    clientes.forEach((cliente) => {
        var newRow = table.insertRow();
        newRow.innerHTML = `
            <td>${cliente.nome}</td>
            <td>${cliente.cpf}</td>
            <td>
                <a href="#" onclick="return load('${cliente.id}')">
                    <!--span style='font-size:40px;'>&#x270D;</span-->
                    <i class="fa-solid fa-pencil"></i>
                </a>
                <a href="#" onclick="return remove('${cliente.id}')">
                    <i class="fa-solid fa-eraser"></i>
                </a>
            </td>
        `;
    });
}
function getClientes(){
    fetch("/cliente", {
        method: "GET",
        headers: [
            ["Content-Type", "application/json"]
        ],
        credentials: "include"
    }).then(response => {
        response.json().then(clientes=>{
            showClientes(clientes);    
        });        
    }).catch(erro => {
        console.log("erro no getClientes");
    });
}

function limparTabela() {
    let table = document.getElementById("tablecliente");
    var rowCount = table.rows.length;
    for (var x = rowCount - 1; x > 0; x--) {
        table.deleteRow(x);
    }
    return table;
}

//chamar o servidor para excluir o cliente e atualizar a tabela
function remove(id){
    document.getElementById("formcliente").reset();
    fetch("/cliente/"+id, {
        method: "DELETE",
        headers: [
            ["Content-Type", "application/json"]
        ],
        credentials: "include"
    }).then(response => {
        if(response.status === 204){
            getClientes(); 
        }
    }).catch(erro => {
        console.log("erro no load");
    });
    
}

//chamar o servidor para obter os valores o cliente selecionado
//atualizar o formulario com esses valores
function load(id){
    document.getElementById("formcliente").reset();
    fetch("/cliente/"+id, {
        method: "GET",
        headers: [
            ["Content-Type", "application/json"]
        ],
        credentials: "include"
    }).then(response => {
        response.json().then(cliente=>{
            document.getElementById("id").value = cliente.id;
            document.getElementById("txnome").value = cliente.nome;
            document.getElementById("txcpf").value = cliente.cpf;
            document.getElementById("txendereco").value = cliente.endereco;
        })
    }).catch(erro => {
        console.log("erro no load");
    });
}
function setErrors(errorObj){
    document.getElementById("erromensage").innerHTML="";
    errorObj.violations.forEach( v => {document.getElementById("erromensage").innerHTML+= v.message+"<br>"})
    document.getElementById("erromensage").style.visibility = "visible";
}
