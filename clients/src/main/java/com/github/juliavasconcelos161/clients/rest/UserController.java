package com.github.juliavasconcelos161.clients.rest;

import com.github.juliavasconcelos161.clients.model.entities.UserLogin;
import com.github.juliavasconcelos161.clients.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody @Valid UserLogin userLogin)
    {
        repository.save(userLogin);
    }
}
