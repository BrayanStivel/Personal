package com.example.ActCapas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ActCapas.dto.OrdenCompraDTO;
import com.example.ActCapas.service.OrdenCompraService;

@RestController
@RequestMapping("/ordenesCompra")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @GetMapping
    public List<OrdenCompraDTO> findAll() {
        return ordenCompraService.findAll();
    }

    @GetMapping("/{ordenCompraId}")
    public OrdenCompraDTO findById(@PathVariable Long ordenCompraId) {
        return ordenCompraService.findById(ordenCompraId);
    }

    @PostMapping
    public OrdenCompraDTO save(@RequestBody OrdenCompraDTO ordenCompraDTO) {
        return ordenCompraService.save(ordenCompraDTO);
    }

    @DeleteMapping("/{ordenCompraId}")
    public void delete(@PathVariable Long ordenCompraId) {
        ordenCompraService.delete(ordenCompraId);
    }
}
