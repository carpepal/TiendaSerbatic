package com.example.tiendacarlos.services.sql.clases;

import com.example.tiendacarlos.models.usuarios.UsuarioVO;
import com.example.tiendacarlos.services.sql.interfaz.repository.UsuarioRepository;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

    public UsuarioVO findById(int id) {
        return usuarioRepository.findById(id).get();
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

    public UsuarioVO registrar(UsuarioVO usuario) {
        usuario.setPassword(passwordEncryptor.encryptPassword(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public UsuarioVO login(UsuarioVO usuario) {
        UsuarioVO usuarioVO = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioVO != null) {
            if (passwordEncryptor.checkPassword(usuario.getPassword(), usuarioVO.getPassword())) {
                return usuarioVO;
            }
        }
        return null;
    }
}



