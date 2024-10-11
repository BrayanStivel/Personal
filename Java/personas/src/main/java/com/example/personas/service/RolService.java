package com.example.personas.service;

import com.example.personas.entity.Rol;
import com.example.personas.repository.RolRepository;
import com.example.personas.serviceinterface.RolServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements RolServiceInterface {

    @Autowired
    private RolRepository rolRepository;

    // Método para crear un nuevo rol
    @Override
    public Rol crearRol(Rol rol) {
        return rolRepository.save(rol);
    }

    // Método para obtener todos los roles
    @Override
    public List<Rol> obtenerTodosLosRoles() {
        return rolRepository.findAll();
    }
}
