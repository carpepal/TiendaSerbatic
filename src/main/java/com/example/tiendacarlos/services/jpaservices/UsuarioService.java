package com.example.tiendacarlos.services.jpaservices;

import com.example.tiendacarlos.entities.Usuarios;
import com.example.tiendacarlos.repository.UsuarioRepository;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

    public Usuarios findById(int id) {
        return usuarioRepository.findById(id).get();
    }

    public Usuarios findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public ArrayList<Usuarios> findAll() {
        return (ArrayList<Usuarios>) usuarioRepository.findAll();
    }

    public Usuarios save(Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(int id) {
        usuarioRepository.deleteById(id);
    }

    public ArrayList<Usuarios> findByRol(int rol) {
        return (ArrayList<Usuarios>) usuarioRepository.findAllByRol(rol);
    }

    public Usuarios registrar(Usuarios usuario) {
        usuario.setClave(passwordEncryptor.encryptPassword(usuario.getClave()));
        return usuarioRepository.save(usuario);
    }

    public Usuarios login(Usuarios usuario) {
        Usuarios Usuarios = usuarioRepository.findByEmail(usuario.getEmail());
        if (Usuarios != null) {
            if (passwordEncryptor.checkPassword(usuario.getClave(), Usuarios.getClave())) {
                return Usuarios;
            }
        }
        return null;
    }

    public Boolean isAdmin(Usuarios usuario) {
        return usuario.getRolesByIdRol().getRol().equals("admin");
    }

    public Boolean isEmp(Usuarios usuario) {
        return usuario.getRolesByIdRol().getRol().equals("emp");
    }

    public ArrayList<Usuarios> findAllEmpleados() {
        return usuarioRepository.findAllByRol(18);
    }
}



