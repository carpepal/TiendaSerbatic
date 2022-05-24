package com.example.tiendacarlos.services.jpaservices;

import com.example.tiendacarlos.entities.Categorias;
import com.example.tiendacarlos.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoriaService {
    @Autowired
    private CategoryRepository categoriaRepository;

    public ArrayList<Categorias> findAll(){
        return (ArrayList<Categorias>) categoriaRepository.findAll();
    }



}
