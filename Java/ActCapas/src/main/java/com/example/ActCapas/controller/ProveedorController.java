package com.example.ActCapas.controller;

import com.example.ActCapas.dto.ProveedorDTO;
import com.example.ActCapas.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<ProveedorDTO> findAll() {
        return proveedorService.findAll();
    }

    @GetMapping("/{proveedorId}")
    public ProveedorDTO findById(@PathVariable Long proveedorId) {
        return proveedorService.findById(proveedorId);
    }

    @PostMapping
    public ProveedorDTO save(@RequestBody ProveedorDTO proveedorDTO) {
        return proveedorService.save(proveedorDTO);
    }

    @DeleteMapping("/{proveedorId}")
    public void delete(@PathVariable Long proveedorId) {
        proveedorService.delete(proveedorId);
    }
}
