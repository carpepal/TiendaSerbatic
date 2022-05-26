package com.example.tiendacarlos.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.Objects;

/**
 * Clase que representa un detalle de pedido
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalles_pedido", schema = "tienda_curso", catalog = "")
public class DetallesPedido {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_pedido")
    private Integer idPedido;
    @Basic
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic
    @Column(name = "precio_unidad")
    private Double precioUnidad;
    @Basic
    @Column(name = "unidades")
    private Integer unidades;
    @Basic
    @Column(name = "impuesto")
    private Double impuesto;
    @Basic
    @Column(name = "total")
    private Double total;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_pedido", insertable = false, updatable = false, referencedColumnName = "id")
    private Pedidos pedidosByIdPedido;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto", referencedColumnName = "id" , insertable = false, updatable = false)
    private Productos productosByIdProducto;

    public DetallesPedido(int id, int id_producto, int id_pedido ,  @DefaultValue(value="0")Double precio, @DefaultValue(value="0") Integer cantidad,@DefaultValue(value="0") double impuesto, @DefaultValue(value="0")double total  , Productos produto) {
        this.id = id;
        this.idPedido = id_pedido;
        this.idProducto = id_producto;
        this.precioUnidad = precio;
        this.unidades = cantidad;
        this.impuesto = impuesto;
        this.total = total;
        this.productosByIdProducto = produto;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
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
        DetallesPedido that = (DetallesPedido) o;
        return id == that.id && Objects.equals(idPedido, that.idPedido) && Objects.equals(idProducto, that.idProducto) && Objects.equals(precioUnidad, that.precioUnidad) && Objects.equals(unidades, that.unidades) && Objects.equals(impuesto, that.impuesto) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPedido, idProducto, precioUnidad, unidades, impuesto, total);
    }

    public Pedidos getPedidosByIdPedido() {
        return pedidosByIdPedido;
    }

    public void setPedidosByIdPedido(Pedidos pedidosByIdPedido) {
        this.pedidosByIdPedido = pedidosByIdPedido;
    }

    public Productos getProductosByIdProducto() {
        return productosByIdProducto;
    }

    public void setProductosByIdProducto(Productos productosByIdProducto) {
        this.productosByIdProducto = productosByIdProducto;
    }

    @Override
    public String toString() {
        return "DetallesPedido{" + "id=" + id + ", idPedido=" + idPedido + ", Producto=" + productosByIdProducto + ", precioUnidad=" + precioUnidad + ", unidades=" + unidades + ", impuesto=" + impuesto + ", total=" + total + ", Productos=" + productosByIdProducto + '}';
    }
}
