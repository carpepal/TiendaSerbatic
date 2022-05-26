package com.example.tiendacarlos.principal.routes;


import com.example.tiendacarlos.entities.Pedidos;
import com.example.tiendacarlos.entities.Productos;
import com.example.tiendacarlos.entities.Usuarios;
import com.example.tiendacarlos.services.jpaservices.CategoriaService;
import com.example.tiendacarlos.services.jpaservices.PedidoService;
import com.example.tiendacarlos.services.jpaservices.ProductoService;
import com.example.tiendacarlos.services.jpaservices.UsuarioService;
import com.example.tiendacarlos.util.global_functions.GeneralUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Clase que se encarga de manejar las peticiones de la vista de empleados
 */
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

    /**
     * Metodo que se encarga de cargar la vista predefinida
     * @return la vista predefinida
     */
    @RequestMapping("/")
    public String index() {
        return "/index";
    }

    /**
     * Este metodo se encarga de cargar la vista de los clientes/
     * @param model
     * @param session
     * @return la vista de los clientes
     */
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

    /**
     * Este metodo se encarga de editar los datos del cliente
     * @param model
     * @param session
     * @return la vista de los cliente
     */
    @PostMapping("/clientes/edit")
    public String postclientes(@ModelAttribute Usuarios usuario ,  Model model , HttpSession session) {
        if(session.getAttribute("usuario") == null || !(usuarioService.isAdmin((Usuarios)session.getAttribute("usuario")) || usuarioService.isEmp((Usuarios)session.getAttribute("usuario")))){
            return "redirect:/";
        }
        System.out.println(usuario);
        usuarioService.save(usuario);
        return "redirect:/emp/clientes";
    }


    /**
     * Este metodo se encarga de cargar la vista del perfil
     * @return la vista del perfil
     */
    @GetMapping("/perfil")
    public String perfil() {

        return "admin/perfil";
    }

    /**
     * Este metodo se encarga de cargar la vista de los productos
     * @param model
     * @param session
     * @return la vista de los productos
     */
    @GetMapping("/productos")
    public String productos(Model model , HttpSession session) {
        if(session.getAttribute("usuario") == null || !(usuarioService.isAdmin((Usuarios)session.getAttribute("usuario")) || usuarioService.isEmp((Usuarios)session.getAttribute("usuario")))){
            return "redirect:/";
        }
        model.addAttribute("categorias" , categoriaService.findAll());
        model.addAttribute("productos", productoService.findAll());
        return "admin/productos";
    }

    /**
     * Este metodo se encarga de editar los datos de un producto
     * @param model
     * @param session
     * @return la vista de los productos
     */
    @PostMapping("/productos/edit")
    public String postproductos(@ModelAttribute Productos producto , Model model , HttpSession session) throws IllegalAccessException {
        if(session.getAttribute("usuario") == null || !(usuarioService.isAdmin((Usuarios)session.getAttribute("usuario")) || usuarioService.isEmp((Usuarios)session.getAttribute("usuario")))){
            return "redirect:/";
        }
        System.out.println(producto);
        Productos finalProduct = (Productos) GeneralUtils.merge(productoService.findById(producto.getId()), producto);

        productoService.save((Productos) GeneralUtils.merge(productoService.findById(producto.getId()), producto));
        return "redirect:/emp/productos";
    }

    /**
     * Este metodo se encarga de cargar la vista de los pedidos
     * @param model
     * @param session
     * @return la vista de los pedidos
     */
    @GetMapping("/pedidos")
    public String pedidos(Model model , HttpSession session) {
        if(session.getAttribute("usuario") == null || !(usuarioService.isAdmin((Usuarios)session.getAttribute("usuario")) || usuarioService.isEmp((Usuarios)session.getAttribute("usuario")))){
            return "redirect:/";
        }

        ArrayList<Pedidos> pedidos = pedidoService.findByEstado("pendiente");

        model.addAttribute("pedidos", pedidos);
        return "admin/pedidos";
    }

    /**
     * Este metodo se encarga de editar los datos de los pedidos
     * @param model
     * @param session
     * @return la vista de los pedidos
     * @throws IllegalAccessException
     */
    @ExceptionHandler(IllegalAccessException.class)
    @PostMapping("/pedidos/edit")
    public String postpedidos(@ModelAttribute Pedidos pedido , Model model , HttpSession session) throws IllegalAccessException {
        if(session.getAttribute("usuario") == null || !(usuarioService.isAdmin((Usuarios)session.getAttribute("usuario")) || usuarioService.isEmp((Usuarios)session.getAttribute("usuario")))){
            return "redirect:/";
        }
        System.out.println(pedido);

        pedidoService.save((Pedidos)GeneralUtils.merge(pedidoService.findById(pedido.getId()), pedido));
        return "redirect:/emp/pedidos";
    }

}
