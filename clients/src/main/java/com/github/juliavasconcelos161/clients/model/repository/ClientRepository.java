package com.github.juliavasconcelos161.clients.model.repository;

import com.github.juliavasconcelos161.clients.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
