package com.example.Autonomo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Autonomo.Entity.Proveedor;
import com.example.Autonomo.Repository.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Obtener todos los proveedores
    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    // Obtener un proveedor por su ID
    public Optional<Proveedor> getProveedorById(Long Id) {
        return proveedorRepository.findById(Id);
    }

    // Crear un nuevo proveedor
    public Proveedor createProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // Actualizar un proveedor
    public Proveedor updateProveedor(Long Id, Proveedor proveedor) {
        if (proveedorRepository.existsById(Id)) {
            proveedor.setIdProveedor(Id);
            return proveedorRepository.save(proveedor);
        }
        return null;
    }

    // Eliminar un proveedor
    public void deleteProveedor(Long Id) {
        proveedorRepository.deleteById(Id);
    }
}
