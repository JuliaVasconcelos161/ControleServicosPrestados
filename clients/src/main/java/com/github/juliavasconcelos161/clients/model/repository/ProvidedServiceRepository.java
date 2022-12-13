package com.github.juliavasconcelos161.clients.model.repository;

import com.github.juliavasconcelos161.clients.model.entities.ProvidedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProvidedServiceRepository extends JpaRepository<ProvidedService, Integer> {

    @Query("select s from ProvidedService s join s.client c where upper(c.name) like upper(:name) and MONTH(s.date) =:month")
    List<ProvidedService> findByNameAndMonth(
            @Param("name") String name,
            @Param("month") Integer month);
}
