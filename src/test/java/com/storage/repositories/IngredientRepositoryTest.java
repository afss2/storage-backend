package com.storage.repositories;

import com.storage.controller.auth.RegisterRequest;
import com.storage.entities.Ingredient;
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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ComponentScan(basePackages = {"com.storage"})
class IngredientRepositoryTest {

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
        ingredientRepository.deleteAll();
    }

    @BeforeAll
    void createUser(){
        authenticationService.register(new RegisterRequest("Andre","af@gmail.com", passwordEncoder.encode("12345678")));
        user = userRepository.findByEmail("af@gmail.com").get();
    }

    @Test
    void findByUserEmail() {
        Ingredient ingredient = new Ingredient("Cebola", 10, 15, user);

        ingredientRepository.save(ingredient);

        List<Ingredient> saved = ingredientRepository.findByUserEmail(user.getEmail()).get();

        assertThat(saved).hasSize(1);
        assertThat(saved.get(0)).isEqualTo(ingredient);
    }

    @Test
    void findByName() {
        Ingredient ingredient = new Ingredient("Cebola", 10, 15, user);

        ingredientRepository.save(ingredient);

        Ingredient saved = ingredientRepository.findByName(ingredient.getName()).get();

        assertThat(saved).isEqualTo(ingredient);
    }
}