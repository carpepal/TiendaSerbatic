package com.example.tiendacarlos.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

/**
 * Clase que representa un pedido
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Pedidos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic
    @Column(name = "fecha")
    private Timestamp fecha;
    @Basic
    @Column(name = "metodo_pago")
    private String metodoPago;
    @Basic
    @Column(name = "estado")
    private String estado;
    @Basic
    @Column(name = "num_factura")
    private String numFactura;
    @Basic
    @Column(name = "total")
    private Double total;
    @OneToMany(mappedBy = "pedidosByIdPedido" , cascade = CascadeType.ALL)
    private Set<DetallesPedido> detallesPedidosById;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id" , insertable = false, updatable = false)
    private Usuarios usuariosByIdUsuario;

    public Pedidos(int id, Usuarios usuario, String tarjeta, String pendiente, String numFactura, int total) {

        this.id = id;
        this.usuariosByIdUsuario = usuario;
        this.fecha = new Timestamp(System.currentTimeMillis());
        this.metodoPago = tarjeta;
        this.estado = pendiente;
        this.numFactura = numFactura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedidos pedidos = (Pedidos) o;
        return id == pedidos.id && Objects.equals(idUsuario, pedidos.idUsuario) && Objects.equals(fecha, pedidos.fecha) && Objects.equals(metodoPago, pedidos.metodoPago) && Objects.equals(estado, pedidos.estado) && Objects.equals(numFactura, pedidos.numFactura) && Objects.equals(total, pedidos.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuario, fecha, metodoPago, estado, numFactura, total);
    }

    public Collection<DetallesPedido> getDetallesPedidosById() {
        return detallesPedidosById;
    }

    public void setDetallesPedidosById(Set<DetallesPedido> detallesPedidosById) {
        this.detallesPedidosById = detallesPedidosById;
    }

    public Usuarios getUsuariosByIdUsuario() {
        return usuariosByIdUsuario;
    }

    public void setUsuariosByIdUsuario(Usuarios usuariosByIdUsuario) {
        this.usuariosByIdUsuario = usuariosByIdUsuario;
    }

    @Override
    public String toString() {
        return "Pedidos{" + "id=" + id + ", idUsuario=" + idUsuario + ", fecha=" + fecha + ", metodoPago=" + metodoPago + ", estado=" + estado + ", detalles=" + detallesPedidosById + ", total=" + total + '}';
    }
}
