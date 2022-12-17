package com.github.juliavasconcelos161.clients.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
public class UserLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "username")//username sera unico
    @NotEmpty(message = "{label.user.required}")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "{label.password.required}")
    private String password;
}
