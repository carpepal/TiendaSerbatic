package com.example.tiendacarlos.repository;

import com.example.tiendacarlos.entities.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categorias, Integer> {

}
