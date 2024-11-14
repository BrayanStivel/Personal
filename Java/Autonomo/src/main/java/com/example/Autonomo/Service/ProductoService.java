package com.example.Autonomo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Autonomo.Entity.Producto;
import com.example.Autonomo.Repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(Long Id) {
        return productoRepository.findById(Id);
    }
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateProducto(Long Id, Producto producto) {
        if (productoRepository.existsById(Id)) {
            producto.setIdProducto(Id);
            return productoRepository.save(producto);
        }
        return null;
    }

    public void deleteProducto(Long Id) {
        productoRepository.deleteById(Id);
    }
}
