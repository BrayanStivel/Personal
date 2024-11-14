package com.example.Autonomo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Autonomo.Entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
