package com.example.Autonomo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Autonomo.Entity.OrdenDeCompra;
import com.example.Autonomo.Repository.OrdenDeCompraRepository;

@Service
public class OrdenCompraService {

    @Autowired
    private OrdenDeCompraRepository ordenCompraRepository;

    // Obtener todas las órdenes de compra
    public List<OrdenDeCompra> getAllOrdenesCompra() {
        return ordenCompraRepository.findAll();
    }

    // Obtener una orden de compra por su ID
    public Optional<OrdenDeCompra> getOrdenCompraById(Long Id) {
        return ordenCompraRepository.findById(Id);
    }

    // Crear una nueva orden de compra
    public OrdenDeCompra createOrdenCompra(OrdenDeCompra ordenCompra) {
        return ordenCompraRepository.save(ordenCompra);
    }

    // Actualizar una orden de compra
    public OrdenDeCompra updateOrdenCompra(Long Id, OrdenDeCompra ordenCompra) {
        if (ordenCompraRepository.existsById(Id)) {
            ordenCompra.setIdOrdenCompra(Id); 
            return ordenCompraRepository.save(ordenCompra);
        }
        return null;
    }

    // Eliminar una orden de compra
    public void deleteOrdenCompra(Long Id) {
        ordenCompraRepository.deleteById(Id);
    }
}
