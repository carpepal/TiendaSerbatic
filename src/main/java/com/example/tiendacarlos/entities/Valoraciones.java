package com.example.tiendacarlos.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Valoraciones {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic
    @Column(name = "valoracion")
    private Integer valoracion;
    @Basic
    @Column(name = "comentario")
    private String comentario;
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id" , insertable = false, updatable = false)
    private Productos productosByIdProducto;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id" , insertable = false, updatable = false)
    private Usuarios usuariosByIdUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Valoraciones that = (Valoraciones) o;
        return id == that.id && Objects.equals(idProducto, that.idProducto) && Objects.equals(idUsuario, that.idUsuario) && Objects.equals(valoracion, that.valoracion) && Objects.equals(comentario, that.comentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idProducto, idUsuario, valoracion, comentario);
    }

    public Productos getProductosByIdProducto() {
        return productosByIdProducto;
    }

    public void setProductosByIdProducto(Productos productosByIdProducto) {
        this.productosByIdProducto = productosByIdProducto;
    }

    public Usuarios getUsuariosByIdUsuario() {
        return usuariosByIdUsuario;
    }

    public void setUsuariosByIdUsuario(Usuarios usuariosByIdUsuario) {
        this.usuariosByIdUsuario = usuariosByIdUsuario;
    }
}
