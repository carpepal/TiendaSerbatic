package com.example.tiendacarlos.modelos.pedido;


import com.example.tiendacarlos.modelos.detalle_pedido.DetallesPedidosVO;
import com.example.tiendacarlos.modelos.usuarios.UsuarioVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pedidos")
@Table(name = "pedidos")
public class PedidoVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private UsuarioVO usuario;

    private Timestamp fecha;

    @Column(name = "metodo_pago")
    private String metodoPago;
    private String estado;
    private String num_factura;
    private double total;


}
