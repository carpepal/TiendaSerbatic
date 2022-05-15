package com.example.tiendacarlos.services;

import com.example.tiendacarlos.models.productos.ProductoDAO;
import com.example.tiendacarlos.models.productos.ProductoVO;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class CartServices {

    public static void addProductToCart(String id  , HttpSession session) {
        HashMap<Integer, ProductoVO> carrito = (HashMap<Integer, ProductoVO>) session.getAttribute("carrito");
        if(carrito.containsKey(Integer.parseInt(id))){
            if(carrito.get(Integer.parseInt(id)).getCantidad() < carrito.get(Integer.parseInt(id)).getStock())
            carrito.get(Integer.parseInt(id)).setCantidad(carrito.get(Integer.parseInt(id)).getCantidad() + 1);
        }else{
            ProductoVO producto = ProductoDAO.getProductoById(Integer.parseInt(id));
            producto.setCantidad(1);
            carrito.put(Integer.parseInt(id), producto);
        }
    }

    public static void removeProductFromCart(String id , HttpSession session) {
        HashMap<Integer, ProductoVO> carrito = (HashMap<Integer, ProductoVO>) session.getAttribute("carrito");
        if(carrito.containsKey(Integer.parseInt(id))){
            carrito.get(Integer.parseInt(id)).setCantidad(carrito.get(Integer.parseInt(id)).getCantidad() - 1);
            if(carrito.get(Integer.parseInt(id)).getCantidad() == 0){
                carrito.remove(Integer.parseInt(id));
            }
        }
    }

    public static void deleteProductFromCart(String id , HttpSession session) {
        HashMap<Integer, ProductoVO> carrito = (HashMap<Integer, ProductoVO>) session.getAttribute("carrito");
        carrito.remove(Integer.parseInt(id));
    }

    public static void clearCart(HttpSession session) {
        HashMap<Integer, ProductoVO> carrito = (HashMap<Integer, ProductoVO>) session.getAttribute("carrito");
        carrito.clear();
    }
}
