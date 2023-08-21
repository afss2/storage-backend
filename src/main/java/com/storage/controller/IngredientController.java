package com.storage.controller;

import com.storage.entities.Ingredient;
import com.storage.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public ResponseEntity<List<Ingredient>> findAll() {
        return ResponseEntity.ok().body(ingredientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(ingredientService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Ingredient> insert(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok().body(ingredientService.insert(ingredient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> update(@RequestBody Ingredient ingredient, @PathVariable UUID id) {
        return ResponseEntity.ok().body(ingredientService.update(ingredient, id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        ingredientService.delete(id);
    }

}
