package com.example.tiendacarlos.principal;

import com.example.tiendacarlos.entities.Productos;
import com.example.tiendacarlos.entities.Usuarios;
import com.example.tiendacarlos.services.sql.clases.PedidoService;
import com.example.tiendacarlos.services.sql.clases.ProductoService;
import com.example.tiendacarlos.services.sql.clases.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/")
    public String index(Model model , HttpSession session){
        String ruta = "index";
        ArrayList<Productos> list = productoService.findAll();
        model.addAttribute("list", list);
//        System.out.println(pedidoService.findByCliente(5));
        System.out.println(pedidoService.findAll());
        System.out.println(servletContext.getRealPath("/"));
        return ruta;
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request , HttpSession session , Model model ){
        if(session.getAttribute("usuario") != null){
            return "redirect:".concat(request.getHeader("referer"));
        }
        model.addAttribute("usuario", new Usuarios());
        return "login";
    }
    @PostMapping("/login")
    public String login(@Valid Usuarios usuario, BindingResult bindingResult , HttpSession session , Model model){

        if(bindingResult.hasErrors()){
            System.out.println(bindingResult);
            return "redirect:/login";
        }
        if(usuario.getEmail() == null || usuario.getClave()== null || usuario.getEmail().isEmpty() || usuario.getClave().isEmpty()){
            return "login";
        }
        Usuarios result = usuarioService.login(usuario);
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
        model.addAttribute("usuario", new Usuarios());
        return "registro";
    }
    @PostMapping(value = "/registro" , consumes = "application/x-www-form-urlencoded")
    public String registro(Usuarios usuario , Model model , HttpSession session){
        model.addAttribute("usuario", new Usuarios());
        if(usuario == null){
            return "registro";
        }
        if(usuario.getEmail() == null || usuario.getClave()== null || usuario.getEmail().isEmpty() || usuario.getClave().isEmpty()){
            return "registro";
        }
        Usuarios result = usuarioService.registrar(usuario);
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
        Productos producto = productoService.findById(Integer.parseInt(id));
        model.addAttribute("producto", producto);
        return "producto";
    }



    @PostConstruct
    public void init() {


    }
}
