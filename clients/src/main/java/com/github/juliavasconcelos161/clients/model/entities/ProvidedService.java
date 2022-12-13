package com.github.juliavasconcelos161.clients.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class ProvidedService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String description;

    @ManyToOne//Podem ser muitos serviços para apenas um cliente
    @JoinColumn(name = "client_id")
    private Client client;

    @Column
    private BigDecimal value;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
}
