package com.java.backend.repository;

import com.java.backend.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Produto findByNome(String nome);
}
