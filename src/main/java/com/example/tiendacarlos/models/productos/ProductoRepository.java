package com.example.tiendacarlos.models.productos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoVO, Integer> {

    ProductoVO findByNombre(String nombre);

}
