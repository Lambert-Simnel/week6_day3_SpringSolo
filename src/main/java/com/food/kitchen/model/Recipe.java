package com.food.kitchen.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column(name = "Cooking_Time")
    private Integer cookingTime;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cookbook",
    joinColumns = @JoinColumn(name = "recipe_id"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    @JsonIgnoreProperties(value = {"Recipes"})
    private Set<Ingredient> ingredients;
}
