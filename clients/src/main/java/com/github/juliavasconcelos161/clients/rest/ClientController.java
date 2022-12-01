package com.github.juliavasconcelos161.clients.rest;

import com.github.juliavasconcelos161.clients.model.entities.Client;
import com.github.juliavasconcelos161.clients.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientRepository repository;
    @Autowired
    public ClientController(ClientRepository repository)
    {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveClient(@RequestBody @Valid Client client)
    {
        return repository.save(client);
    }

    @GetMapping("{id}")
    public Client findClientById(@PathVariable Integer id)
    {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Integer id)
    {
        repository.findById(id)
                .map(client -> {
                    repository.delete(client);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void UpdateClient(@PathVariable Integer id, @RequestBody Client updatedClient)
    {
        repository
                .findById(id)
                .map(client -> {
                    client.setName(updatedClient.getName());
                    client.setCpf(updatedClient.getCpf());
                    return repository.save(client);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
