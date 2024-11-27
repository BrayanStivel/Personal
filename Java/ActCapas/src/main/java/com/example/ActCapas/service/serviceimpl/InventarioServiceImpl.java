package com.example.ActCapas.service.serviceimpl;

import com.example.ActCapas.dto.InventarioDTO;
import com.example.ActCapas.entity.Inventario;
import com.example.ActCapas.entity.Producto;
import com.example.ActCapas.repository.InventarioRepository;
import com.example.ActCapas.repository.ProductoRepository;
import com.example.ActCapas.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<InventarioDTO> findAll() {
        return inventarioRepository.findAll().stream()
                .map(inventario -> new InventarioDTO(
                        inventario.getId(),
                        inventario.getProducto().getId(),
                        inventario.getCantidad()))
                .collect(Collectors.toList());
    }

    @Override
    public InventarioDTO findById(Long id) {
        Optional<Inventario> inventario = inventarioRepository.findById(id);
        if (inventario.isPresent()) {
            return new InventarioDTO(
                    inventario.get().getId(),
                    inventario.get().getProducto().getId(),
                    inventario.get().getCantidad());
        }
        return null;
    }

    @Override
    public InventarioDTO save(InventarioDTO inventarioDTO) {
        // Verificar que el producto existe
        Optional<Producto> producto = productoRepository.findById(inventarioDTO.getProductoId());
        if (!producto.isPresent()) {
            throw new IllegalArgumentException("Producto no encontrado con ID: " + inventarioDTO.getProductoId());
        }

        // Crear inventario con el producto asociado
        Inventario inventario = new Inventario();
        inventario.setProducto(producto.get());
        inventario.setCantidad(inventarioDTO.getCantidad());

        inventario = inventarioRepository.save(inventario);

        return new InventarioDTO(
                inventario.getId(),
                inventario.getProducto().getId(),
                inventario.getCantidad());
    }

    @Override
    public InventarioDTO update(Long id, InventarioDTO inventarioDTO) {
        Optional<Inventario> existingInventario = inventarioRepository.findById(id);
        if (existingInventario.isPresent()) {
            Inventario inventario = existingInventario.get();
            inventario.setCantidad(inventarioDTO.getCantidad());
            inventarioRepository.save(inventario);

            return new InventarioDTO(
                    inventario.getId(),
                    inventario.getProducto().getId(),
                    inventario.getCantidad());
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        inventarioRepository.deleteById(id);
    }
}
