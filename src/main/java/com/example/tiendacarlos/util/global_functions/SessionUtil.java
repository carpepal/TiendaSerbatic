package com.example.tiendacarlos.util.global_functions;

import com.example.tiendacarlos.entities.Usuarios;

import javax.servlet.http.HttpSession;

public class SessionUtil {


    public static boolean hasNotUserSession(HttpSession session){
        return session.getAttribute("usuario") == null;
    }

    public static Usuarios mapUserSession(HttpSession session , Usuarios userForm){
        Usuarios usuario = (Usuarios) session.getAttribute("usuario");
        userForm.setClave(usuario.getClave());
        userForm.setId(usuario.getId());
        userForm.setIdRol(usuario.getIdRol());

        return userForm;
    }

    public static Usuarios getUserSession(HttpSession session) {
        return (Usuarios) session.getAttribute("usuario");
    }
}
