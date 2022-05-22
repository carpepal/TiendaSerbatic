package com.example.tiendacarlos.services.sql.interfaz.repository;

import com.example.tiendacarlos.entities.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Set;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos, Integer> {
//    Set<Pedidos> findAllPedidosByUsuario(int id);

    @Query(value="SELECT * FROM pedidos where pedidos.id_usuario = :Usuarioid" , nativeQuery = true)
//    @Query(value="select a from pedidos a where a.usuario.id = :id")
//    @Query("select a from pedidos a where a.usuario.id = :Usuarioid")
    Set<Pedidos> findAllPedidosByUsuario(@Param("Usuarioid") int Usuarioid);
}
