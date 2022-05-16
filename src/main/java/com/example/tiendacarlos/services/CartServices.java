package com.example.tiendacarlos.services;

import com.example.tiendacarlos.models.pedido.PedidoVO;
import com.example.tiendacarlos.models.productos.ProductoDAO;
import com.example.tiendacarlos.models.productos.ProductoVO;
import com.example.tiendacarlos.models.usuarios.UsuarioVO;
import com.example.tiendacarlos.services.sql.clases.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

public class CartServices {

    @Autowired
    public PedidoService pedidoService;

    public void addProductToCart(String id  , HttpSession session) {
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

    public void removeProductFromCart(String id , HttpSession session) {
        HashMap<Integer, ProductoVO> carrito = (HashMap<Integer, ProductoVO>) session.getAttribute("carrito");
        if(carrito.containsKey(Integer.parseInt(id))){
            carrito.get(Integer.parseInt(id)).setCantidad(carrito.get(Integer.parseInt(id)).getCantidad() - 1);
            if(carrito.get(Integer.parseInt(id)).getCantidad() == 0){
                carrito.remove(Integer.parseInt(id));
            }
        }
    }

    public void deleteProductFromCart(String id , HttpSession session) {
        HashMap<Integer, ProductoVO> carrito = (HashMap<Integer, ProductoVO>) session.getAttribute("carrito");
        carrito.remove(Integer.parseInt(id));
    }

    public void clearCart(HttpSession session) {
        HashMap<Integer, ProductoVO> carrito = (HashMap<Integer, ProductoVO>) session.getAttribute("carrito");
        carrito.clear();
    }

    public void buyProducts(HttpSession session) {
        PedidoVO pedido = new PedidoVO(0 , (UsuarioVO) session.getAttribute("usuario") ,new Timestamp(new Date().getTime()),"tarjeta","Pendiente" , "1" , 100);
        pedidoService.save(pedido);
    }
}
