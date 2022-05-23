package com.example.tiendacarlos.principal.routes;

import com.example.tiendacarlos.entities.Usuarios;
import com.example.tiendacarlos.services.sql.clases.UsuarioService;
import com.example.tiendacarlos.util.global_functions.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioRoute {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/guardar")
    public String guardar(Usuarios usuario, Model model  , HttpSession session){

        Usuarios saveUser = SessionUtil.mapUserSession(session , usuario);
        usuarioService.save(saveUser);
        System.out.println(usuario);
        return "redirect:/usuario";
    }


}