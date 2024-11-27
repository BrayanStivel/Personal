package com.example.Autonomo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Autonomo.Entity.Producto;
import com.example.Autonomo.Repository.OrdenDeCompraRepository;
import com.example.Autonomo.Repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private OrdenDeCompraRepository ordenDeCompraRepository;

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

    @Transactional
    public void deleteProducto(Long Id) {
        if (ordenDeCompraRepository.existsByProductoIdProducto(Id)) {
            throw new DataIntegrityViolationException("El producto no puede ser eliminado porque está asociado a una orden de compra.");
        }
        productoRepository.deleteById(Id);
    }
}
