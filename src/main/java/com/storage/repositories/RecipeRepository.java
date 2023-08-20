package com.storage.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.entities.Recipe;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, UUID> {

}
