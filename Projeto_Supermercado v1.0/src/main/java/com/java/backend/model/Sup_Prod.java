package com.java.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Sup_Prod {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "supermercado_id")
    Supermercado supermercado;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    Produto produto;
}
