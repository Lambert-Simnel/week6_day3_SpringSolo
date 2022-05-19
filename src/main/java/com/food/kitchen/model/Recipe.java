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
    @JsonIgnoreProperties(value = {"recipes"})
    private Set<Ingredient> ingredients;

    public Recipe(Long id, String name, Integer cookingTime, Set<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
    }

    public Recipe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
