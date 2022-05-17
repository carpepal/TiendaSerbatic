package com.example.tiendacarlos.services.sql.interfaz;

import com.example.tiendacarlos.entities.Productos;

public interface IProductoService {

    public Productos findById(int id);

//    public Productos findByName(String name);
}
