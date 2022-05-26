package com.example.tiendacarlos.principal;

import com.example.tiendacarlos.entities.Productos;
import com.example.tiendacarlos.entities.Usuarios;
import com.example.tiendacarlos.services.jpaservices.CategoriaService;
import com.example.tiendacarlos.services.jpaservices.PedidoService;
import com.example.tiendacarlos.services.jpaservices.ProductoService;
import com.example.tiendacarlos.services.jpaservices.UsuarioService;
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

/**
 * Clase que se encarga de manejar las peticiones de la vista principal
 */
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

    /**
     * Metodo que se encarga de manejar las peticiones de la vista principal
     * @param model
     * @param session
     * @return la vista principal
     */
    @GetMapping("/")
    public String index(Model model , HttpSession session){
        String ruta = "index";
        ArrayList<Productos> list = productoService.findAll();
        model.addAttribute("list", list);
        model.addAttribute("categorias", categoriaService.findAll());
        return ruta;
    }

    /**
     * Metodo que se encarga de manejar las peticiones de la vista principal de productos
     * @param model
     * @param session
     * @return la vista principal
     */
    @GetMapping("/productos")
    public String productos(@RequestParam(name="categoria") String categoria ,Model model , HttpSession session){
        String ruta = "productos";
        ArrayList<Productos> list = productoService.findAllByCategoria(categoria);
        model.addAttribute("categorias", categoriaService.findAll());
        model.addAttribute("list", list);
        return "index";

    }

    /**
     * Metodo que se encarga de manejar las peticiones de la vista de login
     * @param model
     * @param session
     * @return la vista de login
     */
    @GetMapping("/login")
    public String login(HttpServletRequest request , HttpSession session , Model model ){
        if(session.getAttribute("usuario") != null){
            return "redirect:".concat(request.getHeader("referer"));
        }
        model.addAttribute("Usuario", new Usuarios());
        return "login";
    }

    /**
     * Metodo que se encarga de recoger los datos del formulario de login
     * @param usuario
     * @param bindingResult
     * @param session
     * @param model
     * @return
     */
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

    /**
     * Metodo que se encarga de manejar las peticiones de la vista de registro
     * @param model
     * @param session
     * @param request
     * @return la vista de registro
     */
    @GetMapping("/registro")
    public String registro(Model model , HttpSession session , HttpServletRequest request){
        if(session.getAttribute("usuario") != null){
            return "redirect:".concat(request.getHeader("referer"));
        }
        model.addAttribute("usuario", new Usuarios());
        return "registro";
    }

    /**
     * Metodo que se encarga de recoger los datos del formulario de registro
     * @param usuario
     * @param model
     * @param session
     * @return la vista de registro
     */
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

    /**
     * Metodo que se encarga de manejar las peticiones de la vista de logout
     * @param session
     * @return redireciona a la vista principal
     */
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("usuario");
        return "redirect:/";
    }

    /**
     * Metodo que se encarga de manejar las peticiones de la vista de un producto en concretol
     * @param id
     * @param model
     * @return la vista de un producto
     */
    @GetMapping("/producto/{id}")
    public String producto(@PathVariable(required = true)String id, Model model){
        Productos producto = productoService.findById(Integer.parseInt(id));
        model.addAttribute("producto", producto);
        return "producto";
    }

    /**
     * Metodo que se encarga de manejar las peticiones de la vista de pedidos
     * @param model
     * @param session
     * @return la vista de pedidos
     */
    @GetMapping("/pedidos")
    public String pedidos(Model model , HttpSession session) {
        if (SessionUtil.hasNotUserSession(session)){
            return "redirect:/";
        }
        model.addAttribute("pedidos", pedidoService.findByCliente(((Usuarios) session.getAttribute("usuario")).getId()));
        return "pedidos";
    }



    /**
     * Metodo que se encarga de manejar las peticiones de la vista de el usuario
     * @param model
     * @param session
     * @return la vista de usuario
     */
    @GetMapping("/usuario")
    public String user(Model model , HttpSession session){
        if(SessionUtil.hasNotUserSession(session)){
            return "redirect:/";
        }
        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "user";
    }


    /**
     * vista general de errorres
     * @param model
     * @return
     */
    @GetMapping("/error")
    public String error(Model model){
        model.addAttribute("error", "No se encontro la pagina");
        return "error";
    }



}
