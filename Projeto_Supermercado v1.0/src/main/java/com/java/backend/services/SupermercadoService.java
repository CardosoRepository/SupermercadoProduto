package com.java.backend.services;

import java.util.List;

import com.java.backend.model.Supermercado;
import com.java.backend.repository.SupermercadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SupermercadoService {
    @Autowired
    SupermercadoRepository repository;

    public ResponseEntity<List<Supermercado>> getAllSupermercados(){ return ResponseEntity.ok().body(repository.findAll()); }

    public ResponseEntity<Supermercado> getSupermercadoById(Integer id){ return ResponseEntity.ok().body(repository.findById(id).get()); }

    public ResponseEntity<List<Supermercado>> getSupermercadoByNome(String nome){ return ResponseEntity.ok().body(repository.findByNome(nome)); }

    public ResponseEntity<Supermercado> createSupermercado(Supermercado supermercado){ return new ResponseEntity<Supermercado>(repository.save(supermercado), HttpStatus.CREATED); }

    public ResponseEntity<String> deleteSupermercado(Integer id){
        repository.deleteById(id);
        return ResponseEntity.ok().body("Supermercado deletado");
    }

    public ResponseEntity<Supermercado> updateSupermercado(Supermercado supermercado, Integer id){
        return repository.findById(id)
                .map(registro -> {
                    registro.setNome(supermercado.getNome());
                    registro.setTelefone(supermercado.getTelefone());
                    registro.setEndereco(supermercado.getEndereco());
                    // registro.setProduto(supermercado.getProduto());
                    return ResponseEntity.ok().body(repository.save(registro));
                }).orElse(ResponseEntity.notFound().build());
    }
}
