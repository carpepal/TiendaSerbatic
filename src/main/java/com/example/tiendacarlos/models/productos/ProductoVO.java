package com.example.tiendacarlos.models.productos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "productos")
@Table(name = "productos")
public class ProductoVO implements Serializable {
	@Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Integer id;

	private String nombre;
	private String descripcion;
	private Double impuesto;
	private float precio;
	private Integer stock;
	private Date fecha_alta;
	private Date fecha_baja;
	private Integer id_categoria;
	private String imagen;

	@Transient
	private int cantidad = 0;

}
