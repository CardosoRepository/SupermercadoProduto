package com.java.backend.repository;

import java.util.List;

import com.java.backend.model.Supermercado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SupermercadoRepository extends JpaRepository<Supermercado, Integer>{
    List<Supermercado> findByNome(String nome);
}
