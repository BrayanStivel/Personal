package com.example.personas.service;

import com.example.personas.model.Rol;
import com.example.personas.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    public Optional<Rol> obtenerRol(Long id) {
        return rolRepository.findById(id);
    }

    public Rol guardarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public Optional<Rol> actualizarRol(Long id, Rol rol) {
        return rolRepository.findById(id).map(r -> {
            r.setNombre(rol.getNombre());
            return rolRepository.save(r);
        });
    }

    public boolean eliminarRol(Long id) {
        if (rolRepository.existsById(id)) {
            rolRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
