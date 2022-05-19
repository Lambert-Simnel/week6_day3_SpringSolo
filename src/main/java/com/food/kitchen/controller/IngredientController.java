package com.food.kitchen.controller;

import com.food.kitchen.model.Ingredient;
import com.food.kitchen.repository.IngredientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class IngredientController {

    private final IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        return ResponseEntity.ok().body(ingredients);
    }

    @GetMapping("/ingredient/{id}")
    public ResponseEntity<Optional<Ingredient>> getSpecificIngredient(Long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        return ResponseEntity.ok().body(ingredient);
    }

    @PostMapping("/ingredients")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient result = ingredientRepository.save(ingredient);
        return ResponseEntity.ok().body(result);
    }

}
