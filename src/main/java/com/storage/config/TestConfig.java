package com.storage.config;

import com.storage.controller.auth.RegisterRequest;
import com.storage.entities.Ingredient;
import com.storage.entities.Recipe;
import com.storage.entities.Role;
import com.storage.entities.User;
import com.storage.repositories.IngredientRepository;
import com.storage.repositories.RecipeRepository;
import com.storage.repositories.UserRepository;
import com.storage.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private IngredientRepository ingredientService;
    @Autowired
    private RecipeRepository recipeService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public void run(String... args) throws Exception {

        authenticationService.register(new RegisterRequest("Andre","af@gmail.com", passwordEncoder.encode("12345678")));
        User user = userRepository.findByEmail("af@gmail.com").get();

        Ingredient cebola = new Ingredient( "Cebola", 5, 10, user);
        Ingredient salsa = new Ingredient("Salsa", 2, 4, user);
        Ingredient cenoura = new Ingredient("Cenoura", 1, 5,user);
        
        List<Ingredient> ingredients = Arrays.asList(cebola,salsa,cenoura);
        Recipe recipe = new Recipe(ingredients, "Tempero", Instant.now(),user);

        ingredientService.save(cebola);
        ingredientService.save(salsa);
        ingredientService.save(cenoura);
        recipeService.save(recipe);

    }
}
