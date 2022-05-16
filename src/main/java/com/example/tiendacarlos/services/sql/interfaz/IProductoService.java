package com.example.tiendacarlos.services.sql.interfaz;

import com.example.tiendacarlos.models.productos.ProductoVO;

public interface IProductoService {

    public ProductoVO findById(int id);

    public ProductoVO findByName(String name);
}
