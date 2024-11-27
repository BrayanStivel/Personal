package com.example.ActCapas.service.serviceimpl;

import com.example.ActCapas.dto.ClienteDTO;
import com.example.ActCapas.dto.OrdenCompraDTO;
import com.example.ActCapas.dto.ProductoDTO;
import com.example.ActCapas.entity.Cliente;
import com.example.ActCapas.entity.Producto;
import com.example.ActCapas.entity.OrdenCompra;
import com.example.ActCapas.repository.OrdenCompraRepository;
import com.example.ActCapas.service.ClienteService;
import com.example.ActCapas.service.OrdenCompraService;
import com.example.ActCapas.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ClienteService clienteService;

    @Override
    public List<OrdenCompraDTO> findAll() {
        return ordenCompraRepository.findAll().stream()
                .map(ordenCompra -> new OrdenCompraDTO(
                        ordenCompra.getOrdenCompraId(),
                        ordenCompra.getCliente().getId(),
                        ordenCompra.getProductos().stream().map(Producto::getId).collect(Collectors.toList()),
                        ordenCompra.getFecha()))
                .collect(Collectors.toList());
    }

    @Override
    public OrdenCompraDTO findById(Long id) {
        Optional<OrdenCompra> ordenCompra = ordenCompraRepository.findById(id);
        if (ordenCompra.isPresent()) {
            return new OrdenCompraDTO(
                    ordenCompra.get().getOrdenCompraId(),
                    ordenCompra.get().getCliente().getId(),
                    ordenCompra.get().getProductos().stream().map(Producto::getId).collect(Collectors.toList()),
                    ordenCompra.get().getFecha());
        }
        return null;
    }

    @Override
    public OrdenCompraDTO save(OrdenCompraDTO ordenCompraDTO) {
        // Obtener el cliente usando el clienteId del DTO
        ClienteDTO clienteDTO = clienteService.findById(ordenCompraDTO.getClienteId());
        if (clienteDTO == null) {
            return null;
        }

        // Convertir ClienteDTO a Cliente
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());

        // Obtener los productos usando los ids de productos del DTO
        List<ProductoDTO> productosDTO = ordenCompraDTO.getProductosIds().stream()
                .map(productoId -> productoService.findById(productoId))
                .collect(Collectors.toList());

        if (productosDTO.contains(null)) {
            return null;
        }

        // Convertir ProductoDTO a Producto
        List<Producto> productos = productosDTO.stream()
                .map(productoDTO -> {
                    Producto producto = new Producto();
                    producto.setId(productoDTO.getId());
                    return producto;
                })
                .collect(Collectors.toList());

        // Crear la nueva orden de compra
        OrdenCompra ordenCompra = new OrdenCompra();
        ordenCompra.setCliente(cliente);
        ordenCompra.setProductos(productos);
        ordenCompra.setFecha(ordenCompraDTO.getFecha());

        // Guardar la orden de compra en la base de datos
        ordenCompra = ordenCompraRepository.save(ordenCompra);

        // Convertir la entidad ordenCompra guardada en DTO y devolverla
        return new OrdenCompraDTO(
                ordenCompra.getOrdenCompraId(),
                ordenCompra.getCliente().getId(),
                ordenCompra.getProductos().stream().map(Producto::getId).collect(Collectors.toList()),
                ordenCompra.getFecha());
    }

    @Override
    public void delete(Long id) {
        ordenCompraRepository.deleteById(id);
    }
}
