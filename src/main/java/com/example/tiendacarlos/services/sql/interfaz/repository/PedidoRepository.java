package com.example.tiendacarlos.services.sql.interfaz.repository;

import com.example.tiendacarlos.entities.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos, Integer> {

//    @Query(value="SELECT * FROM pedidos where pedidos.id_usuario = 5" , nativeQuery = true)
//    @Query(value="select a from pedidos a where a.usuario.id = :id")
//    @Query("select a from pedidos a where a.usuario.id = :Usuarioid")
//    ArrayList<Pedidos> findAllPedidosByUsuario(@Param("Usuarioid") int Usuarioid);
}
