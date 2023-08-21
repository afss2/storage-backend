package com.storage.controller;

import com.storage.entities.Recipe;
import com.storage.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<Recipe>> findAll() {
        return ResponseEntity.ok().body(recipeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(recipeService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Recipe> insert(@RequestBody Recipe recipe) {
        return ResponseEntity.ok().body(recipeService.insert(recipe));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> update(@RequestBody Recipe recipe, @PathVariable UUID id) {
        return ResponseEntity.ok().body(recipeService.update(recipe, id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        recipeService.delete(id);
    }
}
