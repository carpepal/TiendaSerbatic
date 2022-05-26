package com.example.tiendacarlos.principal.routes;

import com.example.tiendacarlos.entities.Usuarios;
import com.example.tiendacarlos.services.jpaservices.UsuarioService;
import com.example.tiendacarlos.util.global_functions.GeneralUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Clase que se encaga de las rutas de usuario
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioRoute {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Metodo que guardar los cambios de un usuario
     * @param usuario
     * @param model
     * @param session
     * @return
     * @throws IllegalAccessException
     */
    @ExceptionHandler(IllegalAccessException.class)
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Usuarios usuario, Model model  , HttpSession session) throws IllegalAccessException {

        if(usuario.getId() != ((Usuarios)session.getAttribute("usuario")).getId()){
            return "redirect:/usuario";
        }
        Usuarios newUser = usuarioService.save((Usuarios)GeneralUtils.merge(usuarioService.findById(((Usuarios) session.getAttribute("usuario")).getId()) , usuario));
        System.out.println(usuario);
        session.setAttribute("usuario",newUser);
        return "redirect:/usuario";
    }


}
