package com.java.backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class Supermercado {
    @Id
    @GeneratedValue
    private Integer id;

    private String nome;
    private String telefone;
    private String endereco; //Criar classe endereço
    
    @OneToMany(targetEntity = Sup_Prod.class, mappedBy = "supermercado")
    private List<Sup_Prod> sup_Prod;
}
