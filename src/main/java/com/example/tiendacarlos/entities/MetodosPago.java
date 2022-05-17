package com.example.tiendacarlos.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "metodos_pago", schema = "tienda_curso", catalog = "")
public class MetodosPago {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "metodo_pago")
    private String metodoPago;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetodosPago that = (MetodosPago) o;
        return id == that.id && Objects.equals(metodoPago, that.metodoPago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, metodoPago);
    }
}
