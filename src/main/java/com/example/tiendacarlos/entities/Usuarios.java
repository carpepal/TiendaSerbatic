package com.example.tiendacarlos.entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuarios {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_rol")
    private Integer idRol;
    @Basic
    @NotNull
    @NotBlank
    @Column(name = "email")
    private String email;
    @Basic
    @NotBlank
    @NotNull(message = "El campo contraseña no puede estar vacio")
    @Size(min = 1 , max = 32 , message = "La contraseña debe tener entre 8 y 32 caracteres")
    @Column(name = "clave")
    private String clave;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "apellido1")
    private String apellido1;
    @Basic
    @Column(name = "apellido2")
    private String apellido2;
    @Basic
    @Column(name = "direccion")
    private String direccion;
    @Basic
    @Column(name = "provincia")
    private String provincia;
    @Basic
    @Column(name = "localidad")
    private String localidad;
    @Basic
    @Column(name = "telefono")
    private String telefono;
    @Basic
    @Column(name = "dni")
    private String dni;
    @OneToMany(mappedBy = "usuariosByIdUsuario")
    private Collection<Pedidos> pedidosById;
    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id" , insertable = false, updatable = false)
    private Roles rolesByIdRol;
    @OneToMany(mappedBy = "usuariosByIdUsuario")
    private Collection<Valoraciones> valoracionesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuarios usuarios = (Usuarios) o;
        return id == usuarios.id && Objects.equals(idRol, usuarios.idRol) && Objects.equals(email, usuarios.email) && Objects.equals(clave, usuarios.clave) && Objects.equals(nombre, usuarios.nombre) && Objects.equals(apellido1, usuarios.apellido1) && Objects.equals(apellido2, usuarios.apellido2) && Objects.equals(direccion, usuarios.direccion) && Objects.equals(provincia, usuarios.provincia) && Objects.equals(localidad, usuarios.localidad) && Objects.equals(telefono, usuarios.telefono) && Objects.equals(dni, usuarios.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idRol, email, clave, nombre, apellido1, apellido2, direccion, provincia, localidad, telefono, dni);
    }

    public Collection<Pedidos> getPedidosById() {
        return pedidosById;
    }

    public void setPedidosById(Collection<Pedidos> pedidosById) {
        this.pedidosById = pedidosById;
    }

    public Roles getRolesByIdRol() {
        return rolesByIdRol;
    }

    public void setRolesByIdRol(Roles rolesByIdRol) {
        this.rolesByIdRol = rolesByIdRol;
    }

    public Collection<Valoraciones> getValoracionesById() {
        return valoracionesById;
    }

    public void setValoracionesById(Collection<Valoraciones> valoracionesById) {
        this.valoracionesById = valoracionesById;
    }
}
