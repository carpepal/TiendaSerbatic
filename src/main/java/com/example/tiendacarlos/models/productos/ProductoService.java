package com.example.tiendacarlos.models.productos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public ProductoVO findById(int id) {

        return productoRepository.findById(id).get();
    }

    @Override
    public ProductoVO findByName(String name) {
        return productoRepository.findByNombre(name);
    }

    public ArrayList<ProductoVO> findAll(){
        return (ArrayList<ProductoVO>) productoRepository.findAll();
    }
}
