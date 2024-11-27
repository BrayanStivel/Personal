package com.example.Autonomo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Autonomo.Entity.Proveedor;
import com.example.Autonomo.Repository.ProductoRepository;
import com.example.Autonomo.Repository.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    public Optional<Proveedor> getProveedorById(Long Id) {
        return proveedorRepository.findById(Id);
    }

    public Proveedor createProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor updateProveedor(Long Id, Proveedor proveedor) {
        if (proveedorRepository.existsById(Id)) {
            proveedor.setIdProveedor(Id);
            return proveedorRepository.save(proveedor);
        }
        return null;
    }

    @Transactional
    public void deleteProveedor(Long Id) {
        if (productoRepository.existsByProveedorIdProveedor(Id)) {
            throw new DataIntegrityViolationException("El proveedor no puede ser eliminado porque está asociado a uno o más productos.");
        }
        proveedorRepository.deleteById(Id);
    }
}
