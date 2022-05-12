package com.example.tiendacarlos.modelos.categoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "categorias")
@Table(name = "categorias")
public class CategoriaVO implements Serializable {
    @Id@GeneratedValue(strategy= javax.persistence.GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String descripcion;
}
