package com.example.tiendacarlos.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Clase que representa la tabla Descuentos
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Descuentos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "codigo")
    private String codigo;
    @Basic
    @Column(name = "descuento")
    private Double descuento;
    @Basic
    @Column(name = "fecha_inicio")
    private Timestamp fechaInicio;
    @Basic
    @Column(name = "fecha_fin")
    private Timestamp fechaFin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descuentos that = (Descuentos) o;
        return id == that.id && Objects.equals(codigo, that.codigo) && Objects.equals(descuento, that.descuento) && Objects.equals(fechaInicio, that.fechaInicio) && Objects.equals(fechaFin, that.fechaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, descuento, fechaInicio, fechaFin);
    }
}
