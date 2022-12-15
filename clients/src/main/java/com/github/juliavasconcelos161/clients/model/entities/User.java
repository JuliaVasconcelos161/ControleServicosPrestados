package com.github.juliavasconcelos161.clients.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "userName")//username sera unico
    private String userName;

    @Column(name = "password")
    private String password;
}
