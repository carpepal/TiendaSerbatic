package com.example.tiendacarlos.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * Clase que representa una opción de menú
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "opciones_menu", schema = "tienda_curso", catalog = "")
public class OpcionesMenu {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "rol_id")
    private Integer rolId;
    @Basic
    @Column(name = "nombre_opcion")
    private String nombreOpcion;
    @Basic
    @Column(name = "url_opcion")
    private String urlOpcion;
    @ManyToOne
    @JoinColumn(name = "rol_id", referencedColumnName = "id" , insertable = false, updatable = false)
    private Roles rolesByRolId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getNombreOpcion() {
        return nombreOpcion;
    }

    public void setNombreOpcion(String nombreOpcion) {
        this.nombreOpcion = nombreOpcion;
    }

    public String getUrlOpcion() {
        return urlOpcion;
    }

    public void setUrlOpcion(String urlOpcion) {
        this.urlOpcion = urlOpcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpcionesMenu that = (OpcionesMenu) o;
        return id == that.id && Objects.equals(rolId, that.rolId) && Objects.equals(nombreOpcion, that.nombreOpcion) && Objects.equals(urlOpcion, that.urlOpcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rolId, nombreOpcion, urlOpcion);
    }

    public Roles getRolesByRolId() {
        return rolesByRolId;
    }

    public void setRolesByRolId(Roles rolesByRolId) {
        this.rolesByRolId = rolesByRolId;
    }
}
