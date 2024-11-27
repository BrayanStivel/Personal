package com.example.ActCapas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ActCapas.dto.InventarioDTO;
import com.example.ActCapas.service.InventarioService;

@RestController
@RequestMapping("/inventarios")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    // Obtener todos los inventarios
    @GetMapping
    public List<InventarioDTO> findAll() {
        return inventarioService.findAll();
    }

    // Obtener un inventario por ID
    @GetMapping("/{id}")
    public InventarioDTO findById(@PathVariable Long id) {
        return inventarioService.findById(id);
    }

    // Crear un nuevo inventario
    @PostMapping
    public InventarioDTO save(@RequestBody InventarioDTO inventarioDTO) {
        return inventarioService.save(inventarioDTO);
    }

    // Actualizar un inventario por ID
    @PutMapping("/{id}")
    public InventarioDTO update(@PathVariable Long id, @RequestBody InventarioDTO inventarioDTO) {
        return inventarioService.update(id, inventarioDTO);
    }

    // Eliminar un inventario por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        inventarioService.delete(id);
    }
}
