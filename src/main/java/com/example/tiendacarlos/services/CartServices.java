package com.example.tiendacarlos.services;

import com.example.tiendacarlos.entities.DetallesPedido;
import com.example.tiendacarlos.entities.Pedidos;
import com.example.tiendacarlos.entities.Productos;
import com.example.tiendacarlos.entities.Usuarios;
import com.example.tiendacarlos.services.sql.clases.PedidoService;
import com.example.tiendacarlos.services.sql.clases.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

@Service
public class CartServices {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private PedidoService pedidoService;

    public void addProductToCart(String id  , HttpSession session ) {
        HashMap<Integer, Productos> carrito = (HashMap<Integer, Productos>) session.getAttribute("carrito");
        if(carrito.containsKey(Integer.parseInt(id))){
            if(carrito.get(Integer.parseInt(id)).getCantidad() < carrito.get(Integer.parseInt(id)).getStock())
            carrito.get(Integer.parseInt(id)).setCantidad(carrito.get(Integer.parseInt(id)).getCantidad() + 1);
        }else{
            Productos producto = productoService.findById(Integer.parseInt(id));
            producto.setCantidad(1);
            carrito.put(Integer.parseInt(id), producto);
        }
    }

    public void removeProductFromCart(String id , HttpSession session ) {
        HashMap<Integer, Productos> carrito = (HashMap<Integer, Productos>) session.getAttribute("carrito");
        if(carrito.containsKey(Integer.parseInt(id))){
            carrito.get(Integer.parseInt(id)).setCantidad(carrito.get(Integer.parseInt(id)).getCantidad() - 1);
            if(carrito.get(Integer.parseInt(id)).getCantidad() == 0){
                carrito.remove(Integer.parseInt(id));
            }
        }
    }

    public void deleteProductFromCart(String id , HttpSession session) {
        HashMap<Integer, Productos> carrito = (HashMap<Integer, Productos>) session.getAttribute("carrito");
        carrito.remove(Integer.parseInt(id));
    }

    public void clearCart(HttpSession session) {
        HashMap<Integer, Productos> carrito = (HashMap<Integer, Productos>) session.getAttribute("carrito");
        carrito.clear();
    }

    public void buyProducts(HttpSession session ) {
        Pedidos pedido = new Pedidos(0 , (Usuarios) session.getAttribute("usuario") ,"tarjeta","Pendiente" , "1" , 100);
        Collection<DetallesPedido> detalles = pedido.getDetallesPedidosById();
        for(Productos producto :( (HashMap<Integer, Productos>) session.getAttribute("carrito")).values()) {
            detalles.add(new DetallesPedido(0, pedido.getId()  , producto.getId() , producto.getPrecio(), producto.getCantidad() , producto.getImpuesto() , (producto.getCantidad() * producto.getPrecio()) * (producto.getImpuesto() / 100)));
        }
        pedidoService.save(pedido);
    }
}
