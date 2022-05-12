package com.example.tiendacarlos.modelos.menu;


import com.example.tiendacarlos.modelos.rol.RolVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "opciones_menu")
@Table(name = "opciones_menu")
public class OpcionesMenuVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    private RolVO rol;
    private String nombre_opcion;
    private String url_opcion;
}
