package com.github.juliavasconcelos161.clients.model.repository;

import com.github.juliavasconcelos161.clients.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
