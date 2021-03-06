package com.example.tiendacarlos.repository;

import com.example.tiendacarlos.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios , Integer> {

    Usuarios findByEmail(String Email);

    @Query(value = "SELECT * FROM usuarios WHERE usuarios.id_rol = ?1" , nativeQuery = true)
    ArrayList<Usuarios> findAllByRol(int rol);

}
