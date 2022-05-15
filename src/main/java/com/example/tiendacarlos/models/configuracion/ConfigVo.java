package com.example.tiendacarlos.models.configuracion;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "configuracion")
public class ConfigVo {

    @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;
    private String clave;
    private String valor;
    private String tipo;

}
