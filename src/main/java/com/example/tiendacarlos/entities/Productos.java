package com.example.tiendacarlos.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

/**
 * Clase que representa un producto
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Productos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "precio")
    private Double precio;
    @Basic
    @Column(name = "stock")
    private Integer stock;
    @Basic
    @Column(name = "fecha_alta")
    private Timestamp fechaAlta;
    @Basic
    @Column(name = "fecha_baja")
    private Timestamp fechaBaja;
    @Basic
    @Column(name = "impuesto")
    private Double impuesto;
    @Basic
    @Column(name = "imagen")
    private String imagen;
    @OneToMany(mappedBy = "productosByIdProducto" , cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
    private Collection<DetallesPedido> detallesPedidosById;
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id" , insertable = false, updatable = false)
    private Categorias categoriasByIdCategoria;
    @OneToMany(mappedBy = "productosByIdProducto")
    private Collection<Valoraciones> valoracionesById;



    @Transient
    private Integer cantidad = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Timestamp getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Timestamp getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Timestamp fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productos productos = (Productos) o;
        return id == productos.id && Objects.equals(idCategoria, productos.idCategoria) && Objects.equals(nombre, productos.nombre) && Objects.equals(descripcion, productos.descripcion) && Objects.equals(precio, productos.precio) && Objects.equals(stock, productos.stock) && Objects.equals(fechaAlta, productos.fechaAlta) && Objects.equals(fechaBaja, productos.fechaBaja) && Objects.equals(impuesto, productos.impuesto) && Objects.equals(imagen, productos.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCategoria, nombre, descripcion, precio, stock, fechaAlta, fechaBaja, impuesto, imagen);
    }

    public Collection<DetallesPedido> getDetallesPedidosById() {
        return detallesPedidosById;
    }

    public void setDetallesPedidosById(Collection<DetallesPedido> detallesPedidosById) {
        this.detallesPedidosById = detallesPedidosById;
    }

    public Categorias getCategoriasByIdCategoria() {
        return categoriasByIdCategoria;
    }

    public void setCategoriasByIdCategoria(Categorias categoriasByIdCategoria) {
        this.categoriasByIdCategoria = categoriasByIdCategoria;
    }

    public Collection<Valoraciones> getValoracionesById() {
        return valoracionesById;
    }

    public void setValoracionesById(Collection<Valoraciones> valoracionesById) {
        this.valoracionesById = valoracionesById;
    }

    @Override
    public String toString(){
        return "Productos{" + "id=" + id + ", idCategoria=" + idCategoria + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + ", impuesto=" + impuesto + ", imagen=" + imagen + '}';

    }

}
