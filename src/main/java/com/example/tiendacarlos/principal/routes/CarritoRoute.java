package com.example.tiendacarlos.principal.routes;

import com.example.tiendacarlos.models.productos.ProductoVO;
import com.example.tiendacarlos.services.CartServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RequestMapping("/carrito")
@Controller
public class CarritoRoute {

    @GetMapping("/")
    public String carrito(Model model){
        return "carrito";
    }

    @GetMapping("/{id}")
    public String carrito(@PathVariable(required = true)String id, @RequestParam(required = true)String action, Model model , HttpSession session , HttpServletRequest request){
        if(session.getAttribute("carrito" ) == null){
            session.setAttribute("carrito", new HashMap<Integer , ProductoVO>());
        }
        if(action.equals("sumar")){

            CartServices.addProductToCart(id, session);
        }
        if(action.equals("restar")){
            CartServices.removeProductFromCart(id, session);
        }
        if(action.equals("borrar")) {
            //delete from cart
            CartServices.deleteProductFromCart(id ,session);

        }
        String ruta = request.getHeader("referer");
        System.out.println(ruta);
        return "redirect:"+ruta;
    }

    @GetMapping("/comprar")
    public String comprar(Model model){

        return "comprar";
    }
}

