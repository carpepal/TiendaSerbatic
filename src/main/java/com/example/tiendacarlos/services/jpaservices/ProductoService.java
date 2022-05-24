package com.example.tiendacarlos.services.jpaservices;


import com.example.tiendacarlos.entities.Productos;
import com.example.tiendacarlos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductoService  {

    @Autowired
    ProductoRepository productoRepository;



//    @Override
//    public Productos findByName(String name) {
//        return productoRepository.findByNombre(name);
//    }
    public Productos findById(int id){
        return productoRepository.findById(id).get();
    }
    public ArrayList<Productos> findAll(){
        return (ArrayList<Productos>) productoRepository.findAll();
    }

    public void save(Productos producto) {
        productoRepository.save(producto);
    }

    public void deleteById(int id) {
        productoRepository.deleteById(id);
    }

    public ArrayList<Productos> findAllByCategoria(String categoria) {
        return (ArrayList<Productos>) productoRepository.findAllByIdCategoria(Integer.parseInt(categoria));
    }
}
