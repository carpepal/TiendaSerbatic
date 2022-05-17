package com.example.tiendacarlos.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Impuestos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "impuesto")
    private Double impuesto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Impuestos impuestos = (Impuestos) o;
        return id == impuestos.id && Objects.equals(impuesto, impuestos.impuesto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, impuesto);
    }
}
