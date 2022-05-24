package com.example.tiendacarlos.services.jpaservices;

import com.example.tiendacarlos.entities.Usuarios;
import com.example.tiendacarlos.repository.UsuarioRepository;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Clase que implementa los servicios de usuario
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

    /**
     * Metodo que busca un usuario por su id
     * @param id
     * @return Usuarios
     */
    public Usuarios findById(int id) {
        return usuarioRepository.findById(id).get();
    }

    /**
     * Metodo que busca un usuario por su email
     * @param email
     * @return Usuarios
     */
    public Usuarios findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    /**
     * Metodo que busca todos los usuarios
     * @return lista de usuarios
     */
    public ArrayList<Usuarios> findAll() {
        return (ArrayList<Usuarios>) usuarioRepository.findAll();
    }

    /**
     * Metodo que guarda un usuario
     * @param usuario
     * @return Usuarios
     */
    public Usuarios save(Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Metodo que elimina un usuario
     * @param id
     */
    public void deleteById(int id) {
        usuarioRepository.deleteById(id);
    }


    /**
     * metodo que busca un usuario por su rol
     * @param rol
     * @return
     */
    public ArrayList<Usuarios> findByRol(int rol) {
        return (ArrayList<Usuarios>) usuarioRepository.findAllByRol(rol);
    }

    /**
     * metodo que registra un usuario
     * @param usuario
     * @return
     */
    public Usuarios registrar(Usuarios usuario) {
        usuario.setClave(passwordEncryptor.encryptPassword(usuario.getClave()));
        return usuarioRepository.save(usuario);
    }

    /**
     * metodo que comprueba si el usuario existe y la contraseña es correcta
     * @param usuario
     * @return Usuario
     */
    public Usuarios login(Usuarios usuario) {
        Usuarios Usuarios = usuarioRepository.findByEmail(usuario.getEmail());
        if (Usuarios != null) {
            if (passwordEncryptor.checkPassword(usuario.getClave(), Usuarios.getClave())) {
                return Usuarios;
            }
        }
        return null;
    }

    /**
     * metoodo que comprueba que el usuario es administrador
     * @param usuario
     * @return Boolean
     */
    public Boolean isAdmin(Usuarios usuario) {
        return usuario.getRolesByIdRol().getRol().equals("admin");
    }

    /**
     * metodo que comprueba que el usuario es empleado
     * @param usuario
     * @return Boolean
     */
    public Boolean isEmp(Usuarios usuario) {
        return usuario.getRolesByIdRol().getRol().equals("emp");
    }

    /**
     * metodo que devuelve todos los empleados
     * @return lista de usuarios
     */
    public ArrayList<Usuarios> findAllEmpleados() {
        return usuarioRepository.findAllByRol(18);
    }
}



