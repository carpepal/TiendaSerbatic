package com.example.tiendacarlos.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Roles {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "rol")
    private String rol;
    @OneToMany(mappedBy = "rolesByRolId")
    private Collection<OpcionesMenu> opcionesMenusById;
    @OneToMany(mappedBy = "rolesByIdRol")
    private Collection<Usuarios> usuariosById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return id == roles.id && Objects.equals(rol, roles.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rol);
    }

    public Collection<OpcionesMenu> getOpcionesMenusById() {
        return opcionesMenusById;
    }

    public void setOpcionesMenusById(Collection<OpcionesMenu> opcionesMenusById) {
        this.opcionesMenusById = opcionesMenusById;
    }

    public Collection<Usuarios> getUsuariosById() {
        return usuariosById;
    }

    public void setUsuariosById(Collection<Usuarios> usuariosById) {
        this.usuariosById = usuariosById;
    }
}
