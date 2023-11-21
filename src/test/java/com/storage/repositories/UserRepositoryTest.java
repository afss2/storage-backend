package com.storage.repositories;

import com.storage.controller.auth.RegisterRequest;
import com.storage.entities.User;
import com.storage.services.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ComponentScan(basePackages = {"com.storage"})
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void findByEmail() {
        authenticationService.register(new RegisterRequest("Andre","af@gmail.com", passwordEncoder.encode("12345678")));
        User user = userRepository.findByEmail("af@gmail.com").get();

        assertThat(user).isNotNull();
    }
}