package com.example.Autonomo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Autonomo.Entity.Categoria;
import com.example.Autonomo.Repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todas las categorías
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    // Obtener una categoría por su ID
    public Optional<Categoria> getCategoriaById(Long Id) {
        return categoriaRepository.findById(Id);
    }

    // Crear una nueva categoría
    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Actualizar una categoría
    public Categoria updateCategoria(Long Id, Categoria categoria) {
        if (categoriaRepository.existsById(Id)) {
            categoria.setIdCategoria(Id);
            return categoriaRepository.save(categoria);
        }
        return null;
    }

    // Eliminar una categoría
    public void deleteCategoria(Long Id) {
        categoriaRepository.deleteById(Id);
    }
}
