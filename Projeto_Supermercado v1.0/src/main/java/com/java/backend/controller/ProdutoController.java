package com.java.backend.controller;

import java.util.List;

import javax.validation.Valid;

import com.java.backend.model.Produto;
import com.java.backend.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/produto")
@RestController
public class ProdutoController {
    @Autowired
    ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos(){ return service.getAllProdutos(); }

    @GetMapping("/id")
    public ResponseEntity<Produto> getProdutoById(@RequestParam Integer id){ return service.getProdutoById(id); }

    @GetMapping("/nome")
    public ResponseEntity<Produto> getProdutoByNome(@RequestParam String nome){ return service.getProdutoByNome(nome); }

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody @Valid Produto produto){ return service.createProduto(produto); }

    @DeleteMapping("/id")
    public ResponseEntity<String> deleteProduto(@RequestParam Integer id){ return service.deleteProduto(id); }

    @PutMapping("/id")
    public ResponseEntity<Produto> updateProduto(@RequestParam Integer id, @RequestBody Produto produto){ return service.updateProduto(produto, id); }
}
