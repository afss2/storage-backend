package com.storage.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.storage.exceptions.IngredientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.storage.entities.Ingredient;
import com.storage.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

	@Autowired
	private IngredientRepository ingredientRepository;

	public Ingredient findById(UUID id) {
		return  ingredientRepository.findById(id).orElseThrow(IngredientNotFoundException::new);
	}

	public List<Ingredient> findAll() {
		return ingredientRepository.findAll();
	}

	public Ingredient insert(Ingredient ingredient) {
		if (ingredientRepository.existsById(ingredient.getId())) {
			throw new RuntimeException("Ingredient already exists.");
		}
		return ingredientRepository.save(ingredient);
	}

	public Ingredient update(Ingredient ingredient, UUID id) {
		if (ingredient.getId() != id) {
			throw new RuntimeException("Id passed as argument is different.");
		}
		if (!ingredientRepository.existsById(id)) {
			throw new RuntimeException("Ingredient does not exists.");
		}
		return ingredientRepository.save(ingredient);
	}

	public void delete(UUID id) {
		ingredientRepository.deleteById(id);
	}

}
