package com.example.ActCapas.service.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ActCapas.dto.CategoriaDTO;
import com.example.ActCapas.dto.ProductoDTO;
import com.example.ActCapas.dto.ProveedorDTO;
import com.example.ActCapas.entity.Categoria;
import com.example.ActCapas.entity.Producto;
import com.example.ActCapas.entity.Proveedor;
import com.example.ActCapas.repository.ProductoRepository;
import com.example.ActCapas.service.CategoriaService;
import com.example.ActCapas.service.ProductoService;
import com.example.ActCapas.service.ProveedorService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProveedorService proveedorService;

    @Override
    public List<ProductoDTO> findAll() {
        return productoRepository.findAll().stream()
                .map(producto -> new ProductoDTO(
                        producto.getId(),
                        producto.getNombre(),
                        producto.getDescripcion(),
                        producto.getPrecio(),
                        producto.getCategoria().getCategoriaId(),
                        producto.getProveedor().getProveedorId()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO findById(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            return new ProductoDTO(
                    producto.get().getId(),
                    producto.get().getNombre(),
                    producto.get().getDescripcion(),
                    producto.get().getPrecio(),
                    producto.get().getCategoria().getCategoriaId(),
                    producto.get().getProveedor().getProveedorId());
        }
        return null;
    }

    @Override
    public ProductoDTO save(ProductoDTO productoDTO) {
        // Validar si la categoría existe
        CategoriaDTO categoria = categoriaService.findById(productoDTO.getCategoriaId());
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria no encontrada con ID: " + productoDTO.getCategoriaId());
        }

        // Validar si el proveedor existe
        ProveedorDTO proveedor = proveedorService.findById(productoDTO.getProveedorId());
        if (proveedor == null) {
            throw new IllegalArgumentException("Proveedor no encontrado con ID: " + productoDTO.getProveedorId());
        }

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());

        // Establecer la categoría y proveedor
        Categoria categoriaEntity = new Categoria();
        categoriaEntity.setCategoriaId(categoria.getCategoriaId());
        producto.setCategoria(categoriaEntity);

        Proveedor proveedorEntity = new Proveedor();
        proveedorEntity.setProveedorId(proveedor.getProveedorId());
        producto.setProveedor(proveedorEntity);

        // Guardar el producto
        producto = productoRepository.save(producto);

        return new ProductoDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getCategoria().getCategoriaId(),
                producto.getProveedor().getProveedorId());
    }

    @Override
    public ProductoDTO update(Long id, ProductoDTO productoDTO) {
        Optional<Producto> existingProducto = productoRepository.findById(id);
        if (existingProducto.isPresent()) {
            Producto producto = existingProducto.get();

            // Actualizar la categoría y el proveedor
            CategoriaDTO categoria = categoriaService.findById(productoDTO.getCategoriaId());
            ProveedorDTO proveedor = proveedorService.findById(productoDTO.getProveedorId());

            producto.setNombre(productoDTO.getNombre());
            producto.setDescripcion(productoDTO.getDescripcion());
            producto.setPrecio(productoDTO.getPrecio());
            producto.setCategoria(new Categoria(categoria.getCategoriaId(), null, null));
            producto.setProveedor(new Proveedor(proveedor.getProveedorId(), null, null, null, null, null));

            productoRepository.save(producto);

            return new ProductoDTO(
                    producto.getId(),
                    producto.getNombre(),
                    producto.getDescripcion(),
                    producto.getPrecio(),
                    producto.getCategoria().getCategoriaId(),
                    producto.getProveedor().getProveedorId());
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
}
