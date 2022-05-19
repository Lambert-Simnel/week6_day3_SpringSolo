package com.food.kitchen.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Integer quantity;

    @ManyToMany(mappedBy = "ingredients")
    @JsonIgnoreProperties(value = "ingredients")
    private Set<Recipe> recipes;
}
