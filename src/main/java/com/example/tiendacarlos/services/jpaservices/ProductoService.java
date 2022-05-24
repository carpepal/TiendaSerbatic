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


    /**
     * Metodo que busca un producto por su id
     * @param id
     * @return
     */
    public Productos findById(int id){
        return productoRepository.findById(id).get();
    }

    /**
     * Metodo que busca todos los productos
     * @return
     */
    public ArrayList<Productos> findAll(){
        return (ArrayList<Productos>) productoRepository.findAll();
    }

    /**
     * metodo para guardar un producto
     * @param producto
     */
    public void save(Productos producto) {
        productoRepository.save(producto);
    }

    /**
     * metodo para borrar un producto por su id
     * @param id
     */
    public void deleteById(int id) {
        productoRepository.deleteById(id);
    }

    /**
     * metodo para recoger todos los productos de una categoria
     * @param categoria
     * @return
     */
    public ArrayList<Productos> findAllByCategoria(String categoria) {
        return (ArrayList<Productos>) productoRepository.findAllByIdCategoria(Integer.parseInt(categoria));
    }
}
