package com.example.tiendacarlos.models.descuento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "descuento")
@Table(name = "descuento")
public class DescuentoVO  implements Serializable {
    @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;

    private String codigo;
    private float descuento;
    private Timestamp fecha_inicio;
    private Timestamp fecha_fin;
}
