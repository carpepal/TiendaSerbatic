

function cancelarPedido(e){
    console.log(e.target.dataset.id);
    let flag = confirm("¿Está seguro que desea cancelar el pedido?");
    if(flag){
        let id = e.target.dataset.id;
        location.href = `/pedidos/cancelar/${id}`;

    }
}


function guardarPerfil({target}){
    if(confirm("estas seguro que quiere guardar los cambios?")){
        let form = document.querySelector('#userform');
        form.submit();
    }
}

function showPedido({target}){
    let id = target.dataset.id;
    if(id === undefined){
        id = target.parentElement.dataset.id;
    }
    location.href = `/pedidos/${id}`;
}

function deleteUser (e){
    e.preventDefault();
    if(confirm("¿Está seguro que desea eliminar el usuario?")){
        let id = e.target.dataset.id;

        location.href = `/admin/clientes/delete?id=${id}`;
    }
}