package com.java.backend.services;

import java.util.List;

import com.java.backend.exception.UnsupportedEqualAttributeException;
import com.java.backend.model.Produto;
import com.java.backend.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repository;

    public ResponseEntity<List<Produto>> getAllProdutos(){ return ResponseEntity.ok().body(repository.findAll()); }

    public ResponseEntity<Produto> getProdutoById(Integer id){ return ResponseEntity.ok().body(repository.findById(id).get()); }

    public ResponseEntity<Produto> getProdutoByNome(String nome){ return ResponseEntity.ok().body(repository.findByNome(nome)); }

    public ResponseEntity<Produto> createProduto(Produto produto){
        if (repository.findByNome(produto.getNome()) != null) throw new UnsupportedEqualAttributeException("Nome do produto está duplicado");
        return new ResponseEntity<Produto>(repository.save(produto), HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteProduto(Integer id){
        repository.deleteById(id);
        return ResponseEntity.ok().body("Produto deletado");
    }

    public ResponseEntity<Produto> updateProduto(Produto produto, Integer id){
        if (repository.findByNome(produto.getNome()) != null) return ResponseEntity.badRequest().build();
        return repository.findById(id)
                .map(registro -> {
                    registro.setNome(produto.getNome());
                    registro.setCodigoDeBarras(produto.getCodigoDeBarras());
                    registro.setCategoria(produto.getCategoria());
                    registro.setPreco(produto.getPreco());
                    return ResponseEntity.ok().body(repository.save(registro));
                }).orElse(ResponseEntity.notFound().build());
    }

    public void updatePrice(Integer id, Double preco){
        Produto produto = repository.findById(id).get();
        produto.setPreco(preco);
        repository.save(produto);
        // repository.findById(id)
        //         .map(registro -> {
        //             registro.setPreco(preco);
        //             repository.save(registro);
        //             return null;
        //         }).orElse(null);
    }
}
