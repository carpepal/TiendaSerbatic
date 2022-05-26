package com.example.tiendacarlos.repository;

import com.example.tiendacarlos.entities.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos, Integer> {
//    Set<Pedidos> findAllPedidosByUsuario(int id);

    @Query(value="SELECT * FROM pedidos where pedidos.id_usuario = :Usuarioid" , nativeQuery = true)
//    @Query(value="select a from pedidos a where a.usuario.id = :id")
//    @Query("select a from pedidos a where a.usuario.id = :Usuarioid")
    Set<Pedidos> findAllPedidosByUsuario(@Param("Usuarioid") int Usuarioid);

    @Transactional
    @Modifying
    @Query(value = " update Pedidos set estado = 'cancelado' where id = ?1")
    void cancelarPedido(int parseInt);

    @Transactional
    @Modifying
    @Query(value = " update Pedidos set estado = ?1 where id = ?2")
    void updateEstadoPedido(String estado , int parseInt);

    @Query("select p from Pedidos p where p.estado = ?1")
    List<Pedidos> findByEstado(String estado);
}
