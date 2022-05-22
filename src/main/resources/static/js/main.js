

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