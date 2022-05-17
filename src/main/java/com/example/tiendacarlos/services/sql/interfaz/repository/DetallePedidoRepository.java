package com.example.tiendacarlos.services.sql.interfaz.repository;

import com.example.tiendacarlos.entities.DetallesPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallesPedido, Integer> {
}
