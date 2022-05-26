package com.example.tiendacarlos.principal.routes;


import com.example.tiendacarlos.entities.Pedidos;
import com.example.tiendacarlos.entities.Productos;
import com.example.tiendacarlos.services.CartServices;
import com.example.tiendacarlos.services.jpaservices.PedidoService;
import com.example.tiendacarlos.services.jpaservices.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Clase que se encarga de manejar las peticiones de la vista de carrito
 */
@RequestMapping("/carrito")
@Controller
public class CarritoRoute {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private CartServices cart = new CartServices();

    /**
     * Metodo que se encarga de redirigir a la vista de carrito
     * @param model
     * @param session
     * @return vista de carrito
     */
    @GetMapping("")
    public String carrito(Model model , HttpSession session){
        if(session.getAttribute("carrito") == null){
            return "redirect:/";
        }
        model.addAttribute("carrito", session.getAttribute("carrito"));
        return "carrito";
    }

    /**
     * Metodo que se encarga de añadir o quitar 1 producto o eliminar un producto del carrito
     * @param id
     * @param action
     * @param model
     * @param session
     * @param request
     * @return vista de carrito
     */
    @GetMapping("/{id}")
    public String carrito(@PathVariable(required = true)String id, @RequestParam(required = true)String action, Model model , HttpSession session , HttpServletRequest request){
        if(session.getAttribute("carrito" ) == null){
            session.setAttribute("carrito", new HashMap<Integer , Productos>());
        }
        if(action.equals("sumar")){

            cart.addProductToCart(id, session );
        }
        if(action.equals("restar")){
           cart.removeProductFromCart(id, session);
        }
        if(action.equals("borrar")) {
            //delete from cart
            cart.deleteProductFromCart(id ,session);

        }
        String ruta = request.getHeader("referer");
        System.out.println(ruta);
        return "redirect:"+ruta;
    }

    /**
     * metodo que realiza la compra del carrito si estas logeado
     * @param metodo
     * @param model
     * @param session
     * @return vista de factura
     */
    @PostMapping("/comprar")
    public String comprar(@Param(value = "metodo") String metodo , Model model , HttpSession session){
        if(session.getAttribute("usuario") == null){
            session.setAttribute("from" , "/carrito/comprar");
            return "redirect:/login";
        }
        if(session.getAttribute("carrito") == null){
            return "redirect:/";
        }
        Pedidos pedido = cart.buyProducts(session  , metodo);
        if(pedido != null){
            System.out.println(pedidoService.findById(pedido.getId()));
            model.addAttribute("pedido", pedido);
            model.addAttribute("detalle", pedido.getDetallesPedidosById());
            model.addAttribute("usuario", pedido.getUsuariosByIdUsuario());

        }
        return "factura";
    }
}

