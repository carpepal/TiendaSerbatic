package com.example.tiendacarlos.services.jpaservices;

import com.example.tiendacarlos.entities.Pedidos;
import com.example.tiendacarlos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Set;

/**
 * Clase con los metodos de base de datos para la entidad Pedidos
 */
@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    /**
     * Metodo para recoger un pedido por id
     * @param id
     * @return Pedidos
     */
    public Pedidos findById(int id){
        return pedidoRepository.findById(id).get();
    }

    /**
     * Metodo para guardar un pedido
     * @param pedido
     * @return Pedidos
     */
    @Transactional
    public Pedidos save(Pedidos pedido){
        return pedidoRepository.save(pedido);
    }

    /**
     * Metodo para Borrar un pedido
     * @param pedido
     */
    public void delete(Pedidos pedido){
        pedidoRepository.delete(pedido);
    }

    /**
     * Metodo para borrar todos los pedidos
     */
    public void deleteAll(){
        pedidoRepository.deleteAll();
    }

    /**
     * Metodo para recoger todos los pedidos
     */
    public Iterable<Pedidos> findAll(){
        return pedidoRepository.findAll();
    }

    /**
     * Metodo para recoger pedidos por el id del cliente
     * @param id
     * @return
     */
    public Set<Pedidos> findByCliente(int id){
        return pedidoRepository.findAllPedidosByUsuario(id);
    }


    /**
     * metodo para cancelar un pedido por su id
     * @param parseInt
     */
    public void cancelarPedido(int parseInt) {
        pedidoRepository.cancelarPedido(parseInt);
    }

    /**
     * metodo para recoger todos los pedidos por su estado
     * @param pendiente
     * @return
     */
    public ArrayList<Pedidos> findByEstado(String pendiente) {
        return (ArrayList<Pedidos>) pedidoRepository.findByEstado(pendiente);
    }
}
