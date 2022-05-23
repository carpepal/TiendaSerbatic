package com.example.tiendacarlos.principal;

import com.example.tiendacarlos.entities.Productos;
import com.example.tiendacarlos.entities.Usuarios;
import com.example.tiendacarlos.services.sql.clases.CategoriaService;
import com.example.tiendacarlos.services.sql.clases.PedidoService;
import com.example.tiendacarlos.services.sql.clases.ProductoService;
import com.example.tiendacarlos.services.sql.clases.UsuarioService;
import com.example.tiendacarlos.services.sql.interfaz.repository.CategoryRepository;
import com.example.tiendacarlos.util.global_functions.SessionUtil;
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

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public String index(Model model , HttpSession session){
        String ruta = "index";
        ArrayList<Productos> list = productoService.findAll();
        model.addAttribute("list", list);
        model.addAttribute("categorias", categoriaService.findAll());
        System.out.println(pedidoService.findAll());
        System.out.println(servletContext.getRealPath("/"));
        return ruta;
    }

    @GetMapping("/productos")
    public String productos(@RequestParam(name="categoria") String categoria ,Model model , HttpSession session){
        String ruta = "productos";
        ArrayList<Productos> list = productoService.findAllByCategoria(categoria);
        model.addAttribute("categorias", categoriaService.findAll());
        model.addAttribute("list", list);
        return "index";

    }

    @GetMapping("/login")
    public String login(HttpServletRequest request , HttpSession session , Model model ){
        if(session.getAttribute("usuario") != null){
            return "redirect:".concat(request.getHeader("referer"));
        }
        model.addAttribute("Usuario", new Usuarios());
        return "login";
    }
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute  Usuarios usuario, BindingResult bindingResult , HttpSession session , Model model){

        if(bindingResult.hasErrors()){
            System.out.println(bindingResult);
            model.addAttribute("Usuario", usuario);
            return "login";
        }
        if(usuario.getEmail() == null || usuario.getClave()== null || usuario.getEmail().isEmpty() || usuario.getClave().isEmpty()){
            return "login";
        }
        Usuarios result = usuarioService.login(usuario);
        if(result != null){
            session.setAttribute("usuario", result);

            if(usuarioService.isAdmin(result) || usuarioService.isEmp(result)){
                return "redirect:/emp/clientes";
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

    @GetMapping("/pedidos")
    public String pedidos(Model model , HttpSession session) {
        if (SessionUtil.hasNotUserSession(session)){
            return "redirect:/";
        }
        model.addAttribute("pedidos", pedidoService.findByCliente(((Usuarios) session.getAttribute("usuario")).getId()));
        return "pedidos";
    }




    @GetMapping("/usuario")
    public String user(Model model , HttpSession session){
        if(SessionUtil.hasNotUserSession(session)){
            return "redirect:/";
        }
        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "user";
    }

    @GetMapping("/error")
    public String error(Model model){
        model.addAttribute("error", "No se encontro la pagina");
        return "error";
    }


    @PostConstruct
    public void init() {


    }
}
