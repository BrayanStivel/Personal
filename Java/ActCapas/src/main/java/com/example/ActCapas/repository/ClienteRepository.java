package com.example.ActCapas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ActCapas.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
