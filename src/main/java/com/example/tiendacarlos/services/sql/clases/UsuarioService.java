package com.example.tiendacarlos.services.sql.clases;

import com.example.tiendacarlos.models.usuarios.UsuarioVO;
import com.example.tiendacarlos.services.sql.interfaz.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<UsuarioVO> findById(int id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioVO findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public ArrayList<UsuarioVO> findAll() {
        return (ArrayList<UsuarioVO>) usuarioRepository.findAll();
    }

    public UsuarioVO save(UsuarioVO usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(int id) {
        usuarioRepository.deleteById(id);
    }

    public ArrayList<UsuarioVO> findByRol(int rol) {
        return (ArrayList<UsuarioVO>) usuarioRepository.findAllByRol(rol);
    }
}



