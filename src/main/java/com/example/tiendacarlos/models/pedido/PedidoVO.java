package com.example.tiendacarlos.models.pedido;


import com.example.tiendacarlos.models.usuarios.UsuarioVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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


    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "id_usuario" , insertable = false , updatable = false , nullable = true)
    private UsuarioVO usuario;

    private Timestamp fecha;

    @Column(name = "metodo_pago")
    private String metodoPago;
    private String estado;
    private String num_factura;
    private double total;


}
