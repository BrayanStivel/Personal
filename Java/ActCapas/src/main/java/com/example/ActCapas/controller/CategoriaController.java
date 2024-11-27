package com.example.ActCapas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ActCapas.dto.CategoriaDTO;
import com.example.ActCapas.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Obtener todas las categorías
    @GetMapping
    public List<CategoriaDTO> findAll() {
        return categoriaService.findAll();
    }

    // Obtener una categoría por ID
    @GetMapping("/{categoriaId}")
    public CategoriaDTO findById(@PathVariable Long categoriaId) {
        return categoriaService.findById(categoriaId);
    }

    // Crear una nueva categoría
    @PostMapping
    public CategoriaDTO save(@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.save(categoriaDTO);
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{categoriaId}")
    public void delete(@PathVariable Long categoriaId) {
        categoriaService.delete(categoriaId);
    }

    // Actualizar una categoría por ID
    @PutMapping("/{categoriaId}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Long categoriaId, @RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO updatedCategoria = categoriaService.update(categoriaId, categoriaDTO);
        if (updatedCategoria != null) {
            return ResponseEntity.ok(updatedCategoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
