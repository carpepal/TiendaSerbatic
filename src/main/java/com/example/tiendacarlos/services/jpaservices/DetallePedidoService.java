package com.example.tiendacarlos.services.jpaservices;

import com.example.tiendacarlos.entities.DetallesPedido;
import com.example.tiendacarlos.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase con los metodos de base de datos para la entidad  DetallesPedido
 */
@Service
public class DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    /**
     * Guarda un detallePedido en la base de datos
     * @param detallePedido
     */
    public void save(DetallesPedido detallePedido){
        detallePedidoRepository.save(detallePedido);
    }

    /**
     * Bucar un detallePedido por su id
     * @param id
     * @return
     */
    public DetallesPedido findById(int id){
        return detallePedidoRepository.findById(id).get();
    }

    /**
     * Borrar un detallePedido por su el objeto
     * @param detallePedido
     */
    public void delete(DetallesPedido detallePedido){
        detallePedidoRepository.delete(detallePedido);
    }
}


