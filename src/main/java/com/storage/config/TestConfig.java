package com.storage.config;

import com.storage.entities.Ingredient;
import com.storage.entities.Recipe;
import com.storage.repositories.IngredientRepository;
import com.storage.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private IngredientRepository ingredientService;
    @Autowired
    private RecipeRepository recipeService;

    @Override
    public void run(String... args) throws Exception {
        Ingredient cebola = new Ingredient( "Cebola", 5, 10);
        Ingredient salsa = new Ingredient("Salsa", 2, 4);
        Ingredient cenoura = new Ingredient("Cenoura", 1, 5);
        
        List<Ingredient> ingredients = Arrays.asList(cebola,salsa,cenoura);
        Recipe recipe = new Recipe(ingredients, "Tempero", Instant.now());

        ingredientService.save(cebola);
        ingredientService.save(salsa);
        ingredientService.save(cenoura);
        recipeService.save(recipe);

    }
}
