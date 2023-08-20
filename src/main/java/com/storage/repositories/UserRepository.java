package com.storage.repositories;

import com.storage.entities.Ingredient;
import com.storage.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Ingredient, UUID> {

    Optional<User> findByEmail(String email);

}
