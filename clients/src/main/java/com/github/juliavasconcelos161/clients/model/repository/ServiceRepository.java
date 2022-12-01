package com.github.juliavasconcelos161.clients.model.repository;

import com.github.juliavasconcelos161.clients.model.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
