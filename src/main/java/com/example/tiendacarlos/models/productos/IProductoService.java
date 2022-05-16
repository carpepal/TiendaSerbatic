package com.example.tiendacarlos.models.productos;

public interface IProductoService {

    public ProductoVO findById(int id);

    public ProductoVO findByName(String name);
}
