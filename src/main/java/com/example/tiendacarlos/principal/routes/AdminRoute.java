package com.example.tiendacarlos.principal.routes;

import com.example.tiendacarlos.entities.Usuarios;
import com.example.tiendacarlos.services.sql.clases.PedidoService;
import com.example.tiendacarlos.services.sql.clases.ProductoService;
import com.example.tiendacarlos.services.sql.clases.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@RequestMapping("/admin")
@Controller
public class AdminRoute {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/clientes/delete")
    public String delete(@RequestParam("id") int id, Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null || !((Usuarios) session.getAttribute("usuario")).getRolesByIdRol().getRol().equals("admin")) {
            return "redirect:/";
        }
        usuarioService.deleteById(id);
        return "redirect:/emp/clientes";
    }

    @GetMapping("/producto/delete")
    public String deleteProducto(@RequestParam("id") int id, Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null || !usuarioService.isAdmin((Usuarios) session.getAttribute("usuario"))) {
            return "redirect:/";
        }
        productoService.deleteById(id);
        return "redirect:/emp/productos";
    }

    @GetMapping("/pedidos/delete")
    public String deletePedido(@RequestParam("id") int id, Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null || !usuarioService.isAdmin((Usuarios) session.getAttribute("usuario"))) {
            return "redirect:/";
        }
        pedidoService.delete(pedidoService.findById(id));
        return "redirect:/emp/pedidos";
    }

    @GetMapping("/empleados")
    public String empleados(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null || !usuarioService.isAdmin((Usuarios) session.getAttribute("usuario"))) {
            return "redirect:/";
        }
        model.addAttribute("empleados", usuarioService.findAllEmpleados());
        return "admin/empleados";
    }

}
