package com.example.tiendacarlos.services.sql.clases;

import com.example.tiendacarlos.models.pedido.PedidoVO;
import com.example.tiendacarlos.services.sql.interfaz.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoVO findById(int id){
        return pedidoRepository.findById(id).get();
    }

    public void save(PedidoVO pedido){
        pedidoRepository.save(pedido);
    }

    public void delete(PedidoVO pedido){
        pedidoRepository.delete(pedido);
    }

    public void deleteAll(){
        pedidoRepository.deleteAll();
    }

    public Iterable<PedidoVO> findAll(){
        return pedidoRepository.findAll();
    }

    public Iterable<PedidoVO> findByCliente(int id){
        return pedidoRepository.findAllPedidosByUsuario(id);
    }
}
