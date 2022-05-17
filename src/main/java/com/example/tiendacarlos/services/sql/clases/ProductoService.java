package com.example.tiendacarlos.services.sql.clases;


import com.example.tiendacarlos.entities.Productos;
import com.example.tiendacarlos.services.sql.interfaz.IProductoService;
import com.example.tiendacarlos.services.sql.interfaz.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public Productos findById(int id) {

        return productoRepository.findById(id).isPresent() ? productoRepository.findById(id).get() : null;
    }

//    @Override
//    public Productos findByName(String name) {
//        return productoRepository.findByNombre(name);
//    }

    public ArrayList<Productos> findAll(){
        return (ArrayList<Productos>) productoRepository.findAll();
    }
}
