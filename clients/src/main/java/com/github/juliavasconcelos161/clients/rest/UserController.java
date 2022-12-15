package com.github.juliavasconcelos161.clients.rest;

import com.github.juliavasconcelos161.clients.model.entities.User;
import com.github.juliavasconcelos161.clients.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody @Valid User user)
    {
        repository.save(user);
    }
}
