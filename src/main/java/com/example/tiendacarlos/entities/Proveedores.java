package com.example.tiendacarlos.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * Clase que representa la entidad Proveedores
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Proveedores {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "direccion")
    private String direccion;
    @Basic
    @Column(name = "localidad")
    private String localidad;
    @Basic
    @Column(name = "provincia")
    private String provincia;
    @Basic
    @Column(name = "telefono")
    private String telefono;
    @Basic
    @Column(name = "cif")
    private String cif;
    @Basic
    @Column(name = "email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedores that = (Proveedores) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(direccion, that.direccion) && Objects.equals(localidad, that.localidad) && Objects.equals(provincia, that.provincia) && Objects.equals(telefono, that.telefono) && Objects.equals(cif, that.cif) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, direccion, localidad, provincia, telefono, cif, email);
    }
}
