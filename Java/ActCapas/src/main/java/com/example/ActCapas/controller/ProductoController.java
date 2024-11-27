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

import com.example.ActCapas.dto.ProductoDTO;
import com.example.ActCapas.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductoDTO> findAll() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public ProductoDTO findById(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @PostMapping
    public ProductoDTO save(@RequestBody ProductoDTO productoDTO) {
        return productoService.save(productoDTO);
    }

    @PutMapping("/{id}")
    public ProductoDTO update(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        return productoService.update(id, productoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productoService.delete(id);
    }
}
