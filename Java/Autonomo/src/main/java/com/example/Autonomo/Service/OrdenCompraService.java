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

    public List<OrdenDeCompra> getAllOrdenesCompra() {
        return ordenCompraRepository.findAll();
    }

    public Optional<OrdenDeCompra> getOrdenCompraById(Long Id) {
        return ordenCompraRepository.findById(Id);
    }

    public OrdenDeCompra createOrdenCompra(OrdenDeCompra ordenCompra) {
        return ordenCompraRepository.save(ordenCompra);
    }

    public OrdenDeCompra updateOrdenCompra(Long Id, OrdenDeCompra ordenCompra) {
        if (ordenCompraRepository.existsById(Id)) {
            ordenCompra.setIdOrdenCompra(Id);
            return ordenCompraRepository.save(ordenCompra);
        }
        return null;
    }

    public void deleteOrdenCompra(Long Id) {
        ordenCompraRepository.deleteById(Id);
    }
}
