package com.java.backend.services;

import java.util.List;

import com.java.backend.exception.UnsupportedBlankAttributeException;
import com.java.backend.exception.UnsupportedEqualAttributeException;
import com.java.backend.exception.UnsupportedPriceValueException;
import com.java.backend.model.Sup_Prod;
import com.java.backend.repository.Sup_ProdRepository;
import com.java.backend.repository.SupermercadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.java.backend.repository.ProdutoRepository;

@Service
public class Sup_ProdService {
    @Autowired
    Sup_ProdRepository repository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    SupermercadoRepository supermercadoRepository;

    @Autowired
    ProdutoService produtoService;

    public ResponseEntity<List<Sup_Prod>> getAllSup_Prod(){ return ResponseEntity.ok().body(repository.findAll()); }

    public ResponseEntity<Sup_Prod> getSup_ProdById(Integer id){ return ResponseEntity.ok().body(repository.findById(id).get()); }

    public ResponseEntity<Sup_Prod> createSup_Prod(Sup_Prod sup_Prod, Double preco){
        if(preco <= 0) throw new UnsupportedPriceValueException("O preço do produto deve ser maior do que zero (valor positivo).");
        if(sup_Prod.getProduto().getId() == null || sup_Prod.getSupermercado().getId() == null) throw new UnsupportedBlankAttributeException("Os ID's de supermercado e produto não podem ser nulos.");
        if(produtoRepository.findById(sup_Prod.getProduto().getId()).isEmpty()) throw new UnsupportedEqualAttributeException("Informe um ID válido de um produto");
        if(supermercadoRepository.findById(sup_Prod.getSupermercado().getId()).isEmpty()) throw new UnsupportedEqualAttributeException("Informe um ID válido de um supermercado");
        produtoService.updatePrice(sup_Prod.getProduto().getId(), preco);

        return new ResponseEntity<Sup_Prod>(repository.save(sup_Prod), HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteSup_Prod(Integer id){
        repository.deleteById(id);
        return ResponseEntity.ok().body("Sup_Prod deletado");
    }

    public ResponseEntity<Sup_Prod> updateSup_Prod(Sup_Prod sup_Prod, Integer id){
        if(sup_Prod.getProduto().getPreco() <= 0) throw new UnsupportedPriceValueException("O preço do produto deve ser maior do que zero (valor positivo).");
        if(sup_Prod.getProduto().getId() == null || sup_Prod.getSupermercado().getId() == null) throw new UnsupportedBlankAttributeException("Os ID's de supermercado e produto não podem ser nulos.");
        if(produtoRepository.findById(sup_Prod.getProduto().getId()).isEmpty()) throw new UnsupportedEqualAttributeException("Informe um ID válido de um produto");
        if(supermercadoRepository.findById(sup_Prod.getSupermercado().getId()).isEmpty()) throw new UnsupportedEqualAttributeException("Informe um ID válido de um supermercado");
        return repository.findById(id)
                .map(registro -> {
                    registro.setProduto(sup_Prod.getProduto());
                    registro.setSupermercado(sup_Prod.getSupermercado());
                    return ResponseEntity.ok().body(repository.save(registro));
                }).orElse(ResponseEntity.notFound().build());
    }
}
