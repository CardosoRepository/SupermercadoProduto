package com.java.backend.controller;

import java.util.List;

import com.java.backend.model.Sup_Prod;
import com.java.backend.services.Sup_ProdService;

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

@RequestMapping("/sup_Prod")
@RestController
public class Sup_ProdController {
    @Autowired
    Sup_ProdService service;

    @GetMapping
    public ResponseEntity<List<Sup_Prod>> getAllSup_Prod(){ return service.getAllSup_Prod(); }

    @GetMapping("/id")
    public ResponseEntity<Sup_Prod> getSup_ProdById(@RequestParam Integer id){ return service.getSup_ProdById(id); }

    @PostMapping("/preco")
    public ResponseEntity<Sup_Prod> createSup_Prod(@RequestBody Sup_Prod sup_Prod, @RequestParam Double preco){ return service.createSup_Prod(sup_Prod, preco); }

    @DeleteMapping("/id")
    public ResponseEntity<String> deleteSup_Prod(@RequestParam Integer id){ return service.deleteSup_Prod(id); }

    @PutMapping("/id")
    public ResponseEntity<Sup_Prod> updateSup_Prod(@RequestParam Integer id, @RequestBody Sup_Prod sup_Prod){ return service.updateSup_Prod(sup_Prod, id); }
}
