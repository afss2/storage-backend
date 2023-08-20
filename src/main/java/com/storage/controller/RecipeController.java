package com.storage.controller;

import com.storage.entities.Recipe;
import com.storage.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private RecipeService recipeService;

    @GetMapping
    public List<Recipe> findAll() {
        return recipeService.findAll();
    }

    @GetMapping("/{id}")
    public Recipe findById(@PathVariable UUID id) {
        return recipeService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Recipe insert(@RequestBody Recipe recipe) {
        return recipeService.insert(recipe);
    }

    @PutMapping("/{id}")
    public Recipe update(@RequestBody Recipe recipe, @PathVariable UUID id) {
        return recipeService.update(recipe, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        recipeService.delete(id);
    }
}
