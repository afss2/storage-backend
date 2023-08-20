package com.storage.services;

import com.storage.entities.Ingredient;
import com.storage.entities.Recipe;
import com.storage.exceptions.RecipeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storage.repositories.RecipeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;

	public Recipe findById(UUID id) {
		return recipeRepository.findById(id).orElseThrow(RecipeNotFoundException::new);
	}

	public List<Recipe> findAll() {
		return recipeRepository.findAll();
	}

	public Recipe insert(Recipe recipe) {
		if (recipeRepository.existsById(recipe.getId())) {
			throw new RuntimeException("Recipe already exists.");
		}
		return recipeRepository.save(recipe);
	}

	public Recipe update(Recipe recipe, UUID id) {
		if (recipe.getId() != id) {
			throw new RuntimeException("Id passed as argument is different.");
		}
		if (!recipeRepository.existsById(id)) {
			throw new RuntimeException("Recipe does not exists.");
		}
		return recipeRepository.save(recipe);
	}

	public void delete(UUID id) {
		recipeRepository.deleteById(id);
	}
}
