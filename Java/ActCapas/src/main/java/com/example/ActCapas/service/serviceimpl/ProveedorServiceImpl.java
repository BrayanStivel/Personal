package com.example.ActCapas.service.serviceimpl;

import com.example.ActCapas.dto.ProveedorDTO;
import com.example.ActCapas.entity.Proveedor;
import com.example.ActCapas.repository.ProveedorRepository;
import com.example.ActCapas.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<ProveedorDTO> findAll() {
        return proveedorRepository.findAll().stream()
                .map(proveedor -> new ProveedorDTO(proveedor.getProveedorId(), proveedor.getNombre(), proveedor.getTelefono(), proveedor.getEmail(), proveedor.getDireccion()))
                .collect(Collectors.toList());
    }

    @Override
    public ProveedorDTO findById(Long proveedorId) {
        Proveedor proveedor = proveedorRepository.findById(proveedorId).orElse(null);
        return proveedor != null ? new ProveedorDTO(proveedor.getProveedorId(), proveedor.getNombre(), proveedor.getTelefono(), proveedor.getEmail(), proveedor.getDireccion()) : null;
    }

    @Override
    public ProveedorDTO save(ProveedorDTO proveedorDTO) {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(proveedorDTO.getNombre());
        proveedor.setTelefono(proveedorDTO.getTelefono());
        proveedor.setEmail(proveedorDTO.getEmail());
        proveedor.setDireccion(proveedorDTO.getDireccion());
        proveedorRepository.save(proveedor);
        return new ProveedorDTO(proveedor.getProveedorId(), proveedor.getNombre(), proveedor.getTelefono(), proveedor.getEmail(), proveedor.getDireccion());
    }

    @Override
    public void delete(Long proveedorId) {
        proveedorRepository.deleteById(proveedorId);
    }
}
