package com.storage.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {

    Optional<List<Ingredient>> findByUserEmail(String email);

}
