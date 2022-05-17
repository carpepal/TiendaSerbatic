package com.example.tiendacarlos.services.sql.interfaz.repository;

import com.example.tiendacarlos.entities.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Integer> {

//    Productos findByNombre(String nombre);

}
