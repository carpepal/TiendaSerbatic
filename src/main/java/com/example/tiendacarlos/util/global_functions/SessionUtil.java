package com.example.tiendacarlos.util.global_functions;

import com.example.tiendacarlos.entities.Usuarios;

import javax.servlet.http.HttpSession;

/**
 * Clase que contiene funciones globales para la sesion
 */
public class SessionUtil {


    /**
     * funcion que valida si el usuario esta logueado
     * @param session
     * @return
     */
    public static boolean hasNotUserSession(HttpSession session){
        return session.getAttribute("usuario") == null;
    }


    /**
     * funcion que devuelve el usuario de la sesion
     * @param session
     * @return
     */
    public static Usuarios getUserSession(HttpSession session) {
        return (Usuarios) session.getAttribute("usuario");
    }
}
