package com.example.tiendacarlos.services.sql.interfaz.repository;

import com.example.tiendacarlos.entities.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Integer> {
    ArrayList<Productos> findAllByIdCategoria(Integer idCategoria);

//    Productos findByNombre(String nombre);
    //update nombre , descripcion and stock of a product


}
