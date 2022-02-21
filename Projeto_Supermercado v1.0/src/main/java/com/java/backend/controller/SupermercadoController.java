package com.java.backend.controller;

import java.util.List;

import com.java.backend.model.Supermercado;
import com.java.backend.services.SupermercadoService;

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

@RequestMapping("/supermercado")
@RestController
public class SupermercadoController {
    @Autowired
    SupermercadoService service;

    @GetMapping
    public ResponseEntity<List<Supermercado>> getAllSupermercados(){ return service.getAllSupermercados(); }

    @GetMapping("/id")
    public ResponseEntity<Supermercado> getSupermercadoById(@RequestParam Integer id){ return service.getSupermercadoById(id); }

    @GetMapping("/nome")
    public ResponseEntity<List<Supermercado>> getSupermercadoByNome(@RequestParam String nome){ return service.getSupermercadoByNome(nome); }

    @PostMapping
    public ResponseEntity<Supermercado> createSupermercado(@RequestBody Supermercado supermercado){ return service.createSupermercado(supermercado); }

    @DeleteMapping("/id")
    public ResponseEntity<String> deleteSupermercado(@RequestParam Integer id){ return service.deleteSupermercado(id); }

    @PutMapping("/id")
    public void updateSupermercado(@RequestParam Integer id, @RequestBody Supermercado supermercado){ service.updateSupermercado(supermercado, id); }
}
