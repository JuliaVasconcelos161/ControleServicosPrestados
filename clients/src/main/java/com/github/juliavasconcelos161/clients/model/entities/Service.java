package com.github.juliavasconcelos161.clients.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String description;

    @ManyToOne//Podem ser muitos serviços para apenas um cliente
    @JoinColumn(name = "client_id")
    private Client client;

    @Column
    private BigDecimal valor;
}
