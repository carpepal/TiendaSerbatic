package com.example.tiendacarlos.modelos.detalle_pedido;

import com.example.tiendacarlos.modelos.pedido.PedidoVO;
import com.example.tiendacarlos.modelos.productos.ProductoVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "detalles_pedidos")
@Table(name = "detalles_pedido")
public class DetallesPedidosVO {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;


    @OneToOne(cascade = CascadeType.ALL)
    private PedidoVO pedidos;

    @OneToMany
    @JoinColumn(name = "id_producto")
    private Set<ProductoVO> productos;

    @Column(name = "precio_cantidad")
    private float precioUnidad;

    private int unidades;
    private float impuesto;
    private double total;
}
