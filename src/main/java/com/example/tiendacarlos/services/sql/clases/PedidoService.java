package com.example.tiendacarlos.services.sql.clases;

import com.example.tiendacarlos.entities.Pedidos;
import com.example.tiendacarlos.services.sql.interfaz.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedidos findById(int id){
        return pedidoRepository.findById(id).get();
    }

    public void save(Pedidos pedido){
        pedidoRepository.save(pedido);
    }

    public void delete(Pedidos pedido){
        pedidoRepository.delete(pedido);
    }

    public void deleteAll(){
        pedidoRepository.deleteAll();
    }

    public Iterable<Pedidos> findAll(){
        return pedidoRepository.findAll();
    }

//    public Iterable<Pedidos> findByCliente(int id){
//        return pedidoRepository.findAllPedidosByUsuario(id);
//    }
}
