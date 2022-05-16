package com.example.tiendacarlos.services.sql.interfaz.repository;

import com.example.tiendacarlos.models.usuarios.UsuarioVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioVO , Integer> {

    UsuarioVO findByEmail(String Email);

    @Query(value = "SELECT * FROM usuarios WHERE usuarios.id_rol = ?1" , nativeQuery = true)
    ArrayList<UsuarioVO> findAllByRol(int rol);

}
