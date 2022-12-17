package com.github.juliavasconcelos161.clients.rest;

import com.github.juliavasconcelos161.clients.exception.RegistratedClientException;
import com.github.juliavasconcelos161.clients.model.entities.UserLogin;
import com.github.juliavasconcelos161.clients.model.repository.UserRepository;
import com.github.juliavasconcelos161.clients.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody @Valid UserLogin userLogin)
    {
        try {
            service.saveUser(userLogin);
        } catch (RegistratedClientException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
