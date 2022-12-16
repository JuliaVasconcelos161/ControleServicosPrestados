package com.github.juliavasconcelos161.clients.model.repository;

import com.github.juliavasconcelos161.clients.model.entities.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserLogin, Integer> {
    Optional<UserLogin> findByUsername(String username);
}
