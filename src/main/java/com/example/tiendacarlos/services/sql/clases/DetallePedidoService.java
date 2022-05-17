package com.example.tiendacarlos.services.sql.clases;

import com.example.tiendacarlos.entities.DetallesPedido;
import com.example.tiendacarlos.services.sql.interfaz.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public void save(DetallesPedido detallePedido){
        detallePedidoRepository.save(detallePedido);
    }

    public DetallesPedido findById(int id){
        return detallePedidoRepository.findById(id).get();
    }

    public void delete(DetallesPedido detallePedido){
        detallePedidoRepository.delete(detallePedido);
    }
}


