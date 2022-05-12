package com.example.tiendacarlos.principal;

import com.example.tiendacarlos.modelos.productos.ProductoDAO;
import com.example.tiendacarlos.modelos.productos.ProductoVO;
import com.example.tiendacarlos.modelos.usuarios.UsuarioDAO;
import com.example.tiendacarlos.modelos.usuarios.UsuarioVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@RequestMapping("/")
@Controller
public class Principal{

    @GetMapping("/")
    public String index(Model model , HttpSession session){
        String ruta = "index";
            ArrayList<ProductoVO> list = ProductoDAO.getProductos();
            model.addAttribute("list", list);

        return ruta;
    }

    @PostMapping("/login")
    public String login(@RequestParam(required = false) String email, @RequestParam(required = false) String password , Model model){
        if(email == null || password == null || email.isEmpty() || password.isEmpty()){
            return "login";
        }

        UsuarioVO usuario = UsuarioDAO.login(email, password);
        if(usuario != null){
            //add user to session
            model.addAttribute("usuario", usuario);
            return "index";
        }

        return "login";
    }

    @PostMapping(value = "/registro" , consumes = "application/x-www-form-urlencoded")
    public String registro(@RequestParam(required = false)HashMap<String, String> datos, Model model){
        if(datos == null){
            return "registro";
        }


        return null;
    }

    @GetMapping("/Carrito/{id}")
    public String carrito(@PathVariable(required = true)String id, @RequestParam(required = true)String action, Model model , HttpSession session){
        if(session.getAttribute("carrito" ) == null){
            session.setAttribute("carrito", new HashMap<Integer , ProductoVO>());
        }
        if(action.equals("sumar")){
            //add to cart
            HashMap<Integer, ProductoVO> carrito = (HashMap<Integer, ProductoVO>) session.getAttribute("carrito");
            if(carrito.containsKey(Integer.parseInt(id))){
                carrito.get(Integer.parseInt(id)).setCantidad(carrito.get(Integer.parseInt(id)).getCantidad() + 1);
            }else{
                carrito.put(Integer.parseInt(id), ProductoDAO.getProductoById(Integer.parseInt(id)));
            }
        }
        if(action.equals("restar")){
            //remove from cart
            HashMap<Integer, ProductoVO> carrito = (HashMap<Integer, ProductoVO>) session.getAttribute("carrito");
            if(carrito.containsKey(Integer.parseInt(id))){
                carrito.get(Integer.parseInt(id)).setCantidad(carrito.get(Integer.parseInt(id)).getCantidad() - 1);
                if(carrito.get(Integer.parseInt(id)).getCantidad() == 0){
                    carrito.remove(Integer.parseInt(id));
                }
            }
        }
        if(action.equals("borrar")) {
            //delete from cart
            HashMap<Integer, ProductoVO> carrito = (HashMap<Integer, ProductoVO>) session.getAttribute("carrito");
            carrito.remove(Integer.parseInt(id));
        }
        return "index";
    }
}
