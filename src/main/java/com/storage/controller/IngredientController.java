package com.storage.controller;

import com.storage.entities.Ingredient;
import com.storage.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;
    @GetMapping
    public List<Ingredient> findAll() {
        return ingredientService.findAll();
    }

    @GetMapping("/{id}")
    public Ingredient findById(@PathVariable UUID id) {
        return ingredientService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient insert(@RequestBody Ingredient ingredient) {
        return ingredientService.insert(ingredient);
    }

    @PutMapping("/{id}")
    public Ingredient update(@RequestBody Ingredient ingredient, @PathVariable UUID id) {
        return ingredientService.update(ingredient, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        ingredientService.delete(id);
    }

}
