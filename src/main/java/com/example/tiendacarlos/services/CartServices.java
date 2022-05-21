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
import java.util.*;

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
        calcularTotal(session);
    }

    public void removeProductFromCart(String id , HttpSession session ) {
        HashMap<Integer, Productos> carrito = (HashMap<Integer, Productos>) session.getAttribute("carrito");
        if(carrito.containsKey(Integer.parseInt(id))){
            carrito.get(Integer.parseInt(id)).setCantidad(carrito.get(Integer.parseInt(id)).getCantidad() - 1);
            if(carrito.get(Integer.parseInt(id)).getCantidad() == 0){
                carrito.remove(Integer.parseInt(id));
            }
        }
        calcularTotal(session);
    }

    public void deleteProductFromCart(String id , HttpSession session) {
        HashMap<Integer, Productos> carrito = (HashMap<Integer, Productos>) session.getAttribute("carrito");
        carrito.remove(Integer.parseInt(id));
        calcularTotal(session);
    }

    public void clearCart(HttpSession session) {
        HashMap<Integer, Productos> carrito = (HashMap<Integer, Productos>) session.getAttribute("carrito");
        carrito.clear();
        calcularTotal(session);
    }

    public void calcularTotal(HttpSession session){
        Double total = 0.0;
        HashMap<Integer, Productos> carrito = (HashMap<Integer, Productos>) session.getAttribute("carrito");
        for(Productos p : carrito.values()){
            total += p.getPrecio() * p.getCantidad();
        }
        session.setAttribute("total", total);
    }

    public Pedidos buyProducts(HttpSession session  , String metodo) {
        Pedidos pedido = new Pedidos(0 , (Usuarios) session.getAttribute("usuario") ,metodo,"Pendiente" , "1" , 100);
        pedido.setIdUsuario(((Usuarios) session.getAttribute("usuario")).getId());
        Set<DetallesPedido> detalles = new HashSet<>();

        pedido.setTotal(Double.parseDouble(session.getAttribute("total").toString()));
        pedido= pedidoService.save(pedido);
        //impuesto not nullable
        for(Productos producto :( (HashMap<Integer, Productos>) session.getAttribute("carrito")).values()) {
            detalles.add(new DetallesPedido(0, producto.getId(), pedido.getId() , producto.getPrecio(), producto.getCantidad() , producto.getImpuesto(),
                    (producto.getCantidad() * producto.getPrecio()) , producto));
        }
        pedido.setDetallesPedidosById(detalles);
        clearCart(session);
        return pedidoService.save(pedido);

    }
}
