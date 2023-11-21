package com.storage.repositories;

import com.storage.controller.auth.RegisterRequest;
import com.storage.entities.Ingredient;
import com.storage.entities.Recipe;
import com.storage.entities.User;
import com.storage.services.AuthenticationService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ComponentScan(basePackages = {"com.storage"})
class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private User user;

    @AfterEach
    void tearDown() {
        recipeRepository.deleteAll();
    }
    @BeforeAll
    void createUser(){
        authenticationService.register(new RegisterRequest("Andre","af@gmail.com", passwordEncoder.encode("12345678")));
        user = userRepository.findByEmail("af@gmail.com").get();
    }

    @Test
    void findByUserEmail() {
        Ingredient ingredient = new Ingredient("Cebola", 10, 15, user);
        Ingredient ingredient2 = new Ingredient("Alho", 5, 5, user);

        List<Ingredient> ingredientList = Arrays.asList(ingredient, ingredient2);
        ingredientRepository.saveAll(ingredientList);

        Recipe recipe = new Recipe(ingredientList, "Cebola com Alho", Instant.now(), user);
        recipeRepository.save(recipe);

        List<Recipe> userRecipes = recipeRepository.findByUserEmail(user.getEmail()).get();

        assertThat(userRecipes).hasSize(1);
        assertThat(userRecipes.get(0)).isEqualTo(recipe);
    }
}