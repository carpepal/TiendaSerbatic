package com.example.tiendacarlos.principal;

import com.example.tiendacarlos.services.sql.clases.PedidoService;
import com.example.tiendacarlos.services.sql.clases.ProductoService;
import com.example.tiendacarlos.models.productos.ProductoVO;
import com.example.tiendacarlos.models.usuarios.UsuarioVO;
import com.example.tiendacarlos.services.CartServices;
import com.example.tiendacarlos.services.sql.clases.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@RequestMapping("/")
@Controller
public class Principal{

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/")
    public String index(Model model , HttpSession session){
        String ruta = "index";
        ArrayList<ProductoVO> list = productoService.findAll();
        model.addAttribute("list", list);
        System.out.println(pedidoService.findByCliente(5));
        return ruta;
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request , HttpSession session , Model model ){
        if(session.getAttribute("usuario") != null){
            return "redirect:".concat(request.getHeader("referer"));
        }
        model.addAttribute("usuario", new UsuarioVO());
        return "login";
    }
    @PostMapping("/login")
    public String login(UsuarioVO usuario,  Model model , HttpSession session){

        if(usuario.getEmail() == null || usuario.getPassword()== null || usuario.getEmail().isEmpty() || usuario.getPassword().isEmpty()){
            return "login";
        }
        UsuarioVO result = usuarioService.login(usuario);
        if(result != null){
            //add user to session
            session.setAttribute("usuario", result);
            if(session.getAttribute("from") != null){
                String from = (String) session.getAttribute("from");
                session.removeAttribute("from");
                return "redirect:".concat(from);
            }
            return "redirect:/";
        }

        return "login";
    }

    @GetMapping("/registro")
    public String registro(Model model , HttpSession session , HttpServletRequest request){
        if(session.getAttribute("usuario") != null){
            return "redirect:".concat(request.getHeader("referer"));
        }
        model.addAttribute("usuario", new UsuarioVO());
        return "registro";
    }
    @PostMapping(value = "/registro" , consumes = "application/x-www-form-urlencoded")
    public String registro(UsuarioVO usuario , Model model , HttpSession session){
        model.addAttribute("usuario", new UsuarioVO());
        if(usuario == null){
            return "registro";
        }
        if(usuario.getEmail() == null || usuario.getPassword()== null || usuario.getEmail().isEmpty() || usuario.getPassword().isEmpty()){
            return "registro";
        }
        UsuarioVO result = usuarioService.registrar(usuario);
        if(result != null){
           session.setAttribute("usuario", result);
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("usuario");
        return "redirect:/";
    }

    @GetMapping("/producto/{id}")
    public String producto(@PathVariable(required = true)String id, Model model){
        ProductoVO producto = productoService.findById(Integer.parseInt(id));
        model.addAttribute("producto", producto);
        return "producto";
    }
}
