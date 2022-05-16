package com.example.tiendacarlos.services.sql.clases;


import com.example.tiendacarlos.models.productos.ProductoVO;
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
    public ProductoVO findById(int id) {

        return productoRepository.findById(id).isPresent() ? productoRepository.findById(id).get() : null;
    }

    @Override
    public ProductoVO findByName(String name) {
        return productoRepository.findByNombre(name);
    }

    public ArrayList<ProductoVO> findAll(){
        return (ArrayList<ProductoVO>) productoRepository.findAll();
    }
}
