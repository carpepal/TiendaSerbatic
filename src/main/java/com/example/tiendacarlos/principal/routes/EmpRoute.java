package com.example.tiendacarlos.principal.routes;


import com.example.tiendacarlos.entities.Pedidos;
import com.example.tiendacarlos.entities.Productos;
import com.example.tiendacarlos.entities.Usuarios;
import com.example.tiendacarlos.services.sql.clases.CategoriaService;
import com.example.tiendacarlos.services.sql.clases.PedidoService;
import com.example.tiendacarlos.services.sql.clases.ProductoService;
import com.example.tiendacarlos.services.sql.clases.UsuarioService;
import com.example.tiendacarlos.util.global_functions.GeneralUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RequestMapping("/emp")
@Controller
public class EmpRoute {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/clientes")
    public String clientes(Model model , HttpSession session) {
        if(session.getAttribute("usuario") == null || !(usuarioService.isAdmin((Usuarios)session.getAttribute("usuario")) || usuarioService.isEmp((Usuarios)session.getAttribute("usuario")))){
            return "redirect:/";
        }
        Usuarios usuario = new Usuarios();
        ArrayList<Usuarios> usuarios = usuarioService.findByRol(2);
        model.addAttribute("usuarios", usuarios);
        return "admin/clientes.html";
    }

    @PostMapping("/clientes/edit")
    public String postclientes(@ModelAttribute Usuarios usuario ,  Model model , HttpSession session) {
        if(session.getAttribute("usuario") == null || !(usuarioService.isAdmin((Usuarios)session.getAttribute("usuario")) || usuarioService.isEmp((Usuarios)session.getAttribute("usuario")))){
            return "redirect:/";
        }
        System.out.println(usuario);
        usuarioService.save(usuario);
        return "redirect:/admin/clientes";
    }



    @GetMapping("/perfil")
    public String perfil() {

        return "admin/perfil";
    }

    @GetMapping("/productos")
    public String productos(Model model , HttpSession session) {
        if(session.getAttribute("usuario") == null || !(usuarioService.isAdmin((Usuarios)session.getAttribute("usuario")) || usuarioService.isEmp((Usuarios)session.getAttribute("usuario")))){
            return "redirect:/";
        }
        model.addAttribute("categorias" , categoriaService.findAll());
        model.addAttribute("productos", productoService.findAll());
        return "admin/productos";
    }

    @ExceptionHandler(IllegalAccessException.class)
    @PostMapping("/productos/edit")
    public String postproductos(@ModelAttribute Productos producto , Model model , HttpSession session) throws IllegalAccessException {
        if(session.getAttribute("usuario") == null || !(usuarioService.isAdmin((Usuarios)session.getAttribute("usuario")) || usuarioService.isEmp((Usuarios)session.getAttribute("usuario")))){
            return "redirect:/";
        }
        System.out.println(producto);
        Productos finalProduct = (Productos) GeneralUtils.merge(productoService.findById(producto.getId()), producto);

        productoService.save((Productos) GeneralUtils.merge(productoService.findById(producto.getId()), producto));
        return "redirect:/admin/productos";
    }

    @GetMapping("/pedidos")
    public String pedidos(Model model , HttpSession session) {
        if(session.getAttribute("usuario") == null || !(usuarioService.isAdmin((Usuarios)session.getAttribute("usuario")) || usuarioService.isEmp((Usuarios)session.getAttribute("usuario")))){
            return "redirect:/";
        }

        ArrayList<Pedidos> pedidos = pedidoService.findByEstado("pendiente");

        model.addAttribute("pedidos", pedidos);
        return "admin/pedidos";
    }
}
