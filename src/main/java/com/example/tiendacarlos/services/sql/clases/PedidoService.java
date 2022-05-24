package com.example.tiendacarlos.services.sql.clases;

import com.example.tiendacarlos.entities.Pedidos;
import com.example.tiendacarlos.services.sql.interfaz.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Set;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedidos findById(int id){
        return pedidoRepository.findById(id).get();
    }

    @Transactional
    public Pedidos save(Pedidos pedido){
        return pedidoRepository.save(pedido);
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

    public Set<Pedidos> findByCliente(int id){
        return pedidoRepository.findAllPedidosByUsuario(id);
    }

    public void cancelarPedido(int parseInt) {
        pedidoRepository.cancelarPedido(parseInt);
    }

    public ArrayList<Pedidos> findByEstado(String pendiente) {
        return (ArrayList<Pedidos>) pedidoRepository.findByEstado(pendiente);
    }
}
