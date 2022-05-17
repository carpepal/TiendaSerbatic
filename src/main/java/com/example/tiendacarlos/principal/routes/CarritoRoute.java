package com.example.tiendacarlos.principal.routes;


import com.example.tiendacarlos.entities.Productos;
import com.example.tiendacarlos.services.CartServices;
import com.example.tiendacarlos.services.sql.clases.PedidoService;
import com.example.tiendacarlos.services.sql.clases.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RequestMapping("/Carrito")
@Controller
public class CarritoRoute {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private CartServices cart = new CartServices();

    @GetMapping("")
    public String carrito(Model model){
        return "carrito";
    }

    @GetMapping("/{id}")
    public String carrito(@PathVariable(required = true)String id, @RequestParam(required = true)String action, Model model , HttpSession session , HttpServletRequest request){
        if(session.getAttribute("carrito" ) == null){
            session.setAttribute("carrito", new HashMap<Integer , Productos>());
        }
        if(action.equals("sumar")){

            cart.addProductToCart(id, session , productoService);
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

    @GetMapping("/comprar")
    public String comprar(Model model , HttpSession session){
        if(session.getAttribute("usuario") == null){
            session.setAttribute("from" , "/carrito/comprar");
            return "redirect:/login";
        }
        if(session.getAttribute("carrito") == null){
            return "redirect:/";
        }
        cart.buyProducts(session , pedidoService , productoService);
        return "comprar";
    }
}

